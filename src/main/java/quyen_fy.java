final class quyen_fy implements Runnable {
   private quyen_et a;
   private final boolean b;

   quyen_fy(quyen_et var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void run() {
      try {
         quyen_bn var1 = quyen_bn.a();
         quyen_bk var2 = quyen_bk.a();
         quyen_et.a(this.a, var1.a(false));
         byte[] var4;
         if ((var4 = var2.b(var1.a(true))) == null || var4.length == 0) {
            this.a.d("Lỗi đọc file.");
         } else if (this.b) {
            if (quyen_et.f(this.a) == 0) {
               this.a.a(var4, var1.a(false), false, this.a.S);
            } else if (quyen_et.f(this.a) == 1) {
               quyen_et.a(var4, var1.a(false), false, 2);
            }
         } else {
            if (!quyen_et.g(this.a)) {
               this.a.a(quyen_et.h(this.a), var4, var1.b(quyen_et.h(this.a)));
            }

            this.a.I();
         }
      } catch (ClassNotFoundException var3) {
         this.a.d("Điện thoại không hỗ trợ chức năng này");
      }
   }
}
