final class quyen_ez implements Action {
   final GameManager a;

   quyen_ez(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      if (GameManager.b(this.a) == null || !GameManager.b(this.a).isHelpTextEquals("Gửi góp ý")) {
         GameManager.a(this.a, UIFactory.createPopupDialog(this.a.mainMenu, "Gửi góp ý", 0, new quyen_fa(this)));
      }

      UIUtils.showTextInput(this.a.mainMenu, GameManager.b(this.a));
   }
}
