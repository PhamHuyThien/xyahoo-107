final class quyen_hd implements Action {
   private GameLobbyScreen a;

   quyen_hd(GameLobbyScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
   }
}
