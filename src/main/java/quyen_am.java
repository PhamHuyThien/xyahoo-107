final class quyen_am implements quyen_ca {
   private final boolean a;
   private final quyen_cb b;
   private final boolean[] c;
   private final byte[] d;

   quyen_am(boolean var1, quyen_cb var2, boolean[] var3, byte[] var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void a() {
      if (this.a) {
         quyen_et var10000 = quyen_et.c;
         int var10001 = this.b.a();
         quyen_cb var1 = this.b;
         var10000.a(var10001, this.c[this.b.b * var1.c + var1.a]);
      } else {
         quyen_af.a(this.d);
      }
   }
}
