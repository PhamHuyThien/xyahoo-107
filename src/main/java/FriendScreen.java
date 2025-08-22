import javax.microedition.lcdui.Image;
import java.util.Hashtable;
import java.util.Vector;

public final class FriendScreen extends Screen {
   public static int[] avatarData;
   public ContactListComponent mainContactList;
   public ContactListComponent secondaryContactList;
   public static String currentUserId;
   public static long currentUserTimestamp;
   public static String currentUserName;
   public static int userStatus;
   public static boolean isAvatarEnabled;
   public static String statusMessage = "";
   private Vector contextMenuItems;
   public ContextMenu contextMenu;
   boolean isSearchMode;
   private TextInputComponent searchInput;
   public static FriendScreen instance;
   public static int currentViewMode;
   public Vector onlineFriends;
   public Vector blockedUsers;
   public Vector pendingRequests;
   private Hashtable userStorage;
   public boolean isInitialized;
   private UIFactory offlineMessageButton;
   public Hashtable offlineMessages;
   public Screen offlineMessageScreen;
   private TextInputComponent activeTextInput;
   private Action primaryAction;
   private Action secondaryAction;
   private DialogScreen statusDialog;
   private DropdownComponent statusDropdown;
   private TextInputComponent statusMessageInput;
   private UIFactory backButton;
   private UIFactory defaultRightSoftkey = new UIFactory(quyen_cr.c(), new quyen_ib(this));
   public Hashtable pendingInvitations;

   public final void clearContactData() {
      if (this.mainContactList != null) {
         if (this.mainContactList.displayItems != null) {
            this.mainContactList.displayItems.removeAllElements();
         }

         this.mainContactList.displayItems = null;
         this.mainContactList.contactData = null;
      }

      if (this.secondaryContactList != null) {
         if (this.secondaryContactList.displayItems != null) {
            this.secondaryContactList.displayItems.removeAllElements();
         }

         this.secondaryContactList.displayItems = null;
         this.secondaryContactList.contactData = null;
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
      this.mainContactList = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
      this.mainContactList.isChatMode = false;
      this.mainContactList.isFilterActive = Xuka.loadBooleanSetting("hideOffline", false);
      this.mainContactList.isLoading = true;
      this.toggleOfflineFilter(this.mainContactList);
      UIUtils.focusComponent(this, this.mainContactList);
      this.contextMenuItems = new Vector();
      this.contextMenu = new ContextMenu(this.contextMenuItems);
      this.contextMenuItems.addElement(new UIFactory("Trạng thái", new quyen_im(this)));
      this.contextMenuItems.addElement(this.createPendingRequestsButton());
      this.contextMenuItems.addElement(new UIFactory("Thêm bạn", new quyen_iu(this)));
      this.contextMenuItems.addElement(new UIFactory("Chat với..", new quyen_iw(this)));
      this.contextMenuItems.addElement(new UIFactory("ID từ chối", new quyen_iy(this)));
      UIFactory var1 = new UIFactory("Chức năng khác", null);
      Vector var2;
      (var2 = new Vector()).addElement(new UIFactory("Mở/tắt ID ẩn", new quyen_iz(this)));
      var2.addElement(new UIFactory("Mở/tắt avatar", new quyen_ja(this)));
      var2.addElement(new UIFactory("Gửi tin nhóm", new quyen_ic(this)));
      var1.parentContainer = new ContextMenu(var2);
      this.contextMenuItems.addElement(var1);
      super.leftSoftkey = new UIFactory("Menu", new quyen_id(this));
      super.rightSoftkey = this.defaultRightSoftkey;
   }

   public static final void toggleOfflineFilter(ContactListComponent var0) {
      var0.isFilterActive = !var0.isFilterActive;
      var0.refreshDisplayList();
      var0.contactSelectedIndex = 0;
      Xuka.saveBooleanSetting("hideOffline", var0.isFilterActive);
   }

   public final void updateContactAvatar(long var1, int[] var3) {
      this.mainContactList.updateContactAvatar(var1, var3);
      if (this.secondaryContactList != null) {
         this.secondaryContactList.updateContactAvatar(var1, var3);
      }
   }

   public final UIFactory createPendingRequestsButton() {
      return new UIFactory("Chờ kết bạn" + (this.pendingRequests.size() > 0 ? " (+" + this.pendingRequests.size() + ")" : ""), new quyen_ie(this));
   }

   public static void updateStatusMessage(String var0) {
      quyen_a.c(var0, 1);
      statusMessage = var0;
      Xuka.saveStringData(currentUserId, var0, false);
   }

   public final void showStatusDialog() {
      if (this.statusDialog == null) {
         System.gc();
         this.statusDialog = new DialogScreen();
         this.statusDialog.title = "Trạng Thái";
         UIUtils.calculateColumnLayout(UIUtils.layoutParam1, UIUtils.layoutParam2);
         this.statusDialog.nextComponentY += 20;
         this.statusDropdown = UIFactory.createChoiceBox(this.statusDialog, UIUtils.concatStrings("Trạng thái", ":", null, null), new String[]{"Hiển thị", "Ẩn danh"});
         this.statusMessageInput = UIFactory.createLabeledTextInput(this.statusDialog, UIUtils.concatStrings("Thông điệp", ":", null, null), 0, -1);
         UIUtils.focusComponent(this.statusDialog, this.statusDropdown);
         this.statusDialog.centerSoftkey = new UIFactory("OK", new quyen_if(this));
         this.statusDialog.rightSoftkey = new UIFactory(quyen_cr.c(), new quyen_ig(this));
         System.gc();
      }

      this.statusDropdown.setSelectedIndex(userStatus == 1 ? 0 : 1);
      GameManager.getInstance().addScreenToStack((Screen)this.statusDialog);
      this.statusMessageInput.setText(statusMessage);
      GameManager.getInstance().o();
   }

   public final void addAllFriendsToOnline() {
      if (this.mainContactList.contactData != null) {
         DownloadCategory var1 = this.mainContactList.contactData.findCategoryById("Ban Be");
         int var2 = 0;

         for (int var3 = var1.downloads.size(); var2 < var3; var2++) {
            this.addToOnlineList(((DownloadData)var1.downloads.elementAt(var2)).timestamp);
         }
      }
   }

   private void enterSearchMode() {
      this.searchInput.setText("");
      this.addComponent(this.searchInput);
      UIUtils.focusComponent(this, (UIComponent)this.searchInput);
      this.isSearchMode = true;
   }

   private void exitSearchMode() {
      UIUtils.focusComponent(this, this.mainContactList);
      this.removeComponent(this.searchInput);
      this.isSearchMode = false;
   }

   public final boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.isSearchMode && super.components.contains(this.mainContactList) && (this.activeTextInput == null || !UIUtils.isComponentSelected(this, (UIComponent)this.activeTextInput))) {
         this.enterSearchMode();
      }

