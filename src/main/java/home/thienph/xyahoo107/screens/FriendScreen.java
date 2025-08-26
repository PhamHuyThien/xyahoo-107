package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.media.BuddyGroup;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.PacketUtils;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Image;
import java.util.Hashtable;
import java.util.Vector;

public final class FriendScreen extends Screen {
    public static int[] avatarData;
    public ContactListComponent friendsComponent;
    public ContactListComponent friendsRequestComponent;
    public static String username;
    public static long currentUserAccountId;
    public static String currentUserName;
    public static int userStatus;
    public static boolean isAvatarEnabled;
    public static String statusMessage = "";
    public final Vector contextMenuItems;
    public ContextMenu contextMenu;
    public boolean isSearchMode;
    private final TextInputComponent searchInput;
    public static FriendScreen instance;
    public static int currentViewMode;
    public Vector onlineFriends;
    public Vector blockedUsers;
    public Vector pendingRequests;
    private Hashtable userStorage;
    public boolean isInitialized;
    private ButtonAction offlineMessageButton;
    public Hashtable offlineMessages;
    public Screen offlineMessageScreen;
    private TextInputComponent activeTextInput;
    private Action primaryAction;
    private Action secondaryAction;
    private DialogScreen statusDialog;
    private DropdownComponent statusDropdown;
    private TextInputComponent statusMessageInput;
    private ButtonAction backButton;
    private final ButtonAction defaultRightSoftkey = new ButtonAction(TextConstant.close(), new quyen_ib(this));
    public Hashtable pendingInvitations;

    public void clearContactData() {
        if (this.friendsComponent != null) {
            if (this.friendsComponent.displayItems != null) {
                this.friendsComponent.displayItems.removeAllElements();
            }

            this.friendsComponent.displayItems = null;
            this.friendsComponent.contactData = null;
        }

        if (this.friendsRequestComponent != null) {
            if (this.friendsRequestComponent.displayItems != null) {
                this.friendsRequestComponent.displayItems.removeAllElements();
            }

            this.friendsRequestComponent.displayItems = null;
            this.friendsRequestComponent.contactData = null;
        }
    }

    public FriendScreen() {
        super.title = "Bạn Bè";
        instance = this;
        currentViewMode = 1;
        this.onlineFriends = new Vector();
        this.blockedUsers = new Vector();
        this.pendingRequests = new Vector();
        this.userStorage = GameManager.loadUserStorage();
        if (this.userStorage == null) {
            this.userStorage = new Hashtable();
        }

        this.isInitialized = true;
        isAvatarEnabled = Xuka.loadBooleanSetting("onavt", true);
        this.searchInput = new TextInputComponent();
        this.searchInput.isNavigationMode = true;
        this.searchInput.setBounds(1, Screen.screenHeight - GameManager.footerHeight - FontRenderer.fontHeight - 11, Screen.screenWidth - 2, FontRenderer.fontHeight + 6);
        this.friendsComponent = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
        this.friendsComponent.isChatMode = false;
        this.friendsComponent.isFilterActive = Xuka.loadBooleanSetting("hideOffline", false);
        this.friendsComponent.isLoading = true;
        toggleOfflineFilter(this.friendsComponent);
        this.addComponent(this.friendsComponent);
        UIUtils.focusComponent(this, this.friendsComponent);
        this.contextMenuItems = new Vector();
        this.contextMenu = new ContextMenu(this.contextMenuItems);
        this.contextMenuItems.addElement(new ButtonAction("Trạng thái", new FriendClickStatusAction(this)));
        this.contextMenuItems.addElement(this.createPendingRequestsButton());
        this.contextMenuItems.addElement(new ButtonAction("Thêm bạn", new FriendClickAddContactAction(this)));
        this.contextMenuItems.addElement(new ButtonAction("Chat với..", new FriendClickChatWithAction(this)));
        this.contextMenuItems.addElement(new ButtonAction("ID từ chối", new FriendListUserRefuseAction(this)));
        ButtonAction var1 = new ButtonAction("Chức năng khác", null);
        Vector var2;
        (var2 = new Vector()).addElement(new ButtonAction("Mở/tắt ID ẩn", new FriendOpenCloseOfflineAction(this)));
        var2.addElement(new ButtonAction("Mở/tắt avatar", new FriendOpenCloseAvatarAction(this)));
        var2.addElement(new ButtonAction("Gửi tin nhóm", new FriendSendToGroupAction(this)));
        var1.parentContainer = new ContextMenu(var2);
        this.contextMenuItems.addElement(var1);
        super.leftSoftkey = new ButtonAction("Menu", new FriendClickMenuAction(this));
        super.rightSoftkey = this.defaultRightSoftkey;
    }

