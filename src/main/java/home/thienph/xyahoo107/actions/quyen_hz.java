package home.thienph.xyahoo107.actions;



import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;
import home.thienph.xyahoo107.forms.SaveFileForm;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

import javax.microedition.lcdui.Display;

public final class quyen_hz implements Action {
   private SaveFileForm a;
   private final FileBrowserList b;
   private final FileSystemInterface c;

   public quyen_hz(SaveFileForm var1, FileBrowserList var2, FileSystemInterface var3) {
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
