import javax.microedition.lcdui.Image;

public class quyen_bw {
   public String a;
   public quyen_ca b;
   public quyen_ci c;

   public quyen_bw(String var1, quyen_ca var2) {
      this.a = var1;
      this.b = var2;
   }

   public static quyen_cs a(quyen_cj var0, String var1, int var2, quyen_ca var3) {
      quyen_cs var5;
      (var5 = new quyen_cs("", var2)).a(10, quyen_n.k + 1000, quyen_cj.h - 21, quyen_bt.i);
      var5.a(var1);
      var5.z = var3;
      var5.h = false;
      var5.p = quyen_et.D();
      quyen_bw var4 = new quyen_bw(quyen_cr.c(), new quyen_cl(var0, var5));
      var5.q = var4;
      var5.w = new quyen_cm(var5, var4);
      var5.r = new quyen_bw("OK", new quyen_cn(var5, var0));
      var0.a(var5);
      return var5;
   }

   public static quyen_cs a(quyen_co var0, String var1, int var2) {
      return b(var0, var1, 0, -1);
   }

   public static quyen_cs a(quyen_co var0, String var1, int var2, int var3) {
      quyen_ce var5;
      (var5 = new quyen_ce(var1, quyen_hr.d, var0.B, quyen_bt.e, -1)).n = -1;
      int var4 = var0.B;
      var0.a(var5);
      var0.B = var4 - 3;
      quyen_cs var6;
      (var6 = new quyen_cs()).s = -1;
      var6.a(quyen_hr.e, var0.B, quyen_hr.g, quyen_bt.i);
      var5.l = quyen_bt.b(var1) + 5;
      var6.d(var2);
      var0.a(var6);
      return var6;
   }

   public static quyen_cs b(quyen_co var0, String var1, int var2, int var3) {
      quyen_ce var5;
      (var5 = new quyen_ce(var1, var0.A, var0.B, quyen_bt.e, var3)).n = -1;
      var0.a(var5);
      quyen_cs var4;
      (var4 = new quyen_cs()).s = var3;
      var4.a(var0.A, var0.B, var0.C, quyen_bt.i);
      var4.d(var2);
      var4.a = var5;
      var0.a(var4);
      var0.B += 2;
      return var4;
   }

   public static quyen_bv a(quyen_co var0, String var1, String[] var2) {
      return a(var0, var1, var2, -1);
   }

   public static quyen_bv a(quyen_co var0, String var1, String[] var2, int var3) {
      quyen_ce var4 = new quyen_ce(var1, var0.A, var0.B, quyen_bt.e, var3);
      var0.a(var4);
      quyen_bv var5;
      (var5 = new quyen_bv(var2, var0.A, var0.B, var0.C, quyen_bt.i)).s = var3;
      var5.a = var4;
      var0.a(var5);
      var0.B += 2;
      return var5;
   }

   public static quyen_ce a(quyen_co var0, int var1) {
      quyen_ce var2;
      (var2 = new quyen_ce("", 5, var0.B, 10)).s = var1;
      var2.l = quyen_cj.h - var2.j - 5;
      var0.a(var2);
      return var2;
   }

   public static quyen_ce a(String var0, quyen_co var1, int var2) {
      if (var0.equals("")) {
         return a(var1, -1);
      } else {
         quyen_ce var3;
         (var3 = new quyen_ce(var0, var1.A, var1.B, quyen_bt.e + 2)).s = -1;
         var1.a(var3);
         return var3;
      }
   }

   public static quyen_ce[] a(String var0, quyen_co var1, int var2, int var3, boolean var4, boolean var5) {
      String[] var8;
      quyen_ce[] var6 = new quyen_ce[(var8 = quyen_bt.c(var0, quyen_cj.h - 10)).length];

      for (int var7 = 0; var7 < var8.length; var7++) {
         var6[var7] = new quyen_ce(var8[var7], 5, var1.B, quyen_bt.e + 2);
         var6[var7].s = var2;
         var6[var7].h = true;
         var6[var7].b = new Integer(var3);
         var6[var7].h = var4 && !var0.trim().equals("");
         var1.a(var6[var7]);
      }

      return var6;
   }

   public static quyen_bs a(quyen_co var0, String var1, quyen_ca var2, int var3, int var4) {
      int var5 = quyen_bt.b(var1) + 20;
      if (var4 < var5) {
         var4 = var5;
      }

      quyen_bs var6;
      (var6 = new quyen_bs(var1, var4, quyen_bt.e + 10)).j = quyen_cj.h - var4 >> 1;
      var6.k = var3 + 3;
      var6.a = var2;
      var6.r.b = var2;
      if (var0 != null) {
         var0.a(var6);
      }

      var0.B += 3;
      return var6;
   }

   public static quyen_cf a(quyen_co var0, String var1, int var2, quyen_ca var3, int var4, int var5, int var6) {
      quyen_cf var7;
      (var7 = new quyen_cf(var1, var4, var5, quyen_bt.e + 4)).s = var2;
      var7.a(var3);
      if (var0 != null) {
         var0.a(var7);
      }

      return var7;
   }

   public static quyen_bu a(quyen_co var0, String var1, boolean var2) {
      int var3 = quyen_bt.b(var1) + 13 + 4;
      quyen_bu var4;
      (var4 = new quyen_bu(var1, var0.A, var0.B, var3, quyen_bt.e + 4)).a = var2;
      if (var0 != null) {
         var0.a(var4);
      }

      return var4;
   }

   public static quyen_ce[] a(quyen_co var0, String var1) {
      return a(var1, var0, -1, 16777215, true, true);
   }

   public static quyen_cc a(quyen_co var0, int var1, Image var2, int var3, int var4, boolean var5, boolean var6) {
      quyen_cc var7;
      (var7 = new quyen_cc()).e(var3, var4);
      var7.h = var5;
      if (var2 != null) {
         var7.a(var2);
      } else {
         var7.c(var1);
      }

      var7.d(quyen_cj.h - var3 >> 1, var0.B == 6 ? var0.B : var0.B + 2);
      var7.a = var6;
      var0.a(var7);
      var0.B += 2;
      return var7;
   }
}
