final class quyen_gw implements Action {
   private RegistrationScreen a;

   quyen_gw(RegistrationScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.performRegistration();
   }
}