    public static void toggleOfflineFilter(ContactListComponent var0) {
//        var0.isFilterActive = !var0.isFilterActive;
//        var0.refreshDisplayList();
//        var0.contactSelectedIndex = 0;
//        Xuka.saveBooleanSetting("hideOffline", var0.isFilterActive);
    }

    public void updateContactAvatar(long var1, int[] var3) {
        this.friendsComponent.updateContactAvatar(var1, var3);
        if (this.friendsRequestComponent != null) {
            this.friendsRequestComponent.updateContactAvatar(var1, var3);
        }
    }

    public ButtonAction createPendingRequestsButton() {
        return new ButtonAction("Chờ kết bạn" + (this.pendingRequests.size() > 0 ? " (+" + this.pendingRequests.size() + ")" : ""), new ClickFriendRequestAction(this));
    }

    public static void updateStatusMessage(String var0) {
        PacketSender.c(var0, 1);
        statusMessage = var0;
        Xuka.saveStringData(username, var0, false);
    }

    public void showStatusDialog() {
        if (this.statusDialog == null) {
            System.gc();
            this.statusDialog = new DialogScreen();
            this.statusDialog.title = "Trạng Thái";
            UIUtils.calculateColumnLayout(UIUtils.layoutParam1, UIUtils.layoutParam2);
            this.statusDialog.nextComponentY += 20;
            this.statusDropdown = ButtonAction.createChoiceBox(this.statusDialog, UIUtils.concatStrings("Trạng thái", ":", null, null), new String[]{"Hiển thị", "Ẩn danh"});
            this.statusMessageInput = ButtonAction.createLabeledTextInput(this.statusDialog, UIUtils.concatStrings("Thông điệp", ":", null, null), 0, -1);
            UIUtils.focusComponent(this.statusDialog, this.statusDropdown);
            this.statusDialog.centerSoftkey = new ButtonAction("OK", new quyen_if(this));
            this.statusDialog.rightSoftkey = new ButtonAction(TextConstant.close(), new quyen_ig(this));
            System.gc();
        }

        this.statusDropdown.setSelectedIndex(userStatus == 1 ? 0 : 1);
        GameManager.getInstance().addScreenToStack((Screen) this.statusDialog);
        this.statusMessageInput.setText(statusMessage);
        GameManager.getInstance().switchToLastScreen();
    }

    public void addAllFriendsToOnline() {
        if (this.friendsComponent.contactData != null) {
            BuddyGroup var1 = this.friendsComponent.contactData.findBuddyContactByName("Ban Be");
            int var2 = 0;

            for (int var3 = var1.contacts.size(); var2 < var3; var2++) {
                this.addToOnlineList(((BuddyInfo) var1.contacts.elementAt(var2)).contactId);
            }
        }
    }

    private void enterSearchMode() {
        this.searchInput.setText("");
        this.addComponent(this.searchInput);
        UIUtils.focusComponent(this, (UIComponent) this.searchInput);
        this.isSearchMode = true;
    }

    private void exitSearchMode() {
        UIUtils.focusComponent(this, this.friendsComponent);
        this.removeComponent(this.searchInput);
        this.isSearchMode = false;
    }

    public boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
        if (var3[0] > 32 && !this.isSearchMode && super.components.contains(this.friendsComponent) && (this.activeTextInput == null || !UIUtils.isComponentSelected(this, (UIComponent) this.activeTextInput))) {
            this.enterSearchMode();
        }

