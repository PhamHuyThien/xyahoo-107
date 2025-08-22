final class quyen_jd implements Action {
   private YahooScreen a;

   quyen_jd(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      FriendScreen.toggleOfflineFilter(this.a.contactList);
   }
}
