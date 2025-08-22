final class quyen_fg implements Action {
   private GameManager a;

   quyen_fg(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showContextMenu(GameManager.d(this.a), 0);
   }
}
