final class quyen_db implements Action {
   private GameScreen a;

   quyen_db(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.exitGame(true);
   }
}
