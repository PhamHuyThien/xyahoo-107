package home.thienph.xyahoo107.actions;



final class quyen_fx implements Action {
   private quyen_fv a;

   quyen_fx(quyen_fv var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_fv var1 = this.a;
      this.a.a.startFileOperation(false);
   }
}
