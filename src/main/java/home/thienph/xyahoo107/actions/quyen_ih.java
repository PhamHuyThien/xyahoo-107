package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ih implements Action {
   private FriendScreen a;

   public quyen_ih(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      FriendScreen.switchToMainViewAndSetRightSoftkey(this.a);
   }
}
