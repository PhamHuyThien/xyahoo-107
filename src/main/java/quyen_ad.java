final class quyen_ad implements Action {
   private ChatRoomScreen a;

   quyen_ad(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4806);
   }
}
