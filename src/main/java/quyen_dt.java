final class quyen_dt implements Action {
   private GameScreen a;

   quyen_dt(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (GameScreen.totalRooms == 0) {
         this.a.returnToLobby();
         GameScreen.requestRoomList();
      }
   }
}
