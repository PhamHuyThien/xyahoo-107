final class quyen_iq implements Action {
   private quyen_ip a;
   private final long[] b;
   private final DialogScreen c;

   quyen_iq(quyen_ip var1, long[] var2, DialogScreen var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      quyen_ip var1 = this.a;
      PacketSender.a(this.b, FriendScreen.getActiveTextInput(this.a.a).getText());
      var1 = this.a;
      FriendScreen.setActiveTextInput(this.a.a, (TextInputComponent) null);
      GameManager.instance.removeScreen(this.c);
      System.gc();
   }
}
