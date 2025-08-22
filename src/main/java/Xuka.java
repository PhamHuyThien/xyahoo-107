import javax.microedition.rms.RecordStore;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDlet;

public class Xuka extends MIDlet
{
   private static String k;
   public static int a;
   public static String[] b;
   public static int[] c;
   public static int d;
   public static int e;
   public static String f;
   public static String g;
   private static String l;
   private static String m;
   private static String n;
   public static quyen_n h;
   public static Xuka i;
   public static String j;

   static {
      Xuka.j = null;
   }

   public Xuka() {
      final String appProperty = this.getAppProperty("IP-Address");
      final String appProperty2 = this.getAppProperty("Port");
      String s = this.getAppProperty("App-ID");
      String s2 = this.getAppProperty("Parner-ID");
      Xuka.k = this.getAppProperty("MIDlet-Version");
      Xuka.f = this.getAppProperty("RefCode");
      Xuka.g = this.getAppProperty("Build-ID");
      System.out.println(Xuka.k);
      System.out.println(Xuka.g);
      System.out.println(appProperty);
      System.out.println(appProperty2);
      System.out.println(s2);
      System.out.println(s);
      System.out.println(Xuka.f);
      Xuka.b = new String[] { (appProperty == null || appProperty.length() == 0) ? "112.78.10.113" : appProperty };
      int int1 = 13715;
      try {
         if (appProperty2 != null && appProperty2.length() > 0) {
            int1 = Integer.parseInt(appProperty2);
         }
      }
      catch (final Exception ex) {}
      Xuka.c = new int[] { int1 };
      Xuka.k = ((Xuka.k == null || Xuka.k.length() == 0) ? "1.0.0" : Xuka.k);
      quyen_et.b = "Th\u1eed nghi\u1ec7m " + Xuka.k;
      Xuka.f = ((Xuka.f == null || Xuka.f.equalsIgnoreCase("200487")) ? "" : (" " + Xuka.f));
      Xuka.g = ((Xuka.g == null || Xuka.g.length() == 0) ? "2012-MD" : Xuka.g);
      if (s2 == null || s2.length() == 0) {
         s2 = Integer.toString(1);
      }
      if (s == null || s.length() == 0) {
         s = Integer.toString(0);
      }
      try {
         Xuka.d = Integer.parseInt(s2);
      }
      catch (final Exception ex2) {
         Xuka.d = 1;
      }
      try {
         Xuka.e = Integer.parseInt(s);
      }
      catch (final Exception ex3) {
         Xuka.e = 0;
      }
      Xuka.a = i(Xuka.k);
      Xuka.l = "nIP" + Xuka.k;
      Xuka.m = "_IP" + Xuka.k;
      Xuka.n = "_Port" + Xuka.k;
      System.gc();
      Xuka.j = System.getProperty("microedition.platform");
      Xuka.h = new quyen_n();
      Xuka.i = this;
   }

   private static int i(String string) {
      int x = (string = String.valueOf(string) + ".").length();
      int n = 0;
      int n2 = 0;
      final StringBuffer sb = new StringBuffer(0);
      final StringBuffer sb2 = new StringBuffer(0);
      for (int i = 0; i < x; ++i) {
         sb2.append(string.charAt(i));
         ++n;
         if (string.charAt(i) == '.') {
            sb2.deleteCharAt(sb2.length() - 1);
            if (++n2 == 1) {
               sb.append((Object)sb2);
            }
            else {
               if (n == 2) {
                  sb2.append("0");
               }
               sb.append((Object)sb2);
            }
            sb2.delete(0, sb2.length());
            n = 0;
         }
      }
      try {
         x = Integer.parseInt(sb.toString());
      }
      catch (final Exception ex) {}
      System.out.println(x);
      System.gc();
      return x;
   }

   public static String a(int length) {
      final StringBuffer sb;
      if ((length = (sb = new StringBuffer(Integer.toString(length))).length()) == 5) {
         sb.insert(0, "0");
         ++length;
      }
      int n = 0;
      int n2 = 0;
      final StringBuffer sb2 = new StringBuffer(0);
      final StringBuffer obj = new StringBuffer(0);
      try {
         for (int i = 0; i < length; ++i) {
            ++n;
            obj.append(sb.charAt(i));
            if (n == 2) {
               n = 0;
               if (++n2 == 1) {
                  if (obj.charAt(0) == '0') {
                     obj.deleteCharAt(0);
                  }
               }
               else {
                  if (obj.charAt(1) == '0') {
                     obj.deleteCharAt(1);
                  }
                  obj.insert(0, '.');
               }
               sb2.append((Object)obj);
               obj.delete(0, obj.length());
            }
         }
      }
      catch (final Exception ex) {}
      System.gc();
      return sb2.toString();
   }

   public final void a(final String s) {
      System.out.println(s);
      try {
         this.platformRequest("tel:" + s);
      }
      catch (final ConnectionNotFoundException ex) {}
   }

   protected void startApp() {
      Display.getDisplay((MIDlet)this).setCurrent((Displayable)quyen_n.a);
   }

   protected void pauseApp() {
   }

   protected void destroyApp(final boolean b) {
      quyen_n.b = false;
   }

   public static void a() {
      quyen_n.b = false;
   }

   public static void a(String string, String x, final quyen_ca quyen_ca, final quyen_ca quyen_ca2, final boolean b) {
      string = String.valueOf(string) + Xuka.f;
      x = x;
      System.out.println(string);
      System.out.println(x);
      new Thread(new quyen_jb(x, string, quyen_ca, b, quyen_ca2)).start();
   }

