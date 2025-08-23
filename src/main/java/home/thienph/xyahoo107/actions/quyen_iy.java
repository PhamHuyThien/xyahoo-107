package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_iy implements Action {
   private FriendScreen a;

   public quyen_iy(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.removeAllComponents();
      this.a.secondaryContactList = null;
      System.gc();
      this.a.secondaryContactList = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
      this.a.secondaryContactList.isChatMode = false;
      this.a.secondaryContactList.isLoading = true;
      this.a.toggleOfflineFilter(this.a.secondaryContactList);
      UIUtils.focusComponent(this.a, this.a.secondaryContactList);
      UIUtils.setScreenSubtitleText(FriendScreen.instance, "ID Từ Chối");
      FriendScreen.currentViewMode = 2;
      this.a.rightSoftkey = FriendScreen.getBackButton(this.a);
      if (this.a.blockedUsers.size() > 0) {
         this.a.sendBulkRequest(this.a.blockedUsers);
      } else {
         this.a.secondaryContactList.isLoading = false;
      }
   }
}
