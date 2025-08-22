final class quyen_jr implements Action {
   private final DropdownComponent a;
   private final TextInputComponent b;

   quyen_jr(YahooScreen var1, DropdownComponent var2, TextInputComponent var3) {
      this.a = var2;
      this.b = var3;
   }

   public final void action() {
      if (this.a.optionList != null && this.a.optionList.length != 0) {
         this.b.setText(this.a.getSelectedText());
      }
   }
}
