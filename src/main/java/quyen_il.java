final class quyen_il implements Action {
   private FriendScreen a;

   quyen_il(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.removeScreen(this.a.offlineMessageScreen);
   }
}
