final class quyen_fk implements quyen_ca {
   private quyen_et a;
   private final quyen_cs b;
   private final String c;
   private final quyen_co d;

   quyen_fk(quyen_et var1, quyen_cs var2, String var3, quyen_co var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void a() {
      if (!this.b.c().equals("")) {
         quyen_ba var1 = new quyen_ba(this.c, "", 0, "", new int[0], 0, 0, null);
         quyen_a.a(this.c, this.b.c(), (byte)1);
         if (this.a.i.a.a().a(this.c, null, 0L) == null) {
            this.a.i.a.a().a(this.b.c(), var1);
            this.a.i.a.b();
            this.a.i.a.c();
         }

         this.a.c(this.d);
      }
   }
}
