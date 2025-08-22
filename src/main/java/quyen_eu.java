final class quyen_eu implements Action {
   quyen_eu(GameManager var1) {
   }

   public final void action() {
      GameManager.isConnected = true;
      GameGraphics.instance.initializeConnection();
      quyen_a.b();
   }
}
