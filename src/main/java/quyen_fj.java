final class quyen_fj implements Action {
   private GameManager a;
   private final String b;
   private final TextInputComponent c;
   private final DialogScreen d;

   quyen_fj(GameManager var1, String var2, TextInputComponent var3, DialogScreen var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      quyen_a.a(this.b, this.c.getText(), (byte)0);
      this.a.removeScreen(this.d);
   }
}
