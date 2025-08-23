package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_ed implements Action {
   public quyen_ed(LoginScreen var1) {
   }

   public final void action() {
      GameManager.instance.showRegisterScreen();
   }
}
