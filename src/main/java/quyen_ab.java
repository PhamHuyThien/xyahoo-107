final class quyen_ab implements Action {
   private quyen_p a;

   quyen_ab(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      if (!GameManager.emptyString.equals("")) {
         this.a.c.insertText(GameManager.emptyString);
      }
   }
}
