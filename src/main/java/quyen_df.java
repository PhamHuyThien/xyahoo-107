final class quyen_df implements Action {
   private GameScreen a;

   quyen_df(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.cardGameComponent.isFirstMove) {
         this.a.cardGameComponent.isFirstMove = false;
      }

      if (FriendScreen.currentUserId.equals(this.a.currentPlayerTurn)) {
         this.a.cardGameComponent.gameEnded = true;
         quyen_a.f(GameScreen.currentRoomId, FriendScreen.currentUserId);
      }
   }
}
