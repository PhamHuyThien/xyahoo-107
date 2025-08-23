final class quyen_r implements Action {
   private ChatRoomScreen a;

   quyen_r(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4813);
   }
}
