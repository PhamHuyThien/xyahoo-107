final class quyen_fl implements Action {
   private GameManager a;
   private final long b;
   private final DialogScreen c;

   quyen_fl(GameManager var1, long var2, DialogScreen var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
   }

   public final void action() {
      PacketSender.a(this.b, false);
      this.a.removeScreen(this.c);
   }
}
