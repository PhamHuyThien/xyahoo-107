final class quyen_ar implements Action {
   private final byte a;
   private final byte[] b;

   quyen_ar(byte var1, byte[] var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      quyen_af.a(this.a);
      quyen_af.a(this.b);
   }
}
