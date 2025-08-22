final class quyen_ix implements quyen_ca {
   private quyen_iw a;

   quyen_ix(quyen_iw var1) {
      this.a = var1;
   }

   public final void a() {
      quyen_iw var1 = this.a;
      String var5 = quyen_ia.c(this.a.a).c().trim();
      quyen_hg var2;
      if ((var2 = (quyen_hg)quyen_et.c.e(var5)) != null) {
         var2.b(1);
         quyen_et.c.f(var5);
      } else {
         long var3;
         if ((var3 = quyen_ia.H.c(var5)) == 0L) {
            quyen_a.c(var5);
            quyen_et.c.H = true;
         } else {
            (var2 = new quyen_hg(var5, false, null, null)).b = var5;
            var2.a(var3);
            var2.b(1);
            quyen_et.c.a(var2);
            quyen_et.c.f(var2.j);
         }
      }

      System.gc();
   }
}
