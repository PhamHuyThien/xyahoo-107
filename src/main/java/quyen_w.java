final class quyen_w implements Action {
   private quyen_p a;

   quyen_w(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(quyen_p.b(this.a), 0);
   }
}
