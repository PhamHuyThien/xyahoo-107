import java.util.Vector;

final class quyen_jx implements Runnable {
   public final Vector a = new Vector();

   public quyen_jx() {
   }

   public final void a(quyen_ju var1) {
      this.a.addElement(var1);
   }

   private static byte[] a(int var0) {
      byte[] var1 = new byte[4];

      for (int var2 = 3; var2 >= 0; var2--) {
         var1[var2] = (byte)var0;
         var0 >>= 8;
      }

      return var1;
   }

   public final void run() {
      while (quyen_jv.a()) {
         try {
            while (this.a.size() > 0) {
               long var1 = System.currentTimeMillis();
               quyen_ju var3 = (quyen_ju)this.a.elementAt(0);
               this.a.removeElementAt(0);
               quyen_jt var4 = var3.b();
               int var5;
               byte[] var6 = a(var5 = 8 + var4.c());
               quyen_jv.f().write(var6, 0, 4);
               quyen_jv.f().write(a(var3.a()), 0, 4);
               quyen_jv.f().write(a(var3.c()), 0, 4);
               quyen_jv.f().write(var4.b(), 0, var5 - 8);
               quyen_jv.g += var5 + 4;
               quyen_jv.f().flush();
               long var7;
               if ((var7 = 100L - (System.currentTimeMillis() - var1)) > 0L) {
                  Thread.sleep(var7);
               }
            }

            Thread.sleep(50L);
         } catch (Exception var9) {
            System.out.println("write ex");
            var9.printStackTrace();
         }
      }

      quyen_jv.b();
   }
}
