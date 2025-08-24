package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.actions.BuddyListItem;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.ImageCache;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class ListComponent extends UIComponent {
    private int iconType;
    private int enableIconStatus;
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
    private int enableDescription;
    public BuddyGroupList dataSource;
    public Vector listItems;
    private int totalItemCount;
    private int rightTextX;
    private StringBuffer stringBuffer;
    private boolean keyProcessed;
    private BuddyListItem currentItem;
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

    public void setIconSettings(int iconType, int iconWidth, int iconHeight) {
        this.iconType = iconType;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
    }

    public void setEnableIconStatus(int enableIconStatus) {
        this.enableIconStatus = enableIconStatus;
    }

    public int getIconType() {
        return this.iconType;
    }

    public void setMultiSelectMode(boolean multiSelectMode) {
        this.isMultiSelectMode = multiSelectMode;
    }

    public void setDataSource(BuddyGroupList dataSource, int enableDescription, boolean adjustHeight) {
        this.enableDescription = enableDescription;
        this.listSelectedIndex = 0;
        if (adjustHeight) {
            super.height = super.height - (GameManager.footerHeight + 2);
        }

        this.maxItemTextWidth = super.width - 36 - this.iconWidth;
        this.itemHeight = this.rowHeight = FontRenderer.fontHeight + 8;
        this.doubleRowHeight = (this.rowHeight << 1) - 3;
        if (this.enableDescription == 0) {
            if (this.rowHeight < this.iconHeight + 8) {
                this.rowHeight = this.iconHeight + 8;
                this.doubleRowHeight = (this.rowHeight << 1) - 4;
            }
        } else if (this.enableDescription == 1 && this.doubleRowHeight < this.iconHeight + 8) {
            this.doubleRowHeight = this.iconHeight + 8;
        }

        this.dataSource = dataSource;
        this.textStartX = this.iconType != 0 ? 15 + this.iconWidth : 9;
        this.maxTextWidth = super.width - 18;
        if (this.enableIconStatus != 0) {
            this.maxTextWidth -= 12;
        }

        if (this.iconType != 0) {
            this.maxTextWidth = this.maxTextWidth - (6 + this.iconWidth);
        }

        this.buildListItems();
    }

    public ListComponent(int posX, int posY, int width, int height) {
        super(0, 0, width, height, true);
        new Vector();
        this.selectAction = new ButtonAction("Chọn", null);
        this.emptyAction = new ButtonAction("", null);
        this.multiSelectAction = new ButtonAction("Chọn", null);
        this.isMultiSelectMode = false;
        String[] defaultMessages = new String[]{"Vui lòng chờ"};
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
            Vector contactGroups = this.dataSource.contactGroups;
            int groupCount = this.dataSource.contactGroups.size();
            int contactCount = 0;

            for (int groupIndex = 0; groupIndex < groupCount; groupIndex++) {
                BuddyGroup currentGroup = (BuddyGroup) contactGroups.elementAt(groupIndex);
                BuddyListItem groupItem;
                (groupItem = new BuddyListItem()).groupName = currentGroup.getGroupName();
                if (groupItem.groupName != null && groupItem.groupName.length() > 0) {
                    groupItem.itemType = 1;
                    groupItem.statusCode = currentGroup.expansionStatus;
                    this.listItems.addElement(groupItem);
                    if (groupItem.statusCode == 1) {
                        continue;
                    }
                }

                Vector groupContacts = currentGroup.contacts;
                contactCount = currentGroup.contacts.size();

                for (int contactIndex = 0; contactIndex < contactCount; contactIndex++) {
                    BuddyInfo currentContact = (BuddyInfo) groupContacts.elementAt(contactIndex);
                    BuddyListItem contactItem;
                    (contactItem = new BuddyListItem()).rawData = currentContact.getRawDataArray();
                    contactItem.groupName = currentContact.username;
                    contactItem.statusCode = currentContact.statusCode;
                    contactItem.displayName = currentContact.displayName;
                    currentContact.getDefaultColor();
                    contactItem.textColor = null;
                    contactItem.textColor = new Integer(currentContact.getDefaultColor());
                    contactItem.timestamp = currentContact.timestamp;
                    contactItem.fileName = currentContact.fileName;
                    contactItem.description = currentContact.statusDescription;
                    contactItem.imageSourceId = currentContact.imageSourceId;
                    contactItem.thumbnailImage = currentContact.thumbnailImage;
                    if (contactItem.description != null && GameGraphics.screenWidth < 160) {
                        if (this.stringBuffer == null) {
                            this.stringBuffer = new StringBuffer();
                        } else {
                            this.stringBuffer.delete(0, this.stringBuffer.length());
                        }

                        this.stringBuffer.append(contactItem.displayName);
                        this.stringBuffer.append(" - ");
                        this.stringBuffer.append(contactItem.description);
                        contactItem.displayName = this.stringBuffer.toString();
                        contactItem.description = null;
                    }

                    if (this.rightTextX == 0 && contactItem.description != null) {
                        this.rightTextX = super.width - (FontRenderer.getTextWidth(contactItem.description) + 31);
                    }

                    contactItem.isSelected = currentContact.isSelected;
                    contactItem.statusText = currentContact.description;
                    contactItem.contactRef = currentContact;
                    this.listItems.addElement(contactItem);
                }
            }

            this.totalItemCount = this.listItems.size();
            if (this.listSelectedIndex < 0) {
                this.listSelectedIndex = 0;
            }

            if (this.listSelectedIndex >= this.totalItemCount) {
                this.listSelectedIndex = this.totalItemCount - 1;
            }

            if (this.enableDescription == 0) {
                this.visibleItemCount = super.height / this.itemHeight + 2;
                this.maxScrollY = this.totalItemCount * this.rowHeight - super.height;
            } else if (this.enableDescription == 1) {
                this.visibleItemCount = super.height / this.doubleRowHeight + (groupCount > 1 ? groupCount : 2);
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
        } else if (((BuddyListItem) this.listItems.elementAt(this.listSelectedIndex)).itemType == 1) {
            super.middleSoftKey = this.emptyAction;
        } else if (this.isMultiSelectMode) {
            super.middleSoftKey = this.multiSelectAction;
        } else {
            super.middleSoftKey = this.selectAction;
        }
    }

    public boolean handleDirectKeyPress(int keyCode) {
        if (keyCode != 13 && keyCode != 12) {
            return true;
        } else {
            this.handleKeyPress(keyCode);
            return false;
        }
    }

    private void updateScrollPosition() {
        if (this.enableDescription == 0) {
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

    public boolean handleKeyPress(int keyCode) {
        if (this.listItems != null && this.totalItemCount != 0) {
            label38:
            {
                this.keyProcessed = true;
                if (keyCode == 12) {
                    this.listSelectedIndex--;
                    if (this.listSelectedIndex >= 0) {
                        break label38;
                    }

                    this.listSelectedIndex = this.totalItemCount - 1;
                } else if (keyCode == 13) {
                    this.listSelectedIndex++;
                    if (this.listSelectedIndex < this.totalItemCount) {
                        break label38;
                    }

                    this.listSelectedIndex = 0;
                }

                this.keyProcessed = false;
            }

            if (keyCode == 12 || keyCode == 13) {
                this.updateSoftKeys();
                this.updateScrollPosition();
                GameGraphics.clearKeyStates();
                ScrollBar.setScrolling(true);
                this.resetTextScrolling();
                UIUtils.markScreenForUpdate(this);
            }

            if (keyCode == 16) {
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
        this.currentItem = (BuddyListItem) this.listItems.elementAt(this.listSelectedIndex);
        if (this.currentItem.itemType == 0) {
            if (this.isMultiSelectMode) {
                BuddyListItem selectedItem = (BuddyListItem) this.listItems.elementAt(this.listSelectedIndex);
                ((BuddyListItem) this.listItems.elementAt(this.listSelectedIndex)).isSelected = !selectedItem.isSelected;
                selectedItem.contactRef.isSelected = !selectedItem.contactRef.isSelected;
                return;
            }
            if (this.itemAction != null) {
                this.itemAction.action();
            }
        } else {
            BuddyGroup contactGroup = this.dataSource.findBuddyContactByName(this.currentItem.groupName);
            if (contactGroup != null) {
                contactGroup.expansionStatus = this.currentItem.statusCode == 0 ? 1 : 0;
            }
            this.buildListItems();
        }
    }

    private void resetTextScrolling() {
        this.textScrollTimer = 0;
        this.currentTextWidth = 0;
        this.needsTextScrolling = false;
    }

    public void render(Graphics graphics) {
        graphics.setClip(super.posX, super.posY, super.width, super.height);
        graphics.translate(0, -this.currentScrollY);
        if (this.enableDescription == 0) {
            this.currentDrawY = this.firstVisibleIndex * this.rowHeight - 2;
        } else {
            this.currentDrawY = this.firstVisibleIndex * this.doubleRowHeight - 2;
        }

        this.lastVisibleIndex = this.firstVisibleIndex + this.visibleItemCount;
        this.itemCountLimit = this.totalItemCount;
        int itemCenterY = 0;
        int itemDrawHeight = 0;

        for (int itemIndex = this.firstVisibleIndex; itemIndex <= this.lastVisibleIndex && itemIndex < this.itemCountLimit; itemIndex++) {
            BuddyListItem currentListItem;
            if ((currentListItem = (BuddyListItem) this.listItems.elementAt(itemIndex)).itemType == 1) {
                itemDrawHeight = this.itemHeight;
                graphics.setColor(2440262);
                graphics.fillRect(0, itemIndex == 0 ? this.currentDrawY + 1 : this.currentDrawY + 2, super.width, itemDrawHeight);
                if (itemIndex == this.listSelectedIndex) {
                    this.drawSelectionBackground(graphics, itemIndex, itemDrawHeight);
                }

                itemCenterY = this.currentDrawY + (this.itemHeight >> 1) + 1;
                graphics.drawImage(GameManager.arrowIcons[currentListItem.statusCode], 10, itemCenterY, 3);
                FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(currentListItem.groupName, 22, this.currentDrawY + 5, graphics);
            } else {
                itemDrawHeight = this.rowHeight;
                if (this.enableDescription == 1) {
                    itemDrawHeight = this.doubleRowHeight;
                }

                if (itemIndex == this.listSelectedIndex) {
                    this.drawSelectionBackground(graphics, itemIndex, itemDrawHeight);
                }

                if (itemIndex == this.listSelectedIndex) {
                    if (this.currentTextWidth == 0) {
                        this.textScrollX = this.textStartX;
                        this.currentTextWidth = FontRenderer.getTextWidth(currentListItem.displayName);
                        itemCenterY = currentListItem.statusText == null ? 0 : FontRenderer.getTextWidth(currentListItem.statusText);
                        if (this.currentTextWidth < itemCenterY) {
                            this.currentTextWidth = itemCenterY;
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

                itemCenterY = this.currentDrawY + (this.enableDescription == 0 ? (this.rowHeight - FontRenderer.fontHeight >> 1) - 1 : this.doubleRowHeight - (FontRenderer.fontHeight << 1) - 5 >> 1) + 2;
                if (this.enableIconStatus != 0) {
                    graphics.setClip(-5, graphics.getClipY(), this.textStartX + this.maxTextWidth, graphics.getClipHeight());
                }

                if (currentListItem.displayName != null) {
                    FontRenderer.getFontInstance(currentListItem.textColor).drawText(currentListItem.displayName, itemIndex == this.listSelectedIndex ? this.textScrollX : this.textStartX, itemCenterY, graphics);
                }

                if (this.enableDescription == 1 && currentListItem.statusText != null) {
                    FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(currentListItem.statusText, itemIndex == this.listSelectedIndex ? this.textScrollX : this.textStartX, itemCenterY + FontRenderer.fontHeight + 3, graphics);
                }

                if (this.enableIconStatus != 0) {
                    graphics.setClip(super.posX, graphics.getClipY(), super.width, graphics.getClipHeight());
                }

                if (this.isMultiSelectMode && currentListItem.statusCode != 3) {
                    graphics.drawRegion(GameManager.loadingImage, 0, currentListItem.isSelected ? 13 : 0, 13, 13, 0, super.width - 12, this.currentDrawY + (this.rowHeight >> 1), 3);
                } else if (this.enableIconStatus != 0) {
                    graphics.drawImage(GameManager.statusIcons[this.enableIconStatus == 1 ? currentListItem.statusCode : 6], super.width - 9 - 10, this.currentDrawY + ((this.enableDescription == 0 ? this.rowHeight : this.doubleRowHeight) >> 1) + 1, 6);
                }

                if (currentListItem.description != null) {
                    if (this.enableDescription == 1) {
                        itemCenterY = this.currentDrawY + (this.doubleRowHeight - FontRenderer.fontHeight >> 1);
                    }

                    FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(currentListItem.description, this.rightTextX, itemCenterY, graphics);
                }

                itemCenterY = this.currentDrawY + ((this.enableDescription == 0 ? this.rowHeight : this.doubleRowHeight) >> 1) + 1;
                if (this.iconType != 0) {
                    if (this.iconType != 1) {
                        graphics.setClip(itemIndex == this.listSelectedIndex ? this.textScrollX - 6 - this.iconWidth : 9, this.currentDrawY < this.currentScrollY ? this.currentScrollY : this.currentDrawY + 2, this.iconWidth, itemDrawHeight - 1);
                        graphics.drawImage(currentListItem.thumbnailImage == null ? ImageCache.getImage(currentListItem.imageSourceId) : currentListItem.thumbnailImage, itemIndex == this.listSelectedIndex ? this.textScrollX - 6 - this.iconWidth : 9, itemCenterY, 6);
                        graphics.setClip(super.posX, super.posY + this.currentScrollY, super.width, super.height);
                    } else {
                        graphics.drawImage(GameManager.statusIcons[5], itemIndex == this.listSelectedIndex ? this.textScrollX - 6 - this.iconWidth : 9, itemCenterY, 6);
                    }
                }
            }

            if (itemIndex == this.listSelectedIndex) {
                graphics.setColor(8700157);
                graphics.fillRect(0, this.currentDrawY + 1, super.width, 1);
            } else {
                graphics.setColor(6781570);
            }

            graphics.fillRect(0, this.currentDrawY + itemDrawHeight + 1, super.width, 1);
            this.currentDrawY += itemDrawHeight;
        }

        graphics.translate(0, this.currentScrollY);
    }

    private void drawSelectionBackground(Graphics graphics, int itemIndex, int itemDrawHeight) {
        graphics.setColor(66826);
        graphics.fillRect(0, itemIndex == 0 ? this.currentDrawY + 1 : this.currentDrawY + 2, super.width, itemDrawHeight);
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

            this.firstVisibleIndex = this.currentScrollY / (this.enableDescription == 0 ? this.rowHeight : this.doubleRowHeight) - 1;
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

    public void renderFocusIndicator(Graphics graphics) {
        ScrollBar.render(graphics, this.listSelectedIndex);
    }

    public void handlePointerRelease(int touchX, int touchY) {
        this.lastTouchX = touchX;
        this.lastTouchY = touchY;
    }

    public void handlePointerPress(int touchX, int touchY) {
        if (this.isDragging) {
            this.isDragging = false;
            this.targetScrollY = this.targetScrollY - (touchY - this.lastTouchY) * 5;
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }
        } else {
            if (this.enableDescription == 0) {
                touchX = (touchY + this.currentScrollY) / this.rowHeight;
            } else {
                touchX = (touchY + this.currentScrollY) / this.doubleRowHeight;
            }

            if (touchX < 0) {
                touchX = 0;
            }

            if (touchX > this.totalItemCount - 1) {
                touchX = this.totalItemCount - 1;
            }

            if (this.listSelectedIndex == touchX) {
                this.handleSelection();
                return;
            }

            this.listSelectedIndex = touchX;
            this.updateSoftKeys();
            this.resetTextScrolling();
            UIUtils.markScreenForUpdate(this);
        }

        ScrollBar.setScrolling(true);
    }

    public void handlePointerDrag(int touchX, int touchY) {
        if (ContactListComponent.abs(touchX - this.lastTouchX) > 1 || ContactListComponent.abs(touchY - this.lastTouchY) > 1) {
            this.isDragging = true;
            this.targetScrollY = this.targetScrollY - (touchY - this.lastTouchY);
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            }

            if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }

            this.currentScrollY = this.targetScrollY;
            this.firstVisibleIndex = this.currentScrollY / (this.enableDescription == 0 ? this.rowHeight : this.doubleRowHeight) - 1;
            if (this.firstVisibleIndex < 0) {
                this.firstVisibleIndex = 0;
            }

            this.lastTouchX = touchX;
            this.lastTouchY = touchY;
        }

        ScrollBar.setScrolling(true);
    }

    public BuddyListItem getSelectedItem() {
        return this.listSelectedIndex < 0 ? null : (BuddyListItem) this.listItems.elementAt(this.listSelectedIndex);
    }

    public String[] getSelectedItemIds() {
        if (this.isMultiSelectMode) {
            Vector selectedIds = new Vector();

            for (int itemIndex = this.totalItemCount - 1; itemIndex >= 0; itemIndex--) {
                BuddyListItem listItem;
                if ((listItem = (BuddyListItem) this.listItems.elementAt(itemIndex)).itemType == 0 && listItem.isSelected) {
                    listItem.isSelected = false;
                    selectedIds.addElement(listItem.fileName);
                }
            }

            if (selectedIds.size() > 0) {
                String[] resultArray = new String[selectedIds.size()];
                selectedIds.copyInto(resultArray);
                return resultArray;
            }
        }

        return null;
    }

    public void toggleSelectAll() {
        if (this.isMultiSelectMode) {
            this.allSelected = !this.allSelected;

            for (int itemIndex = this.totalItemCount - 1; itemIndex >= 0; itemIndex--) {
                BuddyListItem listItem;
                if ((listItem = (BuddyListItem) this.listItems.elementAt(itemIndex)).itemType == 0) {
                    listItem.isSelected = this.allSelected;
                    listItem.contactRef.isSelected = this.allSelected;
                }
            }
        }
    }
}