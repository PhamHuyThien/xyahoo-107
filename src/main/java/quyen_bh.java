final class quyen_bh implements Action {
   private DownloadScreen a;

   quyen_bh(DownloadScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.deleteAllDownloads();
   }
}
