import java.util.Enumeration;

public abstract class quyen_bk {
   public abstract Enumeration a(boolean var1, String var2);

   public abstract int a(String var1);

   public abstract void a(String var1, byte[] var2);

   public abstract byte[] b(String var1);

   public static quyen_bk a() throws ClassNotFoundException {
      try {
         Class.forName("javax.microedition.io.file.FileConnection");
         return (quyen_bk)Class.forName("bl").newInstance();
      } catch (Exception var1) {
         throw new ClassNotFoundException("NAL");
      }
   }
}
