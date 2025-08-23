package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;

public abstract class UIComponent {
    public boolean isVisible;
    public boolean isFocused;
    public int posX;
    public int posY;
    public int width;
    public int height;
    public int id;
    public Screen parentScreen;
    public ButtonAction leftSoftKey;
    public ButtonAction rightSoftKey;
    public ButtonAction middleSoftKey;
    public int selectedIndex = -1;
    public boolean isPressed = false;

    public UIComponent() {
        this.isVisible = true;
    }

    public UIComponent(int var1, int var2, int var3, int var4, boolean var5) {
        this.posX = var1;
        this.posY = var2;
        this.width = var3;
        this.height = var4;
        this.isVisible = true;
    }

    public final boolean isFocused() {
        return this.parentScreen != null && UIUtils.isComponentSelected(this.parentScreen, this);
    }

    public final void setPosition(int var1, int var2) {
        this.posX = var1;
        this.posY = var2;
    }

    public final void setSize(int var1, int var2) {
        this.width = var1;
        this.height = var2;
    }

    public final void setBounds(int var1, int var2, int var3, int var4) {
        this.setPosition(var1, var2);
        this.setSize(var3, var4);
    }

    public abstract void render(Graphics var1);

    public abstract void update();

    public abstract boolean handleKeyPress(int var1);

    public abstract boolean handleDirectKeyPress(int var1);

    public void onFocusGained() {
    }

    public void renderFocusIndicator(Graphics var1) {
    }

    public void handlePointerPress(int var1, int var2) {
    }

    public void handlePointerDrag(int var1, int var2) {
    }

    public void handlePointerRelease(int var1, int var2) {
    }
}
