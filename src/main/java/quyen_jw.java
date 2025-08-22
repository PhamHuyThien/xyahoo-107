import java.io.InputStream;

final class quyen_jw implements Runnable {
   public final void run() {
      try {
         while (quyen_jv.a()) {
            InputStream var1 = quyen_jv.a;
            int var2;
            byte[] var3 = new byte[var2 = quyen_jv.h()];
            int var4 = 0;

            while (var4 >= 0 && var4 < var2) {
               int var5 = var1.read(var3, var4, var2 - var4);
               var4 += var5;
            }

            quyen_ju var10000;
            if (var4 == -1) {
               var10000 = null;
            } else {
               int var16 = a(var3);
               var4 = 0;

               while (var4 >= 0 && var4 < 4) {
                  int var6 = var1.read(var3, var4, var2 - var4);
                  var4 += var6;
               }

               if (var4 == -1) {
                  var10000 = null;
               } else {
                  int var18 = a(var3);
                  var4 = 0;

                  while (var4 >= 0 && var4 < 4) {
                     int var7 = var1.read(var3, var4, var2 - var4);
                     var4 += var7;
                  }

                  if (var4 == -1) {
                     var10000 = null;
                  } else {
                     int var19 = a(var3);
                     int var12;
                     byte[] var17 = new byte[var12 = var16 - 8];
                     var4 = 0;

                     while (var4 >= 0 && var4 < var12) {
                        int var8;
                        if ((var8 = var1.read(var17, var4, var12 - var4)) > 0) {
                           var4 += var8;
                        }
                     }

                     if (var4 == -1) {
                        var10000 = null;
                     } else {
                        quyen_jv.h += var2 + var12;
                        var10000 = new quyen_ju(var18, var19, var17);
                     }
                  }
               }
            }

            quyen_ju var10 = var10000;
            if (var10000 == null) {
               break;
            }

            Integer var11 = new Integer(var10.c());
            if ((quyen_jv.b = (quyen_jz)quyen_jv.g().get(var11)) != null) {
               quyen_jv.b.a(var10);
            }
         }
      } catch (Exception var9) {
         System.out.println("read ex");
         var9.printStackTrace();
      }

      quyen_jv.b();
   }

   private static int a(byte[] var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 4; var2++) {
         int var3;
         var1 = (var3 = var1 << 8) | 255 & var0[var2];
      }

      return var1;
   }
}
