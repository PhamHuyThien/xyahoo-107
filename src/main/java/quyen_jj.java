final class quyen_jj implements quyen_ca {
   private quyen_jc a;

   quyen_jj(quyen_jc var1) {
      this.a = var1;
   }

   public final void a() {
      String var1 = quyen_hs.b(quyen_jc.e(this.a).c().trim());
      int var2 = quyen_jc.f(this.a).a() == 0 ? 0 : 12;
      if (var1 != null && !var1.equals(quyen_jc.A)) {
         quyen_jc.a(this.a, var1);
         quyen_jc.d = 0;
         quyen_et.I = true;
      } else if (var2 != quyen_jc.d) {
         if (var2 == 0) {
            if (var1 != null && var1.length() > 0) {
               quyen_jc.a(this.a, var1);
            } else {
               quyen_a.a(0, 2);
            }

            quyen_jc.d = 0;
            quyen_et.I = true;
         } else {
            quyen_a.a(12, 2);
            quyen_jc.d = 12;
            quyen_et.I = true;
         }
      }

      quyen_et.e().c(quyen_jc.g(this.a));
   }
}
