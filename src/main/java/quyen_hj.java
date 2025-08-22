final class quyen_hj implements Action {
   private ChatScreen a;

   quyen_hj(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.textInputComponent.rightSoftKey = ChatScreen.getSendButton(this.a);
   }
}
