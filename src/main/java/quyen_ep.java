final class quyen_ep implements Action {
   private quyen_ec a;

   quyen_ep(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.a.getText().equals("")) {
         GameManager.getInstance().d(UIUtils.concatStrings("Vui lòng nhập ID. ", "Bạn sẽ nhận mật khẩu qua tin nhắn.", null, null));
      } else {
         GameGraphics.instance.initializeConnection();
         quyen_a.e();
         NetworkManager.sendPacket(new Packet(269, 2));
         GameManager.instance.c(true);
      }
   }
}
