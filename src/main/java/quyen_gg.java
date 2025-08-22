final class quyen_gg implements Action {
   private GameManager a;
   private final String b;
   private final String c;
   private final long d;

   quyen_gg(GameManager var1, String var2, String var3, long var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      quyen_p var1;
      PacketSender.d((var1 = (quyen_p)this.a.setActiveScreen(this.a.currentChatRoom)).a);
      this.a.removeScreen(var1);
      this.a.b(this.b, this.c, this.d);
   }
}
