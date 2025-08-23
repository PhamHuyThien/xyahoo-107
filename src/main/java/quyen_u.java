final class quyen_u implements Action {
   final ChatRoomScreen a;

   quyen_u(ChatRoomScreen var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().a("Bạn có muốn xóa phòng chat?", null, new UIFactory("OK", new quyen_v(this)), GameManager.instance.b(TextConstant.close()));
      System.gc();
   }
}
