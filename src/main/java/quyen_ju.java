public final class quyen_ju {
   private int a;
   private int b;
   private quyen_jt c;

   public quyen_ju() {
      this.c = new quyen_jt();
   }

   public quyen_ju(int var1, int var2) {
      this.a = var1;
      this.b = var2;
      this.c = new quyen_jt();
   }

   quyen_ju(int var1, int var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = new quyen_jt(var3);
   }

   public final int a() {
      return this.a;
   }

   public final quyen_jt b() {
      return this.c;
   }

   public final void a(quyen_jt var1) {
      this.c = var1;
   }

   public final int c() {
      return this.b;
   }
}
