final class quyen_c implements quyen_ca {
   private quyen_b a;

   quyen_c(quyen_b var1) {
      this.a = var1;
   }

   public final void a() {
      String var1 = this.a.a ? "Y! " + quyen_b.a(this.a).c : quyen_b.a(this.a).c;
      quyen_hg var2;
      if ((var2 = (quyen_hg)quyen_et.c.e(var1)) != null) {
         var2.b(1);
         quyen_et.c.f(var1);
      } else {
         if (this.a.a) {
            var2 = new quyen_hg(var1, this.a.a, null, quyen_b.a(this.a).c);
         } else {
            (var2 = new quyen_hg(var1, this.a.a, quyen_b.a(this.a).k, null)).b = quyen_b.a(this.a).d.equals("") ? quyen_b.a(this.a).c : quyen_b.a(this.a).d;
            var2.a(quyen_b.a(this.a).m);
            quyen_et.c.h.m(quyen_b.a(this.a).m);
         }

         var2.b(1);
         quyen_et.c.a(var2);
         quyen_et.c.f(var2.j);
      }
   }
}