   public static byte[] a(final String str, final String str2) {
      final StringBuffer sb;
      (sb = new StringBuffer(str2)).append(str);
      byte[] record;
      try {
         final RecordStore openRecordStore;
         record = (openRecordStore = RecordStore.openRecordStore(sb.toString(), (boolean)(0 != 0))).getRecord(1);
         openRecordStore.closeRecordStore();
      }
      catch (final Exception ex) {
         System.gc();
         return null;
      }
      System.gc();
      return record;
   }

   public static void a(final String str, final byte[] array, final String str2) {
      final StringBuffer sb;
      (sb = new StringBuffer(str2)).append(str);
      try {
         final RecordStore openRecordStore;
         if ((openRecordStore = RecordStore.openRecordStore(sb.toString(), true)).getNumRecords() > 0) {
            openRecordStore.setRecord(1, array, 0, array.length);
         }
         else {
            openRecordStore.addRecord(array, 0, array.length);
         }
         openRecordStore.closeRecordStore();
      }
      catch (final Exception ex) {}
      System.gc();
   }

   public static void b(final String s) {
      a("xkPW", quyen_kb.a(s).getBytes(), "xkown");
   }

   public static void c(final String s) {
      a("YahooID", s.getBytes(), "xkown");
   }

   public static void d(final String s) {
      a("YahooPW", quyen_kb.a(s).getBytes(), "xkown");
   }

   public static void a(final String s, final boolean b) {
      a(s, new byte[] { (byte)(b ? 1 : 0) }, "xkown");
   }

   public static boolean b(String s, final boolean b) {
      final byte[] a;
      int n2;
      final int n = ((a = a(s = s, "xkown")) == null) ? (n2 = -1) : ((a[0] == 1) ? (n2 = 1) : (n2 = 0));
      final int n3 = n2;
      if (n == -1) {
         return b;
      }
      return n3 != 0;
   }

   public static void e(final String s) {
      a("xkID", s.getBytes(), "xkown");
   }

   public static String b() {
      final byte[] a;
      if ((a = a("xkID", "xkown")) == null) {
         return null;
      }
      return new String(a);
   }

   public static void a(final String str, final String s, final boolean b) {
      a(String.valueOf(b ? "yststr" : "ststr") + str, s.getBytes(), "xkown");
   }

   public static String c(final String str, final boolean b) {
      final byte[] a;
      if ((a = a(String.valueOf(b ? "yststr" : "ststr") + str, "xkown")) == null) {
         return null;
      }
      return new String(a);
   }

   public static String c() {
      final byte[] a;
      if ((a = a("xkPW", "xkown")) == null) {
         return null;
      }
      return quyen_kb.b(new String(a));
   }

   public static String d() {
      final byte[] a;
      if ((a = a("YahooID", "xkown")) == null) {
         return "";
      }
      return new String(a);
   }

   public static String e() {
      final byte[] a;
      if ((a = a("YahooPW", "xkown")) == null) {
         return "";
      }
      return quyen_kb.b(new String(a));
   }

   public static void b(final int n) {
      a("domainYahoo", new byte[] { (byte)n }, "xkown");
   }

   public static int f() {
      final byte[] a;
      if ((a = a("domainYahoo", "xkown")) == null) {
         return 0;
      }
      return a[0];
   }

   public static void c(final int n) {
      a("idType", new byte[] { (byte)n }, "xkown");
   }

   public static int g() {
      final byte[] a;
      if ((a = a("idType", "xkown")) == null) {
         return 0;
      }
      return a[0];
   }

   public static void d(final int n) {
      a("caret", new byte[] { (byte)n }, "xkown");
   }

   public static int h() {
      final byte[] a;
      if ((a = a("caret", "xkown")) == null) {
         return 2;
      }
      return a[0];
   }

   public static int f(final String str) {
      final byte[] a;
      if ((a = a("xpam" + str, "xkown")) == null) {
         return 0;
      }
      return a[0];
   }

   public static void g(final String str) {
      a("xpam" + str, new byte[] { 1 }, "xkown");
   }

   public static int b(final String s, final String s2) {
      final byte[] a;
      if ((a = a(s, s2)) == null || a.length != 4) {
         return -1;
      }
      return quyen_et.a(a[0], a[1], a[2], a[3]);
   }

   public static long h(final String s) {
      final byte[] a;
      if ((a = a(s, "xkown")) == null || a.length != 8) {
         return -1L;
      }
      return quyen_et.a(a);
   }

   public static String[] i() {
      final int k;
      if ((k = k()) < 0) {
         return new String[0];
      }
      final String[] array = new String[k];
      for (int i = 0; i < k; ++i) {
         final byte[] a;
         array[i] = (((a = a(String.valueOf(Xuka.m) + i, "xkmisc")) == null) ? null : new String(a));
      }
      return array;
   }

   public static int[] j() {
      final int k;
      if ((k = k()) < 0) {
         return new int[0];
      }
      final int[] array = new int[k];
      for (int i = 0; i < k; ++i) {
         final byte[] a;
         array[i] = Integer.parseInt(((a = a(String.valueOf(Xuka.n) + i, "xkmisc")) == null) ? null : new String(a));
      }
      return array;
   }

   public static void a(final String[] array) {
      a(Xuka.l, new byte[] { (byte)array.length }, "xkmisc");
      for (int i = 0; i < array.length; ++i) {
         a(String.valueOf(Xuka.m) + i, array[i].getBytes(), "xkmisc");
      }
   }

   public static void a(final int[] array) {
      for (int i = 0; i < array.length; ++i) {
         a(String.valueOf(Xuka.n) + i, new StringBuffer(String.valueOf(array[i])).toString().getBytes(), "xkmisc");
      }
   }

   private static int k() {
      final byte[] a;
      if ((a = a(Xuka.l, "xkmisc")) == null) {
         return -1;
      }
      return a[0];
   }
}
