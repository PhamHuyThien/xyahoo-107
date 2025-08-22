final class quyen_fy implements Runnable {
   private GameManager a;
   private final boolean b;

   quyen_fy(GameManager var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void run() {
      try {
         quyen_bn var1 = quyen_bn.a();
         FileSystemInterface var2 = FileSystemInterface.getInstance();
         GameManager.a(this.a, var1.a(false));
         byte[] var4;
         if ((var4 = var2.readFile(var1.a(true))) == null || var4.length == 0) {
            this.a.d("Lỗi đọc file.");
         } else if (this.b) {
            if (GameManager.f(this.a) == 0) {
               this.a.a(var4, var1.a(false), false, this.a.fileManager);
            } else if (GameManager.f(this.a) == 1) {
               GameManager.a(var4, var1.a(false), false, 2);
            }
         } else {
            if (!GameManager.g(this.a)) {
               this.a.a(GameManager.h(this.a), var4, var1.b(GameManager.h(this.a)));
            }

            this.a.startFileSend();
         }
      } catch (ClassNotFoundException var3) {
         this.a.d("Điện thoại không hỗ trợ chức năng này");
      }
   }
}