      String var4 = "";
      if (this.isSearchMode) {
         if (var1[12]) {
            var1[12] = false;
            this.mainContactList.handleKeyPress(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.mainContactList.handleKeyPress(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.mainContactList.handleKeyPress(16);
         }

         var4 = this.searchInput.getText();
      }

      super.handleInput(var1, var2, var3);
      if (this.isSearchMode) {
         if (this.searchInput.getText().equals("")) {
            this.exitSearchMode();
         }

         if (!this.searchInput.getText().equals(var4)) {
            this.mainContactList.setSearchFilter(this.searchInput.getText());
         }
      }

      return true;
   }

   public final void sendBulkRequest(Vector var1) {
      if (var1.size() > 0) {
         long[] var5 = vectorToLongArray(var1);
         Packet var2 = new Packet(5000028, 2);
         quyen_a.a(var5.length, var2);
         int var3 = 0;

         for (int var4 = var5.length; var3 < var4; var3++) {
            quyen_a.a(var5[var3], var2);
         }

         NetworkManager.sendPacket(var2);
      }
   }

   public final void updatePendingRequestsButton() {
      int var1 = this.contextMenuItems.size();

      while (--var1 >= 0) {
         if (((UIFactory)this.contextMenuItems.elementAt(var1)).text.startsWith("Chờ kết bạn")) {
            ((UIFactory)this.contextMenuItems.elementAt(var1)).text = "Chờ kết bạn";
            if (this.pendingRequests.size() > 0) {
               ((UIFactory)this.contextMenuItems.elementAt(var1)).text = UIUtils.concatStrings("Chờ kết bạn", " (+", Integer.toString(this.pendingRequests.size()), ")");
            }

            GameManager.instance.a((UIFactory)this.contextMenuItems.elementAt(var1), var1);
            var1 = 0;
            System.gc();
         }
      }
   }

   public final void addPendingInvitation(long var1, String var3) {
      if (this.pendingInvitations == null) {
         this.pendingInvitations = new Hashtable();
      }

      quyen_a.a(var1);
      this.pendingInvitations.put(new Long(var1), var3);
   }

   public final void processPendingInvitation(long var1) {
      if (this.pendingInvitations.containsKey(new Long(var1))) {
         String var3 = (String)this.pendingInvitations.get(new Long(var1));
         this.pendingInvitations.remove(new Long(var1));
         GameManager.instance.c(var1, var3);
      }
   }

   public final void addOfflineMessage(String var1, String var2) {
      if (this.offlineMessages == null) {
         this.offlineMessages = new Hashtable();
      }

      Vector var3;
      if (this.offlineMessages.containsKey(var1)) {
         var3 = (Vector)this.offlineMessages.get(var1);
      } else {
         var3 = new Vector();
      }

      var3.addElement(var2);
      this.offlineMessages.put(var1, var3);
   }

   public final void createOfflineMessageScreen(DownloadDataManager var1) {
      this.offlineMessageScreen = new Screen();
      this.offlineMessageScreen.title = "Tin Nhắn Offline";
      ListComponent var2;
      (var2 = new ListComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight)).setIconSettings(1, 10, 10);
      var2.setDataSource(var1, 1, false);
      this.offlineMessageScreen.addComponent(var2);
      UIUtils.focusComponent(this.offlineMessageScreen, var2);
      Vector var3;
      (var3 = new Vector()).addElement(new UIFactory("Xem", new quyen_ii(this, var2)));
      var3.addElement(new UIFactory("Hồ sơ", new quyen_ij(this, var2)));
      ContextMenu var4 = new ContextMenu(var3);
      var2.itemAction = new quyen_ik(this, var4);
      this.offlineMessageScreen.rightSoftkey = new UIFactory(quyen_cr.c(), new quyen_il(this));
      this.updateOfflineMessageButton();
   }

