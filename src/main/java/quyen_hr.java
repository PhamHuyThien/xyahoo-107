import javax.microedition.rms.RecordStore;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;

public final class quyen_hr
{
   public static final String[] a;
   public static int b;
   public static int c;
   public static int d;
   public static int e;
   public static int f;
   public static int g;
   public static int h;
   public static int i;

   static {
      a = new String[] { "/", "\\", "<", ">", "?", ":", "\"", "*", "|" };
   }

   public static final String a(String string) {
      String s2;
      final String s = s2 = Long.toString(System.currentTimeMillis());
      if (s.length() > 10) {
         s2 = s.substring(s.length() - 10);
      }
      final StringBuffer sb = new StringBuffer(b(s2));
      if (string != null) {
         sb.append(string);
      }
      string = sb.toString();
      System.gc();
      return string;
   }

   private static String b(String string) {
      for (int i = 0; i < quyen_hr.a.length; ++i) {
         int index;
         while ((index = string.indexOf(quyen_hr.a[i])) != -1) {
            string = String.valueOf(string.substring(0, index)) + "_" + string.substring(index + 1);
         }
      }
      return string;
   }

   public static boolean a(final quyen_cj quyen_cj, final quyen_bx quyen_bx) {
      for (int i = 0; i < quyen_cj.x; ++i) {
         if (quyen_bx.equals(quyen_cj.l.elementAt(i)) && quyen_bx.h) {
            quyen_cj.a(i);
            quyen_cj.c(quyen_cj.c());
            return true;
         }
      }
      return false;
   }

   public static boolean b(final quyen_cj quyen_cj, final quyen_bx obj) {
      try {
         if (quyen_cj.l.elementAt(quyen_cj.c()).equals(obj)) {
            return true;
         }
      }
      catch (final Exception ex) {}
      return false;
   }

   public static void a(final quyen_cj quyen_cj, final quyen_cs quyen_cs) {
      quyen_cs.h = true;
      quyen_cs.k = quyen_cj.i - quyen_et.e - (quyen_bt.e << 1);
      a(quyen_cj, (quyen_bx)quyen_cs);
   }

   public static void b(quyen_cj quyen_cj, final quyen_cs quyen_cs) {
      quyen_cs.h = false;
      quyen_cs.k = quyen_n.k + 1000;
      quyen_cj = quyen_cj;
      for (int i = 0; i < quyen_cj.x; ++i) {
         final quyen_bx quyen_bx;
         if ((quyen_bx = (quyen_bx) quyen_cj.l.elementAt(i)).h) {
            a(quyen_cj, quyen_bx);
            break;
         }
      }
      quyen_cs.c("");
   }

   public static boolean a(final quyen_bx quyen_bx) {
      return quyen_bx instanceof quyen_cs && ((quyen_cs)quyen_bx).y;
   }

   public static String a(final long i) {
      int n = 0;
      final StringBuffer sb;
      int length = (sb = new StringBuffer(Long.toString(i))).length();
      while (--length >= 0) {
         if (++n == 3) {
            n = 0;
            if (length == 0) {
               continue;
            }
            sb.insert(length, ".");
         }
      }
      final String string = sb.toString();
      System.gc();
      return string;
   }

   public static void a(final quyen_cj quyen_cj, final int n) {
      quyen_cj.k = quyen_bt.b(quyen_cj.j, n);
      quyen_et.c.b();
   }

   public static void a(final quyen_cj quyen_cj, final String j) {
      b(quyen_cj, quyen_cj.j = j);
   }

   public static void b(final quyen_cj quyen_cj, final String s) {
      quyen_cj.k = quyen_bt.b(s, quyen_n.j - 30);
      quyen_et.c.b();
   }

   public static void a(final Graphics graphics, final int n, final int n2, final int n3) {
      graphics.setColor(396304);
      graphics.fillRect(n - 3, n2 - 3, 24, 24);
      graphics.setColor(14545919);
      quyen_bs.a(graphics, n - 4, n2 - 4, 25, 25);
      graphics.drawRegion(quyen_et.p, n3 * 18, 0, 18, 18, 0, n, n2, 20);
      graphics.setColor(0);
   }

