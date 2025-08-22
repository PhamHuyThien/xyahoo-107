final class quyen_y implements Action {
   private quyen_p a;

   quyen_y(quyen_p var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.c.rightSoftKey = quyen_p.a(this.a);
   }
}
