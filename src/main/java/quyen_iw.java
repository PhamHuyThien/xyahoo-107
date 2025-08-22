final class quyen_iw implements quyen_ca {
   final quyen_ia a;

   quyen_iw(quyen_ia var1) {
      this.a = var1;
   }

   public final void a() {
      if (this.a.G) {
         quyen_ia.a(this.a).c("");
         this.a.b.c("");
         quyen_ia.b(this.a);
      }

      if (quyen_ia.c(this.a) == null) {
         quyen_ia.a(this.a, quyen_bw.a(this.a, "Vui lòng nhập Xubi ID", 0, null));
      }

      if (quyen_ia.e(this.a) == null) {
         quyen_ia.b(this.a, new quyen_ix(this));
      }

      quyen_ia.c(this.a).z = quyen_ia.e(this.a);
      this.a.a(quyen_ia.c(this.a));
      quyen_hr.a(this.a, quyen_ia.c(this.a));
   }
}
