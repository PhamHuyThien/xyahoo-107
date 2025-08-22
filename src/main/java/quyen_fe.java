final class quyen_fe implements Action {
   private GameManager a;

   quyen_fe(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.c(this.a);
   }
}
