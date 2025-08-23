package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;

public final class CheckboxComponent extends UIComponent {
    private final String checkboxText;
    private int pressAnimationTimer;
    public boolean isChecked;

    public CheckboxComponent(String var1, int var2, int var3, int var4, int var5) {
        this.checkboxText = var1;
        super.posX = var2;
        super.posY = var3;
        super.width = var4;
        super.height = var5;
        super.leftSoftKey = new UIFactory("Chọn", null);
    }

    public boolean handleDirectKeyPress(int var1) {
        return this.handleKeyPress(var1);
    }

    public boolean handleKeyPress(int var1) {
        if (var1 == 17) {
            this.pressAnimationTimer = 2;
            return false;
        } else {
            return true;
        }
    }

    private void toggleChecked() {
        this.isChecked = !this.isChecked;
    }

    public void handlePointerPress(int var1, int var2) {
        UIUtils.focusComponent(super.parentScreen, this);
        this.toggleChecked();
    }

    public void update() {
        if (this.pressAnimationTimer > 0) {
            this.pressAnimationTimer--;
            if (this.pressAnimationTimer == 0) {
                this.toggleChecked();
            }
        }
    }

    public void render(Graphics var1) {
        if (this.isFocused()) {
            ButtonComponent.drawButtonBackground(var1, super.posX - 3, super.posY, super.width + 9, super.height + 2);
        }

        var1.drawRegion(GameManager.loadingImage, 0, this.isChecked ? 13 : 0, 13, 13, 0, super.posX + 8, super.posY + (super.height >> 1) + 1, 3);
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.checkboxText, super.posX + 13 + 5, super.posY + 3, var1);
    }
}
