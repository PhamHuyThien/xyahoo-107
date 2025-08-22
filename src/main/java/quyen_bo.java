final class quyen_bo implements Runnable {
   private quyen_bn a;

   quyen_bo(quyen_bn var1) {
      this.a = var1;
   }

   public final void run() {
      try {
         Thread.sleep(150L);

         try {
            quyen_bn.g("/");
            this.a.c();
         } catch (Exception var1) {
            quyen_et.e();
            quyen_et.a("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
         }
      } catch (Exception var2) {
      }
   }
}
