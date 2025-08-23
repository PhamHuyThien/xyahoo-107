package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

final class quyen_iv implements Action {
   private quyen_iu a;

   quyen_iv(quyen_iu var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_iu var1 = this.a;
      if (FriendScreen.getActiveTextInput(this.a.a).getText() != null) {
         var1 = this.a;
         if (FriendScreen.getActiveTextInput(this.a.a).getText().length() > 0) {
            var1 = this.a;
            var1 = this.a;
            this.a.a.sendFriendRequest(FriendScreen.getActiveTextInput(this.a.a).getText());
         }
      }
   }
}
