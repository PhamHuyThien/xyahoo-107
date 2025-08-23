final class quyen_ae implements Action {
   private ChatRoomScreen a;

   quyen_ae(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4805);
   }
}
