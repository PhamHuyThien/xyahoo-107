final class quyen_iz implements Action {
   private FriendScreen a;

   quyen_iz(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      FriendScreen.toggleOfflineFilter(this.a.mainContactList);
   }
}
