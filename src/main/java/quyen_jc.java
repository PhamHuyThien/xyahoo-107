import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_jc extends quyen_cj {
   private static Integer J = new Integer(1);
   public quyen_b a;
   public static String b;
   public static String c;
   public static int d;
   public static String A;
   private static boolean K;
   boolean B;
   private boolean L;
   private Vector M;
   quyen_ci C;
   quyen_cs D;
   public boolean E;
   private quyen_ce N;
   public quyen_cs F;
   private quyen_ce O;
   public quyen_cs G;
   public quyen_bu H;
   private quyen_ce P;
   quyen_bv I;
   private int Q;
   private int R;
   private quyen_cs S;
   private quyen_bw T;
   private quyen_bw U;
   private quyen_bw V;
   private int W;
   private quyen_co X;
   private quyen_bv Y;
   private quyen_cs Z;

   public quyen_jc() {
      super.v = 11112;
      String var1 = Xuka.d();
      String var2 = Xuka.e();
      super.j = "Yahoo!";
      this.Q = quyen_cj.h - 40 >> 1;
      int var3;
      if ((var3 = (quyen_bt.e + 3 << 2) + 28 + 40 + 5) <= quyen_cj.i - quyen_et.e) {
         this.R = quyen_et.d - 4 + (quyen_cj.i - quyen_et.e - var3 >> 1);
      } else {
         this.R = quyen_et.d + 5;
      }

      var3 = this.R + 40 - 3;
      this.N = new quyen_ce("Yahoo! ID:", quyen_hr.d, var3 + 3, quyen_bt.e);
      this.N.l = quyen_hr.f;
      this.F = new quyen_cs();
      this.F.a(quyen_hr.e, var3, quyen_hr.g, quyen_bt.e + 6);
      this.F.d(0);
      var3 += this.F.m + 7;
      this.O = new quyen_ce("Mật khẩu:", quyen_hr.d, var3 + 3, quyen_bt.e);
      this.O.l = quyen_hr.f;
      this.G = new quyen_cs();
      this.G.a(quyen_hr.e, var3, quyen_hr.g, quyen_bt.e + 6);
      this.G.d(2);
      this.G.c = true;
      this.F.c(var1);
      this.F.x = -5;
      this.G.c(var2);
      this.G.x = -5;
      var3 += this.G.m + 7;
      this.P = new quyen_ce("Domain:", quyen_hr.d, var3 + 3, quyen_bt.e);
      this.P.l = quyen_hr.f;
      this.I = new quyen_bv(new String[]{"@yahoo", "@ymail", "@rocketmail"}, quyen_hr.e, var3, quyen_hr.g, quyen_bt.e + 6);
      this.I.c(Xuka.f());
      var3 += 6 + this.I.m;
      int var4 = quyen_cj.h - (quyen_bt.b("Đăng nhập ẩn") + 13 + 4) >> 1;
      this.H = new quyen_bu("Đăng nhập ẩn", var4, var3, quyen_bt.b("Đăng nhập ẩn") + 13 + 4, quyen_bt.e + 4);
      this.H.a = Xuka.b("statusYahoo", false);
      this.D = new quyen_cs();
      this.D.c = true;
      this.D.a(1, quyen_cj.i - quyen_et.e - quyen_bt.e - 7, quyen_cj.h - 2, quyen_bt.e + 6);
      this.a = new quyen_b(0, 1, quyen_cj.h - 2, quyen_cj.i - 4 - quyen_et.e, true);
      this.a(this.a);
      quyen_hr.a(this, this.a);
      this.a.a = true;
      this.a.b = Xuka.b("hideOffline", false);
      this.M = new Vector();
      this.M.addElement(new quyen_bw("Mở/tắt ID ẩn", new quyen_jd(this)));
      this.M.addElement(new quyen_bw("Trạng thái", new quyen_jl(this)));
      this.M.addElement(new quyen_bw("Chat với..", new quyen_jm(this)));
      this.M.addElement(new quyen_bw("Thêm bạn", new quyen_jo(this)));
      this.M.addElement(new quyen_bw("Mời bạn Yahoo!", new quyen_jp(this)));
      this.M.addElement(new quyen_bw("Thoát Yahoo!", new quyen_jq(this)));
   }

   public final void a() {
      quyen_et.c.x();
      if (this.E || this.L) {
         this.E = false;
         quyen_a.d(b, 2);
         this.a(false);
      }

      quyen_et.c.c(this.X);
      this.X = null;
   }

   public final void a(String var1) {
      quyen_co var2;
      (var2 = new quyen_co()).j = "Thêm bạn";
      quyen_cs var3 = quyen_bw.a(var2, "Thêm bạn", 0);
      if (var1 != null) {
         var3.c(var1);
      }

      quyen_cs var5 = quyen_bw.a(var2, "Vào nhóm mới:", 0);
      quyen_bv var4 = quyen_bw.a(var2, "hoặc đã có:", this.a.f());
      quyen_hr.a(var2, (quyen_bx)var3);
      var4.a(new quyen_jr(this, var4, var5));
      if (var4.b != null && var4.b.length != 0) {
         var5.c(var4.b());
      } else {
         var5.c("Friends");
      }

      var2.n = new quyen_bw(quyen_cr.c(), new quyen_js(this, var2));
      var2.o = new quyen_bw("OK", new quyen_je(this, var3, var5, var2));
      var2.b(1);
      quyen_et.c.a((quyen_cj)var2);
      quyen_et.c.o();
   }

   public final void a(boolean var1) {
      this.e();
      this.L = var1;
      if (var1) {
         if (this.C == null) {
            this.C = new quyen_ci(this.M);
            this.T = new quyen_bw("Menu", new quyen_jf(this));
         }

         super.m = this.T;
         super.o = null;
         this.a(this.a);
         quyen_hr.a(this, this.a);
      } else {
         if (this.U == null) {
            this.U = new quyen_bw("Đăng nhập", new quyen_jg(this));
            this.V = new quyen_bw(quyen_cr.c(), new quyen_jh(this));
         }

         super.m = null;
         super.o = this.U;
         super.n = this.V;
         this.k();
         this.a(this.N);
         this.a(this.F);
         this.a(this.O);
         this.a(this.G);
         this.a(this.P);
         this.a(this.I);
         this.a(this.H);
         if (this.F.c().length() > 0) {
            quyen_hr.a(this, this.I);
         } else {
            quyen_hr.a(this, (quyen_bx)this.F);
         }
      }

      super.u = super.t = 0;
      this.a.e();
      System.gc();
   }

   public final void e(Graphics var1) {
      if (!this.L) {
         var1.drawImage(quyen_ea.a(J), this.Q, this.R, 0);
      }

      super.e(var1);
   }

   protected final void g() {
      if (quyen_et.c.w()) {
         quyen_et.c.d("Tài khoản Yahoo của bạn bị khóa. Vui lòng đăng nhập lại sau.");
      } else {
         this.F.c(this.F.c().trim().toLowerCase());
         String var1 = this.F.c();
         String var2 = this.G.c();
         if (var1.equals("")) {
            quyen_hr.a(this, (quyen_bx)this.F);
         } else if (var2.equals("")) {
            quyen_hr.a(this, (quyen_bx)this.G);
         } else {
            b = var1;
            c = var1;
            d = this.H.a ? 12 : 0;
            K = this.H.a;
            String var3;
            A = (var3 = Xuka.c(b, true)) == null ? "" : var3;
            Xuka.c(var1);
            Xuka.d(var2);
            int var4 = this.I.a();
            Xuka.b(this.I.a());
            if (var4 == 1 || var4 == 2) {
               b = b + this.I.b() + ".com";
            }

            this.a.c = true;
            this.a(true);
            this.W = quyen_et.a(true);
            if (this.W != -1) {
               quyen_bb var5;
               if ((var5 = quyen_et.a(true, b)) != null) {
                  quyen_et.c.i.a.a(var5, -1);
               } else {
                  this.W = -1;
               }
            }

            quyen_a.a(b, var2, d, 2, this.W, (byte)0, "");
         }
      }
   }

   public final void b() {
      this.a.e();
   }

   public final void a(Graphics var1) {
      this.a.b(var1);
   }

   public final void h() {
      if (this.a.f != null) {
         this.a.f.removeAllElements();
      }

      this.a.f = null;
      this.a.e = null;
   }

   private void j() {
      this.D.c("");
      this.a(this.D);
      quyen_hr.a(this, (quyen_bx)this.D);
      this.B = true;
   }

   private void k() {
      quyen_hr.a(this, this.a);
      this.b(this.D);
      this.B = false;
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.B && this.L && (this.S == null || !quyen_hr.b(this, (quyen_bx)this.S))) {
         this.j();
      }

      String var4 = "";
      if (this.B) {
         if (var1[12]) {
            var1[12] = false;
            this.a.b(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.a.b(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.a.b(16);
         }

         var4 = this.D.c();
      }

      boolean var5 = super.a(var1, var2, var3);
      if (this.B) {
         if (this.D.c().equals("")) {
            this.k();
         }

         if (!this.D.c().equals(var4)) {
            this.a.c(this.D.c());
         }
      }

      return var5;
   }

   public final void i() {
      Xuka.g(b);
      quyen_et.e().a("Mời bạn Yahoo! dùng X Yahoo!", new quyen_ji(this));
   }

   static boolean a(quyen_jc var0) {
      if (!var0.E) {
         quyen_et.c.a("Vui lòng chờ", (Image) null, 1);
         return true;
      } else {
         return false;
      }
   }

   static void b(quyen_jc var0) {
      if (K) {
         quyen_et.c.a("Vui lòng thoát Yahoo! và bỏ chọn đăng nhập ẩn", (Image) null, 1);
      } else if (quyen_et.I) {
         quyen_et.c.a("Vui lòng chờ 10s", (Image) null, 1);
      } else {
         if (var0.X == null) {
            System.gc();
            var0.X = new quyen_co();
            var0.X.j = "Trạng Thái";
            quyen_hr.a(quyen_hr.h, quyen_hr.i);
            var0.X.B += 20;
            var0.Y = quyen_bw.a(var0.X, quyen_hr.a("Trạng thái", ":", null, null), new String[]{"Hiển thị", "Ẩn danh"});
            var0.Z = quyen_bw.b(var0.X, quyen_hr.a("Thông điệp", ":", null, null), 0, -1);
            quyen_hr.a(var0.X, var0.Y);
            var0.X.o = new quyen_bw("OK", new quyen_jj(var0));
            var0.X.n = new quyen_bw(quyen_cr.c(), new quyen_jk(var0));
            System.gc();
         }

         var0.Y.c(d == 0 ? 0 : 1);
         quyen_et.e().a((quyen_cj)var0.X);
         var0.Z.c(A);
         quyen_et.e().o();
      }
   }

   static void c(quyen_jc var0) {
      var0.k();
   }

   static quyen_cs d(quyen_jc var0) {
      return var0.S;
   }

   static void a(quyen_jc var0, quyen_cs var1) {
      var0.S = var1;
   }

   static quyen_cs e(quyen_jc var0) {
      return var0.Z;
   }

   static quyen_bv f(quyen_jc var0) {
      return var0.Y;
   }

   static void a(quyen_jc var0, String var1) {
      quyen_a.c(var1, 2);
      A = var1;
      Xuka.a(b, var1, true);
   }

   static quyen_co g(quyen_jc var0) {
      return var0.X;
   }
}
