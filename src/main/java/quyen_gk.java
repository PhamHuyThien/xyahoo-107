final class quyen_gk implements Action {
   private GameManager a;

   quyen_gk(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.a(this.a);
   }
}
