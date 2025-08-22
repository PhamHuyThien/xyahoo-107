final class quyen_ik implements Action {
   private final ContextMenu a;

   quyen_ik(FriendScreen var1, ContextMenu var2) {
      this.a = var2;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a, 1);
   }
}
