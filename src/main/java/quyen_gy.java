final class quyen_gy implements Action {
   private RegistrationScreen a;

   quyen_gy(RegistrationScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameGraphics.instance.initializeConnection();
      RegistrationScreen.setSuggestedUsername(this.a, this.a.usernameInput.getText());
      this.a.c = this.a.passwordInput.getText();
      PacketSender.e();
      PacketSender.h(this.a.finalUsername, this.a.passwordInput.getText());
   }
}
