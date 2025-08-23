final class quyen_ac implements Action {
   private ChatRoomScreen a;

   quyen_ac(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.roomId, 4811);
   }
}
