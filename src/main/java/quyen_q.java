final class quyen_q implements Action {
   final ChatRoomScreen a;

   quyen_q(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().a("Bạn có muốn thoát phòng chat?", null, new UIFactory("OK", new quyen_x(this)), GameManager.instance.b(TextConstant.close()));
      System.gc();
   }
}
