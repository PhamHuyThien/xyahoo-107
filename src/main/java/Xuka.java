import javax.microedition.rms.RecordStore;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Display;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.midlet.MIDlet;

public class Xuka extends MIDlet
{
   private static String version;
   public static int versionCode;
   public static String[] serverIPs;
   public static int[] serverPorts;
   public static int partnerID;
   public static int appID;
   public static String refCode;
   public static String buildID;
   private static String ipCountKey;
   private static String ipPrefixKey;
   private static String portPrefixKey;
   public static GameGraphics gameGraphics;
   public static Xuka instance;
   public static String platform;

   static {
      Xuka.platform = null;
   }

   public Xuka() {
      final String appProperty = this.getAppProperty("IP-Address");
      final String appProperty2 = this.getAppProperty("Port");
      String s = this.getAppProperty("App-ID");
      String s2 = this.getAppProperty("Parner-ID");
      Xuka.version = this.getAppProperty("MIDlet-Version");
      Xuka.refCode = this.getAppProperty("RefCode");
      Xuka.buildID = this.getAppProperty("Build-ID");
      System.out.println(Xuka.version);
      System.out.println(Xuka.buildID);
      System.out.println(appProperty);
      System.out.println(appProperty2);
      System.out.println(s2);
      System.out.println(s);
      System.out.println(Xuka.refCode);
      Xuka.serverIPs = new String[] { (appProperty == null || appProperty.length() == 0) ? "112.78.10.113" : appProperty };
      int int1 = 13715;
      try {
         if (appProperty2 != null && appProperty2.length() > 0) {
            int1 = Integer.parseInt(appProperty2);
         }
      }
      catch (final Exception ex) {}
      Xuka.serverPorts = new int[] { int1 };
      Xuka.version = ((Xuka.version == null || Xuka.version.length() == 0) ? "1.0.0" : Xuka.version);
      GameManager.version = "Thử nghiệm " + Xuka.version;
      Xuka.refCode = ((Xuka.refCode == null || Xuka.refCode.equalsIgnoreCase("200487")) ? "" : (" " + Xuka.refCode));
      Xuka.buildID = ((Xuka.buildID == null || Xuka.buildID.length() == 0) ? "2012-MD" : Xuka.buildID);
      if (s2 == null || s2.length() == 0) {
         s2 = Integer.toString(1);
      }
      if (s == null || s.length() == 0) {
         s = Integer.toString(0);
      }
      try {
         Xuka.partnerID = Integer.parseInt(s2);
      }
      catch (final Exception ex2) {
         Xuka.partnerID = 1;
      }
      try {
         Xuka.appID = Integer.parseInt(s);
      }
      catch (final Exception ex3) {
         Xuka.appID = 0;
      }
      Xuka.versionCode = parseVersion(Xuka.version);
      Xuka.ipCountKey = "nIP" + Xuka.version;
      Xuka.ipPrefixKey = "_IP" + Xuka.version;
      Xuka.portPrefixKey = "_Port" + Xuka.version;
      System.gc();
      Xuka.platform = System.getProperty("microedition.platform");
      Xuka.gameGraphics = new GameGraphics();
      Xuka.instance = this;
   }

