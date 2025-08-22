final class quyen_dm implements Action {
   private GameScreen a;

   quyen_dm(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.chatInputComponent.rightSoftKey = GameScreen.getChatSendButton(this.a);
   }
}
