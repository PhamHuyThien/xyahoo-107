import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Hashtable;
import javax.microedition.io.SocketConnection;

public final class quyen_jv {
   private static DataOutputStream j;
   public static InputStream a;
   public static quyen_jz b;
   private static SocketConnection k;
   public static boolean c;
   public static boolean d;
   private static quyen_jx l = new quyen_jx();
   private static Thread m;
   public static Thread e;
   public static Thread f;
   public static int g;
   public static int h;
   private static int n = 4;
   private static Hashtable o = new Hashtable();
   public static boolean i;

   public static boolean a() {
      return c;
   }

   public static void a(int var0, quyen_jz var1) {
      Integer var2 = new Integer(var0);
      o.put(var2, var1);
   }

   public static void a(String var0, String var1, int var2, int var3) {
      if (!c && !d) {
         k = null;
         (m = new Thread(new quyen_jy(var0, var1, var2, var3))).start();
      }
   }

   public static void a(quyen_ju var0) {
      l.a(var0);
   }

   public static void b() {
      try {
         if (!i && b != null) {
            try {
               b.c();
            } catch (Exception var1) {
               System.out.println("handler ex");
               var1.printStackTrace();
            }
         }

         if (k != null) {
            i();
            return;
         }
      } catch (Exception var2) {
         System.out.println("con ex");
         var2.printStackTrace();
      }
   }

   public static void c() {
      i();
   }

   private static void i() {
      try {
         c = false;
         d = false;
         if (k != null) {
            try {
               k.close();
            } catch (Exception var3) {
            }

            k = null;
         }

         if (j != null) {
            try {
               j.close();
            } catch (Exception var2) {
            }

            j = null;
         }

         if (a != null) {
            try {
               a.close();
            } catch (Exception var1) {
            }

            a = null;
         }

         f = null;
         e = null;
         if (l != null && l.a != null) {
            l.a.removeAllElements();
         }

         System.gc();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   static void a(SocketConnection var0) {
      k = var0;
   }

   static SocketConnection d() {
      return k;
   }

   static void a(DataOutputStream var0) {
      j = var0;
   }

   static quyen_jx e() {
      return l;
   }

   static DataOutputStream f() {
      return j;
   }

   static Hashtable g() {
      return o;
   }

   static int h() {
      return n;
   }
}