   public static void a(final Graphics graphics, final int n, final int n2, int i, int length, final String[] array, final int n3) {
      graphics.setColor(396304);
      graphics.fillRect(n - 3, n2 - 1, i + 1, length + 1);
      graphics.setColor(14545919);
      quyen_bs.a(graphics, n - 4, n2 - 2, i + 2, length + 2);
      if (n3 == 0) {
         i = n + (i >> 1);
         graphics.setColor(396304);
         graphics.fillTriangle(i - 3, n2 + length - 2, i, n2 + length + 5, i + 3, n2 + length - 2);
         graphics.setColor(14545919);
         graphics.drawLine(i - 3, n2 + length, i, n2 + length + 5);
         graphics.drawLine(i, n2 + length + 5, i + 3, n2 + length);
      }
      else if (n3 == 1) {
         i = n + i - ((i / 6 < 7) ? 7 : (i / 6));
         graphics.setColor(396304);
         graphics.fillTriangle(i - 3, n2 + length - 2, i + 4, n2 + length + 5, i + 4, n2 + length - 2);
         graphics.setColor(14545919);
         graphics.drawLine(i - 2, n2 + length, i + 3, n2 + length + 5);
         graphics.drawLine(i + 3, n2 + length + 5, i + 3, n2 + length);
      }
      else if (n3 == 2) {
         i = n + (i >> 1);
         graphics.setColor(396304);
         graphics.fillTriangle(i - 3, n2 - 1, i, n2 - 7, i + 3, n2 - 1);
         graphics.setColor(14545919);
         graphics.drawLine(i - 3, n2 - 2, i, n2 - 7);
         graphics.drawLine(i, n2 - 7, i + 3, n2 - 2);
      }
      else {
         i = n + i / 6;
         graphics.setColor(396304);
         graphics.fillTriangle(i - 3, n2 + length - 2, i - 3, n2 + length + 5, i + 4, n2 + length - 2);
         graphics.setColor(14545919);
         graphics.drawLine(i - 3, n2 + length, i - 3, n2 + length + 5);
         graphics.drawLine(i - 3, n2 + length + 5, i + 2, n2 + length);
      }
      String s;
      int n4;
      int length2;
      int beginIndex;
      int j;
      char char1;
      String substring;
      for (i = 0, length = array.length; i < length; ++i) {
         s = array[i];
         n4 = n;
         length2 = s.length();
         beginIndex = 0;
         for (j = 0; j < length2; ++j) {
            if ((char1 = s.charAt(j)) >= '\u7530') {
               substring = s.substring(beginIndex + 1, j);
               quyen_bt.a(quyen_bt.c).a(substring, n4, n2 + i * quyen_bt.h, graphics);
               n4 += quyen_bt.b(substring);
               graphics.drawRegion(quyen_et.p, (char1 - '\u7530') * 18, 0, 18, 18, 0, n4 + 10, n2 + i * quyen_bt.h + (quyen_bt.h >> 1), 3);
               n4 += 20;
               beginIndex = j;
            }
         }
         quyen_bt.a(quyen_bt.c).a(s.substring(beginIndex, length2), n4, n2 + i * quyen_bt.h, graphics);
      }
   }

   public static int a(final int n) {
      if (n == 0 || n == 0) {
         return 16777215;
      }
      return n;
   }

   public static void b(final quyen_bx quyen_bx) {
      if (quyen_bx.o != null) {
         quyen_bx.o.p = true;
      }
   }

   public static void a(final String s, final String s2) {
      quyen_hr.c = quyen_cj.h - quyen_bt.b(s2) - 4;
      quyen_hr.b = quyen_cj.h - quyen_bt.b(s) >> 1;
   }

   public static Image a(final byte[] array) {
      try {
         final Image image = Image.createImage(array, 0, array.length);
         System.gc();
         return image;
      }
      catch (final Exception ex) {
         return null;
      }
   }

   public static final String a(String string, final String str, final String str2, final String str3) {
      final StringBuffer sb;
      (sb = new StringBuffer(string)).append(str);
      if (str2 != null) {
         sb.append(str2);
      }
      if (str3 != null) {
         sb.append(str3);
      }
      string = sb.toString();
      System.gc();
      return string;
   }

   public static final void a(final boolean b) {
      final String[] listRecordStores;
      if ((listRecordStores = RecordStore.listRecordStores()) != null) {
         try {
            int length = listRecordStores.length;
            while (--length >= 0) {
               if (!b || !listRecordStores[length].startsWith("xkown")) {
                  RecordStore.deleteRecordStore(listRecordStores[length]);
               }
            }
         }
         catch (final Exception ex) {}
      }
   }

   public static boolean c(final quyen_bx quyen_bx) {
      final quyen_ce quyen_ce;
      return quyen_bx instanceof quyen_ce && ((quyen_ce = (quyen_ce)quyen_bx).a.length() == 0 || quyen_ce.a.equals(" "));
   }

   public static void a(final int f, final int g) {
      if (quyen_hr.g != 0) {
         return;
      }
      if ((quyen_hr.g = quyen_cj.h * 6 / 10 - 8) > g) {
         quyen_hr.g = g;
      }
      if ((quyen_hr.f = quyen_cj.h - quyen_hr.g - 13 - 8) > f) {
         quyen_hr.f = f;
      }
      quyen_hr.e = (quyen_hr.d = (((quyen_hr.d = (quyen_cj.h - (quyen_hr.g + quyen_hr.f + 13) >> 1) - 2) < 6) ? 6 : quyen_hr.d)) + quyen_hr.f + 13;
      if (quyen_n.j < 135) {
         quyen_hr.d -= 7;
      }
   }
}
