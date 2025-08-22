final class quyen_jk implements Action {
   private YahooScreen a;

   quyen_jk(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().removeScreen(YahooScreen.getStatusScreen(this.a));
   }
}
