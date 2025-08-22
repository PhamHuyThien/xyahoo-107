final class quyen_jg implements Action {
   private YahooScreen a;

   quyen_jg(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.performLogin();
   }
}
