final class quyen_bi implements Action {
   private DownloadScreen a;

   quyen_bi(DownloadScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.showContextMenu(this.a.contextMenu, 1);
   }
}