   public final void updateOfflineMessageButton() {
      if (this.offlineMessages.size() > 0) {
         String var1 = UIUtils.concatStrings("Tin nhắn offline", " (", Integer.toString(this.offlineMessages.size()), ")");
         if (this.offlineMessageButton == null) {
            this.offlineMessageButton = new UIFactory(var1, new quyen_in(this));
         } else {
            this.offlineMessageButton.text = var1;
            this.contextMenuItems.setElementAt(this.offlineMessageButton, this.contextMenuItems.size());
         }

         if (!this.contextMenuItems.contains(this.offlineMessageButton)) {
            this.contextMenuItems.addElement(this.offlineMessageButton);
            return;
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

   public final void showGroupMessageDialog() {
      if (GameManager.instance.a("Gửi tin nhóm")) {
         GameManager.instance.f("Gửi tin nhóm");
      } else {
         DialogScreen var1;
         (var1 = new DialogScreen()).title = "Gửi tin nhóm";
         ContactListComponent var2;
         (var2 = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true)).setContactData(this.mainContactList.contactData, -1);
         var2.removeContact("Favorite");
         var2.setMultiSelectMode(true);
         var2.selectAll();
         var1.addComponent(var2);
         UIUtils.focusComponent(var1, var2);
         var1.rightSoftkey = new UIFactory(quyen_cr.c(), new quyen_io(this, var1));
         Vector var3;
         (var3 = new Vector()).addElement(new UIFactory("Gửi tin", new quyen_ip(this, var2, var1)));
         var3.addElement(new UIFactory("Chọn/Bỏ chọn hết", new quyen_ir(this, var2)));
         ContextMenu var4 = new ContextMenu(var3);
         var1.leftSoftkey = new UIFactory("Menu", new quyen_is(this, var4));
         var1.startSlideAnimation(1);
         GameManager.instance.addScreenToStack((Screen)var1);
         GameManager.instance.e(var1);
      }
   }

   public static void addContactToList(String var0, DownloadData var1, ContactListComponent var2) {
      if (var2.contactData == null) {
         var2.contactData = new DownloadDataManager();
      }

      var2.contactData.addDownloadToCategory(var0, var1);
      var2.refreshDisplayList();
   }

   public static void removeContactFromList(long var0, ContactListComponent var2) {
      if (var2.contactData != null) {
         var2.contactData.removeDownload(null, var0);
         var2.refreshDisplayList();
      }
   }

   public final DownloadData findContactById(String var1) {
      return this.mainContactList.contactData == null ? null : this.mainContactList.contactData.findDownload(var1, null, 0L);
   }

   public final boolean isUserBlocked(long var1) {
      return containsInVector(var1, this.blockedUsers);
   }

   public final boolean isUserOnline(long var1) {
      return containsInVector(var1, this.onlineFriends);
   }

   public final boolean isRequestPending(long var1) {
      return containsInVector(var1, this.pendingRequests);
   }

   public final String getUserNameById(long var1) {
      if (this.userStorage.containsKey(new Long(var1))) {
         return (String)this.userStorage.get(new Long(var1));
      } else {
         DownloadData var3;
         return this.mainContactList.contactData != null && (var3 = this.mainContactList.contactData.findDownload(null, null, var1)) != null ? var3.downloadId : null;
      }
   }

   public final long getUserTimestampById(String var1) {
      DownloadData var2;
      return this.mainContactList != null && this.mainContactList.contactData != null && (var2 = this.mainContactList.contactData.findDownload(var1, null, 0L)) != null ? var2.timestamp : 0L;
   }

   public final void addToOnlineList(long var1) {
      addToVector(var1, this.onlineFriends);
   }

   public final void removeFromOnlineList(long var1) {
      removeFromVector(var1, this.onlineFriends);
   }

   public final void addToBlockedList(long var1) {
      addToVector(var1, this.blockedUsers);
   }

   public final void removeFromBlockedList(long var1) {
      removeFromVector(var1, this.blockedUsers);
   }

   public final void addToPendingList(long var1) {
      addToVector(var1, this.pendingRequests);
      this.updatePendingRequestsButton();
   }

   public final void removeFromPendingList(long var1) {
      removeFromVector(var1, this.pendingRequests);
      this.updatePendingRequestsButton();
      if (currentViewMode == 3) {
         this.secondaryContactList.contactData.removeDownload(null, var1);
         this.secondaryContactList.refreshDisplayList();
      }
   }

   public final void removeFromBlockedAndRefresh(long var1) {
      removeFromVector(var1, this.blockedUsers);
      if (currentViewMode == 2) {
         this.secondaryContactList.contactData.removeDownload(null, var1);
         this.secondaryContactList.refreshDisplayList();
         GameManager.instance.d("Xóa ID thành công");
      }
   }

   public final void addToFavorites(long var1) {
      if (this.mainContactList.contactData != null && !this.mainContactList.contactData.isDownloadExists("Favorite", var1)) {
         ContactListComponent var7 = this.mainContactList;
         DownloadData var8;
         if ((var8 = var7.contactData == null ? null : var7.contactData.findDownload(null, null, var1)) == null) {
            return;
         }

         this.mainContactList.contactData.insertDownloadToCategory("Favorite", var8);
         DownloadCategory var9;
         if ((var9 = this.mainContactList.contactData.findCategoryById("Favorite")) != null && var9.downloads.size() > 9) {
            var9.downloads.removeElementAt(var9.downloads.size() - 1);
         }

         GameManager.saveBuddyList(this.mainContactList.contactData, false, currentUserId);
         this.mainContactList.refreshDisplayList();
      }
   }

   public final void updateFavoriteStatus(long var1, int var3) {
      if (this.mainContactList.contactData.findCategoryById("Favorite") != null && this.mainContactList.contactData.isDownloadExists("Favorite", var1)) {
         int var4 = 0;

         for (int var5 = this.mainContactList.displayItems.size(); var4 < var5; var4++) {
            quyen_bj var6;
            if ((var6 = (quyen_bj)this.mainContactList.displayItems.elementAt(var4)).a == 0 && var6.m == var1) {
               var6.g = var3;
               return;
            }
         }
      }
   }

   public final void updateContactsStatus(long[] var1, String[] var2) {
      if (currentViewMode == 1) {
         if (this.mainContactList.contactData != null) {
            this.mainContactList.contactData.updateDownloadStatus("Ban Be", var1, var2);
            this.mainContactList.refreshDisplayList();
            String[] var3 = var2;
            long[] var9 = var1;
            FriendScreen var8 = this;
            if (this.mainContactList.contactData.findCategoryById("Favorite") != null) {
               int var4 = var1.length;

               while (--var4 >= 0) {
                  if (var8.mainContactList.contactData.isDownloadExists("Favorite", var9[var4])) {
                     int var5 = 0;

                     for (int var6 = var8.mainContactList.displayItems.size(); var5 < var6; var5++) {
                        quyen_bj var7;
                        if ((var7 = (quyen_bj)var8.mainContactList.displayItems.elementAt(var5)).a == 0 && var7.m == var9[var4]) {
                           var7.g = 1;
                           var7.e = var3[var4];
                           if (var3[var4] != null && var3[var4].length() > 0) {
                              var7.f = UIUtils.concatStrings(var7.d, " - ", var3[var4], null);
                           } else {
                              var7.f = var7.d;
                           }
                        }
                     }
                  }
               }
            }
         }
      } else if (this.secondaryContactList.contactData != null) {
         if (currentViewMode == 2) {
            this.secondaryContactList.contactData.updateDownloadStatus("Danh sách từ chối", var1, var2);
         } else {
            this.secondaryContactList.contactData.updateDownloadStatus("Danh sách kết bạn", var1, var2);
         }

         this.secondaryContactList.refreshDisplayList();
      }
   }

   public final void sendFriendRequest(String var1) {
      if (var1.equals("")) {
         GameManager.getInstance().d("ID không hợp lệ.");
      } else if (!this.mainContactList.hasContact(var1)) {
         quyen_a.b(var1);
         this.switchToMainView();
         GameManager.getInstance().showNotification("Đã gửi yêu cầu kết bạn đến " + var1, (Image) null, 1);
      } else {
         GameManager.getInstance().d("ID đã tồn tại.");
      }
   }

   private void switchToMainView() {
      this.removeAllComponents();
      this.secondaryContactList = null;
      this.toggleOfflineFilter(this.mainContactList);
      UIUtils.focusComponent(this, this.mainContactList);
      super.leftSoftkey = new UIFactory("Menu", new quyen_it(this));
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
         var1[var2] = ((Long)var0.elementAt(var2)).longValue();
      }

      return var1;
   }

   private static void removeFromVector(long var0, Vector var2) {
      int var3 = var2.size();

      while (--var3 >= 0) {
         if (((Long)var2.elementAt(var3)).longValue() == var0) {
            var2.removeElementAt(var3);
            return;
         }
      }
   }

   public final void storeUserData(long var1, String var3) {
      if (!this.userStorage.contains(new Long(var1))) {
         this.userStorage.put(new Long(var1), var3);
         GameManager.saveUserStorage(this.userStorage);
      }
   }

   private static boolean containsInVector(long var0, Vector var2) {
      int var3 = var2.size();

      while (--var3 >= 0) {
         if (((Long)var2.elementAt(var3)).longValue() == var0) {
            return true;
         }
      }

      return false;
   }

   static TextInputComponent getSearchInput(FriendScreen var0) {
      return var0.searchInput;
   }

   static void exitSearchMode(FriendScreen var0) {
      var0.exitSearchMode();
   }

   static TextInputComponent getActiveTextInput(FriendScreen var0) {
      return var0.activeTextInput;
   }

   static void setActiveTextInput(FriendScreen var0, TextInputComponent var1) {
      var0.activeTextInput = var1;
   }

   static Action getPrimaryAction(FriendScreen var0) {
      return var0.primaryAction;
   }

   static void setPrimaryAction(FriendScreen var0, Action var1) {
      var0.primaryAction = var1;
   }

   static Action getSecondaryAction(FriendScreen var0) {
      return var0.secondaryAction;
   }

   static void setSecondaryAction(FriendScreen var0, Action var1) {
      var0.secondaryAction = var1;
   }

   static UIFactory getBackButton(FriendScreen var0) {
      if (var0.backButton == null) {
         var0.backButton = new UIFactory(quyen_cr.c(), new quyen_ih(var0));
      }

      return var0.backButton;
   }

   static TextInputComponent getStatusMessageInput(FriendScreen var0) {
      return var0.statusMessageInput;
   }

   static DropdownComponent getStatusDropdown(FriendScreen var0) {
      return var0.statusDropdown;
   }

   static DialogScreen getStatusDialog(FriendScreen var0) {
      return var0.statusDialog;
   }

   static void switchToMainViewAndSetRightSoftkey(FriendScreen var0) {
      var0.switchToMainView();
      var0.rightSoftkey = var0.defaultRightSoftkey;
   }
}
