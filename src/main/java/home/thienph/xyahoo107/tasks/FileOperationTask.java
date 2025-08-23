package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;
import home.thienph.xyahoo107.managers.GameManager;

public final class FileOperationTask implements Runnable {
   private GameManager gameManager;
   private final boolean isReceivingFile;

   public FileOperationTask(GameManager var1, boolean var2) {
      this.gameManager = var1;
      this.isReceivingFile = var2;
   }

   public final void run() {
      try {
         FileBrowserList var1 = FileBrowserList.getInstance();
         FileSystemInterface var2 = FileSystemInterface.getInstance();
         GameManager.setUploadFileName(this.gameManager, var1.getSelectedFilePath(false));
         byte[] var4;
         if ((var4 = var2.readFile(var1.getSelectedFilePath(true))) == null || var4.length == 0) {
            this.gameManager.showWrappedTextDialog("Lỗi đọc file.");
         } else if (this.isReceivingFile) {
            if (GameManager.getUploadType(this.gameManager) == 0) {
               this.gameManager.showPhotoViewer(var4, var1.getSelectedFilePath(false), false, this.gameManager.fileManager);
            } else if (GameManager.getUploadType(this.gameManager) == 1) {
               GameManager.playMediaFile(var4, var1.getSelectedFilePath(false), false, 2);
            }
         } else {
            if (!GameManager.isSendingFile(this.gameManager)) {
               this.gameManager.setUploadData(GameManager.getUploadFileName(this.gameManager), var4, var1.getFileType(GameManager.getUploadFileName(this.gameManager)));
            }

            this.gameManager.startFileSend();
         }
      } catch (ClassNotFoundException var3) {
         this.gameManager.showWrappedTextDialog("Điện thoại không hỗ trợ chức năng này");
      }
   }
}
