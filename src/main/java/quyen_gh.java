final class quyen_gh implements Action {
   private final String a;
   private final String b;
   private final DialogScreen c;

   quyen_gh(GameManager var1, String var2, String var3, DialogScreen var4) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public final void action() {
      quyen_a.b(this.a, this.b);
      GameManager.instance.removeScreen(this.c);
   }
}
