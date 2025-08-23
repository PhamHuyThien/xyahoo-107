final class quyen_en implements Action {
   private LoginScreen a;

   quyen_en(LoginScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.performLogin();
   }
}
