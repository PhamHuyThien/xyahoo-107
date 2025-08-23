package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.actions.quyen_ct;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.forms.TextBoxCommandListener;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;

public final class TextInputComponent extends UIComponent {
    public TextComponent textInputHandler;
    public boolean isReadOnly;
    public boolean isNavigationMode = false;
    public boolean isEnabled = true;
    public static int inputModeIndex = 2;
    private static final int[] KEYSTROKE_DELAYS = new int[]{18, 14, 11, 9, 6, 4, 2};
    private static int cursorHeight = 0;
    public boolean useNativeInput;
    private static final String[] T9_CHARACTER_MAPS = new String[]{
            " 0",
            ".,@?!_1'/$-():*+<=>;%&#%^&*[];'/1",
            "abc2áàảãạâấầẩẫậăắằẳẵặ2",
            "def3đéèẻẽẹêếềểễệ3",
            "ghi4íìỉĩị4",
            "jkl5",
            "mno6óòỏõọôốồổỗộơớờởỡợ6",
            "pqrs7",
            "tuv8úùủũụưứừửữự8",
            "wxyz9ýỳỷỹỵ9",
            "*",
            "#"
    };
    private String currentText = "";
    private String maskedText = "";
    private String displayText = "";
    private int cursorPosition = 0;
    private int animationCounter = 0;
    private final int maxLength = 50000;
    private int textOffsetX = 0;
    private int lastKeyPressed = -1984;
    private int multiTapTimer = 0;
    private int currentCharIndex = 0;
    private int navigationDelay = 10;
    private int inputConstraint = 0;
    private static boolean isDirectInput;
    private static int caseIndicatorWidth;
    private int caseMode = 0;
    private static final String[] CASE_LABELS = new String[]{"abc", "Abc", "ABC", "123"};
    private static int CASE_SWITCH_KEY = 11;
    public static Canvas currentCanvas;
    public static MIDlet parentMidlet;
    private boolean isDirty;
    public static int keyboardLayout;
    private final ButtonAction clearAction = new ButtonAction("Xóa", new quyen_ct(this));
    public Action onCompleteAction;
    public int marginOffset = 26;
    private int textRenderX;
    private int helpBoxY;
    private String[] helpTextLines;
    private int helpBoxHeight;
    public boolean showHelpBox;
    public Action alternateAction;

