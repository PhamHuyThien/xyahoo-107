final class quyen_fb implements Action {
   private GameManager a;

   quyen_fb(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.friendManager.showStatusDialog();
   }
}
