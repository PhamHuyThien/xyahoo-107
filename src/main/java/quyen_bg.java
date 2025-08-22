final class quyen_bg implements Action {
   private DownloadScreen a;

   quyen_bg(DownloadScreen var1) {
      this.a = var1;
   }

   public final void action() {
      String var1 = this.a.downloadListComponent.getSelectedItem().c;
      this.a.downloadDataManager.removeDownload(var1, 0L);
      this.a.downloadListComponent.buildListItems();
   }
}
