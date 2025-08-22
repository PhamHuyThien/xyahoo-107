final class quyen_es implements Action {
   private quyen_ec a;

   quyen_es(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().showContextMenu(this.a.E, 0);
   }
}
