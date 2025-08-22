final class quyen_ew implements Action {
   private quyen_gn a;
   private final Action b;

   quyen_ew(quyen_gn var1, Action var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      quyen_gn var1 = this.a;
      this.a.a.b("Lỗi gửi SMS", this.b);
   }
}
