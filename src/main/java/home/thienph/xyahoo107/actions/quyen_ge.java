package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

final class quyen_ge implements Action {
   quyen_ge(quyen_gd var1) {
   }

   public final void action() {
      GameScreen.instance.exitGame(false);
      PacketSender.e(GameManager.gameRoom.gameListComponent.getSelectedItem().c);
   }
}
