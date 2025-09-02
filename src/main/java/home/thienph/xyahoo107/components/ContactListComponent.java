package home.thienph.xyahoo107.components;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.BuddyListItem;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.ImageCache;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.PacketUtils;
import home.thienph.xyahoo107.utils.TextRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class ContactListComponent extends UIComponent {
    public boolean isChatMode;
    public boolean isFilterActive;
    public boolean isLoading;
    private String searchKeyword;
    private boolean isSearching;
    private int targetScrollY;
    private int scrollVelocity;
    private int scrollAcceleration;
    private int currentScrollY;
    private int maxScrollY;
    private final Vector requestedContacts;
    private int itemHeight;
    private int firstVisibleIndex;
    private int visibleItemCount;
    public int contactSelectedIndex;
    private final ButtonAction selectAction = new ButtonAction("Chọn", null);
    private final ButtonAction emptyAction = new ButtonAction("", null);
    private final ButtonAction multiSelectAction = new ButtonAction("Chọn", null);
    private boolean isMultiSelectMode = false;
    public BuddyGroupList contactData;
    public Vector displayItems;
    public String[] emptyMessageLines;
    private final int avatarAreaX;
    private final int avatarAreaY;
    private int totalItemCount;
    private BuddyListItem selectedItem;
    private ButtonAction chatAction;
    private ContextMenu contextMenu;
    private int lastVisibleIndex;
    private int itemCountLimit;
    private int itemSpacing;
    private boolean needsTextAnimation;
    private boolean animationDirection;
    private int textAnimationX;
    private int animationTimer;
    private final int maxTextWidth;
    private int fullTextWidth;
    private boolean shouldLoadAvatar;
    private int avatarLoadTimer;
    private int componentWidth;
    private int nameTextWidth;
    private int updateCounter;
    private boolean isDragging;
    private int lastPointerX;
    private int lastPointerY;
    private boolean selectAllState;

    static {
        int[][] var10000 = new int[][]{{0, 13}, {13, 11}, {24, 11}, {35, 11}, {46, 11}, {57, 13}, {70, 8}};
    }

    public void setMultiSelectMode(boolean var1) {
        this.isMultiSelectMode = true;
    }

    public BuddyGroupList getContactData() {
        return this.contactData;
    }

    public void setContactData(BuddyGroupList var1, int var2) {
        this.contactData = var1;
        this.contactSelectedIndex = -1;
        this.refreshDisplayList();
        this.onFocusGained();
    }

    public ContactListComponent(int var1, int var2, int var3, int var4, boolean var5) {
        super(0, 1, var3, var4, true);
        System.currentTimeMillis();
        this.selectAllState = false;
        super.isFocused = true;
        this.isChatMode = true;
        this.itemHeight = FontRenderer.fontHeight + 4;
        if (this.itemHeight < GameManager.statusIcons[0].getHeight()) {
            this.itemHeight = GameManager.statusIcons[0].getHeight();
        }

        this.avatarAreaX = var3 - 4 - 35;
        this.avatarAreaY = 54;
        this.emptyMessageLines = FontRenderer.wrapTextToLines(TextConstant.BAN_CHUA_CO_TRONG_DANH_SACH, GameGraphics.screenWidth - 30);
        this.maxTextWidth = super.width - 23 - 5;
        this.requestedContacts = new Vector();
    }

    public void updateContactAvatar(final long n, final int[] k) {
        if (this.contactData != null) {
            final BuddyGroupList e;
            int i = (e = this.contactData).contactGroups.size() - 1;
            Label_0130:
            while (i >= 0) {
                final BuddyGroup ContactGroup;
                int size = (ContactGroup = (BuddyGroup) e.contactGroups.elementAt(i)).contacts.size();
                while (true) {
                    while (--size >= 0) {
                        final BuddyInfo BuddyInfo;
                        if ((BuddyInfo = (BuddyInfo) ContactGroup.contacts.elementAt(size)).contactId == n) {
                            final BuddyInfo buddyInfo3;
                            final BuddyInfo buddyInfo2 = buddyInfo3 = BuddyInfo;
                            final BuddyInfo buddyInfo4 = buddyInfo3;
                            if (buddyInfo2 != null) {
                                buddyInfo4.setRawDataArray(k);
                            }
                            --i;
                            continue Label_0130;
                        }
                    }
                    BuddyInfo buddyInfo3;
                    final BuddyInfo buddyInfo2 = buddyInfo3 = null;
                    continue;
                }
            }
        }
        BuddyListItem buddyListItem3 = null;
        BuddyListItem buddyListItem2 = null;
        Label_0200:
        {
            if (this.displayItems != null) {
                int size2 = this.displayItems.size();
                while (--size2 >= 0) {
                    final BuddyListItem buddyListItem = (BuddyListItem) this.displayItems.elementAt(size2);
                    if (buddyListItem.contactId == n) {
                        buddyListItem2 = (buddyListItem3 = buddyListItem);
                        break Label_0200;
                    }
                }
            }
            buddyListItem2 = (buddyListItem3 = null);
        }
        final BuddyListItem buddyListItem4 = buddyListItem3;
        if (buddyListItem2 != null) {
            buddyListItem4.rawData = k;
        }
    }

    public void refreshDisplayList() {
        if (this.displayItems == null) {
            this.displayItems = new Vector();
        } else {
            this.displayItems.removeAllElements();
        }

        System.gc();
        if (this.contactData != null && this.contactData.contactGroups != null && this.contactData.contactGroups.size() != 0) {
            Vector var1 = this.contactData.contactGroups;
            boolean var2 = false;
            int var3 = var1.size();
            int var4 = 0;

            for (int var5 = 0; var5 < var3; var5++) {
                BuddyGroup var11 = (BuddyGroup) var1.elementAt(var5);
                BuddyListItem var6;
                (var6 = new BuddyListItem()).itemType = 1;
                var6.statusCode = var11.expansionStatus;
                var6.groupName = var11.getGroupName();
                var6.displayName = UIUtils.concatStrings(var11.getGroupName(), " (", String.valueOf(var11.contacts.size()), ")");
                this.displayItems.addElement(var6);
                if (var6.statusCode != 1) {
                    Vector var13 = var11.contacts;
                    var4 = var11.contacts.size();

                    for (int var7 = 0; var7 < var4; var7++) {
                        BuddyInfo var8 = (BuddyInfo) var13.elementAt(var7);
                        BuddyListItem var9;
                        (var9 = new BuddyListItem()).contactId = var8.contactId;
                        var9.rawData = var8.getRawDataArray();
                        var9.groupName = var8.username;
                        var9.statusCode = var8.statusCode;
                        var9.displayName = var8.displayName;
                        var8.getDefaultColor();
                        var9.textColor = null;
                        var9.textColor = new Integer(var8.getDefaultColor());
                        var9.isSelected = var8.isSelected;
                        var9.statusText = var8.description;
                        if (var9.statusText != null && var9.statusText.length() != 0) {
                            var9.extraField = var9.displayName + " - " + var9.statusText;
                        } else {
                            var9.extraField = var9.displayName;
                        }

                        var9.contactRef = var8;
                        if (!this.isFilterActive || var9.statusCode != 0 && var9.statusCode != 0 && var9.statusCode != -1) {
                            if (this.isSearching) {
                                if (var9.groupName.indexOf(this.searchKeyword) == -1 && var9.displayName.indexOf(this.searchKeyword) == -1) {
                                    continue;
                                }

                                if (!var2) {
                                    this.contactSelectedIndex = this.displayItems.size();
                                    var2 = true;
                                }
                            }

                            this.displayItems.addElement(var9);
                        }
                    }
                }
            }

            System.gc();
            this.totalItemCount = this.displayItems.size();
            if (this.contactSelectedIndex < 0) {
                this.contactSelectedIndex = 0;
            }

            if (this.contactSelectedIndex >= this.totalItemCount) {
                this.contactSelectedIndex = this.totalItemCount - 1;
            }

            this.visibleItemCount = super.height / this.itemHeight + 1;
            this.maxScrollY = this.totalItemCount * this.itemHeight - super.height + 3 + this.itemHeight;
            this.targetScrollY = this.contactSelectedIndex * this.itemHeight - (super.height >> 1);
            this.firstVisibleIndex = this.contactSelectedIndex - (this.visibleItemCount >> 1);
            if (this.displayItems.size() - this.contactSelectedIndex < this.visibleItemCount >> 1) {
                this.firstVisibleIndex = this.totalItemCount - this.visibleItemCount;
            }

            if (this.firstVisibleIndex < 0) {
                this.firstVisibleIndex = 0;
            }

            this.updateSoftKeys();
        } else {
            this.firstVisibleIndex = 0;
            this.visibleItemCount = 0;
            this.totalItemCount = this.displayItems.size();
            this.maxScrollY = 0;
        }
    }

    private void updateSoftKeys() {
        if (((BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex)).itemType == 1) {
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

    public boolean handleKeyPress(int var1) {
        if (this.isLoading) {
            return true;
        } else if (this.displayItems != null && this.totalItemCount != 0) {
            if (var1 == 12) {
                System.currentTimeMillis();
                this.contactSelectedIndex--;
                if (this.contactSelectedIndex < 0) {
                    this.contactSelectedIndex = this.totalItemCount - 1;
                }
            }

            if (var1 == 13) {
                System.currentTimeMillis();
                this.contactSelectedIndex++;
                if (this.contactSelectedIndex >= this.totalItemCount) {
                    this.contactSelectedIndex = 0;
                }
            }

            if (var1 == 12 || var1 == 13) {
                this.updateSoftKeys();
                this.targetScrollY = this.contactSelectedIndex * this.itemHeight - (super.height >> 1);
                this.firstVisibleIndex = this.contactSelectedIndex - (this.visibleItemCount >> 1);
                if (this.totalItemCount - this.contactSelectedIndex < this.visibleItemCount >> 1) {
                    this.firstVisibleIndex = this.totalItemCount - this.visibleItemCount;
                }

                if (this.firstVisibleIndex < 0) {
                    this.firstVisibleIndex = 0;
                }

                this.resetAnimation();
                GameGraphics.clearKeyStates();
                ScrollBar.setScrolling(true);
                this.resetTextAnimation();
                UIUtils.markScreenForUpdate(this);
            }

            if (var1 == 16) {
                this.selectCurrentItem();
                GameGraphics.clearKeyStates();
            }

            return true;
        } else {
            return true;
        }
    }

    public void resetAnimation() {
        this.avatarLoadTimer = 0;
        this.shouldLoadAvatar = false;
    }

    private void selectCurrentItem() {
        if (this.contactSelectedIndex != -1) {
            this.selectedItem = (BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex);
            if (this.selectedItem.itemType == 0) {
                if (this.selectedItem.statusCode == 8) {
                    if (this.selectedItem.groupName.startsWith("http://")) {
                        try {
                            Xuka.instance.platformRequest(this.selectedItem.groupName);
                            return;
                        } catch (ConnectionNotFoundException var6) {
                            return;
                        }
                    }
                } else if (this.selectedItem.statusCode == 4) {
                    return;
                }

                if (this.isMultiSelectMode) {
                    BuddyListItem var8 = (BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex);
                    var8.isSelected = !var8.isSelected;
                    var8.contactRef.isSelected = !var8.contactRef.isSelected;
                } else {
                    if (this.chatAction == null) {
                        this.chatAction = new ButtonAction("Chat", new ContactListClickChatAction(this));
                    }

                    if (this.isChatMode) {
                        this.chatAction.action.action();
                    } else {
                        if (this.contextMenu == null) {
                            Vector var7 = new Vector();
                            ButtonAction var2 = new ButtonAction("Hồ sơ", new ContactListClickProfileAction(this));
                            ButtonAction var3 = new ButtonAction("Media", new ContactListClickMediaAction(this));
                            if (FriendScreen.currentViewMode == 1) {
                                ButtonAction var4 = new ButtonAction("Từ chối ID", new ContactListBlockAction(this));
                                ButtonAction var5 = new ButtonAction("Xóa ID", new ContactListDeleteAction(this));
                                var7.addElement(this.chatAction);
                                var7.addElement(var3);
                                var7.addElement(var2);
                                var7.addElement(var5);
                                var7.addElement(var4);
                            } else if (FriendScreen.currentViewMode == 2) {
                                ButtonAction var9 = new ButtonAction("Bỏ từ chối", new ContactListRemoveBlockAction(this));
                                var7.addElement(var2);
                                var7.addElement(var9);
                            } else {
                                ButtonAction var10 = new ButtonAction("Đồng ý", new ContactListClickAcceptAction(this));
                                ButtonAction var11 = new ButtonAction(TextConstant.decline(), new ContactListRejectAction(this));
                                var7.addElement(var2);
                                var7.addElement(var10);
                                var7.addElement(var11);
                            }

                            this.contextMenu = new ContextMenu(var7);
                        }

                        GameManager.getInstance().showContextMenu(this.contextMenu, 1);
                    }
                }
            } else {
                BuddyGroup var1;
                if ((var1 = this.contactData.findBuddyContactByName(this.selectedItem.groupName)) != null) {
                    var1.expansionStatus = this.selectedItem.statusCode == 0 ? 1 : 0;
                }

                this.refreshDisplayList();
            }
        }
    }

    private void resetTextAnimation() {
        this.animationTimer = 0;
        this.fullTextWidth = 0;
        this.needsTextAnimation = false;
    }

    public void render(Graphics var1) {
        var1.setClip(super.posX, super.posY, super.width + 1, super.height);
        if (this.isLoading) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText("Vui lòng chờ", Screen.screenWidth - FontRenderer.getTextWidth("Vui lòng chờ") >> 1, 20, var1);
            GameManager.instance.drawLoading(var1, TextRenderer.logoCenterX, FontRenderer.fontHeight + 35);
        } else if (this.visibleItemCount == 0) {
            int var12 = this.emptyMessageLines.length;

            while (--var12 >= 0) {
                FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.emptyMessageLines[var12], Screen.screenWidth - FontRenderer.getTextWidth(this.emptyMessageLines[var12]) >> 1, 20 + var12 * FontRenderer.fontHeight, var1);
            }
        } else if (this.displayItems != null) {
            var1.translate(2, 2);
            var1.translate(0, -this.currentScrollY);
            int var2 = this.firstVisibleIndex * this.itemHeight;
            this.lastVisibleIndex = this.firstVisibleIndex + this.visibleItemCount;
            this.itemCountLimit = this.totalItemCount;
            this.itemSpacing = this.itemHeight + 2;
            int var3 = 0;
            this.componentWidth = super.width + 4;
            BuddyListItem var4 = null;

            for (int var5 = this.firstVisibleIndex; var5 <= this.lastVisibleIndex && var5 < this.itemCountLimit; var5++) {
                var4 = (BuddyListItem) this.displayItems.elementAt(var5);
                var3 = this.itemHeight;
                if (var5 == this.contactSelectedIndex) {
                    if (((BuddyListItem) var4).itemType == 0) {
                        var3 <<= 1;
                    }

                    var1.setColor(66826);
                    var1.fillRect(-2, var2 + 1, this.componentWidth, var3);
                    var1.setColor(9478569);
                    var1.drawRect(-3, var2 + 1, this.componentWidth, var3);
                    if (var3 > this.itemHeight) {
                        if (this.fullTextWidth == 0) {
                            this.textAnimationX = 23;
                            this.fullTextWidth = FontRenderer.getTextWidth(((BuddyListItem) var4).extraField);
                            this.nameTextWidth = FontRenderer.getTextWidth(((BuddyListItem) var4).groupName);
                            this.fullTextWidth = this.fullTextWidth > this.nameTextWidth ? this.fullTextWidth : this.nameTextWidth;
                            if (this.fullTextWidth > this.maxTextWidth) {
                                this.needsTextAnimation = this.animationDirection = true;
                            } else {
                                this.needsTextAnimation = false;
                            }
                        }

                        if (this.needsTextAnimation && this.animationTimer++ > 20) {
                            this.animationTimer = 21;
                            if (this.animationDirection) {
                                if (this.textAnimationX > -(this.fullTextWidth - this.maxTextWidth) + 23 - 5) {
                                    this.textAnimationX--;
                                } else {
                                    this.animationDirection = false;
                                }
                            } else if (this.textAnimationX < 23) {
                                this.textAnimationX++;
                            } else {
                                this.animationDirection = true;
                            }
                        }
                    }
                }

                if (((BuddyListItem) var4).itemType == 1) {
                    var1.drawImage(GameManager.arrowIcons[((BuddyListItem) var4).statusCode], 9, var2 + (this.itemHeight >> 1) + 2, 3);
                    FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(((BuddyListItem) var4).displayName, 18, var2 + 3, var1);
                } else {
                    FontRenderer.getFontInstance(((BuddyListItem) var4).textColor).drawText(((BuddyListItem) var4).extraField, var5 == this.contactSelectedIndex ? this.textAnimationX : 23, var2 + 3, var1);
                    if (var5 == this.contactSelectedIndex) {
                        FontRenderer.getFontInstance(FontRenderer.COLOR_BROWN).drawText(((BuddyListItem) var4).groupName, this.textAnimationX, var2 + this.itemSpacing, var1);
                    }

                    var1.drawImage(GameManager.statusIcons[((BuddyListItem) var4).statusCode == 1 ? 1 : 0], var5 == this.contactSelectedIndex ? this.textAnimationX - 12 : 11, var2 + (this.itemHeight >> 1) + 2, 3);
                    if (this.isMultiSelectMode && ((BuddyListItem) var4).statusCode != 3) {
                        var1.drawRegion(GameManager.loadingImage, 0, ((BuddyListItem) var4).isSelected ? 13 : 0, 13, 13, 0, super.width - 12, var2 + (this.itemHeight >> 1), 3);
                    }
                }

                var2 += var3;
            }

            var1.translate(0, this.currentScrollY);
            var1.translate(-2, -2);
            if (FriendScreen.isAvatarEnabled && !this.isChatMode && !this.isMultiSelectMode) {
                if (++this.avatarLoadTimer > 30) {
                    this.avatarLoadTimer = 31;
                    if (!this.shouldLoadAvatar) {
                        this.shouldLoadAvatar = true;
                        if ((var4 = (BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex)).itemType != 1) {
                            String var17 = var4.groupName;
                            if (var4.groupName != null && !this.requestedContacts.contains(var17)) {
                                this.requestedContacts.addElement(var17);
                                long var8 = var4.contactId;
                                Packet var10 = new Packet(3, 6);
                                PacketUtils.writeLong(var8, var10);
                                NetworkManager.sendPacket(var10);
                            }
                        }
                    }
                }

                int[] var11;
                BuddyInfo var18;
                if (((BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex)).itemType != 1
                        && (var18 = (this.contactSelectedIndex < 0 ? null : (BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex)).contactRef) != null
                        && (var11 = var18.getRawDataArray()) != null
                        && var11.length > 0) {
                    this.lastVisibleIndex = var11.length;

                    for (int var14 = 0; var14 < this.lastVisibleIndex; var14++) {
                        var1.drawImage(ImageCache.getImage(var18.processedDataArray[var14]), this.avatarAreaX + (var11[var14] >> 24), this.avatarAreaY + (var11[var14] << 8 >> 24), 0);
                    }
                }
            }
        }
    }

    public void update() {
        this.updateCounter++;
        if (this.updateCounter > 1000) {
            this.updateCounter = 0;
        }

        if (this.currentScrollY != this.targetScrollY) {
            this.scrollVelocity = this.targetScrollY - this.currentScrollY << 2;
            this.scrollAcceleration = this.scrollAcceleration + this.scrollVelocity;
            this.currentScrollY = this.currentScrollY + (this.scrollAcceleration >> 4);
            this.scrollAcceleration &= 15;
            if (this.currentScrollY > this.maxScrollY) {
                this.currentScrollY = this.maxScrollY;
            }

            if (this.currentScrollY < 0) {
                this.currentScrollY = 0;
            }

            this.firstVisibleIndex = this.currentScrollY / this.itemHeight - 1;
            if (this.firstVisibleIndex < 0) {
                this.firstVisibleIndex = 0;
            }
        }
    }

    public void onFocusGained() {
        if (this.displayItems != null) {
            if (super.posY + this.totalItemCount * this.itemHeight >= super.height) {
                ScrollBar.isVisible = true;
                ScrollBar.initialize(this.totalItemCount);
            } else {
                ScrollBar.isVisible = false;
            }
        }
    }

    public void renderFocusIndicator(Graphics var1) {
        ScrollBar.render(var1, this.contactSelectedIndex);
    }

    public void handlePointerRelease(int var1, int var2) {
        this.lastPointerX = var1;
        this.lastPointerY = var2;
    }

    public void handlePointerPress(int var1, int var2) {
        if (this.isDragging) {
            this.isDragging = false;
            this.targetScrollY = this.targetScrollY - (var2 - this.lastPointerY) * 5;
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }
        } else {
            if (this.displayItems == null) {
                return;
            }

            if ((var1 = (var2 + this.currentScrollY) / this.itemHeight) < 0) {
                var1 = 0;
            }

            if (var1 > this.totalItemCount - 1) {
                var1 = this.totalItemCount - 1;
            }

            if (this.contactSelectedIndex == var1) {
                this.selectCurrentItem();
                return;
            }

            if (this.contactSelectedIndex > var1) {
                this.contactSelectedIndex = var1;
            } else {
                BuddyListItem var4;
                if ((var4 = (BuddyListItem) this.displayItems.elementAt(this.contactSelectedIndex)).displayName != null && !var4.displayName.equals("")) {
                    if (this.contactSelectedIndex == var1 - 1) {
                        this.selectCurrentItem();
                        return;
                    }

                    this.contactSelectedIndex = var1 - 1;
                } else {
                    this.contactSelectedIndex = var1;
                }
            }

            this.updateSoftKeys();
            this.resetAnimation();
            this.resetTextAnimation();
            UIUtils.markScreenForUpdate(this);
        }

        ScrollBar.setScrolling(true);
    }

    public void handlePointerDrag(int var1, int var2) {
        if (abs(var1 - this.lastPointerX) > 1 || abs(var2 - this.lastPointerY) > 1) {
            this.isDragging = true;
            this.targetScrollY = this.targetScrollY - (var2 - this.lastPointerY);
            if (this.targetScrollY < 0) {
                this.targetScrollY = 0;
            } else if (this.targetScrollY > this.maxScrollY) {
                this.targetScrollY = this.maxScrollY;
            }

            this.currentScrollY = this.targetScrollY;
            this.firstVisibleIndex = this.currentScrollY / this.itemHeight - 1;
            if (this.firstVisibleIndex < 0) {
                this.firstVisibleIndex = 0;
            }

            this.lastPointerX = var1;
            this.lastPointerY = var2;
        }

        ScrollBar.setScrolling(true);
    }

    public static int abs(int var0) {
        return var0 > 0 ? var0 : -var0;
    }

    public boolean updateContactStatus(String var1, int var2) {
        if (this.contactData == null) {
            return false;
        } else {
            int var5 = var2;
            String var4 = var1;
            BuddyGroupList var3 = this.contactData;

            for (int var6 = this.contactData.contactGroups.size() - 1; var6 >= 0; var6--) {
                BuddyInfo var7;
                if ((var7 = ((BuddyGroup) var3.contactGroups.elementAt(var6)).findContactById(var4)) != null) {
                    var7.statusCode = var5;
                }
            }

            if (this.displayItems == null) {
                return false;
            } else {
                boolean var10 = false;
                int var11 = this.totalItemCount;

                while (--var11 >= 0) {
                    BuddyListItem var12;
                    if ((var12 = (BuddyListItem) this.displayItems.elementAt(var11)).itemType == 0 && var12.groupName.equals(var1) && var12.statusCode != var2) {
                        var12.statusCode = var2;
                        var10 = true;
                    }
                }

                if (this.isFilterActive) {
                    this.refreshDisplayList();
                }

                return var10;
            }
        }
    }

    /**
     * Cập nhật trạng thái online/offline cho contact theo ID
     * @param contactId ID của contact cần cập nhật
     * @param newStatusCode Mã trạng thái mới (0=offline, 1=online, 2=away, etc.)
     * @return true nếu cập nhật thành công và có thay đổi, false nếu không
     */
    public boolean updateContactStatus(long contactId, int newStatusCode) {
        // Kiểm tra dữ liệu contact có tồn tại không
        if (this.contactData == null) {
            return false;
        }

        // Cập nhật status code trong cấu trúc dữ liệu contact groups
        int statusToUpdate = newStatusCode;
        long targetContactId = contactId;
        BuddyGroupList buddyGroupList = this.contactData;
        int updatedContactCount = 0;
        int groupIndex = buddyGroupList.contactGroups.size();

        // Duyệt qua tất cả groups từ cuối lên đầu
        contactGroupLoop:
        while (--groupIndex >= 0) {
            BuddyGroup currentGroup = (BuddyGroup) buddyGroupList.contactGroups.elementAt(groupIndex);
            int contactIndex = currentGroup.contacts.size();

            // Duyệt qua tất cả contacts trong group từ cuối lên đầu
            while (--contactIndex >= 0) {
                BuddyInfo contactInfo = (BuddyInfo) currentGroup.contacts.elementAt(contactIndex);

                // Tìm thấy contact có ID khớp
                if (contactInfo.contactId == targetContactId) {
                    contactInfo.statusCode = statusToUpdate;
                    updatedContactCount++;

                    // Thoát sớm nếu đã cập nhật nhiều hơn 1 contact (tránh trùng lặp)
                    if (updatedContactCount > 1) {
                        break contactGroupLoop;
                    }
                }
            }
        }

        // Kiểm tra danh sách hiển thị có tồn tại không
        if (this.displayItems == null) {
            return false;
        }

        // Cập nhật status code trong danh sách hiển thị UI
        boolean hasStatusChanged = false;
        int displayItemIndex = this.totalItemCount;

        // Duyệt qua tất cả display items từ cuối lên đầu
        while (--displayItemIndex >= 0) {
            BuddyListItem displayItem = (BuddyListItem) this.displayItems.elementAt(displayItemIndex);

            // Kiểm tra: contact item, ID khớp, và status thực sự thay đổi
            if (displayItem.itemType == 0 &&
                    displayItem.contactId == contactId) {

                displayItem.statusCode = newStatusCode;
                hasStatusChanged = true;
            }
        }

        // Nếu có filter đang hoạt động, refresh lại danh sách hiển thị
        // (có thể contact chuyển từ online->offline hoặc ngược lại cần ẩn/hiện)
        if (this.isFilterActive) {
            this.refreshDisplayList();
        }

        return hasStatusChanged;
    }

    /**
     * Cập nhật subtext (mô tả trạng thái) cho contact theo ID
     * @param contactId ID của contact cần cập nhật
     * @param newSubtext Text mô tả mới (có thể null hoặc rỗng)
     * @return true nếu cập nhật thành công, false nếu không tìm thấy hoặc lỗi
     */
    public boolean updateContactSubtext(long contactId, String newSubtext) {
        // Kiểm tra dữ liệu contact có tồn tại không
        if (this.contactData == null) {
            return false;
        }

        // Cập nhật subtext trong cấu trúc dữ liệu contact groups
        String subtextToUpdate = newSubtext;
        long targetContactId = contactId;
        BuddyGroupList buddyGroupList = this.contactData;
        int updatedContactCount = 0;
        int groupIndex = buddyGroupList.contactGroups.size();

        // Duyệt qua tất cả groups từ cuối lên đầu
        contactGroupLoop:
        while (--groupIndex >= 0) {
            BuddyGroup currentGroup = (BuddyGroup) buddyGroupList.contactGroups.elementAt(groupIndex);
            int contactIndex = currentGroup.contacts.size();

            // Duyệt qua tất cả contacts trong group từ cuối lên đầu
            while (--contactIndex >= 0) {
                BuddyInfo contactInfo = (BuddyInfo) currentGroup.contacts.elementAt(contactIndex);

                // Tìm thấy contact có ID khớp
                if (contactInfo.contactId == targetContactId) {
                    contactInfo.description = subtextToUpdate;
                    updatedContactCount++;

                    // Thoát sớm nếu đã cập nhật nhiều hơn 1 contact (tránh trùng lặp)
                    if (updatedContactCount > 1) {
                        break contactGroupLoop;
                    }
                }
            }
        }

        // Kiểm tra danh sách hiển thị có tồn tại không
        if (this.displayItems == null) {
            return false;
        }

        // Cập nhật subtext trong danh sách hiển thị UI
        boolean hasUpdatedDisplayItem = false;
        int displayItemIndex = this.totalItemCount;

        // Duyệt qua tất cả display items từ cuối lên đầu
        while (--displayItemIndex >= 0) {
            BuddyListItem displayItem = (BuddyListItem) this.displayItems.elementAt(displayItemIndex);

            // Kiểm tra xem có phải contact item và có ID khớp không
            if (displayItem.itemType == 0 && displayItem.contactId == contactId) {
                displayItem.statusText = newSubtext;

                // Tạo text hiển thị: nếu có subtext thì ghép với tên, nếu không thì chỉ hiển thị tên
                if (newSubtext != null && newSubtext.length() > 0) {
                    displayItem.extraField = displayItem.displayName + " - " + newSubtext;
                    hasUpdatedDisplayItem = true;
                } else {
                    displayItem.extraField = displayItem.displayName;
                }
            }
        }

        return hasUpdatedDisplayItem;
    }

    public void updateContactSubtext(String var1, String var2, int var3) {
        if (this.contactData != null) {
            String var5 = var2;
            String var4 = var1;
            BuddyGroupList var10 = this.contactData;

            for (int var6 = this.contactData.contactGroups.size() - 1; var6 >= 0; var6--) {
                BuddyInfo var7;
                if ((var7 = ((BuddyGroup) var10.contactGroups.elementAt(var6)).findContactById(var4)) != null) {
                    var7.description = var5;
                }
            }

            if (this.displayItems != null) {
                var3 = this.totalItemCount;

                while (--var3 >= 0) {
                    BuddyListItem var12;
                    if ((var12 = (BuddyListItem) this.displayItems.elementAt(var3)).itemType == 0 && var12.groupName.equals(var1)) {
                        var12.statusText = var2;
                        if (var2 != null && var2.length() != 0) {
                            var12.extraField = var12.displayName + " - " + var2;
                        }
                    }
                }

                if (this.isFilterActive) {
                    this.refreshDisplayList();
                }
            }
        }
    }

    public void removeContact(String var1) {
        String var2 = var1;
        BuddyGroupList var4 = this.contactData;

        for (int var3 = this.contactData.contactGroups.size() - 1; var3 >= 0; var3--) {
            if (((BuddyGroup) var4.contactGroups.elementAt(var3)).getGroupName().equals(var2)) {
                var4.contactGroups.removeElementAt(var3);
                break;
            }
        }

        this.refreshDisplayList();
        this.resetAnimation();
    }

    public boolean hasContact(String var1) {
        int var2 = this.totalItemCount;

        while (--var2 >= 0) {
            BuddyListItem var3;
            if ((var3 = (BuddyListItem) this.displayItems.elementAt(var2)).itemType == 0 && var3.groupName.equals(var1)) {
                return true;
            }
        }

        return false;
    }

    public void setSearchFilter(String var1) {
        if (var1.equals("")) {
            this.isSearching = false;
        } else {
            this.isSearching = true;
            this.searchKeyword = var1;
            this.isFilterActive = false;
        }

        this.refreshDisplayList();
        this.resetAnimation();
    }

    public String[] getGroupNames() {
        int var1;
        String[] var2 = new String[var1 = this.contactData.contactGroups.size()];

        for (int var3 = 0; var3 < var1; var3++) {
            var2[var3] = ((BuddyGroup) this.contactData.contactGroups.elementAt(var3)).getGroupName();
        }

        return var2;
    }

    public void toggleSelectAll() {
        if (this.isMultiSelectMode) {
            this.selectAllState = !this.selectAllState;

            for (int var1 = this.totalItemCount - 1; var1 >= 0; var1--) {
                BuddyListItem var2;
                if ((var2 = (BuddyListItem) this.displayItems.elementAt(var1)).itemType == 0) {
                    var2.isSelected = this.selectAllState;
                    var2.contactRef.isSelected = this.selectAllState;
                }
            }
        }
    }

    public void selectAll() {
        this.selectAllState = true;
        this.toggleSelectAll();
    }

    public long[] getSelectedContactIds() {
        final Vector vector = new Vector();
        if (this.isMultiSelectMode) {
            for (int i = this.totalItemCount - 1; i >= 0; --i) {
                final BuddyListItem buddyListItem;
                if ((buddyListItem = (BuddyListItem) this.displayItems.elementAt(i)).itemType == 0 && buddyListItem.isSelected) {
                    buddyListItem.isSelected = false;
                    vector.addElement(new Long(buddyListItem.contactId));
                }
            }
        }
        if (vector.size() > 0) {
            final long[] array = new long[vector.size()];
            int size = vector.size();
            while (--size >= 0) {
                array[size] = ((Long) vector.elementAt(size)).longValue();
            }
            return array;
        }
        return null;
    }

    public static BuddyListItem getSelectedItem(ContactListComponent var0) {
        return var0.selectedItem;
    }
}
