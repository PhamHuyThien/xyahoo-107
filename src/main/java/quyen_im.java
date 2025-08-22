final class quyen_im implements Action {
   private FriendScreen a;

   quyen_im(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showStatusDialog();
   }
}
