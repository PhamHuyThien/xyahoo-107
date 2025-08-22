final class quyen_if implements quyen_ca {
   private quyen_ia a;

   quyen_if(quyen_ia var1) {
      this.a = var1;
   }

   public final void a() {
      String var1 = quyen_hs.b(quyen_ia.g(this.a).c().trim());
      int var2 = quyen_ia.h(this.a).a() == 0 ? 1 : 0;
      if (var1 != null && !var1.equals(quyen_ia.E)) {
         quyen_ia.a(var1);
         if (!var1.equals("")) {
            var2 = 1;
         }

         quyen_a.a(var2, 1);
      } else if (var2 != quyen_ia.C) {
         quyen_a.a(var2, 1);
      }

      quyen_ia.C = var2;
      quyen_et.e().c(quyen_ia.i(this.a));
   }
}
