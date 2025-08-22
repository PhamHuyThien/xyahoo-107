import java.util.Vector;

final class quyen_ii implements quyen_ca {
   private quyen_ia a;
   private final quyen_ch b;

   quyen_ii(quyen_ia var1, quyen_ch var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void a() {
      String var1 = this.b.c().c;
      long var2 = this.b.c().m;
      Vector var4 = (Vector)this.a.N.get(var1);
      this.a.N.remove(var1);
      quyen_et.c.a(var1, var4, var2);
      this.b.b.b(var1, 0L);
      this.b.b();
      this.a.k();
   }
}
