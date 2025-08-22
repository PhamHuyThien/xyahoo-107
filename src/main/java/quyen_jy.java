import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class quyen_jy implements Runnable {
   private final String a;
   private final String b;
   private final int c;
   private final int d;

   quyen_jy(String var1, String var2, int var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void run() {
      quyen_jv.d = true;
      quyen_jv.c = true;

      try {
         a(this.a, this.c);
      } catch (Exception var4) {
         try {
            a(this.b, this.d);
         } catch (Exception var3) {
            quyen_jv.c = false;

            try {
               if (quyen_jv.b != null) {
                  quyen_jv.c();
                  quyen_jv.b.b();
                  return;
               }
            } catch (Exception var2) {
               var3.printStackTrace();
            }
         }
      }
   }

   private static void a(String var0, int var1) throws IOException {
      System.out.print("Connecting");
      System.out.println(var0);
      System.out.println(var1);

      try {
         quyen_jv.a((SocketConnection)Connector.open("socket://" + var0 + ":" + var1));
      } catch (Exception var3) {
         System.out.println("soc ex1");
         var3.printStackTrace();
         throw new IOException();
      }

      try {
         quyen_jv.d().setSocketOption((byte)2, 1);
      } catch (Exception var2) {
         System.out.println("soc ex2");
         var2.printStackTrace();
      }

      quyen_jv.a(quyen_jv.d().openDataOutputStream());
      quyen_jv.a = quyen_jv.d().openInputStream();
      (quyen_jv.f = new Thread(quyen_jv.e())).start();
      (quyen_jv.e = new Thread(new quyen_jw())).start();
      quyen_jv.d = false;
      quyen_jv.b.d();
      System.out.println("Connected!");
   }
}
