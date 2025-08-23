package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_eh implements Action {
   private LoginScreen a;

   public quyen_eh(LoginScreen var1) {
      this.a = var1;
   }

   public final void action() {
      Xuka.sendRequest(GameManager.smsContent + this.a.usernameInput.getText(), GameManager.instance.getSmsNumber(), new quyen_ei(this), null, true);
   }
}
