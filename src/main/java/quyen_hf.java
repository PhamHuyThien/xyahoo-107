public final class quyen_hf extends quyen_jz {
   private static quyen_hf b = null;
   public static quyen_et a;

   public final void b() {
      a.t();
   }

   public final void c() {
      a.u();
   }

   protected final void a(quyen_ju var1, int var2) {
      switch (var2) {
         case -5:
            a.E();
            return;
         case 20:
            String var17 = quyen_a.g(var1);
            int var20 = quyen_a.d(var1);
            String var21 = quyen_a.g(var1);
            quyen_a.g(var1);
            quyen_a.g(var1);
            quyen_a.g(var1);
            a.a(var17, var20, 2);
            a.a(var17, var21, 2);
            return;
         case 22:
            String var14 = quyen_a.g(var1);
            a.j(var14);
            return;
         case 24:
            quyen_bb var16 = new quyen_bb();
            int var3 = quyen_a.d(var1);

            for (int var4 = 0; var4 < var3; var4++) {
               String var18 = quyen_a.g(var1);
               quyen_bd var6 = new quyen_bd(var18);
               int var19 = quyen_a.d(var1);

               for (int var22 = 0; var22 < var19; var22++) {
                  String var23 = quyen_a.g(var1);
                  int var24 = quyen_a.d(var1);
                  String var25 = quyen_a.g(var1);
                  quyen_a.g(var1);
                  String var26 = quyen_a.g(var1);
                  quyen_a.g(var1);
                  var6.a(new quyen_ba(var23, var26, var24, var25, new int[0], 0, 0, null));
               }

               var16.a.addElement(var6);
            }

            a.a(var16);
            return;
         case 25:
            String var8 = quyen_a.g(var1);
            quyen_a.g(var1);
            String var9 = quyen_a.g(var1);
            String var10 = quyen_a.g(var1);
            a.a(var8, var9, var10);
            return;
         case 27:
            if (quyen_a.d(var1) == -1) {
               a.v();
               return;
            }
            break;
         case 30:
            String var13 = quyen_a.g(var1);
            a.a(var13, 0L, true);
            return;
         case 32:
            String var15 = quyen_a.g(var1);
            byte var12 = var1.b().a();
            a.b(var15, var12);
            break;
         case 34:
            String var5 = quyen_a.g(var1);
            quyen_a.g(var1);
            String var7 = quyen_a.g(var1);
            a.a(var5, var7);
            return;
         case 55:
            return;
         case 56:
            int var11 = quyen_a.d(var1);
            quyen_et.c(var11);
            return;
      }
   }

   public static quyen_hf a() {
      if (b == null) {
         b = new quyen_hf();
      }

      return b;
   }

   public final void d() {
   }
}
