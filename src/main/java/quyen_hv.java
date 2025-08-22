import javax.microedition.lcdui.Display;

final class quyen_hv implements quyen_ca {
   final quyen_ht a;

   quyen_hv(quyen_ht var1) {
      this.a = var1;
   }

   public final void a() {
      quyen_et.e().f();
      quyen_bn var1;
      (var1 = quyen_bn.a()).a(1);
      quyen_eb var2 = quyen_eb.a();

      try {
         quyen_bk var3 = quyen_bk.a();
         var2.a("Tên file", "Tên file", quyen_ht.c(this.a), 0);
         var2.c = new quyen_hw(this, var2, var1, var3);
         Display.getDisplay(Xuka.i).setCurrent(quyen_eb.a);
      } catch (ClassNotFoundException var4) {
         quyen_et.e();
         quyen_et.a("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
      }
   }
}
