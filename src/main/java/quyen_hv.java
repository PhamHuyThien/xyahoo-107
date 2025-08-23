import javax.microedition.lcdui.Display;

final class quyen_hv implements Action {
   final MediaPlayerForm a;

   quyen_hv(MediaPlayerForm var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().closeDialog();
      FileBrowserList var1;
      (var1 = FileBrowserList.getInstance()).setReturnScreen(1);
      TextInputForm var2 = TextInputForm.getInstance();

      try {
         FileSystemInterface var3 = FileSystemInterface.getInstance();
         var2.setupForm("Tên file", "Tên file", MediaPlayerForm.getFileName(this.a), 0);
         var2.completionAction = new quyen_hw(this, var2, var1, var3);
         Display.getDisplay(Xuka.instance).setCurrent(TextInputForm.instance);
      } catch (ClassNotFoundException var4) {
         GameManager.getInstance();
         GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
      }
   }
}
