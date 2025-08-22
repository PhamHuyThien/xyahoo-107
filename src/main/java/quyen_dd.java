final class quyen_dd implements Action {
   private GameScreen a;

   quyen_dd(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.centerSoftkey.text.equals("Chơi ngay!")) {
         PacketSender.e(GameScreen.currentRoomId, FriendScreen.currentUserId);
      } else {
         if (this.a.centerSoftkey.text.equals("Sẵn sàng")) {
            int var1 = this.a.playerComponents.length;

            while (--var1 >= 0) {
               if (this.a.playerComponents[var1].playerName.equals(FriendScreen.currentUserId)) {
                  this.a.centerSoftkey.text = "";
                  PacketSender.d(GameScreen.currentRoomId, FriendScreen.currentUserId);
               }
            }
         }
      }
   }
}
