final class quyen_aa implements Action {
   private quyen_p a;

   quyen_aa(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      String var1;
      if (!(var1 = this.a.b.getFullSelectedMessage()).equals("")) {
         GameManager.emptyString = var1;
      }
   }
}
