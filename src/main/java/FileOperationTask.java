final class FileOperationTask implements Runnable {
   private GameManager gameManager;
   private final boolean isReceivingFile;

   FileOperationTask(GameManager var1, boolean var2) {
      this.gameManager = var1;
      this.isReceivingFile = var2;
   }

   public final void run() {
      try {
         FileBrowserList var1 = FileBrowserList.getInstance();
         FileSystemInterface var2 = FileSystemInterface.getInstance();
         GameManager.a(this.gameManager, var1.getSelectedFilePath(false));
         byte[] var4;
         if ((var4 = var2.readFile(var1.getSelectedFilePath(true))) == null || var4.length == 0) {
            this.gameManager.d("Lỗi đọc file.");
         } else if (this.isReceivingFile) {
            if (GameManager.f(this.gameManager) == 0) {
               this.gameManager.a(var4, var1.getSelectedFilePath(false), false, this.gameManager.fileManager);
            } else if (GameManager.f(this.gameManager) == 1) {
               GameManager.a(var4, var1.getSelectedFilePath(false), false, 2);
            }
         } else {
            if (!GameManager.g(this.gameManager)) {
               this.gameManager.a(GameManager.h(this.gameManager), var4, var1.getFileType(GameManager.h(this.gameManager)));
            }

            this.gameManager.startFileSend();
         }
      } catch (ClassNotFoundException var3) {
         this.gameManager.d("Điện thoại không hỗ trợ chức năng này");
      }
   }
}
