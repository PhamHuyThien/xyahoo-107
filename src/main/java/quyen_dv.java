final class quyen_dv implements Action {
   quyen_dv(GameScreen var1) {
   }

   public final void action() {
      if (GameScreen.totalRooms == 0) {
         quyen_a.g(GameScreen.gameTypeId);
      }
   }
}
