final class quyen_fu implements Action {
   private GameManager a;

   quyen_fu(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.closeDialog();
   }
}
