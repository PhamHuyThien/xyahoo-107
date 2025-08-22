final class quyen_r implements Action {
   private quyen_p a;

   quyen_r(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.b(this.a.a, 4813);
   }
}
