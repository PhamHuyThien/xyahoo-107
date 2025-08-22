final class quyen_az implements Action {
   private final byte[] a;

   quyen_az(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_af.a(this.a);
   }
}
