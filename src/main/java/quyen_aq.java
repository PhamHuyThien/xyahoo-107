final class quyen_aq implements quyen_ca {
   private final quyen_cs a;
   private final int b;
   private final byte[] c;

   quyen_aq(quyen_cs var1, int var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void a() {
      try {
         int var1;
         if ((var1 = Integer.parseInt(this.a.c())) > 0 && var1 <= this.b) {
            quyen_af.a(this.c);
         }
      } catch (Exception var2) {
      }
   }
}
