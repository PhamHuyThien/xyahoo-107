import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;

final class quyen_bm implements Runnable {
   private final String a;
   private final byte[] b;

   quyen_bm(quyen_bl var1, String var2, byte[] var3) {
      this.a = var2;
      this.b = var3;
   }

   public final void run() {
      try {
         FileConnection var1;
         if ((var1 = (FileConnection)Connector.open(this.a, 3)).exists()) {
            var1.delete();
         }

         var1.create();

         try {
            OutputStream var5;
            (var5 = var1.openOutputStream()).write(this.b);
            if (var5 != null) {
               var5.close();
            }
         } catch (Exception var3) {
         }

         var1.close();
      } catch (Exception var4) {
         Alert var2 = new Alert("saveFile", var4.getMessage(), null, AlertType.ERROR);
         Display.getDisplay(Xuka.i).setCurrent(var2);
         var4.printStackTrace();
      }
   }
}
