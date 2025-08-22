final class quyen_ek implements quyen_ca {
   private quyen_ec a;

   quyen_ek(quyen_ec var1) {
      this.a = var1;
   }

   public final void a() {
      System.gc();
      this.a.a.c(this.a.a.c().toLowerCase());
      quyen_ia.d = this.a.a.c();
      quyen_ia.C = this.a.d.a ? 0 : 1;
      if ((quyen_et.L = (byte)this.a.D.a()) == 1) {
         String var1;
         if ((var1 = this.a.a.c()).indexOf("@") == -1) {
            StringBuffer var2;
            (var2 = new StringBuffer(quyen_ia.d)).append("@yahoo.com");
            quyen_ia.d = var2.toString();
         }

         String var5 = var1;
         byte var3 = 0;
         if (var1.indexOf("@ymail") >= 0) {
            var3 = 1;
            var5 = var1.substring(0, var1.indexOf("@ymail"));
         } else if (var1.indexOf("@rocketmail") >= 0) {
            var3 = 2;
            var5 = var1.substring(0, var1.indexOf("@rocketmail"));
         } else if (var1.indexOf("@yahoo") >= 0) {
            var5 = var1.substring(0, var1.indexOf("@yahoo"));
         }

         Xuka.c(var5);
         Xuka.d(this.a.b.c());
         Xuka.a("statusYahoo", this.a.d.a);
         Xuka.b(var3);
         if (quyen_et.c.i != null) {
            quyen_et.c.i.F.c(var5);
            quyen_et.c.i.G.c(this.a.b.c());
            quyen_et.c.i.H.a = this.a.d.a;
            quyen_et.c.i.I.c(var3);
         }
      }

      Xuka.e(this.a.a.c());
      Xuka.b(this.a.b.c());
      Xuka.c(this.a.D.a());
      Xuka.a("status", this.a.d.a);
      quyen_ia.B = quyen_ia.d;
      quyen_et.e().B();
      int var4;
      if ((var4 = quyen_et.a(false)) != -1) {
         quyen_bb var6;
         if ((var6 = quyen_et.a(false, quyen_ia.d)) != null) {
            quyen_et.c.h.b.a(var6, -1);
            quyen_et.c.h.b.c = false;
            quyen_et.c.h.i();
            quyen_ia.A = quyen_et.g(quyen_ia.d);
         } else {
            var4 = -1;
         }
      }

      String var7;
      quyen_ia.E = (var7 = Xuka.c(quyen_ia.d, false)) == null ? "" : var7;
      if (var7 != null && var7.length() > 0) {
         quyen_ia.a(quyen_ia.E);
      }

      System.gc();
      quyen_n.a.a();
      quyen_a.a(quyen_ia.d, this.a.b.c(), quyen_ia.C, 1, var4, quyen_et.L, quyen_ia.E);
   }
}
