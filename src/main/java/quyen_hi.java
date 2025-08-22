final class quyen_hi implements Action {
   private ChatScreen a;

   quyen_hi(ChatScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(ChatScreen.getContextMenu(this.a), 0);
   }
}
