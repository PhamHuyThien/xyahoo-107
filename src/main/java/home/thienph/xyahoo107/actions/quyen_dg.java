package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dg implements Action {
   final GameScreen a;

   public quyen_dg(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.showConfirmDialog("Bạn có muốn rời bàn?", new quyen_dh(this));
   }
}
