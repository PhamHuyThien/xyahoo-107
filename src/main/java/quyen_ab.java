final class quyen_ab implements Action {
   private ChatRoomScreen a;

   quyen_ab(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!GameManager.emptyString.equals("")) {
         this.a.textInputComponent.insertText(GameManager.emptyString);
      }
   }
}
