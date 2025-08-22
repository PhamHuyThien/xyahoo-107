final class quyen_fv implements quyen_ca {
   final quyen_et a;
   private final quyen_bn b;
   private final quyen_bk c;

   quyen_fv(quyen_et var1, quyen_bn var2, quyen_bk var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void a() {
      String var1 = this.b.a(true);
      if (quyen_bn.a(var1) && this.b.c(var1)) {
         quyen_et.a();
         int var2;
         if ((var2 = this.c.a(var1)) < 0) {
            this.a.d("Lỗi đọc file.");
         } else {
            this.a.a(var2, new quyen_fw(this, this.b, var1), new quyen_fx(this));
         }
      } else {
         quyen_et.a("Xubi", "Không hỗ trợ file này", true);
      }
   }
}
