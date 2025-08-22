import javax.microedition.lcdui.Graphics;

public final class quyen_cq {
   private static int b = 15;
   public static boolean a = false;
   private static final int c = quyen_cj.i - quyen_et.e;
   private static int d;
   private static int e;
   private static int f = quyen_cj.h - 4 - 1;
   private static int g = quyen_et.e + 2;
   private static boolean h = false;
   private static int i = 0;

   public static void a(int var0) {
      b = (d = 100 * c / var0) > 600 ? d / 100 : 5;
      e = g + c - b;
   }

   public static void a(boolean var0) {
      if (a) {
         h = var0;
         i = 0;
      }
   }

   public static void a(Graphics var0, int var1) {
      if (h && d > 1 && a) {
         if ((var1 = g + var1 * d / 100) > e) {
            var1 = e;
         }

         var0.setColor(5218244);
         var0.fillRect(f, var1 + 1, 3, b - 2);
         var0.fillRect(f + 1, var1, 1, b);
         if (++i > 10) {
            a(false);
         }
      }
   }
}
