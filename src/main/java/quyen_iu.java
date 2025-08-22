final class quyen_iu implements quyen_ca {
   final quyen_ia a;

   quyen_iu(quyen_ia var1) {
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

      if (quyen_ia.d(this.a) == null) {
         quyen_ia.a(this.a, new quyen_iv(this));
      }

      quyen_ia.c(this.a).z = quyen_ia.d(this.a);
      this.a.a(quyen_ia.c(this.a));
      quyen_hr.a(this.a, quyen_ia.c(this.a));
   }
}
