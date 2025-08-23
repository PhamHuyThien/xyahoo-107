package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dm implements Action {
   private GameScreen a;

   public quyen_dm(GameScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.chatInputComponent.rightSoftKey = GameScreen.getChatSendButton(this.a);
   }
}
