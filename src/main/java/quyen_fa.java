final class quyen_fa implements Action {
   private quyen_ez a;

   quyen_fa(quyen_ez var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_ez var1 = this.a;
      if (GameManager.b(this.a.a).getText() != null) {
         var1 = this.a;
         if (GameManager.b(this.a.a).getText().length() > 0) {
            var1 = this.a;
            quyen_a.f(GameManager.b(this.a.a).getText());
         }
      }
   }
}
