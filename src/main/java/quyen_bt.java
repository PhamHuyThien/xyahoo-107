import javax.microedition.lcdui.Graphics;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import java.util.Hashtable;

public final class quyen_bt
{
   public static boolean a;
   private static Hashtable k;
   public static Integer b;
   public static Integer c;
   public static Integer d;
   public static int e;
   public static String[] f;
   private static int l;
   public static Image g;
   public static int h;
   public static int i;
   public static int j;
   private Image m;
   private static byte[] n;
   private static String o;
   private static String p;
   private static quyen_bt q;
   private static int r;
   private static Vector s;

   static {
      quyen_bt.a = true;
      quyen_bt.b = new Integer(16726823);
      new Integer(0);
      quyen_bt.c = new Integer(16777215);
      quyen_bt.d = new Integer(3981823);
      quyen_bt.l = (quyen_bt.f = new String[] { ":-BD", ":D", ">:)", "X-(", ":((", ":))", "B-)", ":\">", ";;)", ":-SS", ":-*", ":-W", ":-?", ";))", "~X(", ":-H", ":)", ":-/", ":@)", "3:-O", ":(|)", "~:>", "@};-", "~O)", ":|", ":-O", ":(", ";)", ":X", ":>", ":P", "=P~", "=((", "B-(", ":-\"", ":-&", ":-S", "O:-)", "#-O", "I-)", "8-X", "(*)" }).length;
      quyen_bt.n = new byte[] { 3, 7, 5, 7, 7, 7, 7, 7, 7, 7, 7, 3, 3, 3, 3, 7, 4, 4, 7, 4, 5, 4, 7, 6, 9, 9, 8, 7, 4, 4, 3, 3, 7, 9, 12, 7, 7, 7, 7, 7, 7, 7, 6, 7, 7, 3, 4, 7, 3, 11, 7, 7, 7, 7, 5, 7, 5, 7, 8, 10, 7, 8, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 4, 4, 4, 5, 3, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9, 7, 7, 7, 7, 7, 9, 9, 9, 9, 9, 9, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7, 6, 8, 8, 3, 7, 8, 7, 10, 8, 9, 8, 9, 8, 8, 7, 8, 10, 14, 8, 9, 7 };
      quyen_bt.o = " 0123456789.':!?()+-*/#$%\u0110_=[];,^&@><abcdefghijklmnopqrstuvwxyz\u00e1\u00e0\u1ea3\u00e3\u1ea1\u0103\u1eaf\u1eb1\u1eb3\u1eb5\u1eb7\u00e2\u1ea5\u1ea7\u1ea9\u1eab\u1ead\u00e9\u00e8\u1ebb\u1ebd\u1eb9\u00ea\u1ebf\u1ec1\u1ec3\u1ec5\u1ec7\u00ed\u00ec\u1ec9\u0129\u1ecb\u00f3\u00f2\u1ecf\u00f5\u1ecd\u00f4\u1ed1\u1ed3\u1ed5\u1ed7\u1ed9\u01a1\u1edb\u1edd\u1edf\u1ee1\u1ee3\u00fa\u00f9\u1ee7\u0169\u1ee5\u01b0\u1ee9\u1eeb\u1eed\u1eef\u1ef1\u00fd\u1ef3\u1ef7\u1ef9\u1ef5\u0111ABCDEFGHIJKLMNOPQRSTUVWXYZ\u00c1\u00c0\u1ea2\u00c3\u1ea0\u0102\u1eae\u1eb0\u1eb2\u1eb4\u1eb6\u00c2\u1ea4\u1ea6\u1ea8\u1eaa\u1eac\u00c9\u00c8\u1eba\u1ebc\u1eb8\u00ca\u1ebe\u1ec0\u1ec2\u1ec4\u1ec6\u00cd\u00cc\u1ec8\u0128\u1eca\u00d3\u00d2\u1ece\u00d5\u1ecc\u00d4\u1ed0\u1ed2\u1ed4\u1ed6\u1ed8\u01a0\u1eda\u1edc\u1ede\u1ee0\u1ee2\u00da\u00d9\u1ee6\u0168\u1ee4\u01af\u1ee8\u1eea\u1eec\u1eee\u1ef0\u00dd\u1ef2\u1ef6\u1ef8\u1ef4|\"/";
      quyen_bt.p = " 0123456789.':!?()+-*/#$%\u0110_=[];,^&@><abcdefghijklmnopqrstuvwxyz\u00e1\u00e0\u1ea3\u00e3\u1ea1\u0103\u1eaf\u1eb1\u1eb3\u1eb5\u1eb7\u00e2\u1ea5\u1ea7\u1ea9\u1eab\u1ead\u00e9\u00e8\u1ebb\u1ebd\u1eb9\u00ea\u1ebf\u1ec1\u1ec3\u1ec5\u1ec7\u00ed\u00ec\u1ec9\u0129\u1ecb\u00f3\u00f2\u1ecf\u00f5\u1ecd\u00f4\u1ed1\u1ed3\u1ed5\u1ed7\u1ed9\u01a1\u1edb\u1edd\u1edf\u1ee1\u1ee3\u00fa\u00f9\u1ee7\u0169\u1ee5\u01b0\u1ee9\u1eeb\u1eed\u1eef\u1ef1\u00fd\u1ef3\u1ef7\u1ef9\u1ef5\u0111ABCDEFGHIJKLMNOPQRSTUVWXYZAAAAAAAAAAAAAAAAAEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY '";
   }

