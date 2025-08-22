final class quyen_cg implements Action {
   private TextLinkComponent a;

   quyen_cg(TextLinkComponent var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.linkAction.action();
   }
}
