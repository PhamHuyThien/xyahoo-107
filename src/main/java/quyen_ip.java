final class quyen_ip implements quyen_ca {
   final quyen_ia a;
   private final quyen_b b;
   private final quyen_co c;

   quyen_ip(quyen_ia var1, quyen_b var2, quyen_co var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void a() {
      long[] var1;
      if ((var1 = this.b.i()) != null) {
         quyen_ia.a(this.a, quyen_bw.a(this.c, "Nhập nội dung tin nhắn", 0, new quyen_iq(this, var1, this.c)));
         quyen_hr.a(this.c, quyen_ia.c(this.a));
      } else {
         quyen_et.c.d("Vui lòng chọn ID");
      }
   }
}