   public static String a(final String s, final int endIndex) {
      if (s.length() > endIndex) {
         return quyen_hr.a(s.substring(0, endIndex), "..", null, null);
      }
      return s;
   }

   public static int a(final String s) {
      for (int i = 0; i < quyen_bt.l; ++i) {
         if (s.toUpperCase().indexOf(quyen_bt.f[i]) != -1) {
            return i;
         }
      }
      return 100;
   }

   public static String a(String string, final boolean b) {
      quyen_bt.j = 0;
      int n = 10;
      for (int i = 0; i < quyen_bt.l; ++i) {
         int index;
         while ((index = string.toUpperCase().indexOf(quyen_bt.f[i])) != -1) {
            ++quyen_bt.j;
            string = String.valueOf(string.substring(0, index)) + (char)(i + 30000) + string.substring(index + quyen_bt.f[i].length());
            if (--n > 0) {
               continue;
            }
            break;
         }
         if (n <= 0) {
            break;
         }
      }
      if (n == 10 && !b) {
         return null;
      }
      return string;
   }

   public static void a() {
      try {
         quyen_bt.g = Image.createImage("/Numbers.png");
      }
      catch (final Exception ex) {}
      if (quyen_bt.a) {
         quyen_bt.e = 14;
         quyen_bt.k = new Hashtable();
         a(quyen_bt.d);
         a(quyen_bt.c);
      }
      else {
         quyen_bt.e = quyen_cp.a();
      }
      quyen_bt.h = quyen_bt.e + 2;
      quyen_bt.i = quyen_bt.e + 6;
   }

   private quyen_bt(final String s, final int n) {
      if (!quyen_bt.a) {
         return;
      }
      try {
         if (this.m == null) {
            this.m = Image.createImage(s);
         }
         if (n != 16777215) {
            this.m = a(this.m, n);
         }
      }
      catch (final Exception ex) {}
   }

   public static quyen_bt a(Integer var0) {
      if (!a) {
         return q != null ? q : (q = new quyen_bt(null, 0));
      } else {
         quyen_bt var1;
         if ((var1 = (quyen_bt)k.get(var0)) != null) {
            return var1;
         } else {
            if (k.size() < 10) {
               k.put(var0, new quyen_bt("/Font.png", var0.intValue()));
            }

            return (quyen_bt)k.get(c);
         }
      }
   }

   public static int b(String s) {
      if (quyen_bt.a) {
         final String s2 = s;
         final int length = s.length();
         s = s2;
         int n = 0;
         char char1;
         for (int n2 = length + 0, index = 0; index < n2 && (char1 = s.charAt(index)) != '\n'; ++index) {
            n += b(char1);
         }
         return n;
      }
      return quyen_cp.a(s);
   }

   public final void a(final String s, final int n, int n2, final Graphics graphics) {
      if (!quyen_bt.a) {
         quyen_cp.a(graphics, s, n, n2, 0);
         return;
      }
      int n3 = n;
      n2 = n2;
      for (int length = s.length(), i = 0; i < length; ++i) {
         final char char1;
         if ((char1 = s.charAt(i)) == '\n') {
            n3 = n;
            n2 += quyen_bt.e;
         }
         else {
            final int a;
            if ((a = a(char1)) >= 0) {
               graphics.drawRegion(this.m, 0, a * quyen_bt.e, 15, quyen_bt.e, 0, n3, n2, 0);
               n3 += quyen_bt.n[a];
            }
         }
      }
   }

