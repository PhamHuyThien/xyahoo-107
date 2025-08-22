import javax.microedition.lcdui.Display;

final class quyen_hv implements Action {
   final quyen_ht a;

   quyen_hv(quyen_ht var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().closeDialog();
      quyen_bn var1;
      (var1 = quyen_bn.a()).a(1);
      quyen_eb var2 = quyen_eb.a();

      try {
         FileSystemInterface var3 = FileSystemInterface.getInstance();
         var2.a("Tên file", "Tên file", quyen_ht.c(this.a), 0);
         var2.c = new quyen_hw(this, var2, var1, var3);
         Display.getDisplay(Xuka.instance).setCurrent(quyen_eb.a);
      } catch (ClassNotFoundException var4) {
         GameManager.getInstance();
         GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
      }
   }
}
