final class quyen_dw implements Action {
   private GameScreen a;

   quyen_dw(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(GameScreen.getLobbyMenu(this.a), 0);
   }
}
