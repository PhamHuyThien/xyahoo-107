final class quyen_fv implements Action {
   final GameManager a;
   private final quyen_bn b;
   private final FileSystemInterface c;

   quyen_fv(GameManager var1, quyen_bn var2, FileSystemInterface var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      String var1 = this.b.a(true);
      if (quyen_bn.a(var1) && this.b.c(var1)) {
         GameManager.showMainScreen();
         int var2;
         if ((var2 = this.c.getFileSize(var1)) < 0) {
            this.a.d("Lỗi đọc file.");
         } else {
            this.a.a(var2, new quyen_fw(this, this.b, var1), new quyen_fx(this));
         }
      } else {
         GameManager.showAlert("Xubi", "Không hỗ trợ file này", true);
      }
   }
}
