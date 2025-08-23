package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.ImageCache;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class GridComponent extends UIComponent {
    private final Integer[] itemImageIds;
    private final int[] itemDataIds;
    private final Vector itemTextLines;
    private final int itemSpacingX;
    private final int itemHeaderHeight;
    private final int totalItemCount;
    private final int gridStartX;
    private final int gridStartY;
    private final int itemFullHeight;
    private final int scrollRowsNeeded;
    public int selectedColumnIndex = 0;
    public int selectedRowIndex = 0;
    private int scrollOffsetY = 0;
    public int columnsPerRow = 0;
    private int totalRows = 0;
    private final int itemWidth;
    private final int itemImageHeight;
    private final boolean hideImages;
    private final int displayMode; // độ hiển thị (1 hoặc 2 dòng text), 80%
    private int itemPadding;
    private final int imageCenterX;
    private final int imageCenterY;
    private int currentItemX;
    private int currentItemY;
    private int currentRow;
    private int currentColumn;
    private int renderStartY;
    private boolean isCurrentlySelected;
    private boolean hasSecondLine;
    private int selectionWidth;
    private final int selectionHeight;
    private int bounceOffset = 0;
    private int lastPointerY;

    public GridComponent(int var1, int var2, int var3, int var4, int var5, String[] var6, int[] var7, Integer[] var8, int var9, int var10, boolean var11, int var12) {
        super.posX = 0;
        super.posY = 0;
        super.width = var3;
        super.height = var4;
        super.isFocused = true;
        this.totalItemCount = var5;
        this.itemTextLines = new Vector();
        var1 = 0;

        for (int var14 = var6.length; var1 < var14; var1++) {
            String[] var17 = FontRenderer.splitStringByChar(var6[var1], '-');
            this.itemTextLines.addElement(var17);
        }

        this.itemDataIds = var7;
        this.itemImageIds = var8;
        this.itemWidth = var9;
        this.itemImageHeight = var10;
        this.hideImages = false;
        super.isPressed = true;
        this.displayMode = 2;
        var2 = (this.itemWidth < 30 ? 30 : this.itemWidth) + (GameGraphics.screenWidth > 220 ? 25 : 23);
        this.columnsPerRow = super.width / var2;
        this.totalRows = this.totalItemCount % this.columnsPerRow == 0 ? this.totalItemCount / this.columnsPerRow : this.totalItemCount / this.columnsPerRow + 1;
        this.itemSpacingX = (super.width - this.columnsPerRow * this.itemWidth) / (this.columnsPerRow + 1) + 3;
        this.itemHeaderHeight = 28;
        this.itemFullHeight = this.itemHeaderHeight + this.itemImageHeight + 6;
        this.gridStartX = (super.width - this.columnsPerRow * (this.itemWidth + this.itemSpacingX) >> 1) + (this.itemSpacingX >> 1);
        this.gridStartY = super.posY;
        var2 = this.gridStartY + (this.totalRows + 1) * this.itemFullHeight - super.height;
        this.scrollRowsNeeded = var2 / this.itemFullHeight;
        this.scrollOffsetY = 0;
        this.selectedColumnIndex = 0;
        this.selectedRowIndex = 0;
        this.itemPadding = 11;
        this.selectionWidth = this.itemWidth + this.itemPadding;
        if (this.selectionWidth < 50) {
            this.selectionWidth = 50;
            this.itemPadding = this.selectionWidth - this.itemWidth;
        }

        this.selectionHeight = this.itemImageHeight + 15 - 4;
        this.imageCenterX = this.selectionWidth >> 1;
        this.imageCenterY = this.itemImageHeight + 10 >> 1;
    }

    private boolean isSelected(int var1, int var2) {
        return var1 == this.selectedRowIndex && var2 == this.selectedColumnIndex;
    }

    private boolean isValidPosition(int var1, int var2) {
        return var1 * this.columnsPerRow + var2 <= this.totalItemCount - 1;
    }

    public int getSelectedItemId() {
        return this.itemDataIds[this.selectedRowIndex * this.columnsPerRow + this.selectedColumnIndex];
    }

    private void drawCenteredText(Graphics var1, String var2, int var3, int var4) {
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(var2, var3 + (this.itemWidth - FontRenderer.getTextWidth(var2) >> 1), var4, var1);
    }

    public boolean handleDirectKeyPress(int var1) {
        if (var1 != 13 && var1 != 12 && var1 != 14 && var1 != 15) {
            return true;
        } else {
            this.handleKeyPress(var1);
            return false;
        }
    }

    public boolean handleKeyPress(int i) {
        boolean b = true;
        switch (i) {
            case 14: {
                if (this.selectedColumnIndex > 0) {
                    --this.selectedColumnIndex;
                    b = false;
                    break;
                }
                break;
            }
            case 15: {
                if (this.selectedColumnIndex < this.columnsPerRow - 1 && this.isValidPosition(this.selectedRowIndex, this.selectedColumnIndex + 1)) {
                    ++this.selectedColumnIndex;
                    b = false;
                    break;
                }
                break;
            }
            case 12: {
                if (this.selectedRowIndex > 0) {
                    --this.selectedRowIndex;
                    if (this.scrollOffsetY < 0) {
                        this.scrollOffsetY += this.itemFullHeight;
                    }
                } else {
                    this.selectedRowIndex = this.totalRows - 1;
                    i = this.scrollRowsNeeded;
                    if (!this.isValidPosition(this.selectedRowIndex, this.selectedColumnIndex)) {
                        --this.selectedRowIndex;
                        --i;
                    }
                    if (this.gridStartY + this.selectedRowIndex * this.itemFullHeight > Screen.screenHeight - GameManager.footerHeight - 30) {
                        this.scrollOffsetY -= i * this.itemFullHeight;
                    }
                }
                this.calculateBounceOffset();
                b = false;
                ScrollBar.setScrolling(true);
                break;
            }
            case 13: {
                i = this.selectedColumnIndex;
                while (i >= 0) {
                    if (this.selectedRowIndex == this.totalRows - 1) {
                        this.selectedRowIndex = 0;
                        this.scrollOffsetY = 0;
                        break;
                    }
                    if (this.isValidPosition(this.selectedRowIndex + 1, i)) {
                        ++this.selectedRowIndex;
                        this.selectedColumnIndex = i;
                        i = Screen.screenHeight - GameManager.footerHeight - 30;
                        final int n = this.totalRows * this.itemFullHeight;
                        if (this.gridStartY + this.selectedRowIndex * this.itemFullHeight > i && n + this.scrollOffsetY > i) {
                            this.scrollOffsetY -= this.itemFullHeight;
                            break;
                        }
                        break;
                    } else {
                        --i;
                    }
                }
                this.calculateBounceOffset();
                b = false;
                ScrollBar.setScrolling(true);
                break;
            }
        }
        return b;
    }

    private void calculateBounceOffset() {
        this.bounceOffset = 0;
        if (this.selectedRowIndex != 0) {
            int var1 = (this.selectedRowIndex + 1) * this.itemFullHeight + this.scrollOffsetY + 5;
            if (super.height - var1 > 20 && this.selectedRowIndex == this.totalRows - 1 && this.scrollOffsetY < 0) {
                this.bounceOffset = 30;
            } else {
                if (super.height - var1 < 0) {
                    this.bounceOffset = super.height - var1;
                }
            }
        }
    }

    public void render(Graphics var1) {
        var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
        Graphics var2 = var1;
        GridComponent var11 = this;
        this.renderStartY = this.gridStartY + this.scrollOffsetY + this.bounceOffset + Screen.screenY + 15;
        int var3 = this.totalItemCount;

        while (--var3 >= 0) {
            var11.currentRow = var3 / var11.columnsPerRow;
            var11.currentColumn = var3 % var11.columnsPerRow;
            var11.currentItemX = var11.gridStartX + var11.currentColumn * (var11.itemWidth + var11.itemSpacingX);
            var11.currentItemY = var11.currentRow * (var11.itemFullHeight - 4) + var11.renderStartY;
            String[] var4 = (String[]) var11.itemTextLines.elementAt(var3);
            var11.isCurrentlySelected = var11.isSelected(var11.currentRow, var11.currentColumn);
            var11.hasSecondLine = var11.displayMode == 2 && var4.length > 1 && var4[1] != null;
            if (var11.currentItemY + var11.itemImageHeight + 10 > var11.posY && var11.currentItemY < Screen.screenHeight) {
                Image var10002 = var11.hideImages ? null : ImageCache.getImage(var11.itemImageIds[var3]);
                boolean var10 = var11.isCurrentlySelected;
                int var9 = var11.currentItemY;
                int var8 = var11.currentItemX;
                Image var7 = var10002;
                var8 -= var11.itemPadding >> 1;
                var9 -= 5;
                if (var10) {
                    ButtonComponent.drawButtonBackground(var2, var8 - 1, var9 - 1, var11.selectionWidth, var11.selectionHeight);
                }

                var2.drawImage(var7, var8 + var11.imageCenterX, var9 + var11.imageCenterY, 3);
                var11.drawCenteredText(var2, var4[0], var11.currentItemX, var11.currentItemY + var11.itemImageHeight + 5);
                if (var11.hasSecondLine) {
                    var11.currentItemY = var11.currentItemY + (FontRenderer.fontHeight - 2);
                    var11.drawCenteredText(var2, var4[1], var11.currentItemX, var11.currentItemY + var11.itemImageHeight + 1);
                }
            }
        }
    }

    public void onFocusGained() {
        if (this.gridStartY + this.totalRows * this.itemFullHeight > Screen.screenHeight) {
            ScrollBar.isVisible = true;
            ScrollBar.initialize(this.totalRows);
        } else {
            ScrollBar.isVisible = false;
        }
    }

    public void renderFocusIndicator(Graphics var1) {
        ScrollBar.render(var1, this.selectedRowIndex);
    }

    public void handlePointerRelease(int var1, int var2) {
        this.lastPointerY = var2;
    }

    public void handlePointerPress(int var1, int var2) {
        var2 += Screen.screenY;
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;

        for (int var7 = 0; var7 < this.totalItemCount; var7++) {
            var5 = var7 / this.columnsPerRow;
            var6 = var7 % this.columnsPerRow;
            var3 = this.gridStartX + var6 * (this.itemWidth + this.itemSpacingX);
            var4 = this.gridStartY + var5 * this.itemFullHeight + this.scrollOffsetY + 5;
            if (var1 > var3 - 4 && var1 < var3 + this.itemWidth + 4 && var2 > var4 && var2 < var4 + this.itemImageHeight + 24) {
                if (this.isSelected(var5, var6)) {
                    super.middleSoftKey.action.action();
                } else {
                    this.selectedRowIndex = var5;
                    this.selectedColumnIndex = var6;
                }
                break;
            }
        }

        ScrollBar.setScrolling(true);
    }

    public void handlePointerDrag(int var1, int var2) {
        if (ContactListComponent.abs(var1 = var2 - this.lastPointerY) > 10) {
            if (var1 > 0) {
                this.scrollOffsetY += var1;
                if (this.scrollOffsetY > 0) {
                    this.scrollOffsetY = 0;
                }
            } else {
                this.scrollOffsetY += var1;
                if (this.scrollOffsetY < -this.scrollRowsNeeded * this.itemFullHeight + 15) {
                    this.scrollOffsetY = -this.scrollRowsNeeded * this.itemFullHeight + 15;
                }
            }

            this.lastPointerY = var2;
        }

        ScrollBar.setScrolling(true);
    }

    public void update() {
    }
}
