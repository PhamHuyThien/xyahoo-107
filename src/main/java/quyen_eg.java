final class quyen_eg implements quyen_ca {
   private final quyen_bu a;
   private final quyen_bu b;
   private final quyen_bv c;
   private final quyen_bu d;
   private final quyen_bu e;

   quyen_eg(quyen_bu var1, quyen_bu var2, quyen_bv var3, quyen_bu var4, quyen_bu var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final void a() {
      if (quyen_et.c.j != null) {
         quyen_et.c.j.b(1);
      } else {
         quyen_et.c.N.b(1);
      }

      quyen_et.c.c(quyen_ec.j());
      if (quyen_et.n != this.a.a) {
         quyen_et.n = this.a.a;
         Xuka.a("atlog", quyen_et.n);
      }

      if (quyen_et.o != this.b.a) {
         quyen_et.o = this.b.a;
         Xuka.a("atlogY", quyen_et.o);
      }

      if (quyen_cs.e != this.c.a()) {
         Xuka.d(quyen_cs.e = this.c.a());
      }

      if (quyen_et.m != this.d.a) {
         quyen_et.m = this.d.a;
         Xuka.a("vibrate", quyen_et.m);
      }

      if (quyen_et.l != !this.e.a) {
         quyen_et.l = !this.e.a;
         Xuka.a("sound", quyen_et.l);
      }
   }
}
