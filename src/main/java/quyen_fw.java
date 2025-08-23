final class quyen_fw implements Action {
   private quyen_fv a;
   private final FileBrowserList b;
   private final String c;

   quyen_fw(quyen_fv var1, FileBrowserList var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      quyen_fv var1 = this.a;
      GameManager.a(this.a.a, (byte)-1);
      if (this.b.isPngFile(this.c)) {
         var1 = this.a;
         GameManager.a(this.a.a, (byte)0);
      } else if (this.b.isSupportedVideoFile(this.c)) {
         var1 = this.a;
         GameManager.a(this.a.a, (byte)1);
      }

      var1 = this.a;
      if (GameManager.f(this.a.a) != -1) {
         var1 = this.a;
         this.a.a.e(true);
      } else {
         var1 = this.a;
         this.a.a.d("Điện thoại không hổ trợ xem file này");
      }
   }
}
