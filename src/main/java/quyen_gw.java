final class quyen_gw implements Action {
   private quyen_gu a;

   quyen_gw(quyen_gu var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.i();
   }
}
