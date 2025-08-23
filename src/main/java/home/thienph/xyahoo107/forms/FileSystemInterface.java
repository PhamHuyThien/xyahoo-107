package home.thienph.xyahoo107.forms;

import java.util.Enumeration;

public abstract class FileSystemInterface {
   public abstract Enumeration listFiles(boolean var1, String var2);

   public abstract int getFileSize(String var1);

   public abstract void writeFile(String var1, byte[] var2);

   public abstract byte[] readFile(String var1);

   public static FileSystemInterface getInstance() throws ClassNotFoundException {
      try {
         Class.forName("javax.microedition.io.file.FileConnection");
         return (FileSystemInterface)Class.forName("bl").newInstance();
      } catch (Exception var1) {
         throw new ClassNotFoundException("NAL");
      }
   }
}
