final class quyen_fc implements Action {
   final GameManager a;

   quyen_fc(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.a("Bạn có muốn thoát?", new quyen_fd(this));
   }
}
