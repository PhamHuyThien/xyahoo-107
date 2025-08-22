import javax.microedition.lcdui.Display;

final class quyen_hz implements Action {
   private quyen_hy a;
   private final quyen_bn b;
   private final FileSystemInterface c;

   quyen_hz(quyen_hy var1, quyen_bn var2, FileSystemInterface var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      if (!quyen_bn.b().equals("/")) {
         GameManager.instance.closeDialog();
         this.c.writeFile(quyen_bn.b() + quyen_hy.a(this.a), this.a.b);
         Display.getDisplay(Xuka.instance).setCurrent(quyen_hy.a());
      }
   }
}
