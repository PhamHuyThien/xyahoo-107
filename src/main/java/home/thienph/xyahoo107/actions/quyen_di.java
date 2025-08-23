package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_di implements Action {
   private GameScreen a;

   public quyen_di(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(GameScreen.getGameMenu(this.a), 0);
   }
}
