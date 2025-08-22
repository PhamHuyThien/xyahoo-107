final class quyen_cm implements Action {
   private final TextInputComponent a;
   private final UIFactory b;

   quyen_cm(TextInputComponent var1, UIFactory var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      this.a.rightSoftKey = this.b;
   }
}
