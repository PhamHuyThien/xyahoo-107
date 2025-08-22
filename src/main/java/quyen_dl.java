final class quyen_dl implements Action {
   private GameScreen a;

   quyen_dl(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameScreen.showChatInput(this.a);
   }
}
