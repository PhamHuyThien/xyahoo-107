final class quyen_ay implements Action {
   private final ContextMenu a;

   quyen_ay(ContextMenu var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a, 0);
   }
}
