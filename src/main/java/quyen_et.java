import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_et {
   public static boolean a;
   public static String b;
   private Hashtable V;
   private String W;
   private String X;
   private static String Y = "";
   public static quyen_et c = new quyen_et();
   private Vector Z;
   private Vector aa;
   private int ab;
   public static int d;
   public static int e;
   private static int ac;
   private static int ad;
   private static int ae = 15;
   public int f;
   private int af;
   private int ag;
   private int ah;
   private int ai = 1;
   private int aj;
   private int ak;
   public quyen_ca g;
   private int al;
   public quyen_ia h;
   public quyen_jc i;
   public quyen_ec j;
   private quyen_gu am;
   private boolean an;
   private Vector ao = new Vector();
   private int[] ap = new int[3];
   private String[] aq = new String[3];
   private int[] ar = new int[3];
   private int[] as = new int[3];
   private int[] at = new int[3];
   private int[] au = new int[3];
   private int[] av = new int[3];
   private int[] aw = new int[3];
   private Image[] ax = new Image[3];
   private boolean ay;
   private Vector az;
   public static String k = "";
   private boolean aA;
   private Image aB;
   private String[] aC;
   private int aD;
   private boolean aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;
   private int aJ;
   private int aK;
   private int aL;
   public static boolean l = false;
   public static boolean m = true;
   public static boolean n = true;
   public static boolean o = false;
   private static Image aM;
   private static Image aN;
   private int aO;
   private int aP;
   private int aQ;
   public static Image p;
   public static Image q;
   public static Image r;
   public static Image s;
   public static Image t;
   public static Image[] u;
   public static Image[] v;
   public static Image w;
   public static Image x;
   public static Image y;
   public static Image z;
   public static Image A;
   public static Image B;
   public static Image C;
   public static Image D;
   private static Image aR;
   public static Image E;
   public static Image F;
   public static Image G;
   public boolean H;
   private quyen_bw aS;
   private quyen_bw aT;
   private quyen_ca aU;
   private quyen_cj aV;
   private int aW;
   private int aX = 0;
   private int aY = 0;
   private boolean aZ;
   private static int ba;
   public static boolean I;
   private static int bb;
   private int bc;
   private static byte[] bd;
   private int be;
   private int bf;
   private boolean bg;
   public static String J;
   public static String K;
   public static byte L;
   public static boolean M;
   private static quyen_bw bh;
   public quyen_co N;
   private quyen_cs bi;
   private quyen_ci bj;
   private quyen_ci bk;
   public static boolean O;
   public static quyen_bw P;
   public static quyen_bw Q;
   public static quyen_bw R;
   public quyen_go S;
   private String bl;
   private int bm;
   private boolean bn;
   private int bo;
   private int bp;
   private String bq;
   private byte[] br;
   private byte bs;
   private boolean bt;
   private quyen_be bu;
   public static quyen_gz T;
   public String U = null;

   static {
      try {
         aM = Image.createImage("/Load.png");
      } catch (Exception var0) {
      }

      bd = new byte[1];
      M = true;
   }

   private void K() {
      if (this.V == null) {
         this.V = new Hashtable();
      }
   }

   private quyen_ba o(String var1) {
      this.K();
      return (quyen_ba)this.V.get(var1);
   }

   public final quyen_bc a(String var1, int var2) {
      quyen_ba var3;
      if ((var3 = this.o(var1)) == null) {
         var3 = quyen_ia.H.b(var1);
      }

      if (var3 != null && var3.o != null) {
         return var3.o;
      } else {
         quyen_a.a(var1, 0);
         return null;
      }
   }

   public final void a(String var1, quyen_bc var2, int var3) {
      quyen_bc var5 = var2;
      String var4 = var1;
      if (var3 == 0 && quyen_cz.O != null && quyen_cz.O.C != null) {
         int var6 = quyen_cz.O.C.length;

         while (--var6 >= 0) {
            if (quyen_cz.O.C[var6].a.equals(var4)) {
               quyen_cz.O.C[var6].a(var5);
            }
         }
      }

      quyen_ba var7;
      if ((var7 = this.o(var1)) != null && var3 == 0) {
         var7.o = var2;
      }

      quyen_ba var8;
      if ((var8 = quyen_ia.H.b(var1)) != null) {
         if (var3 == 0) {
            var8.o = var2;
         }
      } else {
         quyen_ba var9;
         (var9 = new quyen_ba()).a = var1;
         if (var3 == 0) {
            var9.o = var2;
         }

         this.K();
         this.V.put(var9.a, var9);
      }
   }

   public static void a(String var0, String var1, boolean var2) {
      Alert var3;
      (var3 = new Alert(var0)).setString(var1);
      var3.setTimeout(-2);
      Display.getDisplay(Xuka.i).setCurrent(var3);
   }

   public static void a() {
      Display.getDisplay(Xuka.i).setCurrent(Xuka.h);
      Xuka.h.setFullScreenMode(true);
   }

   private void g(quyen_cj var1) {
      this.aa.addElement(var1);
      this.aW = this.aa.size();
      quyen_hr.a(var1, this.aj - 30);
      if (this.aW == 1) {
         this.al = 0;
         this.L();
      }
   }

   private void L() {
      this.aV = (quyen_cj)this.aa.elementAt(this.al);
      if (this.aV.w) {
         this.aV.w = false;
         this.aX = 0;
         this.aY = 0;
      }

      quyen_cq.a = false;
      this.aV.b();
      this.b();
      this.aV.p = true;
   }

   public final void b() {
      if (this.aV != null) {
         this.aP = quyen_cj.h - quyen_bt.b(this.aV.k) >> 1;
      }
   }

   public final void a(quyen_cj var1) {
      quyen_cj var3 = var1;
      quyen_et var2 = this;
      int var4 = this.aW;

      boolean var10000;
      while (true) {
         if (--var4 < 0) {
            var10000 = false;
            break;
         }

         if (((quyen_cj)var2.aa.elementAt(var4)).j.equals(var3.j)) {
            var10000 = true;
            break;
         }
      }

      if (!var10000) {
         this.g(var1);
      }
   }

   public final void a(Graphics var1, int var2, int var3) {
      var1.setClip(0, 0, quyen_n.j, quyen_n.k);
      var1.drawRegion(aM, 0, this.f % 4 == 0 ? this.ah++ * 6 : this.ah * 6, 46, 6, 0, var2, var3, 3);
      this.ah = this.ah > 4 ? 0 : this.ah;
   }

   private void b(Graphics var1) {
      if (this.aE) {
         var1.setClip(this.aH + 1, this.aI + 1, this.aJ - 1, this.aK - 1);
         int var2 = this.aJ / 50 + 1;

         while (--var2 >= 0) {
            int var3 = this.aK / 50 + 1;

            while (--var3 >= 0) {
               var1.drawImage(r, this.aH + var2 * 50, this.aL + var3 * 50, 0);
            }
         }

         var1.setClip(this.aH - 1, this.aI, this.aJ + 2, this.aK + 2);
         var1.setColor(14545919);
         quyen_bs.a(var1, this.aH, this.aL, this.aJ, this.aK);
         var1.setColor(10278388);
         var1.fillRoundRect(5 + this.aH + this.aF * 20, 5 + this.aL + this.aG * 20, 20, 20, 5, 5);
         int var5 = 7;

         while (--var5 >= 0) {
            var2 = 6;

            while (--var2 >= 0) {
               var1.drawRegion(p, (var5 * 6 + var2) * 18, 0, 18, 18, 0, 5 + this.aH + var2 * 20 + 10, 5 + this.aL + var5 * 20 + 10, 3);
            }
         }

         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         var1.setClip(-1000, -1000, 2000, 2000);
         quyen_cj.f(var1);
         quyen_bt.a(quyen_bt.c).a("Chọn", 4, quyen_cj.z, var1);
         quyen_bt.a(quyen_bt.c).a(quyen_cr.c(), this.aQ, quyen_cj.z, var1);
      }
   }

   public final void a(String var1, Image var2, int var3) {
      if (this.ap[1] == 0 || var3 != 1) {
         this.ax[var3] = var2;
         int var4 = this.ax[var3] != null ? this.ax[var3].getWidth() : 0;
         this.aq[var3] = var1;
         this.ar[var3] = quyen_bt.b(var1) + 15 + var4;
         this.au[var3] = quyen_bt.e + 6;
         if (this.ax[var3] != null && this.au[var3] < this.ax[var3].getHeight() + 6) {
            this.au[var3] = this.ax[var3].getHeight() + 6;
         }

         if (this.ap[var3] == 0) {
            this.ap[var3] = 1;
         }

         if (var3 == 0) {
            this.as[var3] = quyen_n.j - this.ar[var3] - 2;
            if (this.ap[var3] > 1) {
               this.ap[var3] = 1;
            } else {
               this.av[var3] = this.at[var3] + this.au[var3];
            }
         } else if (var3 == 1) {
            this.aw[1] = 2;
            this.as[var3] = quyen_n.j;
            this.av[var3] = this.at[var3];
         } else {
            this.as[var3] = quyen_n.j - this.ar[var3] - 2;
            if (this.ap[var3] > 1) {
               this.ap[var3] = 1;
            } else {
               this.av[var3] = this.at[var3] - this.au[var3] + 1;
            }
         }
      }
   }

   public static void c() {
      System.gc();
   }

   public final void d() {
      if (m) {
         Display.getDisplay(Xuka.i).vibrate(500);
      }
   }

   public final void a(int var1) {
      if (!this.an) {
         this.aJ = 129;
         this.aK = 149;
         this.aH = 2;
         this.aI = this.ak - e - this.aK - 1;
         this.aL = this.ak - e - 1;
         this.aE = true;
      }
   }

   public static quyen_et e() {
      return c;
   }

   public final quyen_by a(String var1, int var2, Vector var3, int var4, quyen_bw var5, quyen_bw var6, quyen_bw var7) {
      quyen_by var8 = new quyen_by(var1, var2, var3, var4, var5, var6, var7);
      this.ao.addElement(var8);
      this.ay = false;
      this.an = true;
      return var8;
   }

   public final quyen_by a(String var1, quyen_bw var2, quyen_bw var3, quyen_bw var4) {
      quyen_by var5 = new quyen_by(var1, var2, var3, var4);
      this.ao.addElement(var5);
      this.ay = false;
      this.an = true;
      return var5;
   }

   private quyen_by a(String[] var1, quyen_bw var2, quyen_bw var3, quyen_bw var4) {
      quyen_by var5 = new quyen_by(var1, var2, var3, var4);
      this.ao.addElement(var5);
      this.ay = false;
      this.an = true;
      return var5;
   }

   public final void f() {
      if (this.ao.size() > 0) {
         quyen_by var1 = (quyen_by)this.ao.elementAt(0);
         this.ao.removeElementAt(0);
         var1.b = null;
         var1.a = null;
         var1.c = null;
         System.gc();
      }

      if (this.ao.size() == 0) {
         this.an = false;
      }
   }

   public final boolean a(String var1) {
      int var2 = this.aW;

      while (--var2 >= 0) {
         if (((quyen_cj)this.aa.elementAt(var2)).j.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public final boolean b(quyen_cj var1) {
      return this.aa.contains(var1);
   }

   protected quyen_et() {
   }

   public final void a(int var1, int var2) {
      if (a = Xuka.b[0].startsWith("10.") || Xuka.b[0].endsWith("127.0.0.1") || Xuka.c[0] == 11112) {
         System.out.println("LOCAL TEST");
      }

      System.gc();
      this.aj = var1;
      this.ak = var2;
      this.aa = new Vector();
      this.az = new Vector();
      this.Z = new Vector();
      if (P == null) {
         P = new quyen_bw("Gọi CSKH", new quyen_eu(this));
         Q = new quyen_bw("Thông tin", new quyen_ff(this));
         R = new quyen_bw("Diễn đàn", new quyen_fq(this));
      }

      ba = quyen_n.j < 130 ? 126 : 130;
      quyen_hr.h = quyen_n.j < 250 ? 70 : 80;
      quyen_hr.i = quyen_n.j < 250 ? 150 : 160;
      this.ab = quyen_bt.e + 3;
      ac = 1;
      d = e = quyen_bt.a ? 18 : quyen_bt.e + 3;
      ad = e;
      this.aO = (d - quyen_bt.e >> 1) - 1;
      this.at[0] = quyen_n.k - e - quyen_bt.e - 8;
      this.at[1] = this.at[2] = ac + e + 1;
      this.aw[0] = 1;
      this.aw[1] = 2;
      this.aw[2] = 1;
      l = Xuka.b("sound", false);
      m = Xuka.b("vibrate", true);
      n = Xuka.b("atlog", true);
      o = Xuka.b("atlogY", false);
      u = new Image[7];
      v = new Image[3];
      quyen_af.a(0);
      byte[] var3;
      Image var11 = Image.createImage(var3 = quyen_af.b(0), 0, var3.length);
      byte[] var4;
      t = Image.createImage(var4 = quyen_af.b(1), 0, var4.length);
      var4 = quyen_af.b(2);
      byte[] var5;
      s = Image.createImage(var5 = quyen_af.b(3), 0, var5.length);
      r = Image.createImage(var4, 0, var4.length);
      var4 = quyen_af.b(4);
      var5 = quyen_af.b(5);
      byte[] var6 = quyen_af.b(6);
      v[0] = Image.createImage(var4, 0, var4.length);
      v[1] = Image.createImage(var5, 0, var5.length);
      v[2] = Image.createImage(var6, 0, var6.length);
      System.gc();
      p = Image.createImage(var4 = quyen_af.b(7), 0, var4.length);
      var4 = quyen_af.b(8);
      var5 = quyen_af.b(9);
      var6 = quyen_af.b(10);
      byte[] var7 = quyen_af.b(11);
      byte[] var8 = quyen_af.b(12);
      byte[] var9 = quyen_af.b(13);
      byte[] var10 = quyen_af.b(14);
      u[0] = Image.createImage(var4, 0, var4.length);
      u[1] = Image.createImage(var5, 0, var5.length);
      u[2] = Image.createImage(var6, 0, var6.length);
      u[3] = Image.createImage(var7, 0, var7.length);
      u[4] = Image.createImage(var8, 0, var8.length);
      u[5] = Image.createImage(var9, 0, var9.length);
      u[6] = Image.createImage(var10, 0, var10.length);
      Image var17 = Image.createImage(var4 = quyen_af.b(15), 0, var4.length);
      quyen_af.a();
      int var20 = quyen_n.k - (e << 1) + 2;
      Graphics var23 = (aN = Image.createImage(quyen_n.j, var20)).getGraphics();
      int var24 = (quyen_n.j >> 5) + 1;

      for (int var25 = 0; var25 < var24; var25++) {
         var23.drawImage(var11, var25 << 5, var20 - var11.getHeight(), 0);
      }

      int var26 = var20 - var11.getHeight() - 32;
      int var21 = (var20 - var11.getHeight() >> 5) + 1;

      for (int var27 = 0; var27 < var24; var27++) {
         for (int var29 = 0; var29 < var21; var29++) {
            var23.drawRegion(var11, 0, 0, 32, 32, 0, var27 << 5, var26 - (var29 << 5), 0);
         }
      }

      System.gc();
      Graphics var28 = (q = Image.createImage(quyen_n.j, 18)).getGraphics();
      int var30 = (quyen_n.j - 128 >> 5) + 1;

      while (--var30 >= 0) {
         var28.drawRegion(var17, 64, 0, 32, 18, 0, 64 + (var30 << 5), 0, 20);
      }

      var28.drawRegion(var17, 0, 0, 64, 18, 0, 0, 0, 20);
      var28.drawRegion(var17, 0, 0, 64, 18, 2, quyen_n.j - 64, 0, 20);
      System.gc();
      aN.getHeight();
      this.af = e;
      this.ag = (e - 7 >> 1) + 1;
      this.al = 0;
      quyen_cj.f = 0;
      quyen_cj.g = ad;
      quyen_cj.h = var1;
      quyen_cj.i = var2 - ad;
      quyen_cj.z = ad + quyen_cj.i - (e >> 1) - (quyen_bt.e >> 1) + (quyen_bt.a ? 0 : 1);
      this.aQ = quyen_cj.h - quyen_bt.b(quyen_cr.c()) - 4;
      this.j = new quyen_ec();
      this.j.b(1);
      this.a((quyen_cj)this.j);
      this.L();
      if (quyen_n.l) {
         quyen_cs.c(1);
      } else if (Xuka.j != null && Xuka.j.toLowerCase().indexOf("nokia") != -1) {
         quyen_cs.c(0);
      } else {
         quyen_cs.c(2);
      }

      quyen_cs.g = quyen_n.a;
      quyen_cs.u = Xuka.i;
      quyen_cs.e = Xuka.h();
      quyen_n.m = true;
   }

   public final void g() {
      if (quyen_jv.d) {
         this.a("Đang kiểm tra kết nối..", null, null, new quyen_bw(quyen_cr.c(), new quyen_gb(this))).a(true);
      }
   }

   public final void h() {
      if (this.am == null) {
         this.am = new quyen_gu();
      }

      this.am.a();
      this.a((quyen_cj)this.am);
      this.e(this.am);
      this.c(this.j);
      this.am.b(1);
   }

   public static void i() {
      if (w == null) {
         quyen_af.a(2);
         byte[] var0;
         y = Image.createImage(var0 = quyen_af.b(0), 0, var0.length);
         System.gc();
         w = Image.createImage(var0 = quyen_af.b(1), 0, var0.length);
         System.gc();
         B = Image.createImage(var0 = quyen_af.b(2), 0, var0.length);
         System.gc();
         A = Image.createImage(var0 = quyen_af.b(3), 0, var0.length);
         D = Image.createImage(var0 = quyen_af.b(4), 0, var0.length);
         System.gc();
         z = Image.createImage(var0 = quyen_af.b(5), 0, var0.length);
         x = Image.createImage(var0 = quyen_af.b(6), 0, var0.length);
         System.gc();
         C = Image.createImage(var0 = quyen_af.b(7), 0, var0.length);
         System.gc();
         quyen_af.a();
      }
   }

   public static void j() {
      if (aR == null) {
         quyen_af.a(1);
         byte[] var0;
         aR = Image.createImage(var0 = quyen_af.b(0), 0, var0.length);
         System.gc();
         F = Image.createImage(var0 = quyen_af.b(1), 0, var0.length);
         G = Image.createImage(var0 = quyen_af.b(2), 0, var0.length);
         E = Image.createImage(var0 = quyen_af.b(3), 0, var0.length);
         System.gc();
         quyen_af.a();
      }
   }

   public final void a(Graphics var1) {
      quyen_et var2 = this;
      if (quyen_bt.a) {
         var1.drawImage(q, 0, 0, 20);
      } else {
         int var5 = e >> 1;
         var1.setColor(1404853);
         var1.fillRect(0, 0, quyen_cj.h, var5);
         var1.setColor(1334695);
         var1.fillRect(0, var5 + 0, quyen_cj.h, var5);
         var1.setColor(537185);
         var1.fillRect(0, 2 * var5, quyen_cj.h, 1);
         var1.setColor(6796786);
         var1.fillRect(0, 1, quyen_cj.h, 1);
      }

      quyen_bt.a(quyen_bt.c).a(this.aV.k, this.aP, this.aO, var1);
      if (this.aW > 1) {
         for (int var4 = 0; var4 < var2.aW; var4++) {
            if (((quyen_cj)var2.aa.elementAt(var4)).w) {
               if (var4 < var2.al) {
                  if (var2.aX++ > 20) {
                     var2.aX = 0;
                  }
               } else if (var2.aY++ > 20) {
                  var2.aY = 0;
               }
            }
         }

         if (var2.al > 0 && var2.aX < 10) {
            var1.drawRegion(v[2], 0, 0, 7, 7, 0, 4, var2.ag, 20);
         }

         if (var2.al < var2.aW - 1 && var2.aY < 10) {
            var1.drawRegion(v[2], 7, 0, 7, 7, 0, var2.aj - 10, var2.ag, 20);
         }
      }

      var1.setClip(0, e, this.aj, this.ak);
      if (this.aV.y) {
         var1.setColor(396304);
         var1.fillRect(0, 0, this.aj, this.ak);
         int var29 = this.aj - 248 >> 1;
         int var3 = this.ak - 248 >> 1;
         int var11 = var29;
         var1.drawImage(aR, var11, var3, 20);
         var1.drawRegion(aR, 0, 0, 124, 248, 2, var11 + 124, var3, 20);
      } else {
         var1.drawImage(aN, 0, this.af, 0);
      }

      if (this.aV.q) {
         var1.translate(-this.aV.r, 0);
      }

      this.aV.b(var1);
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      Graphics var16 = var1;
      var2 = this;

      for (int var20 = 0; var20 < 3; var20++) {
         if (var2.ap[var20] != 0) {
            var16.setClip(0, var2.at[var20], quyen_n.j, var2.au[var20] + 2);
            var16.setColor(872315);
            var16.fillRect(var2.as[var20] + 1, var2.av[var20] + 1, var2.ar[var20] - 1, var2.au[var20] - 1);
            var16.setColor(14545919);
            quyen_bs.a(var16, var2.as[var20], var2.av[var20], var2.ar[var20], var2.au[var20]);
            int var24 = 5;
            if (var2.ax[var20] != null) {
               var16.drawImage(var2.ax[var20], var2.as[var20] + 7 + (var2.ax[var20].getWidth() >> 1), var2.av[var20] + (var2.au[var20] >> 1), 3);
               var24 = 5 + var2.ax[var20].getWidth() + 1;
            }

            quyen_bt.a(quyen_bt.c).a(var2.aq[var20], var2.as[var20] + 3 + var24, var2.av[var20] + 3, var16);
         }
      }

      var1.setClip(-1000, -1000, 2000, 2000);
      if (this.an) {
         ((quyen_by)this.ao.elementAt(0)).a(var1);
      } else if (this.ay) {
         var16 = var1;
         var2 = this;
         int var21 = 0;
         int var25 = this.az.size();

         for (int var6 = 0; var6 < var25; var6++) {
            quyen_ci var7 = (quyen_ci)var2.az.elementAt(var6);
            var21 = var2.aZ ? quyen_b.c(var7.d + var7.f - var7.h) : quyen_b.c(var7.f - (var7.d - var7.h));
            var16.setClip((var2.aZ ? var7.h : var7.d) + 2, var7.i + 2, var21 - 3, var7.g - 3);
            int var8 = var7.f / 50 + 1;

            while (--var8 >= 0) {
               int var9 = var7.g / 50 + 1;

               while (--var9 >= 0) {
                  var16.drawImage(r, (var2.aZ ? var7.h : var7.d) + var8 * 50, var7.i + var9 * 50, 0);
               }
            }

            var16.drawImage(s, (var2.aZ ? var7.h : var7.d) + (var7.f >> 1), var7.i, 17);
            var16.setClip(var7.d, var7.e, var7.f + 1, var7.g + 1);
            var16.setColor(14545919);
            quyen_bs.a(
                    var16,
                    (var2.aZ ? var7.h : var7.d) + 1,
                    var7.i + 1,
                    (var2.aZ ? quyen_b.c(var7.d + var7.f - var7.h) : quyen_b.c(var7.f - (var7.d - var7.h))) - 2,
                    var7.g - 2
            );
            var16.setClip(var2.aZ ? var7.d : var7.d + 2, var7.e, var2.aZ ? var7.f - 1 : var7.f, var7.g);
            var16.translate(var7.h + 5, var7.i + 5);
            var8 = var7.a.size();

            for (int var27 = 0; var27 < var8; var27++) {
               var21 = 1 + var27 * var2.ab + (quyen_bt.a ? 0 : 2);
               String var10 = ((quyen_bw)var7.a.elementAt(var27)).a;
               if (((quyen_bw)var7.a.elementAt(var27)).c != null) {
                  var10 = var10 + " >";
               }

               if (var27 == var7.c) {
                  var16.setColor(136997);
                  var16.fillRoundRect(-1, var27 * var2.ab - 1, (var2.aZ ? quyen_b.c(var7.d + var7.f - var7.h) : var7.f) - 7, var2.ab + 2, 5, 5);
               }

               quyen_bt.a(quyen_bt.c).a(var10, 3, var21, var16);
            }

            var16.translate(-(var7.h + 5), -(var7.i + 5));
         }

         var16.setClip(-1000, -1000, 5000, 5000);
         quyen_cj.f(var16);
         quyen_bt.a(quyen_bt.c).a("Chọn", 4, quyen_cj.z, var16);
         quyen_bt.a(quyen_bt.c).a(quyen_cr.c(), var2.aQ, quyen_cj.z, var16);
      } else if (this.aE) {
         this.b(var1);
      }

      if (this.aA) {
         int var14 = e + 8;
         int var18 = quyen_bt.a ? 0 : 1;
         var1.setColor(1055519);
         var1.fillRect(8, var14 + 1, quyen_n.j - 16, quyen_n.k - (var14 << 1) + 3);
         var1.setColor(9478569);
         quyen_bs.a(var1, 7, var14, quyen_n.j - 15, quyen_n.k - (var14 << 1) + 2);
         var1.setClip(9, 9, quyen_n.j - 18, quyen_n.k - 18);
         int var15 = var14 + 6;
         if (this.aB != null) {
            var1.drawImage(this.aB, quyen_n.j - this.aB.getWidth() >> 1, var15 + 6, 0);
            var15 += this.aB.getHeight() + quyen_bt.e + var18;
         }

         for (int var19 = 0; var19 < this.aC.length; var19++) {
            quyen_bt.a(quyen_bt.d).a(this.aC[var19], quyen_n.j - 20 - quyen_bt.b(this.aC[var19]) >> 1, var15 + var19 * quyen_bt.e, var1);
         }
      }

      if (this.H) {
         var1.setClip(0, 0, quyen_n.j, quyen_n.k);
         var1.drawRegion(aM, 8, this.f % 4 == 0 ? this.ai++ * 6 : this.ai * 6, 30, 6, 0, quyen_n.j - 30, (e >> 1) + 1, 3);
         this.ai = this.ai > 3 ? 1 : this.ai;
      }

      var1.setClip(-1000, -1000, 2000, 2000);
   }

   private void M() {
      O = false;
      quyen_cz.O = null;
      quyen_cz.d = "";
      this.U = null;
      boolean var2 = false;
      this.H = var2;
      this.H();
      this.aa.removeAllElements();
      this.al = 0;
      this.aW = 0;
      this.aV = null;
      if (this.Z != null) {
         this.Z.removeAllElements();
      }

      System.gc();
      if (this.j == null) {
         this.j = new quyen_ec();
      }

      this.a((quyen_cj)this.j);
      this.j.b(-1);
      if (this.h != null) {
         this.h.a();
         this.h = null;
      }

      if (this.i != null) {
         this.i.h();
         this.i = null;
      }

      if (this.bu != null) {
         this.bu.a();
         this.bu = null;
      }

      System.gc();
   }

   public final void k() {
      quyen_jv.i = true;
      this.M();
      int var1 = quyen_jv.g;
      int var2 = quyen_jv.h;
      if (var1 > 0) {
         var1 = var1 / 1024 + 1;
      }

      if (var2 > 0) {
         var2 = var2 / 1024 + 1;
      }

      this.b(new String[]{"Dung lượng internet", var1 + var2 + " Kb"});
      quyen_jv.g = 0;
      quyen_jv.h = 0;
      quyen_jv.c();

      try {
         Thread.sleep(50L);
      } catch (InterruptedException var3) {
      }

      System.gc();
   }

   private quyen_ca N() {
      if (this.aU == null) {
         this.aU = new quyen_gj(this);
      }

      return this.aU;
   }

   public final quyen_bw b(String var1) {
      if (this.aS == null) {
         this.aS = new quyen_bw("", this.N());
      }

      this.aS.a = var1;
      return this.aS;
   }

   public final quyen_bw l() {
      if (this.aT == null) {
         this.aT = new quyen_bw("", this.N());
      }

      return this.aT;
   }

   public final quyen_by c(String var1) {
      return this.a(var1, null, this.b(quyen_cr.c()), null);
   }

   public final quyen_by a(String var1, quyen_ca var2) {
      return this.a(quyen_bt.c(var1, quyen_n.j - 30), new quyen_bw("OK", var2), new quyen_bw("", var2), this.b(quyen_cr.c()));
   }

   public final void b(String var1, quyen_ca var2) {
      this.a(var1, null, new quyen_bw("OK", var2), null);
   }

   public final void d(String var1) {
      this.b(quyen_bt.c(var1, quyen_n.j - 30));
   }

   private void b(String[] var1) {
      this.a(var1, this.l(), this.b("OK"), null);
   }

   public final void c(quyen_cj var1) {
      if (var1 != null) {
         int var2 = this.aa.size();

         while (--var2 >= 0) {
            if (this.aa.elementAt(var2).equals(var1)) {
               if (var2 <= this.al) {
                  this.al--;
                  if (this.al < 0) {
                     this.al = 0;
                  }
               }

               this.aa.removeElementAt(var2);
               System.gc();
               this.aW = this.aa.size();
            }
         }

         this.L();
         this.aV.b(-1);
         System.gc();
      }
   }

   public final void d(quyen_cj var1) {
      this.c(var1);
      System.gc();
   }

   public final quyen_cj e(String var1) {
      int var2 = this.aW;

      while (--var2 >= 0) {
         if (((quyen_cj)this.aa.elementAt(var2)).j.equals(var1)) {
            return (quyen_cj)this.aa.elementAt(var2);
         }
      }

      return null;
   }

   private void f(boolean var1) {
      if (!var1 && this.az.size() > 1) {
         this.az.removeElementAt(this.az.size() - 1);
      } else {
         this.az.removeAllElements();
         this.ay = false;
      }
   }

   public final void a(quyen_ci var1, int var2) {
      if (!this.an) {
         if (!this.ay) {
            this.az.removeAllElements();
         }

         this.ay = true;
         var1.b = var2;
         int var3;
         if (this.aj > 300) {
            var3 = 0;
         } else if (this.aj <= 300 && this.aj >= 170) {
            var3 = ba >> 1;
         } else {
            var3 = ba;
         }

         int var4 = 0;
         int var5 = 0;
         if (this.az.size() > 0) {
            quyen_ci var6;
            var4 = (var6 = (quyen_ci)this.az.lastElement()).d;
            var5 = var6.e;
         }

         var1.g = 9 + var1.a.size() * this.ab;
         var1.f = ba;
         if (this.az.size() == 0) {
            if (var2 == 0) {
               this.aZ = false;
               var1.d = 1;
            } else if (var2 == 2) {
               this.aZ = true;
               var1.d = this.aj - var1.f - 2;
            } else if (var2 == 1) {
               this.aZ = false;
               var1.d = (this.aj >> 1) - (var1.f >> 1);
            }

            var1.e = this.ak - e - var1.g;
            var1.h = var1.d;
            var1.i = this.ak - e;
         } else if (this.az.size() > 0) {
            if (this.aZ) {
               if (this.az.size() > 1 && var4 - var1.f + var3 < 0) {
                  this.aZ = false;
                  var1.d = var4 + ba - var3;
               } else {
                  var1.d = var4 - var1.f + var3;
               }
            } else {
               if (this.az.size() > 1 && var4 + ba - var3 + var1.f > this.aj) {
                  this.aZ = true;
                  var1.d = var4 - var1.f + var3;
               } else {
                  var1.d = var4 + ba - var3;
               }

               if (((quyen_ci)this.az.firstElement()).b == 2) {
                  var1.d = (this.aj >> 1) - (var1.f >> 1);
               }
            }

            if (var1.d < 0) {
               var1.d = 0;
            }

            quyen_ci var8 = (quyen_ci)this.az.lastElement();
            if ((var2 = var5 + var8.c * this.ab) + var1.g > this.ak - e) {
               var1.e = this.ak - e - var1.g;
            } else {
               var1.e = var2;
            }

            var1.i = var1.e;
            if (this.aZ) {
               var1.h = var1.d + var1.f;
            } else {
               var1.h = var1.d - var1.f;
            }
         }

         var1.c = 0;
         this.az.addElement(var1);
      }
   }

   public final void a(boolean[] var1, boolean[] var2, int[] var3) {
      this.f++;
      if (this.f >= 100000) {
         this.f = 0;
      }

      if (this.f % 3000 == 0 && quyen_jv.c) {
         quyen_jv.a(new quyen_ju(50, 2));
      }

      if (this.bg && this.bf++ >= 100) {
         this.x();
      }

      if (this.g != null) {
         this.g.a();
         this.g = null;
      }

      if (I && ++bb == 270) {
         bb = 0;
         I = false;
      }

      quyen_et var4 = this;
      if (this.aA) {
         this.aD--;
         if (this.aD <= 0) {
            this.aA = false;
         }
      }

      if (this.Z != null) {
         this.bc++;
         if (this.bc >= 100000) {
            this.bc = 0;
         }

         int var5 = this.Z.size();

         while (--var5 >= 0) {
            quyen_a var6;
            if ((var6 = (quyen_a)var4.Z.elementAt(var5)) != null) {
               if ((long)var4.bc % var6.c == 0L) {
                  var6.e = true;
               }

               if (var6.e && var4.ap[1] == 0) {
                  var6.e = false;
                  var4.a(var6.a, var6.b, 1);
                  var4.aw[1] = (int)var6.d;
               }
            }
         }
      }

      var4 = this;

      for (int var15 = 0; var15 < 3; var15++) {
         if (var4.ap[var15] > 0) {
            if (var15 == 1) {
               var4.as[var15] = var4.as[var15] - var4.aw[var15];
               if (var4.as[var15] < -var4.ar[var15]) {
                  var4.ap[var15] = 0;
               }
            } else if (var15 == 0) {
               if (var4.ap[var15] <= var4.au[var15]) {
                  if (var4.av[var15] > var4.at[var15]) {
                     var4.av[var15]--;
                  }
               } else if (var4.ap[var15] > 100 - var4.au[var15]) {
                  var4.av[var15]++;
               }

               var4.ap[var15]++;
               if (var4.ap[var15] > 100) {
                  var4.ap[var15] = 0;
               }
            } else if (var15 == 2) {
               if (var4.ap[var15] <= var4.au[var15]) {
                  if (var4.av[var15] < var4.at[var15]) {
                     var4.av[var15]++;
                  }
               } else if (var4.ap[var15] > 100 - var4.au[var15]) {
                  var4.av[var15]--;
               }

               var4.ap[var15]++;
               if (var4.ap[var15] > 100) {
                  var4.ap[var15] = 0;
               }
            }
         }
      }

      if (this.az.size() > 0) {
         quyen_ci var16;
         if ((var16 = (quyen_ci)this.az.lastElement()).i > var16.e) {
            int var21;
            if ((var21 = var16.i - var16.e >> 1) <= 0) {
               var21 = 1;
            }

            var16.i -= var21;
         }

         if (var16.h != var16.d) {
            int var22;
            if ((var22 = quyen_b.c(var16.d - var16.h) >> 1) <= 0) {
               var22 = 1;
            }

            var16.h = var16.h + (this.aZ ? -var22 : var22);
         }
      }

      if (this.aL > this.aI) {
         int var17;
         if ((var17 = this.aL - this.aI >> 1) <= 0) {
            var17 = 1;
         }

         this.aL -= var17;
      }

      this.aV.f();
      if (quyen_n.d) {
         if (quyen_n.h > quyen_n.k - e) {
            if (quyen_n.g < quyen_n.j / 3) {
               var1[17] = true;
            } else if (quyen_n.g > 2 * quyen_n.j / 3) {
               var1[18] = true;
            } else {
               var1[16] = true;
            }
         } else if (!this.an) {
            if (this.ay) {
               quyen_ci var13 = (quyen_ci)this.az.lastElement();
               if (quyen_n.g >= var13.d && quyen_n.g <= var13.d + var13.f && quyen_n.h <= var13.e + var13.g && quyen_n.h >= var13.e) {
                  int var19;
                  if ((var19 = (quyen_n.h - var13.e - 3) / this.ab) < 0) {
                     var19 = 0;
                  }

                  if (var19 >= var13.a.size()) {
                     var19 = var13.a.size() - 1;
                  }

                  var13.c = var19;
                  var1[16] = true;
               } else {
                  this.f(false);
               }
            } else if (this.aE) {
               if (quyen_n.g >= this.aH && quyen_n.g <= this.aH + this.aJ && quyen_n.h <= this.aI + this.aK && quyen_n.h >= this.aI) {
                  int var12 = (quyen_n.g - this.aH - 7) / 20;
                  int var18 = (quyen_n.h - this.aI - 7) / 20;
                  if (var12 < 0) {
                     var12 = 0;
                  }

                  if (var12 > 5) {
                     var12 = 5;
                  }

                  if (var18 < 0) {
                     var18 = 0;
                  }

                  if (var18 > 6) {
                     var18 = 6;
                  }

                  if (var12 == this.aF && var18 == this.aG) {
                     var1[16] = true;
                  } else {
                     this.aF = var12;
                     this.aG = var18;
                  }
               } else {
                  this.aE = false;
               }
            } else if (quyen_n.h <= 0 || quyen_n.h >= e) {
               this.aV.a(quyen_n.g, quyen_n.h - quyen_cj.g);
            } else if (quyen_n.g < ae) {
               this.n();
               var1[14] = false;
            } else if (quyen_n.g > quyen_n.j - ae) {
               this.m();
               var1[15] = false;
            }
         }

         quyen_n.d = false;
      }

      if (quyen_n.e && !this.an) {
         this.aV.c(quyen_n.g, quyen_n.h - quyen_cj.g);
         quyen_n.e = false;
      }

      if (quyen_n.c && !this.an) {
         this.aV.b(quyen_n.g, quyen_n.h - quyen_cj.g);
      }

      if (quyen_n.f && !this.an) {
         this.aV.d(quyen_n.g, quyen_n.h - quyen_cj.g);
         quyen_n.f = false;
      }

      boolean var14 = var1[14];
      boolean var20 = var1[15];
      boolean var23 = var1[12];
      boolean var7 = var1[13];
      if (var14 || var20 || var23) {
         this.aw[1] = this.aw[1] == 2 ? 6 : 2;
         if (this.ap[0] > 1) {
            this.ap[0] = 101 - this.au[0];
         }

         if (this.ap[2] > 1) {
            this.ap[2] = 101 - this.au[2];
         }
      }

      if (this.an) {
         quyen_by var8 = (quyen_by)this.ao.elementAt(0);
         if (var1[17] && var8.a != null) {
            var8.a.b.a();
            this.f();
         }

         if (var1[18] && var8.c != null) {
            var8.c.b.a();
            this.f();
         }

         if (var1[16] && var8.b != null) {
            var8.b.b.a();
            this.f();
         }

         quyen_n.b();
      }

      if (this.ay) {
         if (var23 || var2[12]) {
            quyen_ci var27;
            (var27 = (quyen_ci)this.az.lastElement()).c--;
            if (var27.c < 0) {
               var27.c = var27.a.size() - 1;
            }
         } else if (var7 || var2[13]) {
            quyen_ci var26;
            (var26 = (quyen_ci)this.az.lastElement()).c++;
            if (var26.c > var26.a.size() - 1) {
               var26.c = 0;
            }
         } else if (var14) {
            this.f(false);
         } else if (var20) {
            quyen_ci var25;
            quyen_bw var29;
            if ((var29 = (quyen_bw)(var25 = (quyen_ci)this.az.lastElement()).a.elementAt(var25.c)).c != null) {
               this.a(var29.c, -1);
            }
         } else if (var1[16] || var1[17]) {
            quyen_bw var9;
            quyen_ci var24;
            if ((var9 = (quyen_bw)(var24 = (quyen_ci)this.az.lastElement()).a.elementAt(var24.c)).c == null) {
               if (var9.b != null) {
                  var9.b.a();
                  this.f(true);
               }
            } else {
               this.a(var9.c, -1);
            }
         } else if (var1[18]) {
            this.f(true);
         }

         quyen_n.b();
      }

      if (this.aE) {
         if (var1[17] || var1[16]) {
            this.aE = false;

            try {
               quyen_cj var28 = this.aV;
               if (this.aV == quyen_cz.O && quyen_cz.b) {
                  String var30 = quyen_bt.f[this.aG * 6 + this.aF];
                  if (quyen_cz.Y == 0) {
                     quyen_a.a(0, quyen_cz.d, quyen_ia.d, var30);
                  }
               }

               if (d(var28.v)) {
                  ((quyen_cs)var28.d(2)).d(quyen_bt.f[this.aG * 6 + this.aF]);
               } else if (var28 instanceof quyen_p) {
                  ((quyen_p)var28).c.d(quyen_bt.f[this.aG * 6 + this.aF]);
               } else {
                  quyen_hg var31;
                  (var31 = (quyen_hg)this.aV).d.d(quyen_bt.f[this.aG * 6 + this.aF]);
               }
            } catch (Exception var10) {
            }
         }

         if (var1[18]) {
            this.aE = false;
         }

         if (var23 || var2[12]) {
            this.g(true);
         }

         if (var7 || var2[13]) {
            this.aG++;
            if (this.aG > 6) {
               this.aG = 0;
               this.h(false);
            }
         }

         if (var14 || var2[14]) {
            this.aF--;
            if (this.aF < 0) {
               this.aF = 5;
               this.g(false);
            }
         }

         if (var20 || var2[15]) {
            this.h(true);
         }

         quyen_n.b();
      }

      this.aV.e = false;
      if (this.aV.a(var1, var2, var3)) {
         if (var14) {
            var1[14] = false;
            this.n();
            return;
         }

         if (var20) {
            var1[15] = false;
            this.m();
         }
      }
   }

   private void g(boolean var1) {
      this.aG--;
      if (this.aG < 0) {
         this.aG = 6;
         if (var1) {
            this.aF--;
            if (this.aF < 0) {
               this.aF = 5;
            }
         }
      }
   }

   private void h(boolean var1) {
      this.aF++;
      if (this.aF > 5) {
         this.aF = 0;
         if (var1) {
            this.aG++;
            if (this.aG > 6) {
               this.aG = 0;
            }
         }
      }
   }

   public final void m() {
      if (this.aW > 1) {
         this.al++;
         if (this.al >= this.aW) {
            this.al = 0;
         }

         this.L();
         this.aV.b(1);
      }
   }

   public final void n() {
      if (this.aW > 1) {
         this.al--;
         if (this.al < 0) {
            this.al = this.aW - 1;
         }

         this.L();
         this.aV.b(-1);
      }
   }

   private void e(int var1) {
      if (var1 >= 0) {
         this.al = var1;
         this.L();
      }
   }

   public final void o() {
      this.e(this.aW - 1);
   }

   public final void f(String var1) {
      int var2 = this.aW;

      do {
         var2--;
      } while (var2 >= 0 && !((quyen_cj)this.aa.elementAt(var2)).j.equals(var1));

      this.al = var2;
      this.L();
   }

   public final void e(quyen_cj var1) {
      if (var1 == null) {
         this.e(0);
      } else {
         int var2 = this.aW;

         do {
            var2--;
         } while (var2 >= 0 && !((quyen_cj)this.aa.elementAt(var2)).equals(var1));

         if (var2 == -1) {
            this.e(0);
         } else {
            this.al = var2;
            this.L();
         }
      }
   }

   public final boolean f(quyen_cj var1) {
      int var2 = this.aW;

      while (--var2 >= 0) {
         if (((quyen_cj)this.aa.elementAt(var2)).equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public static int a(byte var0, byte var1, byte var2, byte var3) {
      return var0 << 24 & 0xFF000000 | var1 << 16 & 0xFF0000 | var2 << 8 & 0xFF00 | var3 & 0xFF;
   }

   private static byte[] f(int var0) {
      byte[] var1;
      (var1 = new byte[4])[0] = (byte)(var0 >> 24);
      var1[1] = (byte)(var0 >> 16 & 0xFF);
      var1[2] = (byte)(var0 >> 8 & 0xFF);
      var1[3] = (byte)var0;
      return var1;
   }

   private static void a(ByteArrayOutputStream var0, String var1) throws IOException {
      var0.write(var1.getBytes());
      var0.write(bd);
   }

   private static void a(ByteArrayOutputStream var0, int var1) throws IOException {
      var0.write(f(var1));
   }

   private static int a(ByteArrayInputStream var0) {
      return a((byte)var0.read(), (byte)var0.read(), (byte)var0.read(), (byte)var0.read());
   }

   private static byte[] c(long var0) {
      byte[] var2;
      (var2 = new byte[8])[0] = (byte)((int)(255L & var0 >> 56));
      var2[1] = (byte)((int)(255L & var0 >> 48));
      var2[2] = (byte)((int)(255L & var0 >> 40));
      var2[3] = (byte)((int)(255L & var0 >> 32));
      var2[4] = (byte)((int)(255L & var0 >> 24));
      var2[5] = (byte)((int)(255L & var0 >> 16));
      var2[6] = (byte)((int)(255L & var0 >> 8));
      var2[7] = (byte)((int)(255L & var0));
      return var2;
   }

   public static long a(byte[] var0) {
      return (long)(var0[0] & 255) << 56
             | (long)(var0[1] & 255) << 48
             | (long)(var0[2] & 255) << 40
             | (long)(var0[3] & 255) << 32
             | (long)(var0[4] & 255) << 24
             | (long)(var0[5] & 255) << 16
             | (long)(var0[6] & 255) << 8
             | (long)(var0[7] & 255);
   }

   private static void a(ByteArrayOutputStream var0, long var1) throws IOException {
      var0.write(c(var1));
   }

   private static long b(ByteArrayInputStream var0) {
      byte[] var1 = new byte[8];

      for (byte var2 = 0; var2 < 8; var2++) {
         var1[var2] = (byte)var0.read();
      }

      return a(var1);
   }

   private static String c(ByteArrayInputStream var0) {
      String var1 = "";

      int var2;
      while ((var2 = var0.read()) != 0) {
         var1 = var1 + (char)((byte)var2);
      }

      return var1;
   }

   public static long g(String var0) {
      return Xuka.h("xkmyid" + var0);
   }

   private static void b(int var0, boolean var1) {
      Xuka.a(var1 ? "yahoocs" : "xubics" + quyen_ia.d, f(var0), "xkown");
   }

   public static int a(boolean var0) {
      return Xuka.b(var0 ? "yahoocs" : "xubics" + quyen_ia.d, "xkown");
   }

   public static boolean a(quyen_bb var0, boolean var1, String var2) {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      Vector var9 = var0.a;

      try {
         a(var3, var9.size());

         for (int var4 = 0; var4 < var9.size(); var4++) {
            quyen_bd var5 = (quyen_bd)var9.elementAt(var4);
            a(var3, var5.a());
            Vector var10 = var5.a;
            a(var3, var10.size());

            for (int var6 = 0; var6 < var10.size(); var6++) {
               quyen_ba var7 = (quyen_ba)var10.elementAt(var6);
               a(var3, var7.a);
               a(var3, var7.b);
               a(var3, var7.k);
               if (!var1) {
                  a(var3, var7.l);
               }
            }
         }

         Xuka.a((var1 ? "ybuddy" : "vbuddy") + var2, var3.toByteArray(), "xkown");
         return true;
      } catch (Exception var8) {
         return false;
      }
   }

   public static quyen_bb a(boolean var0, String var1) {
      byte[] var10;
      if ((var10 = Xuka.a((var0 ? "ybuddy" : "vbuddy") + var1, "xkown")) == null) {
         return null;
      } else {
         ByteArrayInputStream var11 = new ByteArrayInputStream(var10);
         quyen_bb var2 = new quyen_bb();

         try {
            var2.a = new Vector();
            int var3 = a(var11);

            for (int var4 = 0; var4 < var3; var4++) {
               String var5 = c(var11);
               quyen_bd var12;
               (var12 = new quyen_bd(var5)).a = new Vector();
               int var6 = a(var11);

               for (int var7 = 0; var7 < var6; var7++) {
                  quyen_ba var8;
                  (var8 = new quyen_ba()).a = c(var11);
                  var8.b = c(var11);
                  var8.k = a(var11);
                  if (!var0) {
                     var8.l = b(var11);
                  }

                  var12.a(var8);
               }

               var2.a.addElement(var12);
            }

            return var2;
         } catch (Exception var9) {
            return null;
         }
      }
   }

   public static boolean a(Hashtable var0) {
      if (var0.size() == 0) {
         return false;
      } else {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();

         try {
            a(var1, var0.size());
            Enumeration var2 = var0.keys();

            while (var2.hasMoreElements()) {
               Long var3 = (Long)var2.nextElement();
               a(var1, var3.longValue());
               a(var1, (String)var0.get(var3));
            }

            Xuka.a("userstorage", var1.toByteArray(), "xkown");
            return true;
         } catch (Exception var4) {
            return false;
         }
      }
   }

   public static Hashtable p() {
      byte[] var0;
      if ((var0 = Xuka.a("userstorage", "xkown")) == null) {
         return null;
      } else {
         ByteArrayInputStream var4 = new ByteArrayInputStream(var0);
         Hashtable var1 = new Hashtable();

         try {
            int var2 = a(var4);

            while (--var2 >= 0) {
               var1.put(new Long(b(var4)), c(var4));
            }

            return var1;
         } catch (Exception var3) {
            return null;
         }
      }
   }

   public final void a(String var1, String var2, String var3) {
      String var4 = "Y! " + var1;
      quyen_hg var5;
      if ((var5 = (quyen_hg)this.e(var4)) == null) {
         (var5 = new quyen_hg(var4, true, null, var1)).b = var1;
         this.a(var5);
      }

      if (!var5.j.equals(this.aV.j)) {
         String var8 = quyen_bt.b(var2, quyen_n.j - quyen_n.j / 3);
         this.a(var1 + " chat: " + var8 + "...", (Image) null, 1);
         var5.w = true;
         this.d();
      }

      var5.c.a(var1 + " (" + var3 + ")", var2, 1);
      var5.c.b();
      var5.e = true;
   }

   public final void a(String var1, String var2) {
      String var3 = "Y! " + var1;
      quyen_hg var4;
      if ((var4 = (quyen_hg)this.e(var3)) == null) {
         (var4 = new quyen_hg(var3, true, null, var1)).b = var1;
         this.a(var4);
      }

      if (!var4.j.equals(this.aV.j)) {
         var3 = quyen_bt.b(var2, quyen_n.j - quyen_n.j / 3);
         this.a(var1 + " chat: " + var3 + "...", (Image) null, 1);
         var4.w = true;
         this.d();
      }

      boolean var6 = var4.c.a();
      var4.c.a(var1, var2, 1);
      if (var6) {
         var4.c.b();
      }

      var4.e = true;
   }

   public final void q() {
      this.f();
      this.d("Lỗi đăng ký. Vui lòng chọn tên khác.");
   }

   public final void r() {
      this.f();
      this.a("Đăng ký thành công", (Image) null, 0);
      this.j.a.c(this.am.d);
      this.j.b.c(this.am.c);
      Xuka.e(this.am.d);
      Xuka.b(this.am.c);
      this.a((quyen_cj)this.j);
      quyen_hr.a(this.j, (quyen_bx)this.j.a);
      this.c(this.am);
      this.am = null;
      System.gc();
   }

   public final void s() {
      this.f();
      this.d("Sai tên hoặc mật khẩu.");
   }

   public final void t() {
      boolean var2 = false;
      this.H = var2;
      this.f();
      if (O) {
         Xuka.i.a("0084969728701");
         O = false;
      } else {
         if (quyen_n.i == 1) {
            this.a("Lỗi kết nối\nVui lòng kiểm tra kết nối internet", null, null, this.b(quyen_cr.c()));
         }
      }
   }

   public final void a(String var1, String var2, int var3) {
      var2 = quyen_hs.b(var2);

      try {
         this.i.a.a(var1, var2, 1);
      } catch (Exception var4) {
      }
   }

   public final void a(String var1, int var2, int var3) {
      String var11 = var2 == 1 ? " đã đăng nhập" : " đã thoát";
      if (this.i != null) {
         try {
            boolean var4;
            if ((var4 = this.i.a.a(var1, var2)) || !var4 && this.i.a.b) {
               byte var5 = 2;
               int var9 = this.aV instanceof quyen_hg ? 2 : 0;
               this.a(var5 == 1 ? var1 + var11 : "Y! " + var1 + var11, var2 == 1 ? u[1] : u[0], var9);
            }

            quyen_hg var12;
            if ((var12 = (quyen_hg)this.e("Y! " + var1)) != null) {
               var12.c.a(var1 + var11, var2 == 1 ? 1 : 2);
               var12.c.b();
               return;
            }
         } catch (Exception var10) {
         }
      }
   }

   public final void h(String var1) {
      this.d(var1);
   }

   public final void u() {
      boolean var2 = false;
      this.H = var2;
      this.f();
      O = false;
      this.a("Mất kết nối\nVui lòng thoát và đăng nhập lại", new quyen_bw("Thoát", new quyen_gk(this)), null, this.b(quyen_cr.c()));
   }

   public final void i(String var1) {
      this.d("Lỗi thêm bạn " + var1);
   }

   public final void v() {
      this.i.E = false;
      this.i.a(false);
      this.be++;
      if (this.w()) {
         this.d("Tài khoản Yahoo của bạn bị khóa. Vui lòng đăng nhập lại sau.");
         this.bg = true;
      } else {
         this.a("Mất kết nối Yahoo!", (Image) null, 0);
      }
   }

   public final boolean w() {
      return this.be > 3;
   }

   public final void x() {
      this.be = 0;
      this.bf = 0;
      this.bg = false;
   }

   public final void j(String var1) {
      this.a(var1, "BUZZ!");
      this.d();
   }

   public final quyen_cj y() {
      return this.aV;
   }

   public final void a(long var1) {
      this.c(var1, "BUZZ!");
      if (!this.h.b(var1)) {
         this.d();
      }
   }

   public final void a(int var1, String var2) {
      this.a("Cập nhật phiên bản mới X Yahoo!: " + Xuka.a(var1), new quyen_bw("Tải về", new quyen_gl(this, var2)), null, this.b(quyen_cr.c()));
   }

   public final String z() {
      return this.X == null ? Y : this.X;
   }

   public final String A() {
      return this.W == null ? Y : this.W;
   }

   public final void b(String var1, String var2, String var3) {
      this.X = var2;
      quyen_gm var4 = new quyen_gm(this);
      quyen_gn var5 = new quyen_gn(this, var3, var4);
      String var7 = var3 + Xuka.f;
      this.a(
              quyen_bt.c(var1 + "Gửi tin: " + var7 + "\nĐến số: " + var2.substring(6), quyen_n.j - 30),
              new quyen_bw("OK", var5),
              null,
              new quyen_bw(quyen_cr.c(), var4)
      );
   }

   public final void b(String var1, String var2) {
      this.W = var1;
      J = var2;
      if (this.j != null) {
         this.j.h();
      }
   }

   public final void B() {
      if (this.h == null) {
         this.h = new quyen_ia();
         this.h.v = 11113;
      }

      this.h.b(1);
   }

   private void O() {
      if (this.i == null) {
         this.i = new quyen_jc();
         this.i.a(false);
      }

      this.i.b(1);
   }

   private void P() {
      String var1 = Xuka.d();
      String var2 = Xuka.e();
      if (var1 != null && var1.length() > 0 && var2 != null && var2.length() > 0) {
         this.O();
         this.i.a(false);
         this.a(this.i);
         this.i.g();
      }
   }

   public static void C() {
   }

   public final void a(int var1, boolean var2) {
      if (var1 == 11112) {
         this.O();
         if (!this.f(this.i)) {
            this.a(this.i);
         }

         this.e(this.i);
      } else {
         if (var1 == 11113) {
            this.B();
            if (!this.f(this.h)) {
               if (this.h.b.e != null) {
                  this.h.b.c = false;
               }

               if (this.h.J.size() > 0) {
                  long[] var6 = quyen_ia.b(this.h.J);
                  quyen_ju var3 = new quyen_ju(5000029, 2);
                  quyen_a.a(var6.length, var3);
                  int var4 = 0;

                  for (int var5 = var6.length; var4 < var5; var4++) {
                     quyen_a.a(var6[var4], var3);
                  }

                  quyen_jv.a(var3);
               } else {
                  quyen_jv.a(new quyen_ju(5000036, 2));
               }

               this.a(this.h);
               this.e(this.h);
               return;
            }

            this.e(this.h);
         } else if (var1 == 11114) {
            if (T == null || !this.f(T)) {
               quyen_a.d();
               return;
            }

            T.b(1);
            this.e(T);
         } else {
            quyen_cj var8;
            if ((var8 = this.b(var1)) != null) {
               var8.b(1);
               this.e(var8);
               return;
            }

            boolean var9 = true;
            this.H = var9;
            if (var2) {
               quyen_ju var7 = new quyen_ju(122, 2);
               quyen_a.a(var1, var7);
               quyen_jv.a(var7);
               return;
            }

            quyen_a.a(var1);
         }
      }
   }

   public final quyen_cj b(int var1) {
      int var2 = this.aW;

      while (--var2 >= 0) {
         quyen_cj var3;
         if ((var3 = (quyen_cj)this.aa.elementAt(var2)).v == var1) {
            return var3;
         }
      }

      return null;
   }

   public final void a(quyen_co var1) {
      this.f();
      this.N = var1;
      if (this.bj == null) {
         D();
         quyen_bw var2 = new quyen_bw("Cấu hình", new quyen_ey(this));
         quyen_bw var3 = new quyen_bw("Gửi góp ý", new quyen_ez(this));
         quyen_bw var4 = new quyen_bw("Trạng thái", new quyen_fb(this));
         quyen_bw var5 = new quyen_bw("Thoát", new quyen_fc(this));
         Vector var6;
         (var6 = new Vector()).addElement(Q);
         var6.addElement(var3);
         var6.addElement(P);
         var6.addElement(R);
         (var3 = new quyen_bw("Hỗ trợ", null)).c = new quyen_ci(var6);
         (var6 = new Vector()).addElement(var2);
         var6.addElement(var3);
         var6.addElement(var5);
         this.bj = new quyen_ci(var6);
         Vector var8;
         (var8 = new Vector()).addElement(var4);
         var8.addElement(this.h.g());
         var8.addElement(new quyen_bw("Tải về", new quyen_fe(this)));
         this.bk = new quyen_ci(var8);
      }

      this.N.m = new quyen_bw("Menu", new quyen_fg(this));
      this.N.n = new quyen_bw("Quản lý", new quyen_fh(this));
      this.c(this.j);
      this.j = null;
      boolean var7 = false;
      if (M && L != 0 && L == 1 && o) {
         this.P();
         var7 = true;
      }

      if (M && o && !var7) {
         this.P();
      }

      quyen_cp.b();
   }

   public static quyen_bw D() {
      if (bh == null) {
         bh = new quyen_bw("", new quyen_ex());
      }

      return bh;
   }

   public final void a(quyen_bw var1, int var2) {
      if (this.bj != null) {
         this.bj.a.setElementAt(var1, var2);
      }
   }

   public final void k(String var1) {
      StringBuffer var2;
      (var2 = new StringBuffer("X Yahoo!")).append(" - ");
      var2.append(b);
      var2.append("\n");
      var2.append("Build ID: ");
      var2.append(Xuka.g);
      var2.append("\n");
      var2.append(var1);
      this.d(var2.toString());
      System.gc();
   }

   public static void l(String var0) {
      Xuka.i.a(var0);
   }

   public static void c(int var0) {
      b(var0, true);
   }

   public final void E() {
      this.x();
      if (quyen_jc.d == 0 && quyen_jc.A != null && quyen_jc.A.length() > 0) {
         quyen_a.c(quyen_jc.A, 2);
      }

      this.i.E = true;
      if (Xuka.f(quyen_jc.b) == 0) {
         this.i.i();
      }
   }

   public final void a(quyen_bb var1) {
      a(var1, true, quyen_jc.b);
      this.i.a.a(var1, -1);
      this.i.e = true;
      this.i.a.c = false;
   }

   public final void b(String var1, int var2) {
      var1 = quyen_hr.a("Y! ", var1, var2 == 0 ? " từ chối" : " đồng ý", " bạn thêm vào danh sách bạn bè");
      if (var2 == 0) {
         this.d(var1);
      } else {
         this.a(var1, (Image) null, 1);
      }

      System.gc();
   }

   public final void a(String var1, long var2, boolean var4) {
      if (var4) {
         if (this.i == null || this.i.a.c) {
            return;
         }
      } else if (var2 == 0L) {
         return;
      }

      quyen_co var5;
      (var5 = new quyen_co()).w = true;
      var5.j = "Thêm bạn";
      quyen_bw.a(var5, quyen_hr.a(var1, " thêm bạn vào danh sách. Bạn có đồng ý?", null, null));
      if (var4) {
         quyen_cs var6 = quyen_bw.a(var5, "Vào nhóm mới:", 0);
         quyen_bv var7;
         (var7 = quyen_bw.a(var5, "hoặc đã có:", this.i.a.f())).a(new quyen_fi(this, var7, var6));
         if (var7.b != null && var7.b.length != 0) {
            var6.c(var7.b());
         } else {
            var6.c("Friends");
         }

         var5.m = new quyen_bw(quyen_cr.e(), new quyen_fj(this, var1, var6, var5));
         var5.o = new quyen_bw("OK", new quyen_fk(this, var6, var1, var5));
      } else {
         var5.m = new quyen_bw(quyen_cr.e(), new quyen_fl(this, var2, var5));
         var5.o = new quyen_bw("OK", new quyen_fm(this, var2, var5));
      }

      var5.n = new quyen_bw(quyen_cr.c(), new quyen_fn(this, var4, var2, var5));
      quyen_hr.a(var5, (quyen_bx)var5.l.elementAt(0));
      this.g(var5);
   }

   public final void b(boolean var1) {
      if (var1) {
         this.d("Đã đổi thành công.");
      } else {
         this.d("Sai mật khẩu cũ.");
      }
   }

   public static boolean d(int var0) {
      return var0 == 2000 || var0 == 2002 || var0 == 2003 || var0 == 2001;
   }

   public final void a(int var1, String var2, byte[] var3, int var4, int var5, String var6) {
      this.bc = 0;

      try {
         if (var1 == 0) {
            if (var4 <= 0) {
               var4 = 1;
            }

            quyen_a var8 = new quyen_a(var1, var2, var3, (long)(var4 * 25), (long)var5, var6, true);
            this.Z.addElement(var8);
            return;
         }

         if (var1 != 1) {
            if (var1 == 2) {
               K = var2;
               if (var6 != null && var6.length() > 0) {
                  K = K + " " + var6;
                  System.gc();
                  return;
               }
            } else if (var1 == 3) {
               this.aA = true;
               this.aB = Image.createImage(var3, 0, var3.length);
               this.aC = quyen_bt.c(var2, quyen_n.j - 50);
               this.aD = var4 * 25;
               return;
            }
         }
      } catch (Exception var7) {
      }
   }

   public static void a(String[] var0, int[] var1) {
      Xuka.a(var0);
      Xuka.a(var1);
      if (!Xuka.b("report", false)) {
         Xuka.a("report", true);
         if (Xuka.j == null) {
            Xuka.j = "null";
         }

         quyen_a.a(0, Xuka.j, quyen_n.k, Xuka.a);
      }

      quyen_a.e();
   }

   public final void b(byte[] var1) {
      this.c(var1);
   }

   public static void F() {
      O = false;
   }

   public final void c(boolean var1) {
      this.H = var1;
   }

   public static void a(Integer var0, byte[] var1) {
      quyen_ea.a(var0, var1);
   }

   public final void a(long var1, int[] var3) {
      if (var1 == quyen_ia.A) {
         quyen_ia.a = var3;
      }

      this.h.a(var1, var3);
   }

   public final void c(String var1, int var2) {
      this.f();
      if (var2 < 0) {
         this.G();
         this.d("Lỗi gửi file");
      } else {
         if (this.bn) {
            this.bl = var1 == null ? "" : var1;
            this.bn = true;
            this.bo = 0;
            this.bp = 0;
            if (this.bm < 1024) {
               this.bm = 5120;
            }

            this.Q();
         }
      }
   }

   public final void d(boolean var1) {
      if (var1) {
         this.Q();
      } else {
         this.G();
         this.d("Lỗi gửi file");
      }
   }

   public final void a(String var1, byte[] var2, byte var3) {
      this.bq = var1;
      this.br = var2;
      this.bs = var3;
   }

   public static void a(byte[] var0, String var1, boolean var2, int var3) {
      quyen_ht var4 = quyen_ht.a();
      if (var2) {
         var4.c();
      } else {
         var4.b();
      }

      var4.a(var3);
      var4.a(var0, var1);
   }

   public final void a(byte[] var1, String var2, boolean var3, quyen_go var4) {
      if (var3) {
         var4.f(1);
      } else {
         var4.a();
      }

      var4.a(var1);
      var4.a(var2);
      var4.b(1);
      this.a(var4);
      this.e(var4);
   }

   private void Q() {
      try {
         if (this.bn && this.br != null) {
            if (this.bo < this.br.length - this.bm) {
               quyen_a.a(c.bl, this.br, this.bo, this.bm, false);
               this.bo = this.bo + this.bm;
               this.bp = 100 * this.bo / this.br.length;
               if (this.bo >= this.br.length) {
                  this.H();
               }
            } else {
               quyen_a.a(c.bl, this.br, this.bo, this.br.length - this.bo, true);
               this.H();
               this.bp = 100;
            }

            this.a(quyen_hr.a(quyen_cr.a(), Integer.toString(this.bp), "%", null), (Image) null, 0);
            this.av[2] = c.at[2];
            return;
         }
      } catch (Exception var1) {
      }
   }

   public final void G() {
      this.bn = false;
      this.bo = 0;
      this.bp = 0;
   }

   public final void H() {
      this.G();
      quyen_bn.a = null;
      this.bq = null;
      this.br = null;
      if (this.bs == 0) {
         if (this.S != null) {
            this.S.b = null;
            this.d(this.S);
         }
      } else if (this.bs == 1 && quyen_hy.a != null) {
         quyen_hy.a.b();
      }

      System.gc();
   }

   public final void a(int var1, quyen_ca var2, quyen_ca var3) {
      this.a(
              quyen_hr.a(quyen_bn.a().a(false), " có kích thước ", Integer.toString(var1 / 1000), " KBs. Bạn có muốn tiếp tục?"),
              new quyen_bw("Gửi", new quyen_fs(this, var3)),
              new quyen_bw("Mở", new quyen_ft(this, var2)),
              new quyen_bw(quyen_cr.c(), new quyen_fu(this))
      );
   }

   public final void e(boolean var1) {
      new Thread(new quyen_fy(this, var1)).start();
   }

   public final void I() {
      if (!this.bn) {
         this.bn = true;
         quyen_a.a(this.br.length, this.bs, this.bq);
         this.a("Đang gửi file..", (Image) null, 2);
      } else {
         this.a("Đang gửi file khác.\nBạn có muốn hủy bỏ file đang gửi?", new quyen_bw("Hủy bỏ", new quyen_fz(this)), null, this.b(quyen_cr.c()));
      }
   }

   public static quyen_bw a(quyen_cj var0, boolean var1, quyen_ca var2) {
      Object var3;
      if (var1) {
         var3 = new quyen_ga(var2, var0);
      } else {
         var3 = new quyen_gc(var0);
      }

      return new quyen_bw(quyen_cr.c(), (quyen_ca)var3);
   }

   public final void a(byte var1, byte var2) {
      if (this.S == null) {
         this.S = new quyen_go();
         this.S.e(0);
      }

      this.bs = var2;
      if (var1 == 1) {
         quyen_et var6 = this;

         try {
            quyen_bk var7 = quyen_bk.a();
            quyen_bn var3;
            (var3 = quyen_bn.a()).a(2);
            var3.c = new quyen_fv(var6, var3, var7);
            var3.a("Chọn file", -1);
         } catch (ClassNotFoundException var4) {
            a();
            c.d("Điện thoại không hỗ trợ chức năng này");
         } catch (Exception var5) {
            a();
            return;
         }
      } else if (var1 == 0) {
         if (var2 == 0) {
            quyen_l.a().a = new quyen_fr(this);
            quyen_l.a().a(0);
            return;
         }

         if (var2 == 1) {
            quyen_l.a().a = new quyen_fo(this);
            quyen_l.a().b = new quyen_fp(this);
            quyen_l.a().a(1);
         }
      }
   }

   public final void a(String var1, byte[] var2) {
      if (this.bu != null) {
         int var3 = this.bu.a.c.size();

         while (--var3 >= 0) {
            quyen_bj var4;
            quyen_ba var5;
            if ((var5 = (var4 = (quyen_bj)this.bu.a.c.elementAt(var3)).i).a.equals(var1)) {
               var5.j = var2;
               var5.g = true;
               var4.e = quyen_hr.a(Integer.toString(var5.c), " KBs", null, null);
               if (this.bt) {
                  this.a(quyen_hr.a("Đã tải xong ", var5.h, null, null), (Image) null, 1);
               } else {
                  this.bt = true;
                  this.a(quyen_hr.a("Đã tải xong ", var5.h, ". Vào Quản lý > Tải về. ", null), (Image) null, 1);
               }
            }
         }

         this.a(this.bu);
      }

      System.gc();
   }

   private void R() {
      this.bu.b(1);
      this.a(this.bu);
   }

   public final void a(String var1, String var2, int var3, byte var4) {
      String var5 = quyen_hr.a("Đang tải về ", var2, null, null);
      if (this.bu == null) {
         this.bu = new quyen_be();
         this.R();
         this.e(this.bu);
         this.a(quyen_hr.a(var5, ". Vào Quản lý > Tải về. ", "Bạn có thể lưu vào thẻ nhớ.", null), (Image) null, 1);
      } else {
         this.R();
         this.a(var5, (Image) null, 1);
      }

      this.bu.a(var4);
      if (var4 == 0) {
         var5 = quyen_hr.a("Hình", " ", var2, null);
      } else {
         var5 = quyen_hr.a("Video", " ", var2, null);
      }

      quyen_ba var6;
      (var6 = new quyen_ba(var1, var5, var3, null, null, -1, -1, null)).e = var4;
      var6.f = quyen_hr.a("Đang tải - ", Integer.toString(var3), " KBs", null);
      var6.h = var2;
      this.bu.b.b("", var6);
      this.bu.a.b();
   }

   public static void a(
           String var0,
           String var1,
           int var2,
           byte[] var3,
           int var4,
           String[] var5,
           int[] var6,
           long[] var7,
           long[] var8,
           byte[][] var9,
           boolean[] var10,
           quyen_bc[] var11
   ) {
      if (quyen_cz.d.equals(var0)) {
         quyen_cz.O.a(true, true);
         quyen_cz.O.a(var1, var2, var3, null, false);
         quyen_cz.O.I = var10;
         quyen_cz.O.a(var0, (byte)var5.length, var5, var7, var8, (byte)var5.length, var5, var9, var6, var11);
      }
   }

   public static void a(String var0, String var1, byte var2, String[] var3, int[] var4, long[] var5, long[] var6, byte[][] var7, quyen_bc[] var8) {
      if (quyen_cz.d.equals(var0)) {
         quyen_cz.O.a(true, true);
         quyen_cz.O.I = new boolean[var3.length];

         for (int var9 = 0; var9 < var3.length; var9++) {
            quyen_cz.O.I[var9] = false;
            if (var3[var9].equals(quyen_ia.d)) {
               for (int var10 = 0; var10 < var3.length; var10++) {
                  if (quyen_cz.O.C[var10].a.equals(var3[var9])) {
                     quyen_cz.O.C[var10].e = var7[var9];
                     quyen_cz.O.a(var7[var9], var1, false, false);
                     break;
                  }
               }
            }
         }

         quyen_cz.O.a(var0, var2, var3, var5, var6, var2, var3, var7, var4, var8);
         quyen_cz.O.i();
      }
   }

   public static void a(String var0, byte[] var1, String var2, boolean var3) {
      if (quyen_cz.d.equals(var0)) {
         quyen_cz.O.a(false, true);
         quyen_cz.O.B = true;
         quyen_cz.O.aa = true;
         quyen_cz.O.ab = null;
         quyen_cz.O.a(var1, var2, var3, true);
      }
   }

   public final void a(String var1, String var2, int var3, byte[] var4, String var5, boolean var6) {
      if (quyen_cz.d.equals(var1)) {
         p(var2);
         if (quyen_ia.d.equals(var2)) {
            quyen_cz.O.K.b(var4);
         }

         quyen_cz.O.a(var2, var3, var4, var5, var6);
      }
   }

   private static void p(String var0) {
      if (quyen_cz.O.ab == null) {
         quyen_cz.O.ab = var0;
      } else {
         if (!quyen_cz.O.ab.equals(var0)) {
            quyen_cz.O.aa = false;
         }
      }
   }

   public final void a(String var1, String var2, int var3, byte[] var4, String var5, boolean var6, int var7) {
      if (quyen_cz.d.equals(var1)) {
         p(var2);
         this.a(var1, var2, var3, var4, var5, var6);

         for (int var8 = 0; var8 < quyen_cz.O.C.length; var8++) {
            if (quyen_cz.O.C[var8].a.equals(var2)) {
               quyen_cz.O.C[var8].v = var7;
               quyen_cz.O.C[var8].d = true;
               if (var2.equals(quyen_ia.d)) {
                  quyen_cz.O.c = true;
               }
            }
         }
      }
   }

   public static void J() {
      if (quyen_cz.O != null && quyen_cz.O.K != null) {
         quyen_cz.O.K.b();
      }
   }

   public final void a(String var1, String var2, String var3, String[] var4, String var5) {
      if (quyen_cz.O != null) {
         if (quyen_cz.d.equals(var1)) {
            if (var2.equals(quyen_ia.d)) {
               if (var5 != null && var5.length() > 0) {
                  this.a(var5, (Image) null, 1);
               }

               quyen_cz.O.g();
               quyen_cz.h();
               return;
            }

            if (quyen_cz.b && var4.length > 0) {
               quyen_cz.O.C = a(var4);
               quyen_cz.O.a = var3;
               long[] var7 = new long[var4.length];
               int[] var8 = new int[var4.length];
               quyen_cz.O.J = new boolean[var4.length];

               for (int var6 = 0; var6 < var4.length; var6++) {
                  var7[var6] = quyen_cz.O.C[var6].a();
                  var8[var6] = quyen_cz.O.C[var6].A.intValue();
                  quyen_cz.O.J[var6] = quyen_cz.O.C[var6].b();
                  if (var4[var6].equals(var3)) {
                     quyen_cz.O.a(var2);
                  }
               }

               quyen_cz.O.a((byte)var4.length, var4, var7, var8);
            }
         }
      }
   }

   public static void a(String var0, String var1, String var2, boolean var3) {
      if (quyen_cz.d.equals(var0) && quyen_cz.O != null) {
         quyen_cz.O.a(var1, var2, var3);
      }
   }

   public final void a(String var1, long var2, String[] var4, long[] var5, int[] var6, boolean[] var7, String var8) {
      quyen_cz var9 = quyen_cz.O;
      if (quyen_cz.O != null) {
         if (quyen_cz.b) {
            if (!quyen_cz.d.equals(var1)) {
               return;
            }

            if (!(this.aV instanceof quyen_cz)) {
               this.a("Có người chơi vào bàn", (Image) null, 2);
            }
         }

         quyen_cz.d = var1;
         var9.T = true;
         var9.U = var4.length;
         var9.V = var4;
         var9.W = var5;
         var9.X = var6;
         var9.a = var8;
         var9.J = new boolean[var4.length];
         if (var9.S) {
            var9.H = (byte)var4.length;
            var9.a(var2);
            var9.D = new String[var4.length];

            for (byte var10 = 0; var10 < var4.length; var10++) {
               var9.D[var10] = var4[var10];
               var9.X[var10] = var6[var10];
               var9.J[var10] = var7[var10];
               if (!quyen_cz.b) {
                  var9.b(1);
               }
            }

            System.gc();
            var9.a((byte)var4.length, var4, var5, var6);
         }
      }
   }

   public static void a(String var0, String[] var1, boolean[] var2) {
      if (quyen_cz.d.equals(var0)) {
         for (byte var4 = 0; var4 < quyen_cz.O.C.length; var4++) {
            for (int var3 = 0; var3 < var1.length; var3++) {
               if (quyen_cz.O.C[var4].a.equals(var1[var3])) {
                  quyen_cz.O.J[var4] = var2[var3];
                  quyen_cz.O.C[var4].a(var2[var3]);
                  if (quyen_ia.d.equals(var1[var3]) && !var2[var3] && !quyen_ia.d.equals(quyen_cz.O.a) && quyen_cz.O.o != null) {
                     quyen_cz.O.o.a = "Sẵn sàng";
                  }
               }
            }
         }
      }
   }

   public static quyen_dz[] a(String[] var0) {
      quyen_dz[] var1 = new quyen_dz[var0.length];

      for (byte var2 = 0; var2 < var0.length; var2++) {
         for (byte var3 = 0; var3 < quyen_cz.O.C.length; var3++) {
            if (var0[var2].equals(quyen_cz.O.C[var3].a)) {
               var1[var2] = quyen_cz.O.C[var3];
            }
         }
      }

      return var1;
   }

   public static void b(String var0, String var1, String var2, boolean var3) {
      if (quyen_cz.d.equals(var0)) {
         quyen_cz.O.b(var1, var2, var3);
      }
   }

   public final void b(long var1) {
      this.a(quyen_hr.a("Số tiền của bạn: ", Long.toString(var1), " ", "xu"), (Image) null, 1);
   }

   public static void a(String var0, String var1, String var2, int var3) {
      if (quyen_cz.d.equals(var0)) {
         quyen_dz[] var6 = null;
         if (var3 == 39) {
            var6 = quyen_cz.O.C;
         }

         if (var2.length() < 5 && (var3 = quyen_bt.a(var2)) != 100 && var6 != null) {
            int var4 = 0;

            for (int var5 = var6.length; var4 < var5; var4++) {
               if (var6[var4].a.equals(var1)) {
                  var6[var4].x = true;
                  var6[var4].z = var3;
                  var6[var4].y = (byte)((int)(System.currentTimeMillis() / 1000L));
                  System.gc();
                  return;
               }
            }
         }

         if (var6 != null) {
            var3 = 0;

            for (int var9 = var6.length; var3 < var9; var3++) {
               if (var6[var3].a.equals(var1)) {
                  var6[var3].a(var2);
                  System.gc();
                  return;
               }
            }
         }
      }
   }

   public final void a(String var1, quyen_cv[] var2, int var3, String var4) {
      quyen_cz.Z = var1;
      quyen_cz.a().M = var4;
      quyen_cz.O.a(var2, 0);
      if (!this.aV.equals(quyen_cz.O)) {
         quyen_cz.O.b(1);
      }

      this.a(quyen_cz.O);
      this.e(quyen_cz.O);
   }

   private static String c(int var0, boolean var1) {
      StringBuffer var2;
      (var2 = new StringBuffer(var1 ? "cs" : "dt")).append(var0);
      return var2.toString();
   }

   private void c(byte[] var1) {
      new Thread(new quyen_gf(this, var1)).start();
   }

   public final void b(int var1, int var2) {
      byte[] var4;
      if (Xuka.b(c(var1, true), "xkcsp") == var2 && (var4 = Xuka.a(c(var1, false), "xkcsp")) != null) {
         this.c(var4);
      } else {
         quyen_a.a(var1);
      }
   }

   public final void a(int var1, int var2, byte[] var3) {
      this.c(var3);
      Xuka.a(c(var1, true), f(var2), "xkcsp");
      Xuka.a(c(var1, false), var3, "xkcsp");
   }

   public final void b(quyen_bb var1) {
      if (T == null) {
         (T = new quyen_gz()).a.d = new quyen_gd(this);
         T.a.a.a = "Vào phòng";
         T.j = "Tiến Lên Miền Nam";
         T.b = 0;
         quyen_hr.b(T, T.j);
      }

      T.a.a(1, 10, 10);
      T.a.c(1);
      T.a.a(var1, 0, false);
      T.b(1);
      if (!this.f(T)) {
         this.a(T);
      }

      this.e(T);
   }

   public final void a(long var1, long[] var3, int var4) {
      if (this.h != null) {
         quyen_ia.A = var1;
         String var7 = quyen_ia.d;
         Xuka.a("xkmyid" + var7, c(var1), "xkown");
         if (var3 != null) {
            if (a(false) != var4) {
               b(var4, false);
               quyen_ia.a(var3, this.h.J);
               this.h.a(this.h.J);
               return;
            }
         } else {
            this.h.b.c = false;
            if (this.h.b.e != null) {
               this.h.b.e = null;
            }
         }
      }
   }

   public final void m(String var1) {
      if (this.h != null) {
         this.h.b.g = quyen_bt.c(var1, quyen_n.j - 30);
      }
   }

   public final void c(quyen_bb var1) {
      this.h.b.a(var1, -1);
      a(var1, false, quyen_ia.d);
      this.h.b.c = false;
   }

   public final void a(long[] var1, String[] var2) {
      if (this.h != null && var1 != null) {
         if (this.h.M) {
            Vector var7 = new Vector();
            int var8 = var1.length;

            while (--var8 >= 0) {
               if (!this.h.c(var1[var8]) && !this.h.b(var1[var8])) {
                  var7.addElement(new Long(var1[var8]));
               }
            }

            if (var7.size() > 0) {
               Long[] var9 = new Long[var7.size()];
               var7.copyInto(var9);
               var1 = new long[var7.size()];
               int var5 = var7.size();

               while (--var5 >= 0) {
                  var1[var5] = var9[var5].longValue();
               }
            }

            quyen_ia.a(var1, this.h.L);
            if (var1.length > 0) {
               int var6 = var1.length;
               this.a("Bạn có " + var6 + " lời mời kết bạn. Xin vào Quản lý => Chờ kết bạn", (Image) null, 1);
               this.h.j();
            }

            this.h.M = false;
            return;
         }

         int var3 = 0;

         for (int var4 = var1.length; var3 < var4; var3++) {
            if (!this.h.c(var1[var3]) && !this.h.b(var1[var3]) && !this.h.d(var1[var3])) {
               this.a(var2[var3], var1[var3], false);
               this.a(var2[var3] + " muốn kết bạn với bạn.", (Image) null, 1);
            }
         }
      }
   }

   public final void d(quyen_bb var1) {
      if (quyen_ia.I == 3) {
         this.h.c.a(var1, -1);
         this.h.c.c = false;
      }
   }

   public final void a(long[] var1) {
      if (this.h != null && var1 != null) {
         quyen_ia.a(var1, this.h.K);
      }
   }

   public final void e(quyen_bb var1) {
      if (quyen_ia.I == 2) {
         this.h.c.a(var1, -1);
         this.h.c.c = false;
      }
   }

   public final void a(long var1, String var3) {
      this.h.b(var1, var3);
      if (this.h.P.size() > 0) {
         this.h.a(var1);
      }
   }

   public final void b(long var1, String var3) {
      this.h.b(var1, var3);
      quyen_hg var4;
      (var4 = new quyen_hg(var3, false, null, null)).b = var3;
      var4.a(var1);
      var4.b(1);
      c.a(var4);
      c.f(var4.j);
   }

   public final void a(long var1, String var3, int var4, int var5) {
      if (this.h != null) {
         if (this.h.b(var1)) {
            this.h.l(var1);
         } else {
            this.a(quyen_hr.a(var3, " đồng ý kết bạn với bạn.", null, null), (Image) null, 1);
         }

         quyen_ba var10;
         (var10 = new quyen_ba(var3, "", var4, "", new int[0], 0, 0, null)).l = var1;
         quyen_ia.a("Ban Be", var10, this.h.b);
         a(this.h.b.e, false, quyen_ia.d);
         this.h.f(var1);
         b(var5, false);
         if (this.h.d(var1)) {
            this.h.k(var1);
         }

         System.gc();
      }
   }

   public final void a(long var1, int var3) {
      if (this.h != null) {
         String var4 = this.h.e(var1);
         quyen_ia.a(var1, this.h.b);
         this.h.g(var1);
         this.h.i(var1);
         if (this.h.J.size() > 0) {
            a(this.h.b.e, false, quyen_ia.d);
         } else {
            var3 = -1;
         }

         b(var3, false);
         if (var4 != null) {
            this.a(quyen_hr.a("Đã xóa ", var4, null, null), (Image) null, 1);
         }

         System.gc();
      }
   }

   public final void b(long var1, int var3) {
      if (this.h != null) {
         quyen_ia.a(var1, this.h.b);
         this.h.g(var1);
         this.h.h(var1);
         if (this.h.J.size() > 0) {
            a(this.h.b.e, false, quyen_ia.d);
         } else {
            var3 = -1;
         }

         this.a("Đã chuyển ID vào danh sách đen.", (Image) null, 1);
         b(var3, false);
         System.gc();
      }
   }

   public final void c(long var1, String var3) {
      if (!this.h.b(var1)) {
         String var4;
         if ((var4 = this.h.e(var1)) == null) {
            this.h.a(var1, var3);
         } else {
            quyen_hg var5;
            (var5 = this.n(var4)).a(var1);
            if (!var5.j.equals(this.aV.j)) {
               String var6 = quyen_bt.b(var3, quyen_n.j - quyen_n.j / 3);
               this.a(quyen_hr.a(var4, ": ", var6, ".."), (Image) null, 1);
               var5.w = true;
               this.d();
               System.gc();
            }

            boolean var7 = var5.c.a();
            var5.c.a(var5.b, var3, 1);
            if (var7) {
               var5.c.b();
            }

            var5.e = true;
         }
      }
   }

   public final quyen_hg n(String var1) {
      quyen_hg var2;
      if ((var2 = (quyen_hg)this.e(var1)) == null) {
         (var2 = new quyen_hg(var1, false, null, null)).b = var1;
         var2.w = true;
         this.a(var2);
      }

      return var2;
   }

   public final void b(long[] var1, String[] var2) {
      if (this.h != null) {
         this.h.a(var1, var2);
      }
   }

   public final void c(long var1, int var3) {
      if (this.h != null && this.h.b.a(var1, var3)) {
         this.h.a(var1, var3);
         int var4 = this.aV instanceof quyen_hg ? 2 : 0;
         quyen_ba var6;
         if ((var6 = this.h.b.e.a(null, null, var1)) != null) {
            String var2 = quyen_hr.a(var6.a, var3 == 1 ? " đã đăng nhập" : " đã thoát", null, null);
            this.a(var2, var3 == 1 ? u[1] : u[0], var4);

            try {
               quyen_hg var7;
               if ((var7 = (quyen_hg)this.e(var6.a)) != null) {
                  var7.c.a(var2, var3 == 1 ? 1 : 2);
                  var7.c.b();
                  return;
               }
            } catch (Exception var5) {
            }
         }
      }
   }

   public final void d(long var1, String var3) {
      if (this.h != null && this.h.b.a(var1, var3)) {
         int var4 = this.aV instanceof quyen_hg ? 2 : 0;
         quyen_ba var5 = this.h.b.e.a(null, null, var1);
         String var6 = quyen_bt.b(var3, quyen_n.j);
         this.a(quyen_hr.a(var5.a, ": ", var6, var3.equals(var6) ? null : ".."), u[1], var4);
         if (var1 == quyen_ia.A) {
            quyen_ia.E = var3;
            Xuka.a(quyen_ia.d, var3, false);
         }
      }
   }

   public final void c(String var1, String var2) {
      this.h.a(var1, var2);
   }

   public final void f(quyen_bb var1) {
      this.h.a(var1);
      this.h.O.b(1);
      this.a(this.h.O);
      this.e(this.h.O);
   }

   public final void a(String var1, Vector var2, long var3) {
      quyen_hg var6;
      (var6 = this.n(var1)).a(var3);
      int var7 = 0;

      for (int var4 = var2.size(); var7 < var4; var7++) {
         String var5 = (String)var2.elementAt(var7);
         var6.c.a(var6.b, var5, 1);
      }

      var6.c.b();
      var6.e = true;
      var6.b(1);
      this.e(var6);
   }

   public final void a(String var1, String var2, long var3) {
      if (var1.equals(this.U)) {
         this.f(var1);
      } else if (this.U != null) {
         this.a("Bạn có muốn thoát phòng đang chat?", new quyen_gg(this, var1, var2, var3));
      } else {
         this.b(var1, var2, var3);
      }
   }

   public final void b(String var1, String var2, long var3) {
      if ((quyen_p)this.e(var1) == null) {
         quyen_p var5 = new quyen_p(var1, var2, var3 == quyen_ia.A);
         this.U = var1;
         var5.b(1);
         this.a((quyen_cj)var5);
         this.e(var5);
         this.c(this.b(910001));
      } else {
         this.f(var1);
      }
   }

   public final void a(String var1, String var2, String var3, String var4) {
      String var5 = quyen_hr.a(var1, " mời bạn", null, null);
      if (this.a(var5)) {
         this.e(var5).w = true;
      } else {
         quyen_co var6;
         (var6 = new quyen_co()).j = var5;
         var6.w = true;
         var1 = quyen_hr.a(var1, " mời bạn tham gia phòng chat ", var2, null);
         quyen_bw.a(var6, var1);
         this.a(var1, (Image) null, 1);
         var6.m = new quyen_bw("Đồng ý", new quyen_gh(this, var3, var4, var6));
         var6.n = new quyen_bw(quyen_cr.c(), new quyen_gi(this, var6));
         quyen_hr.a(var6, (quyen_bx)var6.l.elementAt(0));
         this.g(var6);
      }
   }

   public final void b(String var1, String var2, int var3) {
      if (this.U != null) {
         try {
            quyen_p var4;
            if ((var4 = (quyen_p)this.e(this.U)) != null) {
               if (!var4.j.equals(this.aV.j)) {
                  String var5 = quyen_bt.b(var2, quyen_n.j - quyen_n.j / 3);
                  this.a(quyen_hr.a(var1, ": ", var5, ".."), (Image) null, 1);
                  var4.w = true;
                  this.d();
                  System.gc();
               }

               if (var4.d) {
                  var4.a();
               }

               boolean var7 = var4.b.a();
               var4.b.a(var1, var2, var3 != 3 ? (var1.equals(quyen_ia.d) ? 0 : 1) : var3);
               if (var7) {
                  var4.b.b();
               }

               var4.e = true;
               return;
            }
         } catch (Exception var6) {
         }
      }
   }

   static void a(quyen_et var0) {
      var0.M();
   }

   static quyen_cs b(quyen_et var0) {
      return var0.bi;
   }

   static void a(quyen_et var0, quyen_cs var1) {
      var0.bi = var1;
   }

   static void c(quyen_et var0) {
      if (var0.bu == null) {
         var0.bu = new quyen_be();
      }

      var0.R();
      var0.e(var0.bu);
   }

   static quyen_ci d(quyen_et var0) {
      return var0.bj;
   }

   static quyen_ci e(quyen_et var0) {
      return var0.bk;
   }

   static void a(quyen_et var0, byte var1) {
      var0.bs = var1;
   }

   static byte f(quyen_et var0) {
      return var0.bs;
   }

   static void a(quyen_et var0, String var1) {
      var0.bq = var1;
   }

   static boolean g(quyen_et var0) {
      return var0.bn;
   }

   static String h(quyen_et var0) {
      return var0.bq;
   }
}
