final class quyen_du implements Action {
   quyen_du(GameScreen var1) {
   }

   public final void action() {
      GameManager.instance.removeScreen(GameScreen.instance);
      System.gc();
   }
}
