package home.thienph.xyahoo107.utils;

import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.components.ButtonComponent;
import home.thienph.xyahoo107.components.TextComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.Screen;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;

public final class UIUtils {
    public static final String[] INVALID_FILENAME_CHARS;
    public static int centerTextX;
    public static int rightTextX;
    public static int leftColumnX;
    public static int rightColumnX;
    public static int leftColumnWidth;
    public static int rightColumnWidth;
    public static int layoutParam1;
    public static int layoutParam2;

    static {
        INVALID_FILENAME_CHARS = new String[]{"/", "\\", "<", ">", "?", ":", "\"", "*", "|"};
    }

    public static String generateTimestampString(String string) {
        String s2;
        final String s = s2 = Long.toString(System.currentTimeMillis());
        if (s.length() > 10) {
            s2 = s.substring(s.length() - 10);
        }
        final StringBuffer sb = new StringBuffer(sanitizeFilename(s2));
        if (string != null) {
            sb.append(string);
        }
        string = sb.toString();
        System.gc();
        return string;
    }

    private static String sanitizeFilename(String string) {
        for (int i = 0; i < UIUtils.INVALID_FILENAME_CHARS.length; ++i) {
            int index;
            while ((index = string.indexOf(UIUtils.INVALID_FILENAME_CHARS[i])) != -1) {
                string = string.substring(0, index) + "_" + string.substring(index + 1);
            }
        }
        return string;
    }

    public static boolean focusComponent(final Screen Screen, final UIComponent UIComponent) {
        for (int i = 0; i < Screen.componentCount; ++i) {
            if (UIComponent.equals(Screen.components.elementAt(i)) && UIComponent.isVisible) {
                Screen.setSelectedIndex(i);
                Screen.scrollToComponent(Screen.getSelectedIndex());
                return true;
            }
        }
        return false;
    }

    public static boolean isComponentSelected(final Screen Screen, final UIComponent obj) {
        try {
            if (Screen.components.elementAt(Screen.getSelectedIndex()).equals(obj)) {
                return true;
            }
        } catch (final Exception ex) {
        }
        return false;
    }

    public static void showTextInput(final Screen Screen, final TextInputComponent TextInputComponent) {
        TextInputComponent.isVisible = true;
        TextInputComponent.posY = home.thienph.xyahoo107.screens.Screen.screenHeight - GameManager.footerHeight - (FontRenderer.fontHeight << 1);
        focusComponent(Screen, (UIComponent) TextInputComponent);
    }

    public static void hideTextInput(Screen Screen, final TextInputComponent TextInputComponent) {
        TextInputComponent.isVisible = false;
        TextInputComponent.posY = GameGraphics.screenHeight + 1000;
        Screen = Screen;
        for (int i = 0; i < Screen.componentCount; ++i) {
            final UIComponent UIComponent;
            if ((UIComponent = (UIComponent) Screen.components.elementAt(i)).isVisible) {
                focusComponent(Screen, UIComponent);
                break;
            }
        }
        TextInputComponent.setText("");
    }

    public static boolean isTextInputWithHelpBox(final UIComponent UIComponent) {
        return UIComponent instanceof TextInputComponent && ((TextInputComponent) UIComponent).showHelpBox;
    }

    public static String formatNumberWithDots(final long i) {
        int n = 0;
        final StringBuffer sb;
        int length = (sb = new StringBuffer(Long.toString(i))).length();
        while (--length >= 0) {
            if (++n == 3) {
                n = 0;
                if (length == 0) {
                    continue;
                }
                sb.insert(length, ".");
            }
        }
        final String string = sb.toString();
        System.gc();
        return string;
    }

    public static void setScreenSubtitle(final Screen Screen, final int n) {
        Screen.subtitle = FontRenderer.getFirstLineWrapped(Screen.title, n);
        GameManager.instance.updateTitlePosition();
    }

    public static void setScreenTitle(final Screen Screen, final String j) {
        setScreenSubtitleText(Screen, Screen.title = j);
    }

    public static void setScreenSubtitleText(final Screen Screen, final String s) {
        Screen.subtitle = FontRenderer.getFirstLineWrapped(s, GameGraphics.screenWidth - 30);
        GameManager.instance.updateTitlePosition();
    }

    public static void drawGameIcon(final Graphics graphics, final int n, final int n2, final int n3) {
        graphics.setColor(396304);
        graphics.fillRect(n - 3, n2 - 3, 24, 24);
        graphics.setColor(14545919);
        ButtonComponent.drawRoundedBorder(graphics, n - 4, n2 - 4, 25, 25);
        graphics.drawRegion(GameManager.gameIcons, n3 * 18, 0, 18, 18, 0, n, n2, 20);
        graphics.setColor(0);
    }

