final class quyen_jq implements Action {
   private YahooScreen a;

   quyen_jq(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.logout();
   }
}
