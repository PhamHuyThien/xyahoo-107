final class quyen_ct implements Action {
   private TextInputComponent a;

   quyen_ct(TextInputComponent var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.deleteCharacterAtCursor();
   }
}
