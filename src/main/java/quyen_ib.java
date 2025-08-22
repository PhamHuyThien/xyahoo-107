final class quyen_ib implements Action {
   quyen_ib(FriendScreen var1) {
   }

   public final void action() {
      GameManager.instance.removeScreen(FriendScreen.instance);
   }
}
