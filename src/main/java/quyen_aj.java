final class quyen_aj implements Action {
   private final byte[] a;

   quyen_aj(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_af.a(this.a);
   }
}
