final class quyen_el implements Action {
   final quyen_ec a;

   quyen_el(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      if (this.a.c == null) {
         this.a.c = UIFactory.createPopupDialog(this.a, "Gửi góp ý", 0, new quyen_em(this));
      }

      UIUtils.showTextInput(this.a, this.a.c);
   }
}
