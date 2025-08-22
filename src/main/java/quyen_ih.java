final class quyen_ih implements Action {
   private FriendScreen a;

   quyen_ih(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      FriendScreen.switchToMainViewAndSetRightSoftkey(this.a);
   }
}
