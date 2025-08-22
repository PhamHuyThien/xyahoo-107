public final class quyen_jt {
   private byte[] a;
   private int b;
   private int c;

   public quyen_jt() {
      this.a = new byte[32];
      this.c = 0;
   }

   public quyen_jt(byte[] var1) {
      this.a = var1;
      this.c = 0;
      this.b = var1.length;
   }

   public final void a(byte var1) {
      this.a[this.c++] = var1;
      this.d();
   }

   private void d() {
      if (this.c > this.b) {
         this.b = this.c;
      }
   }

   public final void a(int var1) {
      if ((var1 = this.c + var1) > this.a.length) {
         byte[] var3 = new byte[var1];
         System.arraycopy(this.a, 0, var3, 0, this.b);
         this.a = var3;
      }
   }

   public final void a(byte[] var1, int var2, int var3) {
      System.arraycopy(var1, var2, this.a, this.c, var3);
      this.c += var3;
      this.d();
   }

   public final byte a() {
      return this.a[this.c++];
   }

   public final byte[] b(int var1) {
      byte[] var2 = new byte[var1];
      System.arraycopy(this.a, this.c, var2, 0, var1);
      this.c += var1;
      return var2;
   }

   public final byte[] b() {
      return this.a;
   }

   public final int c() {
      return this.b;
   }
}
