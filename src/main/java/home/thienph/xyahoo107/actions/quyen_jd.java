package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jd implements Action {
   private YahooScreen a;

   public quyen_jd(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      FriendScreen.toggleOfflineFilter(this.a.contactList);
   }
}
