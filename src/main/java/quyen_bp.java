final class quyen_bp implements Runnable {
   private quyen_bn a;
   private final String b;

   quyen_bp(quyen_bn var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void run() {
      if (quyen_bn.e().equals("/")) {
         quyen_bn.g(this.b);
      } else if (this.b.equals("..")) {
         int var1;
         if ((var1 = quyen_bn.e().lastIndexOf(47, quyen_bn.e().length() - 2)) != -1) {
            quyen_bn.g(quyen_bn.e().substring(0, var1 + 1));
         } else {
            quyen_bn.g("/");
         }
      } else {
         quyen_bn.g(quyen_bn.e() + this.b);
      }

      try {
         this.a.c();
      } catch (Exception var2) {
         GameManager.instance.d("ERROR: " + var2.toString());
      }
   }
}
