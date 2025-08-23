package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_df implements Action {
   private GameScreen a;

   public quyen_df(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.cardGameComponent.isFirstMove) {
         this.a.cardGameComponent.isFirstMove = false;
      }

      if (FriendScreen.currentUserId.equals(this.a.currentPlayerTurn)) {
         this.a.cardGameComponent.gameEnded = true;
         PacketSender.f(GameScreen.currentRoomId, FriendScreen.currentUserId);
      }
   }
}
