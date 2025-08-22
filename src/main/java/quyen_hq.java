final class quyen_hq implements Action {
   private ChatScreen a;

   quyen_hq(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!GameManager.emptyString.equals("")) {
         this.a.textInputComponent.insertText(GameManager.emptyString);
      }
   }
}
