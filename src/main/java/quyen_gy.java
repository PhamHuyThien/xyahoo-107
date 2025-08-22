final class quyen_gy implements Action {
   private quyen_gu a;

   quyen_gy(quyen_gu var1) {
      this.a = var1;
   }

   public final void action() {
      GameGraphics.instance.initializeConnection();
      quyen_gu.a(this.a, this.a.a.getText());
      this.a.c = this.a.b.getText();
      quyen_a.e();
      quyen_a.h(this.a.d, this.a.b.getText());
   }
}
