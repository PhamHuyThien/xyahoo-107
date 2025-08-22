final class quyen_ig implements Action {
   private FriendScreen a;

   quyen_ig(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().removeScreen(FriendScreen.getStatusDialog(this.a));
   }
}
