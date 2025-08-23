package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fp implements Action {
   private GameManager a;

   public quyen_fp(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      this.a.closeDialog();
      GameManager.showMainScreen();
   }
}
