final class quyen_fz implements Action {
   private GameManager a;

   quyen_fz(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.cancelFileSend();
   }
}
