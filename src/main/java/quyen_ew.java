final class quyen_ew implements quyen_ca {
   private quyen_gn a;
   private final quyen_ca b;

   quyen_ew(quyen_gn var1, quyen_ca var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void a() {
      quyen_gn var1 = this.a;
      this.a.a.b("Lỗi gửi SMS", this.b);
   }
}
