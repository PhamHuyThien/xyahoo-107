package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;

public final class DropdownComponent extends UIComponent {
    public TextComponent textInputHandler;
    public String[] optionList;
    private int dropdownSelectedIndex;
    private int actionDelayTimer;
    public Action changeAction;
    private String displayText = "";
    private int textCenterX;

    public DropdownComponent(String[] var1, int var2, int var3, int var4, int var5) {
        this.actionDelayTimer = 0;
        this.optionList = var1;
        super.posX = var2;
        super.posY = var3;
        super.width = var4;
        super.height = var5;
        this.updateDisplayText();
    }

    public int getSelectedIndex() {
        return this.dropdownSelectedIndex;
    }

    public void setSelectedIndex(int var1) {
        this.dropdownSelectedIndex = var1;
        this.updateDisplayText();
    }

    public boolean handleDirectKeyPress(int var1) {
        if (var1 == 14) {
            this.selectPrevious();
            return false;
        } else if (var1 == 15) {
            this.selectNext();
            return false;
        } else {
            return true;
        }
    }

    private void selectPrevious() {
        this.dropdownSelectedIndex--;
        if (this.dropdownSelectedIndex < 0) {
            this.dropdownSelectedIndex = this.optionList.length - 1;
        }

        if (this.changeAction != null) {
            this.changeAction.action();
        }

        this.updateDisplayText();
    }

    private void selectNext() {
        this.dropdownSelectedIndex++;
        if (this.dropdownSelectedIndex >= this.optionList.length) {
            this.dropdownSelectedIndex = 0;
        }

        if (this.changeAction != null) {
            this.changeAction.action();
        }

        this.updateDisplayText();
    }

    public boolean handleKeyPress(int var1) {
        if (this.optionList.length == 0) {
            return true;
        } else if (var1 == 14) {
            this.selectPrevious();
            return false;
        } else if (var1 == 15) {
            this.selectNext();
            return false;
        } else {
            return true;
        }
    }

    public void handlePointerPress(int var1, int var2) {
        UIUtils.focusComponent(super.parentScreen, this);
        this.dropdownSelectedIndex++;
        if (this.dropdownSelectedIndex >= this.optionList.length) {
            this.dropdownSelectedIndex = 0;
        }

        if (this.changeAction != null) {
            this.changeAction.action();
        }

        this.updateDisplayText();
    }

    private void updateDisplayText() {
        if (this.optionList.length != 0) {
            this.displayText = FontRenderer.getFirstLineWrapped(this.optionList[this.dropdownSelectedIndex], super.width - 30);
        }

        this.textCenterX = super.posX + (super.width - FontRenderer.getTextWidth(this.optionList.length != 0 ? this.displayText : " ") >> 1);
    }

    public void render(Graphics var1) {
        boolean var4;
        if (var4 = this.isFocused()) {
            var1.setColor(66826);
            var1.fillRect(super.posX + 2, super.posY + 2, super.width - 3, super.height - 3);
        }

        int var2 = super.posY + 3 + (FontRenderer.isCustomFontEnabled ? 0 : 1);
        if (this.optionList.length == 0) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(" ", this.textCenterX, var2, var1);
        } else {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.displayText, this.textCenterX, var2, var1);
        }

        var2 = super.height - 2;
        int var3 = super.posY + 1;
        var1.setColor(var4 ? 8700157 : 9478569);
        ButtonComponent.drawRoundedBorder(var1, super.posX + 1, var3, super.width - 2, var2);
        var2 = super.posY + (super.height >> 1);
        var1.drawRegion(GameManager.arrowIcons[2], 0, 0, 7, 7, 0, super.posX + 9, var2, 3);
        var1.drawRegion(GameManager.arrowIcons[2], 7, 0, 7, 7, 0, super.posX + super.width - 9, var2, 3);
    }

    public void setChangeAction(Action var1) {
        this.changeAction = var1;
        if (super.middleSoftKey != null) {
            super.middleSoftKey.action = var1;
        }
    }

    public void update() {
        if (this.actionDelayTimer > 0) {
            this.actionDelayTimer--;
            if (this.actionDelayTimer == 0 && this.changeAction != null) {
                this.changeAction.action();
            }
        }
    }

    public String getSelectedText() {
        return this.dropdownSelectedIndex >= 0 && this.dropdownSelectedIndex < this.optionList.length ? this.optionList[this.dropdownSelectedIndex] : null;
    }
}
