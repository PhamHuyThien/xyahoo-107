final class quyen_jh implements Action {
   private YahooScreen a;

   quyen_jh(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().removeScreen(this.a);
   }
}
