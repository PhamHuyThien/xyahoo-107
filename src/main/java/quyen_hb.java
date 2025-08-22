final class quyen_hb implements Action {
   private GameLobbyScreen a;

   quyen_hb(GameLobbyScreen var1) {
      this.a = var1;
   }

   public final void action() {
      NetworkManager.sendPacket(new Packet(5000012, 39));
   }
}
