final class quyen_eh implements Action {
   private quyen_ec a;

   quyen_eh(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      Xuka.sendRequest(GameManager.smsContent + this.a.a.getText(), GameManager.instance.getSmsNumber(), new quyen_ei(this), null, true);
   }
}
