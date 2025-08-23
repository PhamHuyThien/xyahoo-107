package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class quyen_gi implements Action {
   private final DialogScreen a;

   public quyen_gi(GameManager var1, DialogScreen var2) {
      this.a = var2;
   }

   public final void action() {
      GameManager.instance.removeScreen(this.a);
   }
}
