final class quyen_dc implements Action {
   private GameScreen a;

   quyen_dc(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(GameScreen.getGameMenu(this.a), 0);
   }
}
