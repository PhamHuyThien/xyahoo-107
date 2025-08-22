final class quyen_dk implements Action {
   private GameScreen a;

   quyen_dk(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.removeComponent(this.a.chatInputComponent);
      this.a.isChatMode = false;
      UIUtils.focusComponent(this.a, GameScreen.getFocusedComponent(this.a));
      GameScreen.adjustScroll(this.a);
      this.a.chatInputComponent.setText("");
   }
}
