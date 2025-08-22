final class quyen_ev implements Action {
   private quyen_gn a;

   quyen_ev(quyen_gn var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_gn var1 = this.a;
      this.a.a.d("Vui lòng chờ tin nhắn xác nhận sau vài phút.");
   }
}
