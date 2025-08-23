final class quyen_hx implements Action {
   private quyen_hw a;
   private final FileBrowserList b;
   private final FileSystemInterface c;
   private final String d;

   quyen_hx(quyen_hw var1, FileBrowserList var2, FileSystemInterface var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      if (!FileBrowserList.getCurrentPathUrl().equals("/")) {
         FileSystemInterface var10000 = this.c;
         String var10001 = UIUtils.concatStrings(FileBrowserList.getCurrentPathUrl(), this.d, null, null);
         quyen_hw var1 = this.a;
         quyen_hv var2 = this.a.a;
         var10000.writeFile(var10001, MediaPlayerForm.getMediaData(this.a.a.a));
         GameManager.instance.closeDialog();
         GameManager.showMainScreen();
      }
   }
}
