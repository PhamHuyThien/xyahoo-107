package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hj implements Action {
   private ChatScreen a;

   public quyen_hj(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.textInputComponent.rightSoftKey = ChatScreen.getSendButton(this.a);
   }
}
