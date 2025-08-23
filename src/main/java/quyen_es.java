final class quyen_es implements Action {
   private LoginScreen a;

   quyen_es(LoginScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
   }
}
