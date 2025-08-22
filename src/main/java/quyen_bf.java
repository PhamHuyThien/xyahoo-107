final class quyen_bf implements Action {
   private DownloadScreen a;

   quyen_bf(DownloadScreen var1) {
      this.a = var1;
   }

   public final void action() {
      DownloadData var1;
      if ((var1 = this.a.downloadListComponent.getSelectedItem().i).downloadType == 0) {
         GameManager.instance.a(var1.imageBytes, var1.fileName, true, new PhotoViewerScreen());
      } else {
         GameManager.a(var1.imageBytes, var1.fileName, true, 2);
      }
   }
}
