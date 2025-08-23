package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.Screen;

public final class quyen_ga implements Action {
   private final Action a;
   private final Screen b;

   public quyen_ga(Action var1, Screen var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      if (this.a != null) {
         this.a.action();
      }

      GameManager.instance.destroyScreen(this.b);
   }
}
