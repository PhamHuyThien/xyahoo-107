package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ic implements Action {
   private FriendScreen a;

   public quyen_ic(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showGroupMessageDialog();
   }
}