        String var4 = "";
        if (this.isSearchMode) {
            if (var1[12]) {
                var1[12] = false;
                this.friendsComponent.handleKeyPress(12);
            } else if (var1[13]) {
                var1[13] = false;
                this.friendsComponent.handleKeyPress(13);
            } else if (var1[16]) {
                var1[16] = false;
                this.friendsComponent.handleKeyPress(16);
            }

            var4 = this.searchInput.getText();
        }

        super.handleInput(var1, var2, var3);
        if (this.isSearchMode) {
            if (this.searchInput.getText().equals("")) {
                this.exitSearchMode();
            }

            if (!this.searchInput.getText().equals(var4)) {
                this.friendsComponent.setSearchFilter(this.searchInput.getText());
            }
        }

        return true;
    }

    public void sendBulkRequest(Vector var1) {
        if (var1.size() > 0) {
            long[] var5 = vectorToLongArray(var1);
            Packet var2 = new Packet(5000028, 2);
            PacketUtils.writeInt(var5.length, var2);
            int var3 = 0;

            for (int var4 = var5.length; var3 < var4; var3++) {
                PacketUtils.writeLong(var5[var3], var2);
            }

            NetworkManager.sendPacket(var2);
        }
    }

    public void updatePendingRequestsButton() {
        int var1 = this.contextMenuItems.size();

        while (--var1 >= 0) {
            if (((ButtonAction) this.contextMenuItems.elementAt(var1)).text.startsWith("Chờ kết bạn")) {
                ((ButtonAction) this.contextMenuItems.elementAt(var1)).text = "Chờ kết bạn";
                if (this.pendingRequests.size() > 0) {
                    ((ButtonAction) this.contextMenuItems.elementAt(var1)).text = UIUtils.concatStrings("Chờ kết bạn", " (+", Integer.toString(this.pendingRequests.size()), ")");
                }

                GameManager.instance.replaceMainMenuItem((ButtonAction) this.contextMenuItems.elementAt(var1), var1);
                var1 = 0;
                System.gc();
            }
        }
    }

    public void addPendingInvitation(long var1, String var3) {
        if (this.pendingInvitations == null) {
            this.pendingInvitations = new Hashtable();
        }

        PacketSender.requestSendDataUIComponent(var1);
        this.pendingInvitations.put(new Long(var1), var3);
    }

    public void processPendingInvitation(long var1) {
        if (this.pendingInvitations.containsKey(new Long(var1))) {
            String var3 = (String) this.pendingInvitations.get(new Long(var1));
            this.pendingInvitations.remove(new Long(var1));
            GameManager.instance.receiveMessage(var1, var3);
        }
    }

    public void addOfflineMessage(String var1, String var2) {
        if (this.offlineMessages == null) {
            this.offlineMessages = new Hashtable();
        }

        Vector var3;
        if (this.offlineMessages.containsKey(var1)) {
            var3 = (Vector) this.offlineMessages.get(var1);
        } else {
            var3 = new Vector();
        }

        var3.addElement(var2);
        this.offlineMessages.put(var1, var3);
    }

    public void createOfflineMessageScreen(BuddyGroupList var1) {
        this.offlineMessageScreen = new Screen();
        this.offlineMessageScreen.title = "Tin Nhắn Offline";
        ListComponent var2;
        (var2 = new ListComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight)).setIconSettings(1, 10, 10);
        var2.setDataSource(var1, 1, false);
        this.offlineMessageScreen.addComponent(var2);
        UIUtils.focusComponent(this.offlineMessageScreen, var2);
        Vector var3;
        (var3 = new Vector()).addElement(new ButtonAction("Xem", new quyen_ii(this, var2)));
        var3.addElement(new ButtonAction("Hồ sơ", new quyen_ij(this, var2)));
        ContextMenu var4 = new ContextMenu(var3);
        var2.itemAction = new quyen_ik(this, var4);
        this.offlineMessageScreen.rightSoftkey = new ButtonAction(TextConstant.close(), new quyen_il(this));
        this.updateOfflineMessageButton();
    }

    public void updateOfflineMessageButton() {
        if (this.offlineMessages.size() > 0) {
            String var1 = UIUtils.concatStrings("Tin nhắn offline", " (", Integer.toString(this.offlineMessages.size()), ")");
            if (this.offlineMessageButton == null) {
                this.offlineMessageButton = new ButtonAction(var1, new quyen_in(this));
            } else {
                this.offlineMessageButton.text = var1;
                this.contextMenuItems.setElementAt(this.offlineMessageButton, this.contextMenuItems.size());
            }

            if (!this.contextMenuItems.contains(this.offlineMessageButton)) {
                this.contextMenuItems.addElement(this.offlineMessageButton);
            }
        } else {
            if (this.offlineMessageButton != null) {
                this.contextMenuItems.removeElement(this.offlineMessageButton);
            }

            if (this.offlineMessageScreen != null) {
                GameManager.instance.removeScreen(this.offlineMessageScreen);
            }
        }
    }

    public void showGroupMessageDialog() {
        if (GameManager.instance.hasScreen("Gửi tin nhóm")) {
            GameManager.instance.switchToScreenByTitle("Gửi tin nhóm");
        } else {
            DialogScreen var1 = new DialogScreen();
            var1.title = "Gửi tin nhóm";
            ContactListComponent var2 = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
            var2.setContactData(this.friendsComponent.contactData, -1);
            var2.removeContact("Favorite");
            var2.setMultiSelectMode(true);
            var2.selectAll();
            var1.addComponent(var2);
            UIUtils.focusComponent(var1, var2);
            var1.rightSoftkey = new ButtonAction(TextConstant.close(), new quyen_io(this, var1));
            Vector var3;
            (var3 = new Vector()).addElement(new ButtonAction("Gửi tin", new quyen_ip(this, var2, var1)));
            var3.addElement(new ButtonAction("Chọn/Bỏ chọn hết", new quyen_ir(this, var2)));
            ContextMenu var4 = new ContextMenu(var3);
            var1.leftSoftkey = new ButtonAction("Menu", new quyen_is(this, var4));
            var1.startSlideAnimation(1);
            GameManager.instance.addScreenToStack((Screen) var1);
            GameManager.instance.switchToScreen(var1);
        }
    }

    public static void addContactToList(String var0, BuddyInfo var1, ContactListComponent var2) {
        if (var2.contactData == null) {
            var2.contactData = new BuddyGroupList();
        }

        var2.contactData.addContactToGroup(var0, var1);
        var2.refreshDisplayList();
    }

    public static void removeContactFromList(long var0, ContactListComponent var2) {
        if (var2.contactData != null) {
            var2.contactData.removeContact(null, var0);
            var2.refreshDisplayList();
        }
    }

    public BuddyInfo findContactById(String var1) {
        return this.friendsComponent.contactData == null ? null : this.friendsComponent.contactData.findDownloadFile(var1, null, 0L);
    }

    public boolean isUserBlocked(long var1) {
        return containsInVector(var1, this.blockedUsers);
    }

    public boolean isUserOnline(long var1) {
        return containsInVector(var1, this.onlineFriends);
    }

    public boolean isRequestPending(long var1) {
        return containsInVector(var1, this.pendingRequests);
    }

    public String getUserNameById(long var1) {
        if (this.userStorage.containsKey(new Long(var1))) {
            return (String) this.userStorage.get(new Long(var1));
        } else {
            BuddyInfo var3;
            return this.friendsComponent.contactData != null && (var3 = this.friendsComponent.contactData.findDownloadFile(null, null, var1)) != null ? var3.username : null;
        }
    }

    public long getUserTimestampById(String var1) {
        BuddyInfo var2;
        return this.friendsComponent != null && this.friendsComponent.contactData != null && (var2 = this.friendsComponent.contactData.findDownloadFile(var1, null, 0L)) != null ? var2.contactId : 0L;
    }

    public void addToOnlineList(long var1) {
        addToVector(var1, this.onlineFriends);
    }

    public void removeFromOnlineList(long var1) {
        removeFromVector(var1, this.onlineFriends);
    }

    public void addToBlockedList(long var1) {
        addToVector(var1, this.blockedUsers);
    }

    public void removeFromBlockedList(long var1) {
        removeFromVector(var1, this.blockedUsers);
    }

    public void addToPendingList(long var1) {
        addToVector(var1, this.pendingRequests);
        this.updatePendingRequestsButton();
    }

    public void removeFromPendingList(long var1) {
        removeFromVector(var1, this.pendingRequests);
        this.updatePendingRequestsButton();
        if (currentViewMode == 3) {
            this.friendsRequestComponent.contactData.removeContact(null, var1);
            this.friendsRequestComponent.refreshDisplayList();
        }
    }

    public void removeFromBlockedAndRefresh(long var1) {
        removeFromVector(var1, this.blockedUsers);
        if (currentViewMode == 2) {
            this.friendsRequestComponent.contactData.removeContact(null, var1);
            this.friendsRequestComponent.refreshDisplayList();
            GameManager.instance.showWrappedTextDialog("Xóa ID thành công");
        }
    }

    public void addToFavorites(long var1) {
        if (this.friendsComponent.contactData != null && !this.friendsComponent.contactData.isContatcExists("Favorite", var1)) {
            ContactListComponent var7 = this.friendsComponent;
            BuddyInfo var8;
            if ((var8 = var7.contactData == null ? null : var7.contactData.findDownloadFile(null, null, var1)) == null) {
                return;
            }

            this.friendsComponent.contactData.insertContactToGroup("Favorite", var8);
            BuddyGroup var9;
            if ((var9 = this.friendsComponent.contactData.findBuddyContactByName("Favorite")) != null && var9.contacts.size() > 9) {
                var9.contacts.removeElementAt(var9.contacts.size() - 1);
            }

            GameManager.saveBuddyList(this.friendsComponent.contactData, false, username);
            this.friendsComponent.refreshDisplayList();
        }
    }

    public void updateFavoriteStatus(long var1, int var3) {
        if (this.friendsComponent.contactData.findBuddyContactByName("Favorite") != null && this.friendsComponent.contactData.isContatcExists("Favorite", var1)) {
            int var4 = 0;

            for (int var5 = this.friendsComponent.displayItems.size(); var4 < var5; var4++) {
                BuddyListItem var6;
                if ((var6 = (BuddyListItem) this.friendsComponent.displayItems.elementAt(var4)).itemType == 0 && var6.contactId == var1) {
                    var6.statusCode = var3;
                    return;
                }
            }
        }
    }

    public void updateContactsStatus(long[] contactIds, String[] statusMessages) {
        if (currentViewMode == 1) {
            if (this.friendsComponent.contactData != null) {
                this.friendsComponent.contactData.updateStatus("Ban Be", contactIds, statusMessages);
                this.friendsComponent.refreshDisplayList();
                String[] messages = statusMessages;
                long[] ids = contactIds;
                FriendScreen currentScreen = this;
                if (this.friendsComponent.contactData.findBuddyContactByName("Favorite") != null) {
                    int contactCount = contactIds.length;

                    while (--contactCount >= 0) {
                        if (currentScreen.friendsComponent.contactData.isContatcExists("Favorite", ids[contactCount])) {
                            int displayIndex = 0;

                            for (int displayItemsSize = currentScreen.friendsComponent.displayItems.size(); displayIndex < displayItemsSize; displayIndex++) {
                                BuddyListItem currentItem = (BuddyListItem) currentScreen.friendsComponent.displayItems.elementAt(displayIndex);
                                if (currentItem.itemType == 0 && currentItem.contactId == ids[contactCount]) {
                                    currentItem.statusCode = 1;
                                    currentItem.statusText = messages[contactCount];
                                    if (messages[contactCount] != null && messages[contactCount].length() > 0) {
                                        currentItem.extraField = UIUtils.concatStrings(currentItem.displayName, " - ", messages[contactCount], null);
                                    } else {
                                        currentItem.extraField = currentItem.displayName;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (this.friendsRequestComponent.contactData != null) {
            if (currentViewMode == 2) {
                this.friendsRequestComponent.contactData.updateStatus("Danh sách từ chối", contactIds, statusMessages);
            } else {
                this.friendsRequestComponent.contactData.updateStatus("Danh sách kết bạn", contactIds, statusMessages);
            }

            this.friendsRequestComponent.refreshDisplayList();
        }
    }

    public void sendFriendRequest(String var1) {
        if (var1.equals("")) {
            GameManager.getInstance().showWrappedTextDialog("ID không hợp lệ.");
        } else if (!this.friendsComponent.hasContact(var1)) {
            PacketSender.b(var1);
            this.switchToMainView();
            GameManager.getInstance().showNotification("Đã gửi yêu cầu kết bạn đến " + var1, (Image) null, 1);
        } else {
            GameManager.getInstance().showWrappedTextDialog("ID đã tồn tại.");
        }
    }

    private void switchToMainView() {
        this.removeAllComponents();
        this.friendsRequestComponent = null;
        toggleOfflineFilter(this.friendsComponent);
        super.addComponent(this.friendsComponent);
        UIUtils.focusComponent(this, this.friendsComponent);
        super.leftSoftkey = new ButtonAction("Menu", new FriendSwitchMainMenuAction(this));
        UIUtils.setScreenSubtitleText(instance, "Bạn Bè");
        currentViewMode = 1;
        System.gc();
    }

    private static void addToVector(long var0, Vector var2) {
        var2.addElement(new Long(var0));
    }

    public static void setVectorFromArray(long[] var0, Vector var1) {
        var1.removeAllElements();
        int var2 = 0;

        for (int var3 = var0.length; var2 < var3; var2++) {
            var1.addElement(new Long(var0[var2]));
        }
    }

    public static long[] vectorToLongArray(Vector var0) {
        long[] var1 = new long[var0.size()];
        int var2 = var0.size();

        while (--var2 >= 0) {
            var1[var2] = ((Long) var0.elementAt(var2)).longValue();
        }

        return var1;
    }

    private static void removeFromVector(long var0, Vector var2) {
        int var3 = var2.size();

        while (--var3 >= 0) {
            if (((Long) var2.elementAt(var3)).longValue() == var0) {
                var2.removeElementAt(var3);
                return;
            }
        }
    }

    public void storeUserData(long var1, String var3) {
        if (!this.userStorage.contains(new Long(var1))) {
            this.userStorage.put(new Long(var1), var3);
            GameManager.saveUserStorage(this.userStorage);
        }
    }

    private static boolean containsInVector(long var0, Vector var2) {
        int var3 = var2.size();

        while (--var3 >= 0) {
            if (((Long) var2.elementAt(var3)).longValue() == var0) {
                return true;
            }
        }

        return false;
    }

    public static TextInputComponent getSearchInput(FriendScreen var0) {
        return var0.searchInput;
    }

    public static void exitSearchMode(FriendScreen var0) {
        var0.exitSearchMode();
    }

    public static TextInputComponent getActiveTextInput(FriendScreen var0) {
        return var0.activeTextInput;
    }

    public static void setActiveTextInput(FriendScreen var0, TextInputComponent var1) {
        var0.activeTextInput = var1;
    }

    public static Action getPrimaryAction(FriendScreen var0) {
        return var0.primaryAction;
    }

    public static void setPrimaryAction(FriendScreen var0, Action var1) {
        var0.primaryAction = var1;
    }

    public static Action getSecondaryAction(FriendScreen var0) {
        return var0.secondaryAction;
    }

    public static void setSecondaryAction(FriendScreen var0, Action var1) {
        var0.secondaryAction = var1;
    }

    public static ButtonAction getBackButton(FriendScreen var0) {
        if (var0.backButton == null) {
            var0.backButton = new ButtonAction(TextConstant.close(), new FriendBackToFriendScreenAction(var0));
        }

        return var0.backButton;
    }

    public static TextInputComponent getStatusMessageInput(FriendScreen var0) {
        return var0.statusMessageInput;
    }

    public static DropdownComponent getStatusDropdown(FriendScreen var0) {
        return var0.statusDropdown;
    }

    public static DialogScreen getStatusDialog(FriendScreen var0) {
        return var0.statusDialog;
    }

    public static void switchToMainViewAndSetRightSoftkey(FriendScreen var0) {
        var0.switchToMainView();
        var0.rightSoftkey = var0.defaultRightSoftkey;
    }
}
