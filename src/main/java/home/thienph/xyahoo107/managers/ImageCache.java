package home.thienph.xyahoo107.managers;

import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.utils.PacketUtils;
import home.thienph.xyahoo107.utils.UIUtils;

import java.util.Hashtable;
import javax.microedition.lcdui.Image;

public final class ImageCache {
   private static Hashtable imageCache = new Hashtable();

   public static Image getImage(Integer n) {
      Object object = (Image) imageCache.get(n);
      if (object != null) {
         return (Image) object;
      }
      object = ImageCache.loadImageFromStorage(n);
      if (object != null) {
         imageCache.put(n, object);
      } else {
         object = n;
         Packet packet2 = new Packet(119, 2);
         PacketUtils.writeInt(((Integer)object).intValue(), packet2);
         NetworkManager.sendPacket(packet2);
         object = GameManager.statusIcons[2];
         imageCache.put(n, object);
      }
      return (Image) object;
   }


   public static void cacheImage(Integer var0, byte[] var1) {
      try {
         try {
            imageCache.remove(var0);
         } catch (Exception var2) {
         }

         imageCache.put(var0, Image.createImage(var1, 0, var1.length));
         Xuka.saveData(getImageFileName(var0), var1, "xkimg");
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   private static String getImageFileName(Integer n) {
      return UIUtils.concatStrings("img", Integer.toString(n.intValue()), null, null);
   }

   private static Image loadImageFromStorage(Integer var0) {
      Image var1 = null;
      byte[] var3 = Xuka.loadData(getImageFileName(var0), "xkimg");

      try {
         var1 = Image.createImage(var3, 0, var3.length);
      } catch (Exception var2) {
      }

      return var1;
   }
}
