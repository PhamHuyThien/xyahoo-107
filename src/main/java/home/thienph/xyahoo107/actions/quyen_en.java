package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_en implements Action {
   private LoginScreen a;

   public quyen_en(LoginScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.performLogin();
   }
}
