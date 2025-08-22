import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class quyen_cz extends quyen_cj {
   public String a;
   public static boolean b;
   public boolean c;
   private quyen_cv[] ac;
   private quyen_cx ad;
   private int ae;
   private int af;
   public static String d = "";
   private String ag = "";
   public Object A;
   public boolean B;
   public quyen_dz[] C;
   public String[] D;
   private quyen_cs ah;
   public boolean E;
   public quyen_cs F;
   public boolean G;
   public int H;
   public boolean[] I;
   public boolean[] J;
   public quyen_cw K;
   private String[] ai;
   private boolean aj;
   public boolean L;
   public String M;
   public boolean N;
   public static quyen_cz O;
   byte P;
   String[] Q;
   private String[] ak;
   byte[][] R;
   public boolean S = true;
   public boolean T;
   public int U;
   public String[] V;
   public long[] W;
   public int[] X;
   public static int Y;
   private quyen_bx al;
   public static String Z;
   private quyen_bw am;
   private Vector an;
   private quyen_ci ao;
   private quyen_bw ap;
   private Vector aq;
   private quyen_ci ar;
   private Vector as;
   private quyen_ci at;
   private quyen_bw au;
   private Vector av;
   private quyen_ci aw;
   private int ax;
   private quyen_bw ay = new quyen_bw("Biểu cảm", new quyen_da(this));
   private quyen_bw az = new quyen_bw("Chat", new quyen_dl(this));
   private quyen_bw aA = new quyen_bw("Chọn/hủy hết bài", new quyen_dr(this));
   private quyen_bw aB = new quyen_bw("Đặt cược", new quyen_ds(this));
   public boolean aa;
   public String ab;
   private quyen_bw aC;
   private quyen_bw aD;
   private quyen_bw aE;
   private quyen_bw aF;
   private quyen_bw aG;
   private quyen_bw aH = new quyen_bw("Cập nhật", new quyen_dt(this));
   private quyen_bw aI = new quyen_bw(quyen_cr.c(), new quyen_du(this));
   private quyen_bw aJ = new quyen_bw("Chơi nhanh", new quyen_dv(this));

   public final void a(long var1) {
      this.ag = quyen_hr.a("Cược", ": ", quyen_hr.a(var1), quyen_hr.a(" ", this.N ? "gold" : "xu", null, null));
   }

   public static quyen_cz a() {
      if (O == null) {
         O = new quyen_cz();
      }

      return O;
   }

   public final void a(String var1) {
      Vector var10000 = this.an;
      String var2 = var1;
      quyen_cz var5 = this;
      byte var3 = 0;

      quyen_bw var10001;
      while (true) {
         if (var3 >= var5.an.size()) {
            var10001 = null;
            break;
         }

         quyen_bw var4;
         if ((var4 = (quyen_bw)var5.an.elementAt(var3)).a.equals(var2)) {
            var10001 = var4;
            break;
         }

         var3++;
      }

      var10000.removeElement(var10001);
   }

   public quyen_cz() {
      this.as = new Vector();
      this.at = new quyen_ci(this.as);
      this.au = new quyen_bw("Menu", new quyen_dw(this));
      super.y = true;
      quyen_et.j();
      this.N = false;
   }

   public final void a(boolean var1, boolean var2) {
      quyen_cw.y = var1;
      this.c = var1;
      int var3 = this.C.length;

      while (--var3 >= 0) {
         this.C[var3].d = var1;
         if (var2) {
            this.J[var3] = false;
            this.C[var3].a(false);
         }
      }
   }

   public final void b(Graphics var1) {
      super.b(var1);
      if (b) {
         quyen_bt.a(quyen_bt.c).a(this.ag, 5, quyen_cj.g + 3, var1);
         int var2 = this.H;

         while (--var2 >= 0) {
            if (this.C[var2].d) {
               switch (this.C[var2].v) {
                  case 1:
                     this.a(var1, 0, 0, 36, 35, var2);
                     break;
                  case 2:
                     if (!this.aa && this.H != 2) {
                        this.a(var1, 36, 0, 35, 35, var2);
                     } else {
                        this.a(var1, 106, 0, 35, 35, var2);
                     }
                     break;
                  case 3:
                     if (!this.aa && this.H != 3) {
                        this.a(var1, 71, 0, 35, 35, var2);
                     } else {
                        this.a(var1, 106, 0, 35, 35, var2);
                     }
                     break;
                  case 4:
                     this.a(var1, 106, 0, 35, 35, var2);
               }
            }

            if (this.C[var2].C) {
               this.C[var2].c(var1);
            }
         }
      }
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      if ((quyen_et.c.f >> 3) % 2 == 0) {
         this.ax = this.C[var6].c - (this.C[var6].B ? -10 : 4);
      } else {
         this.ax = this.C[var6].c - (this.C[var6].B ? -11 : 3);
      }

      var1.drawRegion(
         quyen_et.B, var2, 0, var4, 35, 0, 0 + this.C[var6].b + (this.C[var6].B ? (this.C[var6].g == 1 ? -50 : 21) : -31), quyen_cj.g + this.ax, 20
      );
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && b && !this.E) {
         this.k();
      }

      return super.a(var1, var2, var3);
   }

   public final void b() {
   }

   public final void a(Graphics var1) {
   }

   public final void a(quyen_cv[] var1, int var2) {
      Y = var2;
      this.G = false;
      b = false;
      this.S = true;
      if (var1 != null) {
         this.ac = var1;
      }

      String var3 = this.M;
      this.M = var3;
      super.j = var3;
      quyen_hr.b(this, var3);
      this.m();
      super.s = true;
      this.e();
      System.gc();
      if (this.ad == null) {
         this.ad = new quyen_cx(quyen_cj.h - 3, quyen_cj.i - 3 - quyen_et.e, Y);
      }

      this.ad.a(this.ac);
      this.a(this.ad);
      quyen_hr.a(this, this.ad);
      super.n = this.aI;
      this.as.removeAllElements();
      this.as.addElement(this.aJ);
      this.as.addElement(this.aH);
      this.as.addElement(quyen_gz.d);
      super.m = this.au;
      System.gc();
   }

   public final void g() {
      b = false;
      this.a(null, Y);
   }

   public static void h() {
      quyen_a.e(Z);
   }

   public final void a(byte var1, String[] var2, long[] var3, int[] var4) {
      b = true;
      Y = 0;
      this.e();
      this.S = true;
      this.C = null;
      System.gc();
      if (this.am == null) {
         this.an = new Vector();
         this.ao = new quyen_ci(this.an);
         this.am = new quyen_bw("Đá người chơi", null);
         this.am.c = this.ao;
      }

      this.C = new quyen_dz[var1];
      this.H = var1;
      this.X = var4;
      boolean var5 = false;
      byte[] var6 = new byte[var1];
      byte var7 = 0;
      byte var8 = 0;

      for (byte var9 = 0; var9 < var1; var9++) {
         if (quyen_ia.d.equals(var2[var9])) {
            var7 = var9;
            break;
         }
      }

      for (byte var12 = 0; var12 < var1; var12++) {
         var6[var12] = var7;
         if (var7 == var1 - 1) {
            var7 = 0;
         } else {
            var7++;
         }

         var8 = var6[var12];
         if (var2[var8] != null) {
            this.C[var12] = new quyen_dz(var2[var8], var3[var8], var12, var2[var8].equals(this.a));
            this.C[var12].a(this.J[var8]);
            this.C[var12].A = new Integer(var4[var8]);
            quyen_bc var11;
            if ((var11 = quyen_et.c.a(var2[var8], 0)) != null) {
               this.C[var12].a(var11);
            }
         }

         if (quyen_ia.d.equals(this.C[var12].a)) {
            this.ae = this.C[var12].b;
            this.af = this.C[var12].c;
            var5 = this.C[var12].b();
         }

         if (this.C[var12] != null) {
            this.a(this.C[var12]);
         }
      }

      this.n();
      this.av.addElement(this.ay);
      this.av.addElement(this.az);
      if (quyen_ia.d.equals(this.a)) {
         this.av.addElement(this.aB);
      }

      this.av.addElement(quyen_gz.d);
      if (quyen_ia.d.equals(this.a) && this.C.length > 1) {
         this.an.removeAllElements();
         System.gc();

         for (byte var13 = 0; var13 < this.C.length; var13++) {
            if (!quyen_ia.d.equals(this.C[var13].a)) {
               this.an.addElement(new quyen_bw(this.C[var13].a, new quyen_dx(this, var13)));
            }
         }

         this.av.addElement(this.am);
      }

      this.o();
      this.av.addElement(new quyen_bw("Rời bàn", new quyen_db(this)));
      super.m = new quyen_bw("Menu", new quyen_dc(this));
      super.n = null;
      if (super.o == null) {
         super.o = new quyen_bw("", new quyen_dd(this));
      }

      if (quyen_ia.d.equals(this.a)) {
         super.o.a = "Chơi ngay!";
      } else if (!var5) {
         super.o.a = "Sẵn sàng";
      }

      if (!this.E && this.ah == null) {
         System.gc();
         this.ah = new quyen_cs("", 1);
         this.ah.a(0, quyen_cj.i - quyen_et.e - (quyen_bt.e << 1) - 10, quyen_cj.h - 1, quyen_bt.e + 6);
         this.ah.n = 2222;
         this.ah.p = quyen_et.D();
         if (this.aF == null) {
            this.aF = new quyen_bw(quyen_cr.c(), new quyen_do(this));
         }

         this.ah.q = this.aF;
         this.ah.w = new quyen_dp(this);
         if (this.aG == null) {
            this.aG = new quyen_bw("Cược", new quyen_dq(this));
         }

         this.ah.r = this.aG;
      }

      this.p();
      this.al = this.C[0];
      if (this.G) {
         this.k();
      } else if (this.E) {
         this.l();
      } else {
         quyen_hr.a(this, this.al);
      }

      this.m();
      System.gc();
   }

   private void k() {
      if (!super.l.contains(this.F)) {
         this.a(this.F);
      }

      quyen_hr.a(this, (quyen_bx)this.F);
      this.G = true;
   }

   private void l() {
      if (!super.l.contains(this.ah)) {
         this.a(this.ah);
      }

      quyen_hr.a(this, (quyen_bx)this.ah);
      this.E = true;
      this.m();
   }

   private void m() {
      super.t = -quyen_cj.g + 2;
   }

   public final String e(int var1) {
      if (this.ai == null) {
         this.ai = new String[]{
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30"
         };
      }

      return var1 < O.ai.length && var1 >= 0 ? O.ai[var1] : Integer.toString(var1);
   }

   public final void a(byte[] var1, String var2, boolean var3, boolean var4) {
      super.p = true;
      System.gc();
      if (this.K == null) {
         this.K = new quyen_cw();
      }

      this.K.a(var1);
      quyen_cw.v = var4;
      this.K.c = var2;
      this.A = var2;
      if (quyen_ia.d.equals(var2)) {
         this.aj = var3;
         this.K.f = var3;
      }

      this.K.u = true;
      this.K.g = false;
      this.T = false;
      this.S = false;
      this.L = false;
      if (this.K != null) {
         this.K.f = this.aj;
         this.a(this.K);
         quyen_hr.a(this, this.K);
      }

      System.gc();
      super.n = new quyen_bw("Bỏ lượt", new quyen_df(this));
      this.al = this.K;
      this.p();
      this.n();
      this.av.addElement(this.ay);
      this.av.addElement(this.az);
      this.av.addElement(this.aA);
      this.av.addElement(quyen_gz.d);
      this.o();
      this.av.addElement(new quyen_bw("Rời bàn", new quyen_dg(this)));
      super.m = new quyen_bw("Menu", new quyen_di(this));
      System.gc();
      if (this.G) {
         this.b(this.F);
         this.k();
      }

      this.m();

      for (int var5 = 0; var5 < O.H; var5++) {
         if (O.C[var5].a != null && O.C[var5].a.equals(var2)) {
            O.C[var5].c(30);
            return;
         }
      }
   }

   private void n() {
      if (this.av == null) {
         this.av = new Vector();
         this.aw = new quyen_ci(this.av);
      } else {
         this.av.removeAllElements();
      }

      System.gc();
   }

   private void o() {
      if (this.ap == null) {
         this.aq = new Vector();
         this.ar = new quyen_ci(this.aq);
         this.ap = new quyen_bw("Hồ sơ", null);
         this.ap.c = this.ar;
      }

      if (this.C.length > 1) {
         this.aq.removeAllElements();
         System.gc();

         for (byte var1 = 0; var1 < this.C.length; var1++) {
            if (!quyen_ia.d.equals(this.C[var1].a) && quyen_et.c.h.b(this.C[var1].a) == null) {
               this.aq.addElement(new quyen_bw(this.C[var1].a, new quyen_de(this, var1)));
            }
         }

         if (this.aq.size() > 0) {
            this.av.addElement(this.ap);
         }
      }
   }

   public final void a(boolean var1) {
      this.g();
      this.b(var1 ? -1 : 1);
      quyen_a.a(Y, d, quyen_ia.d, this.B);
   }

   public final void a(String var1, int var2, byte[] var3, String var4, boolean var5) {
      super.p = true;
      this.L = true;
      this.A = var4;
      quyen_dz var6 = null;

      for (byte var7 = 0; var7 < this.H; var7++) {
         if (this.C[var7].a != null && this.C[var7].a.equals(var1)) {
            var6 = this.C[var7];
         }
      }

      if (this.K != null && var6 != null) {
         this.K.u = var5;
         this.K.c = var4;
         this.K.d = var2;
         this.K.f = false;
         this.K.x = false;
         if (this.K.u) {
            this.K.g = false;

            for (int var8 = 0; var8 < O.H; var8++) {
               this.C[var8].u = false;
            }
         } else {
            var6.u = false;
         }

         this.K.a(var3, var6.g == 1 ? quyen_cj.h - var3.length * 14 - 35 : var6.b, var6.g == 1 ? (quyen_cj.i >> 1) - 5 : var6.c);

         for (byte var9 = 0; var9 < this.H; var9++) {
            if (this.C[var9].a != null) {
               if (this.C[var9].a.equals(this.A)) {
                  this.C[var9].c(30);
               } else {
                  this.C[var9].D = false;
               }
            }
         }
      }
   }

   public final void a(String var1, String var2, boolean var3) {
      super.p = true;
      this.K.u = var3;
      this.K.c = var2;
      this.A = var2;
      if (this.K.f) {
         this.K.f = false;
      }

      if (this.K.u) {
         this.K.g = false;
         this.K.e = null;
         this.K.w = null;

         for (byte var4 = 0; var4 < this.H; var4++) {
            this.C[var4].u = false;
         }
      } else {
         for (byte var5 = 0; var5 < this.H; var5++) {
            if (this.C[var5].a.equals(var1)) {
               this.C[var5].u = true;
               break;
            }
         }
      }

      for (byte var6 = 0; var6 < this.H; var6++) {
         if (this.C[var6].a.equals(var1)) {
            this.C[var6].D = false;
         } else if (this.C[var6].a.equals(var2)) {
            this.C[var6].c(30);
         }
      }
   }

   public final void a(String var1, byte var2, String[] var3, long[] var4, long[] var5, byte var6, String[] var7, byte[][] var8, int[] var9, quyen_bc[] var10) {
      if (d.equals(var1)) {
         this.P = var2;
         this.Q = var3;
         this.ak = var7;

         for (byte var11 = 0; var11 < this.H; var11++) {
            if (this.C[var11] != null) {
               this.C[var11].D = false;

               for (byte var12 = 0; var12 < var3.length; var12++) {
                  if (this.C[var11].a.equals(var3[var12])) {
                     this.C[var11].a(var5[var12]);
                     this.C[var11].v = var9[var12];
                     this.C[var11].w = var4[var12];
                     this.C[var11].a(var10[var12]);
                     break;
                  }
               }
            }
         }

         this.B = false;
         if (var1.equals(var1)) {
            this.R = var8;
            if (this.K != null) {
               this.K.c();
            }
         }
      }
   }

   public final void i() {
      super.o.a = "";
      if (this.aC == null) {
         this.aC = new quyen_bw("Chơi tiếp", new quyen_dj(this));
      }

      super.n = this.aC;
      super.p = true;
   }

   public final void j() {
      Vector var1 = new Vector();

      for (int var2 = 0; var2 < this.I.length; var2++) {
         if (!this.I[var2]) {
            var1.addElement(this.ak[var2]);
         }
      }

      String[] var4 = new String[var1.size()];
      var1.copyInto(var4);
      this.C = quyen_et.a(var4);
      this.U = var4.length;

      for (int var3 = 0; var3 < var4.length; var3++) {
         this.V[var3] = this.C[var3].a;
         this.W[var3] = this.C[var3].a();
         this.X[var3] = this.C[var3].A.intValue();
      }

      System.gc();
   }

   public final void b(String var1, String var2, boolean var3) {
      this.K.c = var2;
      this.K.u = var3;
      O.A = var2;
      if (this.K.u) {
         this.K.g = false;
         this.K.e = null;
         this.K.w = null;
      }

      if (this.C != null) {
         for (int var4 = 0; var4 < this.C.length; var4++) {
            if (this.C[var4] != null) {
               this.C[var4].u = false;
               if (!this.K.f && this.C[var4].a.equals(var2)) {
                  this.C[var4].c(30);
               }
            }
         }

         for (byte var5 = 0; var5 < this.C.length; var5++) {
            if (this.C[var5].a.equals(var1)) {
               this.C[var5].f = true;
            }
         }
      }
   }

   private void p() {
      if (!this.G && this.F == null) {
         System.gc();
         this.F = new quyen_cs("", 0);
         this.F.a(0, quyen_cj.i - quyen_et.e - (quyen_bt.e << 1) - 10, quyen_cj.h - 1, quyen_bt.e + 6);
         this.F.n = 1111;
         this.F.p = quyen_et.D();
         if (this.aD == null) {
            this.aD = new quyen_bw(quyen_cr.c(), new quyen_dk(this));
         }

         this.F.q = this.aD;
         this.F.w = new quyen_dm(this);
         if (this.aE == null) {
            this.aE = new quyen_bw("Chat", new quyen_dn(this));
         }

         this.F.r = this.aE;
      }
   }

   static void a(quyen_cz var0) {
      var0.k();
   }

   static void b(quyen_cz var0) {
      var0.l();
   }

   static quyen_ci c(quyen_cz var0) {
      return var0.at;
   }

   static quyen_ci d(quyen_cz var0) {
      return var0.aw;
   }

   static quyen_bx e(quyen_cz var0) {
      return var0.al;
   }

   static void f(quyen_cz var0) {
      var0.m();
   }

   static quyen_bw g(quyen_cz var0) {
      return var0.aD;
   }

   static quyen_cs h(quyen_cz var0) {
      return var0.ah;
   }

   static quyen_bw i(quyen_cz var0) {
      return var0.aF;
   }
}