    public static void drawTooltip(final Graphics graphics, final int n, final int n2, int i, int length, final String[] array, final int n3) {
        graphics.setColor(396304);
        graphics.fillRect(n - 3, n2 - 1, i + 1, length + 1);
        graphics.setColor(14545919);
        ButtonComponent.drawRoundedBorder(graphics, n - 4, n2 - 2, i + 2, length + 2);
        if (n3 == 0) {
            i = n + (i >> 1);
            graphics.setColor(396304);
            graphics.fillTriangle(i - 3, n2 + length - 2, i, n2 + length + 5, i + 3, n2 + length - 2);
            graphics.setColor(14545919);
            graphics.drawLine(i - 3, n2 + length, i, n2 + length + 5);
            graphics.drawLine(i, n2 + length + 5, i + 3, n2 + length);
        } else if (n3 == 1) {
            i = n + i - ((i / 6 < 7) ? 7 : (i / 6));
            graphics.setColor(396304);
            graphics.fillTriangle(i - 3, n2 + length - 2, i + 4, n2 + length + 5, i + 4, n2 + length - 2);
            graphics.setColor(14545919);
            graphics.drawLine(i - 2, n2 + length, i + 3, n2 + length + 5);
            graphics.drawLine(i + 3, n2 + length + 5, i + 3, n2 + length);
        } else if (n3 == 2) {
            i = n + (i >> 1);
            graphics.setColor(396304);
            graphics.fillTriangle(i - 3, n2 - 1, i, n2 - 7, i + 3, n2 - 1);
            graphics.setColor(14545919);
            graphics.drawLine(i - 3, n2 - 2, i, n2 - 7);
            graphics.drawLine(i, n2 - 7, i + 3, n2 - 2);
        } else {
            i = n + i / 6;
            graphics.setColor(396304);
            graphics.fillTriangle(i - 3, n2 + length - 2, i - 3, n2 + length + 5, i + 4, n2 + length - 2);
            graphics.setColor(14545919);
            graphics.drawLine(i - 3, n2 + length, i - 3, n2 + length + 5);
            graphics.drawLine(i - 3, n2 + length + 5, i + 2, n2 + length);
        }
        String s;
        int n4;
        int length2;
        int beginIndex;
        int j;
        char char1;
        String substring;
        for (i = 0, length = array.length; i < length; ++i) {
            s = array[i];
            n4 = n;
            length2 = s.length();
            beginIndex = 0;
            for (j = 0; j < length2; ++j) {
                if ((char1 = s.charAt(j)) >= '\u7530') {
                    substring = s.substring(beginIndex + 1, j);
                    FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(substring, n4, n2 + i * FontRenderer.lineHeight, graphics);
                    n4 += FontRenderer.getTextWidth(substring);
                    graphics.drawRegion(GameManager.gameIcons, (char1 - '\u7530') * 18, 0, 18, 18, 0, n4 + 10, n2 + i * FontRenderer.lineHeight + (FontRenderer.lineHeight >> 1), 3);
                    n4 += 20;
                    beginIndex = j;
                }
            }
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(s.substring(beginIndex, length2), n4, n2 + i * FontRenderer.lineHeight, graphics);
        }
    }

    public static int validateColor(final int n) {
        if (n == 0 || n == 0) {
            return 16777215;
        }
        return n;
    }

    public static void markScreenForUpdate(final UIComponent UIComponent) {
        if (UIComponent.parentScreen != null) {
            UIComponent.parentScreen.needsUpdate = true;
        }
    }

    public static void calculateTextPositions(final String s, final String s2) {
        UIUtils.rightTextX = Screen.screenWidth - FontRenderer.getTextWidth(s2) - 4;
        UIUtils.centerTextX = Screen.screenWidth - FontRenderer.getTextWidth(s) >> 1;
    }

    public static Image createImageFromBytes(final byte[] array) {
        try {
            final Image image = Image.createImage(array, 0, array.length);
            System.gc();
            return image;
        } catch (final Exception ex) {
            return null;
        }
    }

    public static String concatStrings(String string, final String str, final String str2, final String str3) {
        final StringBuffer sb;
        (sb = new StringBuffer(string)).append(str);
        if (str2 != null) {
            sb.append(str2);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        string = sb.toString();
        System.gc();
        return string;
    }

    public static void clearRecordStores(final boolean b) {
        final String[] listRecordStores;
        if ((listRecordStores = RecordStore.listRecordStores()) != null) {
            try {
                int length = listRecordStores.length;
                while (--length >= 0) {
                    if (!b || !listRecordStores[length].startsWith("xkown")) {
                        RecordStore.deleteRecordStore(listRecordStores[length]);
                    }
                }
            } catch (final Exception ex) {
            }
        }
    }

    public static boolean isEmptyTextComponent(final UIComponent UIComponent) {
        final TextComponent TextComponent;
        return UIComponent instanceof TextComponent && ((TextComponent = (TextComponent) UIComponent).text.length() == 0 || TextComponent.text.equals(" "));
    }

    public static void calculateColumnLayout(final int f, final int g) {
        if (UIUtils.rightColumnWidth != 0) {
            return;
        }
        if ((UIUtils.rightColumnWidth = Screen.screenWidth * 6 / 10 - 8) > g) {
            UIUtils.rightColumnWidth = g;
        }
        if ((UIUtils.leftColumnWidth = Screen.screenWidth - UIUtils.rightColumnWidth - 13 - 8) > f) {
            UIUtils.leftColumnWidth = f;
        }
        UIUtils.rightColumnX = (UIUtils.leftColumnX = (((UIUtils.leftColumnX = (Screen.screenWidth - (UIUtils.rightColumnWidth + UIUtils.leftColumnWidth + 13) >> 1) - 2) < 6) ? 6 : UIUtils.leftColumnX)) + UIUtils.leftColumnWidth + 13;
        if (GameGraphics.screenWidth < 135) {
            UIUtils.leftColumnX -= 7;
        }
    }
}
