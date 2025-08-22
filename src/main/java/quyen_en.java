final class quyen_en implements Action {
   private quyen_ec a;

   quyen_en(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.i();
   }
}
