final class quyen_it implements Action {
   private FriendScreen a;

   quyen_it(FriendScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
   }
}
