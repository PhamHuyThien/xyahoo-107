final class quyen_fp implements Action {
   private GameManager a;

   quyen_fp(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      this.a.closeDialog();
      GameManager.showMainScreen();
   }
}
