package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_ie implements Action {
   private FriendScreen a;

   public quyen_ie(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (GameManager.instance.containsScreenInstance(GameManager.instance.friendManager)) {
         GameManager.instance.switchToScreen(GameManager.instance.friendManager);
      } else {
         GameManager.instance.initializeFriendManager();
         GameManager.instance.addScreenToStack(GameManager.instance.friendManager);
         GameManager.instance.switchToScreen(GameManager.instance.friendManager);
      }

      this.a.removeAllComponents();
      this.a.secondaryContactList = null;
      System.gc();
      this.a.secondaryContactList = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
      this.a.secondaryContactList.isChatMode = false;
      this.a.secondaryContactList.isLoading = true;
      this.a.toggleOfflineFilter(this.a.secondaryContactList);
      UIUtils.focusComponent(this.a, this.a.secondaryContactList);
      UIUtils.setScreenSubtitleText(FriendScreen.instance, "Chờ Kết Bạn");
      FriendScreen.currentViewMode = 3;
      this.a.rightSoftkey = FriendScreen.getBackButton(this.a);
      if (this.a.pendingRequests.size() > 0) {
         this.a.sendBulkRequest(this.a.pendingRequests);
      } else {
         this.a.secondaryContactList.isLoading = false;
      }
   }
}
