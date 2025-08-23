import javax.microedition.lcdui.Display;

final class quyen_hz implements Action {
   private SaveFileForm a;
   private final FileBrowserList b;
   private final FileSystemInterface c;

   quyen_hz(SaveFileForm var1, FileBrowserList var2, FileSystemInterface var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      if (!FileBrowserList.getCurrentPathUrl().equals("/")) {
         GameManager.instance.closeDialog();
         this.c.writeFile(FileBrowserList.getCurrentPathUrl() + SaveFileForm.getFullFileName(this.a), this.a.fileData);
         Display.getDisplay(Xuka.instance).setCurrent(SaveFileForm.getInstance());
      }
   }
}
