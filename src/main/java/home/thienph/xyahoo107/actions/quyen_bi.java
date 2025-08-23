package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DownloadScreen;

public final class quyen_bi implements Action {
   private DownloadScreen a;

   public quyen_bi(DownloadScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.showContextMenu(this.a.contextMenu, 1);
   }
}