   private static int a(final char c) {
      final int index;
      if ((index = quyen_bt.p.indexOf(c)) != -1) {
         return index;
      }
      final int index2;
      if ((index2 = quyen_bt.p.indexOf(((quyen_bt.r = quyen_bt.o.indexOf(c)) != -1) ? quyen_bt.p.charAt(quyen_bt.r) : ' ')) != -1) {
         return index2;
      }
      return 0;
   }

   private static int b(final char c) {
      return quyen_bt.n[a(c)];
   }

   public static String b(final String s, final int n) {
      if (s == null) {
         return null;
      }
      if (s.length() == 0) {
         return "...";
      }
      final Vector vector = new Vector();
      int i = 0;
      int n2 = 0;
      int n3 = 0;
      int n4 = -1;
      while (i < s.length()) {
         final char char1;
         if ((char1 = s.charAt(i)) == ' ') {
            n4 = i;
         }
         if ((n3 += b(char1)) > n || char1 == '\n') {
            if (char1 != '\n' && n4 != -1) {
               i = n4;
            }
            vector.addElement(s.substring(n2, i));
            if (s.charAt(i) == ' ' || char1 == '\n') {
               ++i;
            }
            n2 = i;
            n3 = 0;
            n4 = -1;
         }
         else {
            ++i;
         }
      }
      if (i > n2) {
         vector.addElement(s.substring(n2, i));
      }
      final String[] array = new String[vector.size()];
      for (int j = 0; j < array.length; ++j) {
         array[j] = (String)vector.elementAt(j);
      }
      return array[0];
   }

   private static Image a(final Image image, int n) {
      final int[] array = new int[image.getWidth() * image.getHeight()];
      n = n;
      final Image rgbImage = Image.createRGBImage(new int[] { n }, 1, 1, false);
      final int[] array2 = { 0 };
      rgbImage.getRGB(array2, 0, 1, 0, 0, 1, 1);
      n = array2[0];
      image.getRGB(array, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
      for (int i = 0; i < array.length; ++i) {
         if (array[i] == -1) {
            array[i] = n;
         }
      }
      return Image.createRGBImage(array, image.getWidth(), image.getHeight(), true);
   }

   public static String[] c(final String s, final int n) {
      if (quyen_bt.s == null) {
         quyen_bt.s = new Vector();
      }
      else {
         quyen_bt.s.removeAllElements();
      }
      String[] a;
      for (int length = (a = a(s, (char)10)).length, i = 0; i < length; ++i) {
         final String s2;
         if ((s2 = a[i]).length() > 0) {
            String[] d;
            for (int length2 = (d = d(s2, n)).length, j = 0; j < length2; ++j) {
               quyen_bt.s.addElement(d[j]);
            }
         }
         else {
            quyen_bt.s.addElement("");
         }
      }
      final String[] anArray = new String[quyen_bt.s.size()];
      quyen_bt.s.copyInto(anArray);
      System.gc();
      return anArray;
   }

   private static String[] d(final String s, final int n) {
      final Vector vector = new Vector();
      String string = "";
      int beginIndex;
      int i;
      for (beginIndex = 0, i = s.indexOf(32); i >= 0; i = s.indexOf(32, beginIndex)) {
         final String substring = s.substring(beginIndex, i + 1);
         if (b(String.valueOf(string) + substring) >= n) {
            vector.addElement(string);
            string = "";
         }
         string = String.valueOf(string) + substring;
         beginIndex = i + 1;
      }
      if (i == -1) {
         final String substring2 = s.substring(beginIndex);
         if (b(String.valueOf(string) + substring2) >= n) {
            vector.addElement(string);
            string = "";
         }
         vector.addElement(String.valueOf(string) + substring2);
      }
      final String[] anArray = new String[vector.size()];
      vector.copyInto(anArray);
      return anArray;
   }

   public static String[] a(final String s, final char c) {
      int n = 0;
      int i = s.indexOf(c);
      final Vector vector = new Vector();
      while (i > 0) {
         if (s.charAt(i - 1) == '\r') {
            vector.addElement(s.substring(n, i - 1));
         }
         else {
            vector.addElement(s.substring(n, i));
         }
         n = i + 1;
         i = s.indexOf(c, n);
      }
      if (n < s.length()) {
         vector.addElement(s.substring(n));
      }
      final String[] anArray = new String[vector.size()];
      vector.copyInto(anArray);
      return anArray;
   }
}
