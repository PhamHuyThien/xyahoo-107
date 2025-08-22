final class quyen_di implements Action {
   private GameScreen a;

   quyen_di(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(GameScreen.getGameMenu(this.a), 0);
   }
}
