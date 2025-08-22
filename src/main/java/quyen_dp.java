final class quyen_dp implements Action {
   private GameScreen a;

   quyen_dp(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameScreen.getBetInputComponent(this.a).rightSoftKey = GameScreen.getBetSendButton(this.a);
   }
}
