final class quyen_w implements Action {
   private ChatRoomScreen a;

   quyen_w(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(ChatRoomScreen.getContextMenu(this.a), 0);
   }
}
