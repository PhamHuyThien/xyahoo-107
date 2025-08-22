import java.util.Hashtable;
import javax.microedition.lcdui.Image;

public final class quyen_ea {
   private static Hashtable a = new Hashtable();

   public static Image a(Integer n) {
      Object object = (Image)a.get(n);
      if (object != null) {
         return (Image) object;
      }
      object = quyen_ea.c(n);
      if (object != null) {
         a.put(n, object);
      } else {
         object = n;
         Packet packet2 = new Packet(119, 2);
         quyen_a.a(((Integer)object).intValue(), packet2);
         NetworkManager.sendPacket(packet2);
         object = GameManager.statusIcons[2];
         a.put(n, object);
      }
      return (Image) object;
   }


   public static void a(Integer var0, byte[] var1) {
      try {
         try {
            a.remove(var0);
         } catch (Exception var2) {
         }

         a.put(var0, Image.createImage(var1, 0, var1.length));
         Xuka.saveData(b(var0), var1, "xkimg");
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   private static String b(Integer n) {
      return UIUtils.concatStrings("img", Integer.toString(n.intValue()), null, null);
   }

   private static Image c(Integer var0) {
      Image var1 = null;
      byte[] var3 = Xuka.loadData(b(var0), "xkimg");

      try {
         var1 = Image.createImage(var3, 0, var3.length);
      } catch (Exception var2) {
      }

      return var1;
   }
}
