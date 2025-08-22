final class quyen_ak implements Action {
   private final byte[] a;

   quyen_ak(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_af.a(this.a);
   }
}
