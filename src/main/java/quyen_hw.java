final class quyen_hw implements Action {
   final quyen_hv a;
   private final TextInputForm b;
   private final FileBrowserList c;
   private final FileSystemInterface d;

   quyen_hw(quyen_hv var1, TextInputForm var2, FileBrowserList var3, FileSystemInterface var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      String var1 = this.b.textField.getString().trim();
      this.c.selectedAction = new quyen_hx(this, this.c, this.d, var1);
      this.c.showBrowser("Chọn thư mục", 2);
   }
}
