package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;

public final class ButtonComponent extends UIComponent {
    private String buttonText;
    private int textCenterX;
    private int pressAnimationTimer;
    public Action buttonAction;
    private static int tempHeight;
    private static int tempX2;
    private static int tempX1;
    private static int tempY;

    public ButtonComponent() {
    }

    public ButtonComponent(String var1, int var2, int var3) {
        this.pressAnimationTimer = 0;
        super.width = var2;
        super.height = var3;
        super.middleSoftKey = new UIFactory("Chọn", null);
        this.buttonText = var1;
        this.textCenterX = super.width - FontRenderer.getTextWidth(var1) >> 1;
    }

    public boolean handleKeyPress(int var1) {
        if (var1 == 16) {
            this.pressAnimationTimer = 2;
            return false;
        } else {
            return true;
        }
    }

    public void handlePointerPress(int var1, int var2) {
        if (this.isFocused()) {
            this.buttonAction.action();
        } else {
            UIUtils.focusComponent(super.parentScreen, this);
        }
    }

    public void render(Graphics var1) {
        boolean var2 = this.isFocused();
        var1.setColor(var2 ? 1588055 : 1124399);
        var1.fillRect(super.posX + 2, super.posY + 1, super.width - 3, super.height - 4 >> 1);
        var1.setColor(var2 ? 1389387 : 728097);
        var1.fillRect(super.posX + 2, super.posY + (super.height - 4 >> 1), super.width - 3, super.height - 4 >> 1);
        var1.setColor(var2 ? 8700157 : 9478569);
        drawRoundedBorder(var1, super.posX + 1, super.posY, super.width - 2, super.height - 4);
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.buttonText, super.posX + this.textCenterX, super.posY + 3, var1);
    }

    public void update() {
        if (this.pressAnimationTimer > 0) {
            this.pressAnimationTimer--;
            if (this.pressAnimationTimer == 0 && this.buttonAction != null) {
                this.buttonAction.action();
            }
        }
    }

    public static void drawRoundedBorder(Graphics var0, int var1, int var2, int var3, int var4) {
        var3++;
        var4++;
        tempX2 = var1 + var3 - 2;
        tempY = var2 + var4 - 2;
        tempX1 = var1 + 1;
        var0.fillRect(tempX1, tempY, 1, 1);
        var0.fillRect(tempX2, tempY, 1, 1);
        tempY = var2 + 1;
        var0.fillRect(tempX1, tempY, 1, 1);
        var0.fillRect(tempX2, tempY, 1, 1);
        tempHeight = var4 - 4;
        tempX2 = var2 + 2;
        var0.fillRect(var1, tempX2, 1, tempHeight);
        var0.fillRect(var1 + var3 - 1, tempX2, 1, tempHeight);
        tempHeight = var1 + 2;
        tempX2 = var3 - 4;
        var0.fillRect(tempHeight, var2, tempX2, 1);
        var0.fillRect(tempHeight, var2 + var4 - 1, tempX2, 1);
    }

    public static void drawButtonBackground(Graphics var0, int var1, int var2, int var3, int var4) {
        var0.setColor(66826);
        var0.fillRect(var1 + 1, var2 + 1, var3 - 1, var4 - 1);
        var0.setColor(8700157);
        drawRoundedBorder(var0, var1, var2, var3, var4);
    }

    public boolean handleDirectKeyPress(int var1) {
        return true;
    }
}
