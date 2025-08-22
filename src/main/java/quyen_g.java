final class quyen_g implements Action {
   final ContactListComponent a;

   quyen_g(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      GameManager.getInstance().a(UIUtils.concatStrings("Bạn có muốn xóa ", ContactListComponent.getSelectedItem(this.a).c, "?", null), null, new UIFactory("OK", new quyen_h(this)), GameManager.instance.b(quyen_cr.c()));
      System.gc();
   }
}
