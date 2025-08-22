final class quyen_u implements Action {
   final quyen_p a;

   quyen_u(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().a("Bạn có muốn xóa phòng chat?", null, new UIFactory("OK", new quyen_v(this)), GameManager.instance.b(quyen_cr.c()));
      System.gc();
   }
}
