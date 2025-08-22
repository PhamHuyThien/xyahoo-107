final class quyen_ge implements Action {
   quyen_ge(quyen_gd var1) {
   }

   public final void action() {
      GameScreen.instance.exitGame(false);
      PacketSender.e(GameManager.gameRoom.gameListComponent.getSelectedItem().c);
   }
}
