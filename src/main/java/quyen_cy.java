final class quyen_cy implements Action {
   private GameRoomGridComponent a;

   quyen_cy(GameRoomGridComponent var1) {
      this.a = var1;
   }

   public final void action() {
      String var1 = GameRoomGridComponent.getRoomData(this.a)[GameRoomGridComponent.getSelectedIndex(this.a)].roomId;
      if (GameRoomGridComponent.getRoomType(this.a) == 0) {
         PacketSender.c(var1, FriendScreen.currentUserId);
      }
   }
}
