final class FileBrowserInitializer implements Runnable {
   private FileBrowserList fileBrowserList;

   FileBrowserInitializer(FileBrowserList var1) {
      this.fileBrowserList = var1;
   }

   public final void run() {
      try {
         Thread.sleep(150L);

         try {
            FileBrowserList.setCurrentPath("/");
            this.fileBrowserList.refreshFileList();
         } catch (Exception var1) {
            GameManager.getInstance();
            GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
         }
      } catch (Exception var2) {
      }
   }
}
