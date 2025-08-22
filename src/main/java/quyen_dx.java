final class quyen_dx implements Action {
   private GameScreen a;
   private final int b;

   quyen_dx(GameScreen var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      PacketSender.a(GameScreen.currentRoomId, FriendScreen.currentUserId, this.a.playerComponents[this.b].playerName);
   }
}
