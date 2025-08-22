final class quyen_ad implements Action {
   private quyen_p a;

   quyen_ad(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.a, 4806);
   }
}
