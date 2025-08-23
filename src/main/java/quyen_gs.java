final class quyen_gs implements Action {
   final quyen_gr a;
   private final TextInputForm b;
   private final FileBrowserList c;
   private final FileSystemInterface d;

   quyen_gs(quyen_gr var1, TextInputForm var2, FileBrowserList var3, FileSystemInterface var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      GameGraphics.clearKeyStates();
      quyen_gr var1 = this.a;
      this.a.a.setTitle(this.b.textField.getString().trim());
      this.c.selectedAction = new quyen_gt(this, this.c, this.d);
      this.c.showBrowser("Chọn thư mục", 2);
   }
}
