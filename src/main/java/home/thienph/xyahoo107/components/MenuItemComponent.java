package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.utils.FontRenderer;

import javax.microedition.lcdui.Graphics;

public final class MenuItemComponent extends UIComponent {
    private String itemText;
    private int clickDelay;
    public DialogScreen parentMenu;
    public int itemIndex;
    private int textWidth;
    public boolean isExpanded;

    public MenuItemComponent() {
    }

    public MenuItemComponent(String var1, int var2, int var3, int var4, int var5) {
        this();
        this.clickDelay = 0;
        this.itemText = var1;
        super.posX = 0;
        super.posY = 0;
        super.width = var4;
        super.height = var5 < 19 ? var5 : 19;
    }

    public boolean handleKeyPress(int var1) {
        if (var1 == 16) {
            this.clickDelay = 2;
            return false;
        } else {
            return true;
        }
    }

    public void handlePointerPress(int var1, int var2) {
        this.parentMenu.expandMenu(this.itemIndex);
    }

    public void render(Graphics var1) {
        if (this.isFocused()) {
            this.textWidth = FontRenderer.getTextWidth(this.itemText);
            var1.setColor(66826);
            var1.fillRoundRect(super.posX + 19, super.posY + 1, this.textWidth + 10, super.height, 8, 8);
        }

        FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(this.itemText, super.posX + 22, super.posY + (super.height - FontRenderer.fontHeight >> 1), var1);
        var1.drawImage(GameManager.arrowIcons[this.isExpanded ? 0 : 1], super.posX + 10, super.posY + (super.height >> 1), 3);
    }

    public void update() {
        if (this.clickDelay > 0) {
            this.clickDelay--;
            if (this.clickDelay == 0) {
                this.parentMenu.expandMenu(this.itemIndex);
            }
        }
    }

    public boolean handleDirectKeyPress(int var1) {
        return true;
    }
}
