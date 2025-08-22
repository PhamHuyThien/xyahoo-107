import javax.microedition.lcdui.Display;

final class quyen_gr implements Action {
   final PhotoViewerScreen a;

   quyen_gr(PhotoViewerScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.closeDialog();
      quyen_bn var1;
      (var1 = quyen_bn.a()).a(2);
      quyen_eb var2 = quyen_eb.a();

      try {
         FileSystemInterface var3 = FileSystemInterface.getInstance();
         var2.a("Tên file", "Tên file", this.a.title, 0);
         var2.c = new quyen_gs(this, var2, var1, var3);
         Display.getDisplay(Xuka.instance).setCurrent(quyen_eb.a);
      } catch (ClassNotFoundException var4) {
         GameManager.getInstance();
         GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
      }
   }
}
