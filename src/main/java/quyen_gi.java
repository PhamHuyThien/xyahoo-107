final class quyen_gi implements Action {
   private final DialogScreen a;

   quyen_gi(GameManager var1, DialogScreen var2) {
      this.a = var2;
   }

   public final void action() {
      GameManager.instance.removeScreen(this.a);
   }
}
