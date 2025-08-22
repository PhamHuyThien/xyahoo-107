import java.io.InputStream;
import java.util.Enumeration;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;

class FileSystemImpl extends FileSystemInterface {
   public final Enumeration listFiles(boolean var1, String var2) {
      Enumeration var3 = null;

      try {
         if (var1) {
            var3 = FileSystemRegistry.listRoots();
         } else {
            FileConnection var5;
            var3 = (var5 = (FileConnection)Connector.open("file://localhost/" + var2)).list();
            var5.close();
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var3;
   }

   public final int getFileSize(String var1) {
      int var2 = 0;

      try {
         FileConnection var4;
         var2 = (int)(var4 = (FileConnection)Connector.open(var1, 1)).fileSize();
         var4.close();
      } catch (Exception var3) {
         var2 = -1;
      }

      return var2;
   }

   public final void writeFile(String var1, byte[] var2) {
      new Thread(new FileWriteTask(this, var1, var2)).start();
   }

   public final byte[] readFile(String var1) {
      byte[] var2 = null;

      try {
         FileConnection var7;
         InputStream var9 = (var7 = (FileConnection)Connector.open(var1, 1)).openInputStream();
         var2 = new byte[(int)var7.fileSize()];
         var9.read(var2);
         var9.close();
         var7.close();
      } catch (OutOfMemoryError var5) {
         Alert var8 = new Alert("readFile OutOfMemoryError: ", var5.getMessage(), null, AlertType.ERROR);
         Display.getDisplay(Xuka.instance).setCurrent(var8);
         var5.printStackTrace();
      } catch (Exception var6) {
         Alert var3 = new Alert("readFile Exception: ", var6.getMessage(), null, AlertType.ERROR);
         Display.getDisplay(Xuka.instance).setCurrent(var3);
         var6.printStackTrace();
      }

      return var2;
   }
}
