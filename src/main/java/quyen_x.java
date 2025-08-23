final class quyen_x implements Action {
   private quyen_q a;

   quyen_x(quyen_q var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_q var1 = this.a;
      GameManager.instance.destroyScreen(this.a.a);
      var1 = this.a;
      PacketSender.d(this.a.a.roomId);
      GameManager.instance.currentChatRoom = null;
   }
}
