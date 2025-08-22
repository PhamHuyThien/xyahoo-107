import javax.microedition.lcdui.Image;

public class quyen_a {
   public String a;
   public Image b;
   public long c;
   public long d;
   public boolean e = true;

   public quyen_a(int var1, String var2, byte[] var3, long var4, long var6, String var8, boolean var9) {
      try {
         this.b = Image.createImage(var3, 0, var3.length);
      } catch (Exception var10) {
      }

      this.a = var2;
      if (var8 != null && var8.length() > 0) {
         quyen_hr.a(this.a, " ", var8, null);
         System.gc();
      }

      this.c = var4;
      this.d = var6;
      this.e = true;
   }

   public static void a(String var0, int var1) {
      quyen_ju var2 = null;
      if (var1 == 0) {
         var2 = new quyen_ju(3418, 39);
      }

      a(var0, var2);
      quyen_jv.a(var2);
   }

   public static void a(String var0) {
      quyen_ju var1 = new quyen_ju(6000000, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void a() {
      b(11712001, 2);
   }

   public static void b() {
      b(11712002, 2);
   }

   public static void c() {
      b(5000039, 2);
   }

   private static void b(int var0, int var1) {
      quyen_et.c.c(true);
      quyen_jv.a(new quyen_ju(var0, 2));
   }

   public static void b(String var0) {
      quyen_ju var1 = new quyen_ju(5000025, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void a(long var0, boolean var2) {
      quyen_ju var3 = new quyen_ju(5000017, 2);
      a(var0, var3);
      a(var2, var3);
      quyen_jv.a(var3);
   }

   public static void a(long var0) {
      quyen_ju var2 = new quyen_ju(5000022, 2);
      a(var0, var2);
      quyen_jv.a(var2);
   }

   public static void c(String var0) {
      quyen_ju var1 = new quyen_ju(5000038, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void a(long var0, String var2) {
      quyen_ju var3 = new quyen_ju(5000023, 2);
      a(var0, var3);
      a(var2, var3);
      quyen_jv.a(var3);
   }

   public static void a(long[] var0, String var1) {
      quyen_ju var2 = new quyen_ju(5000041, 2);
      a(var0.length, var2);
      int var3 = 0;

      for (int var4 = var0.length; var3 < var4; var3++) {
         a(var0[var3], var2);
      }

      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void d(String var0) {
      quyen_ju var1 = new quyen_ju(4802, 48);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void a(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(4804, 48);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void b(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(4808, 48);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void b(String var0, int var1) {
      quyen_ju var2 = new quyen_ju(var1, 48);
      a(var0, var2);
      quyen_jv.a(var2);
   }

   public static void d() {
      quyen_et.c.c(true);
      quyen_jv.a(new quyen_ju(5000009, 39));
   }

   public static void e(String var0) {
      quyen_et.c.c(true);
      quyen_ju var1 = new quyen_ju(5000011, 39);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void a(int var0) {
      quyen_ju var1 = new quyen_ju(123, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void f(String var0) {
      quyen_ju var1 = new quyen_ju(5023, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void c(String var0, String var1) {
      quyen_et.c.c(true);
      quyen_ju var2 = new quyen_ju(3403, 39);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void g(String var0) {
      quyen_ju var1 = new quyen_ju(3404, 39);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void d(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(3405, 39);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void e(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(3406, 39);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void f(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(3407, 39);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void a(String var0, String var1, int var2, byte[] var3) {
      quyen_ju var4 = new quyen_ju(3408, 39);
      a(var0, var4);
      a(var1, var4);
      a(var2, var4);
      int var5;
      a(var5 = var3.length, var4);

      for (int var6 = 0; var6 < var5; var6++) {
         a(var3[var6], var4);
      }

      quyen_jv.a(var4);
   }

   public static void a(String var0, String var1, String var2) {
      quyen_ju var3 = new quyen_ju(3412, 39);
      a(var0, var3);
      a(var1, var3);
      a(var2, var3);
      quyen_jv.a(var3);
   }

   public static void a(int var0, String var1, String var2, boolean var3) {
      quyen_ju var4 = new quyen_ju();
      if (var0 == 0) {
         var4 = new quyen_ju(3409, 39);
      }

      a(var1, var4);
      if (var0 == 0) {
         a(var2, var4);
      }

      a(var3, var4);
      quyen_jv.a(var4);
   }

   public static void a(int var0, String var1, String var2, String var3) {
      quyen_ju var4 = new quyen_ju();
      if (var0 == 0) {
         var4 = new quyen_ju(3411, 39);
      }

      a(var1, var4);
      if (var0 == 0) {
         a(var2, var4);
      }

      a(var3, var4);
      quyen_jv.a(var4);
   }

   public static void a(int var0, String var1, String var2, long var3) {
      quyen_ju var5 = new quyen_ju();
      if (var0 == 0) {
         var5 = new quyen_ju(3410, 39);
      }

      a(var1, var5);
      a(var2, var5);
      a(var3, var5);
      quyen_jv.a(var5);
   }

   public static void e() {
      quyen_ju var0 = new quyen_ju(324, 2);
      a(Xuka.d, var0);
      a(Xuka.e, var0);
      a((byte)0, var0);
      quyen_jv.a(var0);
      var0 = new quyen_ju(5030, 2);
      a(1, var0);
      quyen_jv.a(var0);
   }

   public static void h(String var0) {
      quyen_ju var1 = new quyen_ju(322, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void i(String var0) {
      quyen_ju var1 = new quyen_ju(321, 2);
      a(var0, var1);
      quyen_jv.a(var1);
   }

   public static void a(long var0, String var2, int var3) {
      quyen_ju var4 = new quyen_ju(var3 == 1 ? 5000016 : 22, var3 == 1 ? 2 : 4);
      if (var2 == null) {
         a(var0, var4);
      } else {
         a(var2, var4);
      }

      quyen_jv.a(var4);
   }

   public static void g(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(30, 4);
      a(var0, var2);
      a(var1, var2);
      quyen_jv.a(var2);
   }

   public static void h(String var0, String var1) {
      quyen_ju var2 = new quyen_ju(5000010, 2);
      a(quyen_kb.a(var0), var2);
      a(quyen_kb.a(var1), var2);
      a(Xuka.d, var2);
      a(Xuka.e, var2);
      quyen_jv.a(var2);
   }

   public static void a(int var0, int var1) {
      quyen_ju var2 = new quyen_ju(var1 == 1 ? 5000031 : 28, var1 == 1 ? 2 : 4);
      a(var0, var2);
      quyen_jv.a(var2);
   }

   public static void c(String var0, int var1) {
      quyen_ju var2 = new quyen_ju(var1 == 1 ? 5000035 : 29, var1 == 1 ? 2 : 4);
      if (var1 == 2) {
         quyen_jc.A = var0;
         Xuka.a(quyen_jc.b, var0, true);
      }

      a(var0, var2);
      quyen_jv.a(var2);
   }

   public static void a(String var0, String var1, int var2, int var3, int var4, byte var5, String var6) {
      quyen_ju var8;
      if (var3 == 1) {
         var8 = new quyen_ju(1016, 2);
         a(2, var8);
         quyen_jv.a(var8);
         var8 = new quyen_ju(5000007, 2);
      } else {
         var8 = new quyen_ju(21, 4);
      }

      a(quyen_kb.a(var0), var8);
      a(quyen_kb.a(var1), var8);
      a(var2, var8);
      a(var6, var8);
      a(var4, var8);
      if (var3 == 1) {
         a(var5, var8);
      }

      quyen_jv.a(var8);
   }

   public static void a(String var0, String var1, String var2, int var3) {
      quyen_ju var4 = new quyen_ju(34, 4);
      a(var0, var4);
      a(var1, var4);
      a(var2, var4);
      quyen_jv.a(var4);
   }

   public static void d(String var0, int var1) {
      quyen_ju var2 = new quyen_ju(23, 4);
      a(var0, var2);
      quyen_jv.a(var2);
   }

   public static void a(String var0, String var1, byte var2) {
      quyen_ju var3 = new quyen_ju(31, 4);
      a(var0, var3);
      a(var2, var3);
      if (var2 != 1) {
         var1 = "";
      }

      a(var1, var3);
      quyen_jv.a(var3);
   }

   public static void a(int var0, String var1, int var2, int var3) {
      quyen_ju var4 = new quyen_ju(501, 2);
      a(0, var4);
      a(var1, var4);
      a(var2, var4);
      a(var3, var4);
      quyen_jv.a(var4);
   }

   public static void a(byte[] var0) {
      quyen_ju var1 = new quyen_ju(115, 2);
      a(var0, 0, var0.length, var1);
      quyen_jv.a(var1);
   }

   public static void a(int var0, byte var1, String var2) {
      quyen_ju var3 = new quyen_ju(5002, 37);
      a(var0, var3);
      a(var1, var3);
      a(var2, var3);
      quyen_jv.a(var3);
   }

   public static void a(String var0, byte[] var1, int var2, int var3, boolean var4) {
      quyen_ju var5 = new quyen_ju(5003, 37);
      a(var0, var5);
      a(var1, var2, var3, var5);
      a(var4, var5);
      quyen_jv.a(var5);
   }

   public static short a(quyen_ju var0) {
      short var1 = 0;

      for (int var2 = 0; var2 < 2; var2++) {
         short var3;
         var1 = (short)((var3 = (short)(var1 << 8)) | 255 & var0.b().a());
      }

      return var1;
   }

   public static byte[] b(quyen_ju var0) {
      int var1 = d(var0);
      return var0.b().b(var1);
   }

   public static long c(quyen_ju var0) {
      long var1 = 0L;

      for (int var3 = 0; var3 < 8; var3++) {
         long var4;
         var1 = (var4 = var1 << 8) | (long)(255 & var0.b().a());
      }

      return var1;
   }

   public static int d(quyen_ju var0) {
      int var1 = 0;

      for (int var2 = 0; var2 < 4; var2++) {
         int var3;
         var1 = (var3 = var1 << 8) | 255 & var0.b().a();
      }

      return var1;
   }

   public static boolean e(quyen_ju var0) {
      return var0.b().a() == 1;
   }

   public static char f(quyen_ju var0) {
      return (char)a(var0);
   }

   public static String g(quyen_ju var0) {
      int var1 = d(var0);
      StringBuffer var2 = new StringBuffer(var1);

      for (int var3 = 0; var3 < var1; var3++) {
         var2.append(f(var0));
      }

      return var2.toString();
   }

   private static void b(int var0, quyen_ju var1) {
      for (int var2 = 3; var2 >= 0; var2--) {
         var1.b().a((byte)(var0 >> (var2 << 3)));
      }
   }

   public static void a(byte[] var0, int var1, int var2, quyen_ju var3) {
      var3.b().a(var2 + 4);
      b(var2, var3);
      var3.b().a(var0, var1, var2);
   }

   public static void a(byte var0, quyen_ju var1) {
      var1.b().a(1);
      var1.b().a(var0);
   }

   public static void a(boolean var0, quyen_ju var1) {
      var1.b().a(1);
      if (var0) {
         var1.b().a((byte)1);
      } else {
         var1.b().a((byte)0);
      }
   }

   public static void a(int var0, quyen_ju var1) {
      var1.b().a(4);

      for (int var2 = 3; var2 >= 0; var2--) {
         var1.b().a((byte)(var0 >> (var2 << 3)));
      }
   }

   public static void a(long var0, quyen_ju var2) {
      var2.b().a(8);

      for (int var3 = 7; var3 >= 0; var3--) {
         var2.b().a((byte)((int)(var0 >> (var3 << 3))));
      }
   }

   public static void a(String var0, quyen_ju var1) {
      quyen_jt var2 = var1.b();
      int var3 = var0.length();
      var2.a(4 + 2 * var3);
      b(var3, var1);

      for (int var7 = 0; var7 < var3; var7++) {
         short var10000 = (short)var0.charAt(var7);
         quyen_ju var5 = var1;
         short var4 = var10000;

         for (int var6 = 1; var6 >= 0; var6--) {
            var5.b().a((byte)(var4 >> (var6 << 3)));
         }
      }
   }
}