    public void openNativeTextBox() {
        TextBox var1;
        (var1 = new TextBox("", "", 500, 0)).addCommand(new Command("OK", 4, 0));
        var1.addCommand(new Command(TextConstant.close(), 3, 0));
        var1.setCommandListener(new TextBoxCommandListener(this, var1));

        try {
            if (this.useNativeInput) {
                var1.setConstraints(3);
            } else if (this.inputConstraint == 2) {
                var1.setConstraints(65536);
            } else if (this.inputConstraint == 1) {
                var1.setConstraints(2);
            } else {
                var1.setConstraints(0);
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        var1.setString(this.currentText);
        var1.setMaxSize(this.maxLength);
        Display.getDisplay(parentMidlet).setCurrent(var1);
    }

    public static void setKeyboardLayout(int var0) {
        keyboardLayout = var0;
        if (var0 == 1) {
            T9_CHARACTER_MAPS[0] = "0";
            T9_CHARACTER_MAPS[10] = " *";
            T9_CHARACTER_MAPS[11] = "#";
            CASE_SWITCH_KEY = 35;
        } else if (var0 == 0) {
            T9_CHARACTER_MAPS[0] = " 0";
            T9_CHARACTER_MAPS[10] = "*";
            T9_CHARACTER_MAPS[11] = "#";
            CASE_SWITCH_KEY = 35;
        } else {
            if (var0 == 2) {
                T9_CHARACTER_MAPS[0] = "0";
                T9_CHARACTER_MAPS[10] = "*";
                T9_CHARACTER_MAPS[11] = " #";
                CASE_SWITCH_KEY = 42;
            }
        }
    }

    private static void initializeFontMetrics() {
        cursorHeight = FontRenderer.fontHeight + 1;
        caseIndicatorWidth = FontRenderer.getTextWidth("ABC") + 1;
    }

    public TextInputComponent() {
        this.currentText = "";
        initializeFontMetrics();
    }

    public TextInputComponent(String var1, int var2) {
        this.currentText = var1;
        this.inputConstraint = var2;
        initializeFontMetrics();
    }

    public void deleteCharacterAtCursor() {
        if (this.currentText.length() == 1) {
            this.hideRightSoftKey();
        }

        if (this.cursorPosition > 0 && this.currentText.length() > 0) {
            this.currentText = this.currentText.substring(0, this.cursorPosition - 1) + this.currentText.substring(this.cursorPosition);
            this.cursorPosition--;
            this.adjustTextScrollPosition();
            this.updatePasswordMask();
        }
    }

    private void showRightSoftKey() {
        super.rightSoftKey = this.clearAction;
        UIUtils.markScreenForUpdate(this);
    }

    private void hideRightSoftKey() {
        super.rightSoftKey = null;
        if (this.onCompleteAction != null) {
            this.onCompleteAction.action();
        }

        UIUtils.markScreenForUpdate(this);
    }

    private void adjustTextScrollPosition() {
        if (this.inputConstraint == 2) {
            this.displayText = this.maskedText;
        } else {
            this.displayText = this.currentText;
        }

        if (this.textOffsetX < 0 && FontRenderer.getTextWidth(this.displayText) + this.textOffsetX < super.width - 6 - 13 - caseIndicatorWidth) {
            this.textOffsetX = super.width - 10 - caseIndicatorWidth - FontRenderer.getTextWidth(this.displayText);
        }

        if (this.textOffsetX + FontRenderer.getTextWidth(this.displayText.substring(0, this.cursorPosition)) <= 0) {
            this.textOffsetX = -FontRenderer.getTextWidth(this.displayText.substring(0, this.cursorPosition));
            this.textOffsetX += 40;
        } else if (this.textOffsetX + FontRenderer.getTextWidth(this.displayText.substring(0, this.cursorPosition)) >= super.width - 12 - caseIndicatorWidth) {
            this.textOffsetX = super.width + this.marginOffset - caseIndicatorWidth - FontRenderer.getTextWidth(this.displayText.substring(0, this.cursorPosition)) - 12;
        }

        if (this.textOffsetX > 0) {
            this.textOffsetX = 0;
        }
    }

    private void insertDirectCharacter(int var1) {
        this.isDirty = true;
        if (this.useNativeInput) {
            this.openNativeTextBox();
        } else {
            this.insertTextAtCursor(var1, null);
        }
    }

    private void insertTextAtCursor(int var1, String var2) {
        if (this.currentText.length() < this.maxLength) {
            this.showRightSoftKey();
            String var3 = this.currentText.substring(0, this.cursorPosition);
            if (var2 == null) {
                var3 = var3 + (char) var1;
            } else {
                var3 = var3 + var2;
            }

            if (this.cursorPosition < this.currentText.length()) {
                var3 = var3 + this.currentText.substring(this.cursorPosition);
            }

            this.currentText = var3;
            this.cursorPosition++;
            this.updatePasswordMask();
            this.adjustTextScrollPosition();
        }
    }

    private void insertDateSeparator(int var1) {
        if (this.inputConstraint == 3 && (this.currentText.length() == 2 || this.currentText.length() == 5)) {
            this.insertTextAtCursor(var1, "/");
        }
    }

    public boolean handleKeyPress(int var1) {
        if (this.currentText.length() <= 0 && var1 == 16) {
            this.openNativeTextBox();
            return false;
        } else {
            if (var1 >= 65 && var1 <= 122) {
                if (this.inputConstraint == 1 || this.inputConstraint == 3) {
                    return false;
                }

                isDirectInput = true;
            }

            if (isDirectInput) {
                this.isDirty = true;
                if (var1 == 45) {
                    if (var1 == this.lastKeyPressed && this.multiTapTimer < KEYSTROKE_DELAYS[inputModeIndex]) {
                        this.currentText = this.currentText.substring(0, this.cursorPosition - 1) + '_';
                        this.displayText = this.currentText;
                        this.updatePasswordMask();
                        this.adjustTextScrollPosition();
                        this.lastKeyPressed = -1984;
                        this.showRightSoftKey();
                        return false;
                    }

                    this.lastKeyPressed = 45;
                }

                if (var1 >= 32) {
                    this.insertDirectCharacter(var1);
                    if (this.inputConstraint == 3) {
                        this.insertDateSeparator(var1);
                    }

                    return false;
                }
            }

            if (var1 == CASE_SWITCH_KEY) {
                this.caseMode++;
                if (this.caseMode > 3) {
                    this.caseMode = 0;
                }

                this.multiTapTimer = 1;
                this.lastKeyPressed = var1;
                return false;
            } else {
                if (var1 == 42) {
                    var1 = 58;
                }

                if (var1 == 35) {
                    var1 = 59;
                }

                if (var1 < 48 || var1 > 59) {
                    this.currentCharIndex = 0;
                    this.lastKeyPressed = -1984;
                    if (var1 == 14 && !this.isNavigationMode) {
                        if (this.cursorPosition > 0) {
                            this.cursorPosition--;
                            this.adjustTextScrollPosition();
                            this.navigationDelay = 10;
                            return false;
                        }
                    } else {
                        if (var1 == 15) {
                            if (!this.isNavigationMode && this.cursorPosition < this.currentText.length()) {
                                this.cursorPosition++;
                                this.adjustTextScrollPosition();
                                this.navigationDelay = 10;
                                return false;
                            }

                            this.isDirty = !this.isDirty;
                            return !this.isDirty;
                        }

                        if (var1 == 19) {
                            this.deleteCharacterAtCursor();
                            return false;
                        }

                        this.lastKeyPressed = var1;
                    }
                } else if (this.inputConstraint == 0 || this.inputConstraint == 2) {
                    this.isDirty = false;
                    if (this.useNativeInput) {
                        this.openNativeTextBox();
                    } else {
                        this.showRightSoftKey();
                        if (var1 == this.lastKeyPressed) {
                            this.currentCharIndex = (this.currentCharIndex + 1) % T9_CHARACTER_MAPS[var1 - 48].length();
                            char var3 = T9_CHARACTER_MAPS[var1 - 48].charAt(this.currentCharIndex);
                            if (this.caseMode == 0) {
                                var3 = Character.toLowerCase(var3);
                            } else if (this.caseMode == 1) {
                                var3 = Character.toUpperCase(var3);
                            } else if (this.caseMode == 2) {
                                var3 = Character.toUpperCase(var3);
                            } else {
                                var3 = T9_CHARACTER_MAPS[var1 - 48].charAt(T9_CHARACTER_MAPS[var1 - 48].length() - 1);
                            }

                            String var5 = this.currentText.substring(0, this.cursorPosition - 1) + var3;
                            if (this.cursorPosition < this.currentText.length()) {
                                var5 = var5 + this.currentText.substring(this.cursorPosition);
                            }

                            this.currentText = var5;
                            this.multiTapTimer = KEYSTROKE_DELAYS[inputModeIndex];
                            this.updatePasswordMask();
                        } else if (this.currentText.length() < this.maxLength) {
                            if (this.caseMode == 1 && this.lastKeyPressed != -1984) {
                                this.caseMode = 0;
                            }

                            this.currentCharIndex = 0;
                            char var6 = T9_CHARACTER_MAPS[var1 - 48].charAt(this.currentCharIndex);
                            if (this.caseMode == 0) {
                                var6 = Character.toLowerCase(var6);
                            } else if (this.caseMode == 1) {
                                var6 = Character.toUpperCase(var6);
                            } else if (this.caseMode == 2) {
                                var6 = Character.toUpperCase(var6);
                            } else {
                                var6 = T9_CHARACTER_MAPS[var1 - 48].charAt(T9_CHARACTER_MAPS[var1 - 48].length() - 1);
                            }

                            String var8 = this.currentText.substring(0, this.cursorPosition) + var6;
                            if (this.cursorPosition < this.currentText.length()) {
                                var8 = var8 + this.currentText.substring(this.cursorPosition);
                            }

                            this.currentText = var8;
                            this.multiTapTimer = KEYSTROKE_DELAYS[inputModeIndex];
                            this.cursorPosition++;
                            this.updatePasswordMask();
                            this.adjustTextScrollPosition();
                        }

                        this.lastKeyPressed = var1;
                    }
                } else if (this.inputConstraint == 1 || this.inputConstraint == 3) {
                    this.insertDirectCharacter(var1);
                    this.multiTapTimer = 1;
                    this.insertDateSeparator(var1);
                }

                return true;
            }
        }
    }

    public boolean handleDirectKeyPress(int var1) {
        if (!isDirectInput && var1 < T9_CHARACTER_MAPS.length) {
            this.deleteCharacterAtCursor();
            this.insertDirectCharacter(T9_CHARACTER_MAPS[var1].charAt(T9_CHARACTER_MAPS[var1].length() - 1));
            this.multiTapTimer = KEYSTROKE_DELAYS[inputModeIndex];
        }

        if (var1 == 19) {
            this.setText("");
        }

        return true;
    }

    public void handlePointerPress(int var1, int var2) {
        if (this.isFocused()) {
            this.openNativeTextBox();
        } else {
            UIUtils.focusComponent(super.parentScreen, (UIComponent) this);
        }
    }

    public void showHelpText(String var1) {
        this.showHelpBox = true;
        this.helpBoxHeight = super.height + 9;
        this.helpBoxY = Screen.screenHeight - GameManager.footerHeight - (FontRenderer.fontHeight << 1) - 6;
        if (var1 != null && var1.length() > 0) {
            this.helpTextLines = FontRenderer.wrapTextToLines(var1, Screen.screenWidth - 30);
            this.helpBoxHeight = super.height + 16 + 4 + this.helpTextLines.length * (FontRenderer.fontHeight + 2);
            this.helpBoxY = Screen.screenHeight - GameManager.footerHeight - this.helpBoxHeight - 3;
        }
    }

    public boolean isHelpTextEquals(String var1) {
        StringBuffer var2 = new StringBuffer(0);
        int var3 = 0;

        for (int var4 = this.helpTextLines.length; var3 < var4; var3++) {
            var2.append(this.helpTextLines[var3]);
            if (var3 < var4 - 1) {
                var2.append(" ");
            }
        }

        return var2.toString().equals(var1);
    }

    public void render(Graphics var1) {
        int var2 = 0;
        int var3 = super.posY + (super.height - FontRenderer.fontHeight >> 1);
        boolean var4 = this.isFocused();
        if (this.showHelpBox) {
            var1.setColor(8700157);
            int var10003 = Screen.screenWidth - 10;
            int var8 = this.helpBoxHeight;
            int var7 = var10003;
            int var6 = this.helpBoxY;
            byte var5 = 5;
            var1.fillRect(var5, var6 - 1, var7, var8 + 2);
            var1.fillRect(var5 - 1, var6, var7 + 2, var8);
            var1.setColor(284567);
            var1.fillRect(5, this.helpBoxY, Screen.screenWidth - 10, this.helpBoxHeight);
            if (this.helpTextLines != null) {
                for (int var9 = 0; var9 < this.helpTextLines.length; var9++) {
                    FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.helpTextLines[var9], GameGraphics.screenWidth - FontRenderer.getTextWidth(this.helpTextLines[var9]) >> 1, this.helpBoxY + 8 + var9 * (FontRenderer.fontHeight + 2), var1);
                }
            }
        }

        if (this.inputConstraint == 2) {
            this.displayText = this.maskedText;
        } else {
            this.displayText = this.currentText;
        }

        if (var4 && this.isEnabled) {
            var2 = super.posX + super.width - 3;
            var1.setColor(66826);
            var1.fillRect(super.posX + 2, super.posY + 2, super.width - 3, super.height - 3);
            if (!isDirectInput && !this.isReadOnly) {
                var1.setColor(9478569);
                ButtonComponent.drawRoundedBorder(var1, var2 - caseIndicatorWidth, super.posY + 3, caseIndicatorWidth, super.height - 6);
                FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(CASE_LABELS[this.caseMode], var2 - caseIndicatorWidth + (caseIndicatorWidth - FontRenderer.getTextWidth(CASE_LABELS[this.caseMode]) >> 1) + (FontRenderer.isCustomFontEnabled ? 0 : 1), var3, var1);
            }
        }

        Graphics var10000;
        int var10001;
        if (!var4) {
            var10000 = var1;
            var10001 = 9478569;
        } else {
            var10000 = var1;
            var10001 = var4 && !this.isEnabled ? 11320516 : 8700157;
        }

        var10000.setColor(var10001);
        ButtonComponent.drawRoundedBorder(var1, super.posX + 1, super.posY + 1, super.width - 2, super.height - 2);
        var2 = super.posY + 1;
        this.textRenderX = 6 + this.textOffsetX + super.posX;
        var1.setClip(super.posX + 3, var2 > super.parentScreen.currentScrollY ? var2 : super.parentScreen.currentScrollY, super.width, super.height - 4);
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.displayText, this.textRenderX, var3, var1);
        if (var4) {
            if (this.multiTapTimer != 0 || this.navigationDelay <= 0 && this.animationCounter / 5 % 2 != 0) {
                var1.setColor(9360375);
            } else {
                var1.setColor(2767169);
            }

            var1.fillRect(this.textRenderX + FontRenderer.getTextWidth(this.displayText.substring(0, this.cursorPosition)) + (FontRenderer.isCustomFontEnabled ? 1 : 0), super.posY + (super.height - cursorHeight >> 1) + 2, 1, cursorHeight);
        }
    }

