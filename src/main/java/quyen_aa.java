final class quyen_aa implements Action {
   private ChatRoomScreen a;

   quyen_aa(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      String var1;
      if (!(var1 = this.a.chatComponent.getFullSelectedMessage()).equals("")) {
         GameManager.emptyString = var1;
      }
   }
}
