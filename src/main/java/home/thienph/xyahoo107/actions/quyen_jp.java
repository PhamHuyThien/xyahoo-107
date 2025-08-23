package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jp implements Action {
   private YahooScreen a;

   public quyen_jp(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!YahooScreen.checkConnectionReady(this.a)) {
         this.a.showInviteFriendDialog();
      }
   }
}