   private static int parseVersion(String string) {
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

   public static String formatVersion(int length) {
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

   public final void makePhoneCall(final String s) {
      System.out.println(s);
      try {
         this.platformRequest("tel:" + s);
      }
      catch (final ConnectionNotFoundException ex) {}
   }

   protected void startApp() {
      Display.getDisplay((MIDlet)this).setCurrent((Displayable) GameGraphics.instance);
   }

   protected void pauseApp() {
   }

   protected void destroyApp(final boolean b) {
      GameGraphics.isRunning = false;
   }

   public static void shutdown() {
      GameGraphics.isRunning = false;
   }

   public static void sendRequest(String string, String x, final Action Action, final Action action2, final boolean b) {
      string = String.valueOf(string) + Xuka.refCode;
      x = x;
      System.out.println(string);
      System.out.println(x);
      new Thread(new quyen_jb(x, string, Action, b, action2)).start();
   }

   public static byte[] loadData(final String str, final String str2) {
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

   public static void saveData(final String str, final byte[] array, final String str2) {
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

   public static void savePassword(final String s) {
      saveData("xkPW", quyen_kb.a(s).getBytes(), "xkown");
   }

   public static void saveYahooID(final String s) {
      saveData("YahooID", s.getBytes(), "xkown");
   }

   public static void saveYahooPassword(final String s) {
      saveData("YahooPW", quyen_kb.a(s).getBytes(), "xkown");
   }

   public static void saveBooleanSetting(final String s, final boolean b) {
      saveData(s, new byte[] { (byte)(b ? 1 : 0) }, "xkown");
   }

   public static boolean loadBooleanSetting(String s, final boolean b) {
      final byte[] a;
      int n2;
      final int n = ((a = loadData(s = s, "xkown")) == null) ? (n2 = -1) : ((a[0] == 1) ? (n2 = 1) : (n2 = 0));
      final int n3 = n2;
      if (n == -1) {
         return b;
      }
      return n3 != 0;
   }

   public static void saveUserID(final String s) {
      saveData("xkID", s.getBytes(), "xkown");
   }

   public static String loadUserID() {
      final byte[] a;
      if ((a = loadData("xkID", "xkown")) == null) {
         return null;
      }
      return new String(a);
   }

   public static void saveStringData(final String str, final String s, final boolean b) {
      saveData(String.valueOf(b ? "yststr" : "ststr") + str, s.getBytes(), "xkown");
   }

   public static String loadStringData(final String str, final boolean b) {
      final byte[] a;
      if ((a = loadData(String.valueOf(b ? "yststr" : "ststr") + str, "xkown")) == null) {
         return null;
      }
      return new String(a);
   }

   public static String loadPassword() {
      final byte[] a;
      if ((a = loadData("xkPW", "xkown")) == null) {
         return null;
      }
      return quyen_kb.b(new String(a));
   }

   public static String loadYahooID() {
      final byte[] a;
      if ((a = loadData("YahooID", "xkown")) == null) {
         return "";
      }
      return new String(a);
   }

   public static String loadYahooPassword() {
      final byte[] a;
      if ((a = loadData("YahooPW", "xkown")) == null) {
         return "";
      }
      return quyen_kb.b(new String(a));
   }

   public static void saveYahooDomain(final int n) {
      saveData("domainYahoo", new byte[] { (byte)n }, "xkown");
   }

   public static int loadYahooDomain() {
      final byte[] a;
      if ((a = loadData("domainYahoo", "xkown")) == null) {
         return 0;
      }
      return a[0];
   }

   public static void saveIDType(final int n) {
      saveData("idType", new byte[] { (byte)n }, "xkown");
   }

   public static int loadIDType() {
      final byte[] a;
      if ((a = loadData("idType", "xkown")) == null) {
         return 0;
      }
      return a[0];
   }

   public static void saveCaret(final int n) {
      saveData("caret", new byte[] { (byte)n }, "xkown");
   }

   public static int loadCaret() {
      final byte[] a;
      if ((a = loadData("caret", "xkown")) == null) {
         return 2;
      }
      return a[0];
   }

   public static int checkSpamFlag(final String str) {
      final byte[] a;
      if ((a = loadData("xpam" + str, "xkown")) == null) {
         return 0;
      }
      return a[0];
   }

   public static void setSpamFlag(final String str) {
      saveData("xpam" + str, new byte[] { 1 }, "xkown");
   }

   public static int loadIntData(final String s, final String s2) {
      final byte[] a;
      if ((a = loadData(s, s2)) == null || a.length != 4) {
         return -1;
      }
      return GameManager.bytesToInt(a[0], a[1], a[2], a[3]);
   }

   public static long loadLongData(final String s) {
      final byte[] a;
      if ((a = loadData(s, "xkown")) == null || a.length != 8) {
         return -1L;
      }
      return GameManager.bytesToLong(a);
   }

   public static String[] loadServerIPs() {
      final int k;
      if ((k = getServerCount()) < 0) {
         return new String[0];
      }
      final String[] array = new String[k];
      for (int i = 0; i < k; ++i) {
         final byte[] a;
         array[i] = (((a = loadData(String.valueOf(Xuka.ipPrefixKey) + i, "xkmisc")) == null) ? null : new String(a));
      }
      return array;
   }

   public static int[] loadServerPorts() {
      final int k;
      if ((k = getServerCount()) < 0) {
         return new int[0];
      }
      final int[] array = new int[k];
      for (int i = 0; i < k; ++i) {
         final byte[] a;
         array[i] = Integer.parseInt(((a = loadData(String.valueOf(Xuka.portPrefixKey) + i, "xkmisc")) == null) ? null : new String(a));
      }
      return array;
   }

   public static void saveServerIPs(final String[] array) {
      saveData(Xuka.ipCountKey, new byte[] { (byte)array.length }, "xkmisc");
      for (int i = 0; i < array.length; ++i) {
         saveData(String.valueOf(Xuka.ipPrefixKey) + i, array[i].getBytes(), "xkmisc");
      }
   }

   public static void saveServerPorts(final int[] array) {
      for (int i = 0; i < array.length; ++i) {
         saveData(String.valueOf(Xuka.portPrefixKey) + i, new StringBuffer(String.valueOf(array[i])).toString().getBytes(), "xkmisc");
      }
   }

   private static int getServerCount() {
      final byte[] a;
      if ((a = loadData(Xuka.ipCountKey, "xkmisc")) == null) {
         return -1;
      }
      return a[0];
   }
}
