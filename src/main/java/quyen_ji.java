final class quyen_ji implements Action {
   quyen_ji(YahooScreen var1) {
   }

   public final void action() {
      NetworkManager.sendPacket(new Packet(33, 4));
   }
}
