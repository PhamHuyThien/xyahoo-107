final class quyen_y implements Action {
   private ChatRoomScreen a;

   quyen_y(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.textInputComponent.rightSoftKey = ChatRoomScreen.getBackSoftkey(this.a);
   }
}
