package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_er implements Action {
   public quyen_er(LoginScreen var1) {
   }

   public final void action() {
      Xuka.shutdown();
   }
}
