final class quyen_gv implements Action {
   private RegistrationScreen a;

   quyen_gv(RegistrationScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.returnToLoginScreen();
   }
}
