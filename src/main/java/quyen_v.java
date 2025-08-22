final class quyen_v implements Action {
   private quyen_u a;

   quyen_v(quyen_u var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_u var1 = this.a;
      PacketSender.b(this.a.a.a, 4812);
   }
}
