import java.util.Enumeration;

final class quyen_br implements Runnable {
   private quyen_bn a;

   quyen_br(quyen_bn var1) {
      this.a = var1;
   }

   public final void run() {
      try {
         Enumeration var1 = null;
         this.a.deleteAll();
         if ("/".equals(quyen_bn.e())) {
            try {
               var1 = quyen_bk.a().a(true, quyen_bn.e());
            } catch (ClassNotFoundException var4) {
            }
         } else {
            this.a.append("..", null);

            try {
               var1 = quyen_bk.a().a(false, quyen_bn.e());
            } catch (ClassNotFoundException var3) {
            }

            this.a.setTitle(quyen_bn.e());
         }

         if (var1 != null) {
            while (var1.hasMoreElements()) {
               String var2;
               if ((var2 = String.valueOf(var1.nextElement())) != null) {
                  if (var2.endsWith("/")) {
                     this.a.append(var2, null);
                  } else {
                     this.a.append(var2, null);
                  }
               }
            }

            return;
         }
      } catch (Exception var5) {
      }
   }
}
