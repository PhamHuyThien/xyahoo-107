final class quyen_s implements Action {
   private ChatRoomScreen a;

   quyen_s(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4810);
   }
}
