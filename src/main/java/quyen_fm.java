final class quyen_fm implements Action {
   private GameManager a;
   private final long b;
   private final DialogScreen c;

   quyen_fm(GameManager var1, long var2, DialogScreen var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
   }

   public final void action() {
      PacketSender.a(this.b, true);
      this.a.removeScreen(this.c);
   }
}
