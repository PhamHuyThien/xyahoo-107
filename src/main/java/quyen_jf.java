final class quyen_jf implements Action {
   private YahooScreen a;

   quyen_jf(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
   }
}
