final class quyen_ep implements Action {
   private LoginScreen a;

   quyen_ep(LoginScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.usernameInput.getText().equals("")) {
         GameManager.getInstance().d(UIUtils.concatStrings("Vui lòng nhập ID. ", "Bạn sẽ nhận mật khẩu qua tin nhắn.", null, null));
      } else {
         GameGraphics.instance.initializeConnection();
         PacketSender.e();
         NetworkManager.sendPacket(new Packet(269, 2));
         GameManager.instance.c(true);
      }
   }
}
