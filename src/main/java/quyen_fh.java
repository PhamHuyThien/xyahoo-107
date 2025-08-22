final class quyen_fh implements Action {
   private GameManager a;

   quyen_fh(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showContextMenu(GameManager.e(this.a), 2);
   }
}
