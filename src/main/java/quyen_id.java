final class quyen_id implements Action {
   private FriendScreen a;

   quyen_id(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
   }
}
