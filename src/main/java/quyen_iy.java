final class quyen_iy implements quyen_ca {
   private quyen_ia a;

   quyen_iy(quyen_ia var1) {
      this.a = var1;
   }

   public final void a() {
      this.a.e();
      this.a.c = null;
      System.gc();
      this.a.c = new quyen_b(0, 1, quyen_cj.h - 2, quyen_cj.i - 4 - quyen_et.e, true);
      this.a.c.a = false;
      this.a.c.c = true;
      this.a.a(this.a.c);
      quyen_hr.a(this.a, this.a.c);
      quyen_hr.b(quyen_ia.H, "ID Từ Chối");
      quyen_ia.I = 2;
      this.a.n = quyen_ia.f(this.a);
      if (this.a.K.size() > 0) {
         this.a.a(this.a.K);
      } else {
         this.a.c.c = false;
      }
   }
}