    private void updatePasswordMask() {
        if (this.inputConstraint == 2) {
            this.maskedText = "";

            for (int var1 = 0; var1 < this.currentText.length(); var1++) {
                this.maskedText = this.maskedText + "*";
            }

            if (this.multiTapTimer > 0 && this.cursorPosition > 0) {
                this.maskedText = this.maskedText.substring(0, this.cursorPosition - 1) + this.currentText.charAt(this.cursorPosition - 1) + this.maskedText.substring(this.cursorPosition);
            }
        }
    }

    public void update() {
        this.animationCounter++;
        if (this.multiTapTimer > 0) {
            this.multiTapTimer--;
            if (this.multiTapTimer == 0) {
                this.currentCharIndex = 0;
                if (this.caseMode == 1 && this.lastKeyPressed != CASE_SWITCH_KEY) {
                    this.caseMode = 0;
                }

                this.lastKeyPressed = -1984;
                this.updatePasswordMask();
            }
        }

        if (this.navigationDelay > 0) {
            this.navigationDelay--;
        }
    }

    public String getText() {
        return this.currentText;
    }

    public void setText(String var1) {
        if (var1 != null) {
            if (var1.length() == 0) {
                this.hideRightSoftKey();
            } else {
                this.showRightSoftKey();
            }

            this.lastKeyPressed = -1984;
            this.multiTapTimer = 0;
            this.currentCharIndex = 0;
            this.currentText = var1;
            this.displayText = var1;
            this.updatePasswordMask();
            this.cursorPosition = var1.length();
            this.adjustTextScrollPosition();
        }
    }

    public void insertText(String var1) {
        if (var1 != null && var1.length() != 0) {
            this.showRightSoftKey();
            this.currentText = this.currentText.substring(0, this.cursorPosition) + var1 + this.currentText.substring(this.cursorPosition);
            this.updatePasswordMask();
            this.cursorPosition = this.cursorPosition + var1.length();
            this.adjustTextScrollPosition();
        }
    }

    public void setInputConstraint(int var1) {
        this.inputConstraint = var1;
    }
}
