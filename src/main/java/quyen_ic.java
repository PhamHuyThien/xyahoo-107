final class quyen_ic implements Action {
   private FriendScreen a;

   quyen_ic(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showGroupMessageDialog();
   }
}
