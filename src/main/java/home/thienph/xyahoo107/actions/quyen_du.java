package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_du implements Action {
   public quyen_du(GameScreen var1) {
   }

   public final void action() {
      GameManager.instance.removeScreen(GameScreen.instance);
      System.gc();
   }
}
