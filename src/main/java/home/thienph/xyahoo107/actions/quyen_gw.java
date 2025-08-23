package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.RegistrationScreen;

public final class quyen_gw implements Action {
   private RegistrationScreen a;

   public quyen_gw(RegistrationScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.performRegistration();
   }
}
