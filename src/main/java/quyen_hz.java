import javax.microedition.lcdui.Display;

final class quyen_hz implements quyen_ca {
   private quyen_hy a;
   private final quyen_bn b;
   private final quyen_bk c;

   quyen_hz(quyen_hy var1, quyen_bn var2, quyen_bk var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void a() {
      if (!quyen_bn.b().equals("/")) {
         quyen_et.c.f();
         this.c.a(quyen_bn.b() + quyen_hy.a(this.a), this.a.b);
         Display.getDisplay(Xuka.i).setCurrent(quyen_hy.a());
      }
   }
}
