final class quyen_fq implements Action {
   quyen_fq(GameManager var1) {
   }

   public final void action() {
      GameGraphics.instance.initializeConnection();
      PacketSender.c();
   }
}
