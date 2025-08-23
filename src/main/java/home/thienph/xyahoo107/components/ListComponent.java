package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.actions.quyen_bj;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyContact;
import home.thienph.xyahoo107.data.media.BuddyListManager;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.ImageCache;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class ListComponent extends UIComponent {
    private int iconType;
    private int statusIconType;
    private int iconWidth;
    private int iconHeight;
    private int targetScrollY;
    private int scrollSpeed;
    private int scrollAcceleration;
    private int currentScrollY;
    private int maxScrollY;
    private int itemHeight;
    private int rowHeight;
    private int doubleRowHeight;
    private int firstVisibleIndex;
    private int visibleItemCount;
    private int listSelectedIndex;
    public ButtonAction selectAction;
    private final ButtonAction emptyAction;
    private final ButtonAction multiSelectAction;
    private boolean isMultiSelectMode;
    private int maxTextWidth;
    private int displayMode;
    public BuddyListManager dataSource;
    public Vector listItems;
    private int totalItemCount;
    private int rightTextX;
    private StringBuffer stringBuffer;
    private boolean keyProcessed;
    private quyen_bj currentItem;
    public Action itemAction;
    private boolean needsTextScrolling;
    private boolean scrollingLeft;
    private int textScrollX;
    private int textScrollTimer;
    private int maxItemTextWidth;
    private int currentTextWidth;
    private int lastVisibleIndex;
    private int itemCountLimit;
    private int currentDrawY;
    private int textStartX;
    private boolean isDragging;
    private int lastTouchX;
    private int lastTouchY;
    private boolean allSelected;

    public void setIconSettings(int var1, int var2, int var3) {
        this.iconType = var1;
        this.iconWidth = var2;
        this.iconHeight = var3;
    }

    public void setStatusIconType(int var1) {
        this.statusIconType = var1;
    }

    public int getIconType() {
        return this.iconType;
    }

    public void setMultiSelectMode(boolean var1) {
        this.isMultiSelectMode = var1;
    }

    public void setDataSource(BuddyListManager var1, int var2, boolean var3) {
        this.displayMode = var2;
        this.listSelectedIndex = 0;
        if (var3) {
            super.height = super.height - (GameManager.footerHeight + 2);
        }

        this.maxItemTextWidth = super.width - 36 - this.iconWidth;
        this.itemHeight = this.rowHeight = FontRenderer.fontHeight + 8;
        this.doubleRowHeight = (this.rowHeight << 1) - 3;
        if (this.displayMode == 0) {
            if (this.rowHeight < this.iconHeight + 8) {
                this.rowHeight = this.iconHeight + 8;
                this.doubleRowHeight = (this.rowHeight << 1) - 4;
            }
        } else if (this.displayMode == 1 && this.doubleRowHeight < this.iconHeight + 8) {
            this.doubleRowHeight = this.iconHeight + 8;
        }

        this.dataSource = var1;
        this.textStartX = this.iconType != 0 ? 15 + this.iconWidth : 9;
        this.maxTextWidth = super.width - 18;
        if (this.statusIconType != 0) {
            this.maxTextWidth -= 12;
        }

        if (this.iconType != 0) {
            this.maxTextWidth = this.maxTextWidth - (6 + this.iconWidth);
        }

        this.buildListItems();
    }

    public ListComponent(int var1, int var2, int var3, int var4) {
        super(0, 0, var3, var4, true);
        new Vector();
        this.selectAction = new ButtonAction("Chọn", null);
        this.emptyAction = new ButtonAction("", null);
        this.multiSelectAction = new ButtonAction("Chọn", null);
        this.isMultiSelectMode = false;
        String[] var10000 = new String[]{"Vui lòng chờ"};
        this.textStartX = 22;
        this.allSelected = false;
        super.isPressed = true;
        super.isFocused = true;
    }

    public void buildListItems() {
        if (this.listItems == null) {
            this.listItems = new Vector();
        } else {
            this.listItems.removeAllElements();
        }

        System.gc();
        if (this.dataSource != null && this.dataSource.contactGroups != null && this.dataSource.contactGroups.size() != 0) {
            this.rightTextX = 0;
            Vector var1 = this.dataSource.contactGroups;
            int var2 = this.dataSource.contactGroups.size();
            int var3 = 0;

            for (int var4 = 0; var4 < var2; var4++) {
                BuddyGroup var9 = (BuddyGroup) var1.elementAt(var4);
                quyen_bj var5;
                (var5 = new quyen_bj()).c = var9.getGroupName();
                if (var5.c != null && var5.c.length() > 0) {
                    var5.a = 1;
                    var5.g = var9.expansionStatus;
                    this.listItems.addElement(var5);
                    if (var5.g == 1) {
                        continue;
                    }
                }

                Vector var11 = var9.contacts;
                var3 = var9.contacts.size();

                for (int var6 = 0; var6 < var3; var6++) {
                    BuddyContact var7 = (BuddyContact) var11.elementAt(var6);
                    quyen_bj var8;
                    (var8 = new quyen_bj()).k = var7.getRawDataArray();
                    var8.c = var7.username;
                    var8.g = var7.statusCode;
                    var8.d = var7.displayName;
                    var7.getDefaultColor();
                    var8.b = null;
                    var8.b = new Integer(var7.getDefaultColor());
                    var8.m = var7.timestamp;
                    var8.j = var7.fileName;
                    var8.l = var7.description;
                    var8.n = var7.priority;
                    var8.o = var7.thumbnailImage;
                    if (var8.l != null && GameGraphics.screenWidth < 160) {
                        if (this.stringBuffer == null) {
                            this.stringBuffer = new StringBuffer();
                        } else {
                            this.stringBuffer.delete(0, this.stringBuffer.length());
                        }

                        this.stringBuffer.append(var8.d);
                        this.stringBuffer.append(" - ");
                        this.stringBuffer.append(var8.l);
                        var8.d = this.stringBuffer.toString();
                        var8.l = null;
                    }

                    if (this.rightTextX == 0 && var8.l != null) {
                        this.rightTextX = super.width - (FontRenderer.getTextWidth(var8.l) + 31);
                    }

                    var8.h = var7.isSelected;
                    var8.e = var7.downloadText;
                    var8.i = var7;
                    this.listItems.addElement(var8);
                }
            }

            this.totalItemCount = this.listItems.size();
            if (this.listSelectedIndex < 0) {
                this.listSelectedIndex = 0;
            }

            if (this.listSelectedIndex >= this.totalItemCount) {
                this.listSelectedIndex = this.totalItemCount - 1;
            }

            if (this.displayMode == 0) {
                this.visibleItemCount = super.height / this.itemHeight + 2;
                this.maxScrollY = this.totalItemCount * this.rowHeight - super.height;
            } else if (this.displayMode == 1) {
                this.visibleItemCount = super.height / this.doubleRowHeight + (var2 > 1 ? var2 : 2);
                this.maxScrollY = this.totalItemCount * this.doubleRowHeight - super.height;
            }

            this.updateSoftKeys();
            this.updateScrollPosition();
            this.onFocusGained();
            System.gc();
        } else {
            this.firstVisibleIndex = 0;
            this.visibleItemCount = 0;
            this.maxScrollY = 0;
        }
    }

    private void updateSoftKeys() {
        if (this.listSelectedIndex == -1 || this.listSelectedIndex >= this.listItems.size() || this.listItems.size() == 0) {
            super.middleSoftKey = null;
        } else if (((quyen_bj) this.listItems.elementAt(this.listSelectedIndex)).a == 1) {
            super.middleSoftKey = this.emptyAction;
        } else if (this.isMultiSelectMode) {
            super.middleSoftKey = this.multiSelectAction;
        } else {
            super.middleSoftKey = this.selectAction;
        }
    }

    public boolean handleDirectKeyPress(int var1) {
        if (var1 != 13 && var1 != 12) {
            return true;
        } else {
            this.handleKeyPress(var1);
            return false;
        }
    }

    private void updateScrollPosition() {
        if (this.displayMode == 0) {
            this.targetScrollY = this.listSelectedIndex * this.rowHeight - (super.height >> 1);
        } else {
            this.targetScrollY = this.listSelectedIndex * this.doubleRowHeight - (super.height >> 1);
        }

        this.firstVisibleIndex = this.listSelectedIndex - (this.visibleItemCount >> 1) - 1;
        if (this.totalItemCount - this.listSelectedIndex < this.visibleItemCount >> 1) {
            this.firstVisibleIndex = this.totalItemCount - this.visibleItemCount;
        }

        if (this.firstVisibleIndex < 0) {
            this.firstVisibleIndex = 0;
        }
    }

    public boolean handleKeyPress(int var1) {
        if (this.listItems != null && this.totalItemCount != 0) {
            label38:
            {
                this.keyProcessed = true;
                if (var1 == 12) {
                    this.listSelectedIndex--;
                    if (this.listSelectedIndex >= 0) {
                        break label38;
                    }

                    this.listSelectedIndex = this.totalItemCount - 1;
                } else if (var1 == 13) {
                    this.listSelectedIndex++;
                    if (this.listSelectedIndex < this.totalItemCount) {
                        break label38;
                    }

                    this.listSelectedIndex = 0;
                }

                this.keyProcessed = false;
            }

            if (var1 == 12 || var1 == 13) {
                this.updateSoftKeys();
                this.updateScrollPosition();
                GameGraphics.clearKeyStates();
                ScrollBar.setScrolling(true);
                this.resetTextScrolling();
                UIUtils.markScreenForUpdate(this);
            }

            if (var1 == 16) {
                this.handleSelection();
                GameGraphics.clearKeyStates();
            }

            return !this.keyProcessed;
        } else {
            return true;
        }
    }

    private void handleSelection() {
        if (this.listSelectedIndex == -1) {
            return;
        }
        this.currentItem = (quyen_bj) this.listItems.elementAt(this.listSelectedIndex);
        if (this.currentItem.a == 0) {
            if (this.isMultiSelectMode) {
                quyen_bj quyen_bj2 = (quyen_bj) this.listItems.elementAt(this.listSelectedIndex);
                ((quyen_bj) this.listItems.elementAt(this.listSelectedIndex)).h = !quyen_bj2.h;
                quyen_bj2.i.isSelected = !quyen_bj2.i.isSelected;
                return;
            }
            if (this.itemAction != null) {
                this.itemAction.action();
            }
        } else {
            BuddyGroup contactGroup2 = this.dataSource.findBuddyContactByName(this.currentItem.c);
            if (contactGroup2 != null) {
                contactGroup2.expansionStatus = this.currentItem.g == 0 ? 1 : 0;
            }
            this.buildListItems();
        }
    }

    private void resetTextScrolling() {
        this.textScrollTimer = 0;
        this.currentTextWidth = 0;
        this.needsTextScrolling = false;
    }

    public void render(Graphics var1) {
        var1.setClip(super.posX, super.posY, super.width, super.height);
        var1.translate(0, -this.currentScrollY);
        if (this.displayMode == 0) {
            this.currentDrawY = this.firstVisibleIndex * this.rowHeight - 2;
        } else {
            this.currentDrawY = this.firstVisibleIndex * this.doubleRowHeight - 2;
        }

        this.lastVisibleIndex = this.firstVisibleIndex + this.visibleItemCount;
        this.itemCountLimit = this.totalItemCount;
        int var2 = 0;
        int var3 = 0;

        for (int var4 = this.firstVisibleIndex; var4 <= this.lastVisibleIndex && var4 < this.itemCountLimit; var4++) {
            quyen_bj var5;
            if ((var5 = (quyen_bj) this.listItems.elementAt(var4)).a == 1) {
                var3 = this.itemHeight;
                var1.setColor(2440262);
                var1.fillRect(0, var4 == 0 ? this.currentDrawY + 1 : this.currentDrawY + 2, super.width, var3);
                if (var4 == this.listSelectedIndex) {
                    this.drawSelectionBackground(var1, var4, var3);
                }

                var2 = this.currentDrawY + (this.itemHeight >> 1) + 1;
                var1.drawImage(GameManager.arrowIcons[var5.g], 10, var2, 3);
                FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(var5.c, 22, this.currentDrawY + 5, var1);
            } else {
                var3 = this.rowHeight;
                if (this.displayMode == 1) {
                    var3 = this.doubleRowHeight;
                }

                if (var4 == this.listSelectedIndex) {
                    this.drawSelectionBackground(var1, var4, var3);
                }

                if (var4 == this.listSelectedIndex) {
                    if (this.currentTextWidth == 0) {
                        this.textScrollX = this.textStartX;
                        this.currentTextWidth = FontRenderer.getTextWidth(var5.d);
                        var2 = var5.e == null ? 0 : FontRenderer.getTextWidth(var5.e);
                        if (this.currentTextWidth < var2) {
                            this.currentTextWidth = var2;
                        }

                        if (this.currentTextWidth > this.maxItemTextWidth) {
                            this.needsTextScrolling = this.scrollingLeft = true;
                        } else {
                            this.needsTextScrolling = false;
                        }
                    }

                    if (this.needsTextScrolling && this.textScrollTimer++ > 20) {
                        this.textScrollTimer = 21;
                        if (this.scrollingLeft) {
                            if (this.textScrollX > -(this.currentTextWidth - this.maxItemTextWidth) + this.textStartX - 9) {
                                this.textScrollX--;
                            } else {
                                this.textScrollTimer = 10;
                                this.scrollingLeft = false;
                            }
                        } else if (this.textScrollX < this.textStartX) {
                            this.textScrollX++;
                        } else {
                            this.textScrollTimer = 10;
                            this.scrollingLeft = true;
                        }
                    }
                }

                var2 = this.currentDrawY + (this.displayMode == 0 ? (this.rowHeight - FontRenderer.fontHeight >> 1) - 1 : this.doubleRowHeight - (FontRenderer.fontHeight << 1) - 5 >> 1) + 2;
                if (this.statusIconType != 0) {
                    var1.setClip(-5, var1.getClipY(), this.textStartX + this.maxTextWidth, var1.getClipHeight());
                }

                if (var5.d != null) {
                    FontRenderer.getFontInstance(var5.b).drawText(var5.d, var4 == this.listSelectedIndex ? this.textScrollX : this.textStartX, var2, var1);
                }

                if (this.displayMode == 1 && var5.e != null) {
                    FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(var5.e, var4 == this.listSelectedIndex ? this.textScrollX : this.textStartX, var2 + FontRenderer.fontHeight + 3, var1);
                }

                if (this.statusIconType != 0) {
                    var1.setClip(super.posX, var1.getClipY(), super.width, var1.getClipHeight());
                }

                if (this.isMultiSelectMode && var5.g != 3) {
                    var1.drawRegion(GameManager.loadingImage, 0, var5.h ? 13 : 0, 13, 13, 0, super.width - 12, this.currentDrawY + (this.rowHeight >> 1), 3);
                } else if (this.statusIconType != 0) {
                    var1.drawImage(GameManager.statusIcons[this.statusIconType == 1 ? var5.g : 6], super.width - 9 - 10, this.currentDrawY + ((this.displayMode == 0 ? this.rowHeight : this.doubleRowHeight) >> 1) + 1, 6);
                }

                if (var5.l != null) {
                    if (this.displayMode == 1) {
                        var2 = this.currentDrawY + (this.doubleRowHeight - FontRenderer.fontHeight >> 1);
                    }

                    FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(var5.l, this.rightTextX, var2, var1);
                }

                var2 = this.currentDrawY + ((this.displayMode == 0 ? this.rowHeight : this.doubleRowHeight) >> 1) + 1;
                if (this.iconType != 0) {
                    if (this.iconType != 1) {
                        var1.setClip(var4 == this.listSelectedIndex ? this.textScrollX - 6 - this.iconWidth : 9, this.currentDrawY < this.currentScrollY ? this.currentScrollY : this.currentDrawY + 2, this.iconWidth, var3 - 1);
                        var1.drawImage(var5.o == null ? ImageCache.getImage(var5.n) : var5.o, var4 == this.listSelectedIndex ? this.textScrollX - 6 - this.iconWidth : 9, var2, 6);
                        var1.setClip(super.posX, super.posY + this.currentScrollY, super.width, super.height);
                    } else {
                        var1.drawImage(GameManager.statusIcons[5], var4 == this.listSelectedIndex ? this.textScrollX - 6 - this.iconWidth : 9, var2, 6);
                    }
                }
            }

            if (var4 == this.listSelectedIndex) {
                var1.setColor(8700157);
                var1.fillRect(0, this.currentDrawY + 1, super.width, 1);
            } else {
                var1.setColor(6781570);
            }

            var1.fillRect(0, this.currentDrawY + var3 + 1, super.width, 1);
            this.currentDrawY += var3;
        }

        var1.translate(0, this.currentScrollY);
    }

    private void drawSelectionBackground(Graphics var1, int var2, int var3) {
        var1.setColor(66826);
        var1.fillRect(0, var2 == 0 ? this.currentDrawY + 1 : this.currentDrawY + 2, super.width, var3);
    }

    public void update() {
        if (this.currentScrollY != this.targetScrollY) {
            this.scrollSpeed = this.targetScrollY - this.currentScrollY << 2;
            this.scrollAcceleration = this.scrollAcceleration + this.scrollSpeed;
            this.currentScrollY = this.currentScrollY + (this.scrollAcceleration >> 4);
            this.scrollAcceleration &= 15;
            if (this.currentScrollY > this.maxScrollY) {
                this.currentScrollY = this.maxScrollY;
            }

            if (this.currentScrollY < 0) {
                this.currentScrollY = 0;
            }

            this.firstVisibleIndex = this.currentScrollY / (this.displayMode == 0 ? this.rowHeight : this.doubleRowHeight) - 1;
            if (this.firstVisibleIndex < 0) {
                this.firstVisibleIndex = 0;
            }
        }
    }

    public void onFocusGained() {
        if (this.listItems != null) {
            if (super.posY + this.totalItemCount * this.rowHeight >= super.height) {
                ScrollBar.isVisible = true;
                ScrollBar.initialize(this.totalItemCount);
            } else {
                ScrollBar.isVisible = false;
            }
        }
    }

    public void renderFocusIndicator(Graphics var1) {
        ScrollBar.render(var1, this.listSelectedIndex);
    }

    public void handlePointerRelease(int var1, int var2) {
        this.lastTouchX = var1;
        this.lastTouchY = var2;
    }

    public void handlePointerPress(int var1, int var2) {
        if (this.isDragging) {
            this.isDragging = false;
            this.targetScrollY = this.targetScrollY - (var2 - this.lastTouchY) * 5;
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }
        } else {
            if (this.displayMode == 0) {
                var1 = (var2 + this.currentScrollY) / this.rowHeight;
            } else {
                var1 = (var2 + this.currentScrollY) / this.doubleRowHeight;
            }

            if (var1 < 0) {
                var1 = 0;
            }

            if (var1 > this.totalItemCount - 1) {
                var1 = this.totalItemCount - 1;
            }

            if (this.listSelectedIndex == var1) {
                this.handleSelection();
                return;
            }

            this.listSelectedIndex = var1;
            this.updateSoftKeys();
            this.resetTextScrolling();
            UIUtils.markScreenForUpdate(this);
        }

        ScrollBar.setScrolling(true);
    }

    public void handlePointerDrag(int var1, int var2) {
        if (ContactListComponent.abs(var1 - this.lastTouchX) > 1 || ContactListComponent.abs(var2 - this.lastTouchY) > 1) {
            this.isDragging = true;
            this.targetScrollY = this.targetScrollY - (var2 - this.lastTouchY);
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            }

            if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }

            this.currentScrollY = this.targetScrollY;
            this.firstVisibleIndex = this.currentScrollY / (this.displayMode == 0 ? this.rowHeight : this.doubleRowHeight) - 1;
            if (this.firstVisibleIndex < 0) {
                this.firstVisibleIndex = 0;
            }

            this.lastTouchX = var1;
            this.lastTouchY = var2;
        }

        ScrollBar.setScrolling(true);
    }

    public quyen_bj getSelectedItem() {
        return this.listSelectedIndex < 0 ? null : (quyen_bj) this.listItems.elementAt(this.listSelectedIndex);
    }

    public String[] getSelectedItemIds() {
        if (this.isMultiSelectMode) {
            Vector var1 = new Vector();

            for (int var2 = this.totalItemCount - 1; var2 >= 0; var2--) {
                quyen_bj var3;
                if ((var3 = (quyen_bj) this.listItems.elementAt(var2)).a == 0 && var3.h) {
                    var3.h = false;
                    var1.addElement(var3.j);
                }
            }

            if (var1.size() > 0) {
                String[] var4 = new String[var1.size()];
                var1.copyInto(var4);
                return var4;
            }
        }

        return null;
    }

    public void toggleSelectAll() {
        if (this.isMultiSelectMode) {
            this.allSelected = !this.allSelected;

            for (int var1 = this.totalItemCount - 1; var1 >= 0; var1--) {
                quyen_bj var2;
                if ((var2 = (quyen_bj) this.listItems.elementAt(var1)).a == 0) {
                    var2.h = this.allSelected;
                    var2.i.isSelected = this.allSelected;
                }
            }
        }
    }
}
