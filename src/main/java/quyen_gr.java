import javax.microedition.lcdui.Display;

final class quyen_gr implements Action {
   final PhotoViewerScreen a;

   quyen_gr(PhotoViewerScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.closeDialog();
      FileBrowserList var1;
      (var1 = FileBrowserList.getInstance()).setReturnScreen(2);
      TextInputForm var2 = TextInputForm.getInstance();

      try {
         FileSystemInterface var3 = FileSystemInterface.getInstance();
         var2.setupForm("Tên file", "Tên file", this.a.title, 0);
         var2.completionAction = new quyen_gs(this, var2, var1, var3);
         Display.getDisplay(Xuka.instance).setCurrent(TextInputForm.instance);
      } catch (ClassNotFoundException var4) {
         GameManager.getInstance();
         GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
      }
   }
}
