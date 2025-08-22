final class quyen_jo implements Action {
   private YahooScreen a;

   quyen_jo(YahooScreen yahooScreen2) {
      this.a = yahooScreen2;
   }

   public final void action() {
      if (YahooScreen.checkConnectionReady(this.a)) {
         return;
      }
      this.a.showAddFriendDialog((String)null);
   }
}
