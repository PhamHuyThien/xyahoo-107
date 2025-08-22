final class quyen_jn implements quyen_ca {
   private quyen_jm a;

   quyen_jn(quyen_jm var1) {
      this.a = var1;
   }

   public final void a() {
      StringBuffer var10000 = new StringBuffer("Y! ");
      quyen_jm var1 = this.a;
      String var3 = var10000.append(quyen_jc.d(this.a.a).c().trim()).toString();
      quyen_hg var2;
      if ((var2 = (quyen_hg)quyen_et.c.e(var3)) != null) {
         var2.b(1);
         quyen_et.c.f(var3);
      } else {
         var1 = this.a;
         var2 = new quyen_hg(var3, true, null, quyen_jc.d(this.a.a).c().trim());
      }

      var2.b(1);
      quyen_et.c.a(var2);
      quyen_et.c.f(var2.j);
      System.gc();
   }
}
