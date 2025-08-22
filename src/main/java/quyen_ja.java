final class quyen_ja implements Action {
   private FriendScreen a;

   quyen_ja(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (FriendScreen.isAvatarEnabled = !FriendScreen.isAvatarEnabled) {
         this.a.mainContactList.resetAnimation();
      }

      Xuka.saveBooleanSetting("onavt", FriendScreen.isAvatarEnabled);
   }
}
