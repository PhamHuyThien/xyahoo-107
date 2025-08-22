final class quyen_gc implements Action {
   private final Screen a;

   quyen_gc(Screen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.instance.removeScreen(this.a);
   }
}
