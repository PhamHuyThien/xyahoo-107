import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_cp {
   private static Image e;
   public static int a = 32;
   private static int f = 9;
   private static int g = 4;
   private static int h;
   private static String i = "0123456789";
   private static byte[] j = new byte[]{8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
   private static Font k;
   public static int b;
   public static int c;
   public static int d;

   static {
      (k = Font.getFont(0, 0, 8)).getHeight();
      String var0 = " 1234567890_-+=\\~`!@#$%^&*()|qwertyuiop[]{}asdfghjkl;':\"zxcvbnm,./<>?ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      k.stringWidth(var0);
      var0.length();
   }

   public static int a(String var0) {
      return k.stringWidth(var0);
   }

   public static int a() {
      return k.getHeight();
   }

   public static void b() {
      e = null;
      System.gc();
   }

   public static Image c() {
      if (e == null) {
         try {
            e = Image.createImage("/Logo.png");
            d = quyen_n.j >> 1;
            c = quyen_n.k >> 1;
         } catch (IOException var0) {
         }
      }

      return e;
   }

   private static int a(String var0, int var1, int var2, int var3) {
      int var4 = 0;
      if ((var2 = var1 + var2) > var0.length()) {
         var2 = var0.length();
      }

      char var5;
      for (int var6 = var1; var6 < var2 && (var5 = var0.charAt(var6)) != '\n'; var6++) {
         var4 += (h = i.indexOf(var5)) != -1 ? j[h] - (var3 == 0 ? 1 : 2) : g;
      }

      return var4;
   }

   public static void a(String string, int n, int n2, int n3, Graphics graphics, int n4) {
      int n5 = 1;
      Graphics graphics2 = graphics;
      boolean bl = false;
      n3 = n2;
      n2 = n;
      n = string.length();
      boolean bl2 = false;
      int n6 = n + 0;
      String string2 = string;
      if (n6 > string2.length()) {
         n6 = string2.length();
      }
      int n7 = !bl ? n2 : (bl ? n2 - quyen_cp.a(string2, 0, n, n5) : n2 - (quyen_cp.a(string2, 0, n, n5) >> 1));
      int n8 = 0;
      while (n8 < n6) {
         int n9 = string2.charAt(n8);
         if (n9 == 10) {
            n7 = !bl ? n2 : (bl ? n2 - quyen_cp.a(string2, n8 + 1, n - n8 - 1, n5) : n2 - (quyen_cp.a(string2, n8 + 1, n - n8 - 1, n5) >> 1));
            n3 += n5 == 0 ? f : f - 1;
         } else if ((n9 = i.indexOf(n9)) >= 0) {
            graphics2.drawRegion(quyen_bt.g, 0, n9 * (f - 1), 7, f - 1, 0, n7, n3, 20);
            n7 += j[n9] - (n5 == 0 ? 1 : 2);
         } else {
            n7 += g;
         }
         ++n8;
      }
   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4) {
      var0.setFont(k);
      var0.drawString(var1, var2, var3, 20);
   }
}
