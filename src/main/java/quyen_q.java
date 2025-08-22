final class quyen_q implements Action {
   final quyen_p a;

   quyen_q(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().a("Bạn có muốn thoát phòng chat?", null, new UIFactory("OK", new quyen_x(this)), GameManager.instance.b(quyen_cr.c()));
      System.gc();
   }
}
