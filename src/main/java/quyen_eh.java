final class quyen_eh implements Action {
   private LoginScreen a;

   quyen_eh(LoginScreen var1) {
      this.a = var1;
   }

   public final void action() {
      Xuka.sendRequest(GameManager.smsContent + this.a.usernameInput.getText(), GameManager.instance.getSmsNumber(), new quyen_ei(this), null, true);
   }
}
