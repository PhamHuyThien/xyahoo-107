final class quyen_gt implements Action {
   private quyen_gs a;
   private final quyen_bn b;
   private final FileSystemInterface c;

   quyen_gt(quyen_gs var1, quyen_bn var2, FileSystemInterface var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      if (!quyen_bn.b().equals("/")) {
         GameManager.instance.closeDialog();
         FileSystemInterface var10000 = this.c;
         String var10001 = quyen_bn.b();
         quyen_gs var1 = this.a;
         quyen_gr var2 = this.a.a;
         var10001 = UIUtils.concatStrings(var10001, this.a.a.a.title, null, null);
         var1 = this.a;
         quyen_gr var4 = this.a.a;
         var10000.writeFile(var10001, this.a.a.a.imageBytes);
         GameManager.showMainScreen();
      }
   }
}
