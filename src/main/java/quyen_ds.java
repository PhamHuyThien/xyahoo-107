final class quyen_ds implements Action {
   private GameScreen a;

   quyen_ds(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameScreen.showBetInput(this.a);
   }
}
