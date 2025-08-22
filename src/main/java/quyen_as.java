final class quyen_as implements Action {
   private final byte[] a;

   quyen_as(byte[] var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_af.a(this.a);
   }
}
