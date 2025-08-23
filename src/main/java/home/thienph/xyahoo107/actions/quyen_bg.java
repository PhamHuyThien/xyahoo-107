package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.DownloadScreen;

public final class quyen_bg implements Action {
   private DownloadScreen a;

   public quyen_bg(DownloadScreen var1) {
      this.a = var1;
   }

   public final void action() {
      String var1 = this.a.downloadListComponent.getSelectedItem().c;
      this.a.downloadDataManager.removeDownload(var1, 0L);
      this.a.downloadListComponent.buildListItems();
   }
}
