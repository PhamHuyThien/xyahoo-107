package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;

import java.util.Enumeration;

public final class FileListRefresher implements Runnable {
   private FileBrowserList fileBrowserList;

   public FileListRefresher(FileBrowserList var1) {
      this.fileBrowserList = var1;
   }

   public final void run() {
      try {
         Enumeration var1 = null;
         this.fileBrowserList.deleteAll();
         if ("/".equals(FileBrowserList.getCurrentPath())) {
            try {
               var1 = FileSystemInterface.getInstance().listFiles(true, FileBrowserList.getCurrentPath());
            } catch (ClassNotFoundException var4) {
            }
         } else {
            this.fileBrowserList.append("..", null);

            try {
               var1 = FileSystemInterface.getInstance().listFiles(false, FileBrowserList.getCurrentPath());
            } catch (ClassNotFoundException var3) {
            }

            this.fileBrowserList.setTitle(FileBrowserList.getCurrentPath());
         }

         if (var1 != null) {
            while (var1.hasMoreElements()) {
               String var2;
               if ((var2 = String.valueOf(var1.nextElement())) != null) {
                  if (var2.endsWith("/")) {
                     this.fileBrowserList.append(var2, null);
                  } else {
                     this.fileBrowserList.append(var2, null);
                  }
               }
            }

            return;
         }
      } catch (Exception var5) {
      }
   }
}
