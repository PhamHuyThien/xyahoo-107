final class quyen_cd implements Action {
   private ImageComponent a;

   quyen_cd(ImageComponent var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.handlePointerPress(0, 0);
   }
}
