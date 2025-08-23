package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_gd implements Action {
   private GameManager a;

   public quyen_gd(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.containsScreen(GameScreen.getInstance()) && GameScreen.isInGame) {
         this.a.showConfirmDialog("Bạn có muốn thoát bàn đang chơi?", new quyen_ge(this));
      } else {
         PacketSender.e(GameManager.gameRoom.gameListComponent.getSelectedItem().c);
      }
   }
}
