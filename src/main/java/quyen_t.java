final class quyen_t implements Action {
   private ChatRoomScreen a;

   quyen_t(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4809);
   }
}
