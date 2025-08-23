package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_do implements Action {
   private GameScreen a;

   public quyen_do(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.removeComponent(GameScreen.getBetInputComponent(this.a));
      this.a.isBettingMode = false;
      UIUtils.focusComponent(this.a, GameScreen.getFocusedComponent(this.a));
      GameScreen.adjustScroll(this.a);
      GameScreen.getBetInputComponent(this.a).setText("");
   }
}
