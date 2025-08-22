final class quyen_cl implements Action {
   private final Screen a;
   private final TextInputComponent b;

   quyen_cl(Screen var1, TextInputComponent var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      UIUtils.hideTextInput(this.a, this.b);
   }
}
