import javax.microedition.lcdui.Image;
import java.util.Hashtable;
import java.util.Vector;

public final class quyen_ia extends quyen_cj {
   public static int[] a;
   public quyen_b b;
   public quyen_b c;
   public static String d;
   public static long A;
   public static String B;
   public static int C;
   public static boolean D;
   public static String E = "";
   private Vector Q;
   public quyen_ci F;
   boolean G;
   private quyen_cs R;
   public static quyen_ia H;
   public static int I;
   public Vector J;
   public Vector K;
   public Vector L;
   private Hashtable S;
   public boolean M;
   private quyen_bw T;
   public Hashtable N;
   public quyen_cj O;
   private quyen_cs U;
   private quyen_ca V;
   private quyen_ca W;
   private quyen_co X;
   private quyen_bv Y;
   private quyen_cs Z;
   private quyen_bw aa;
   private quyen_bw ab = new quyen_bw(quyen_cr.c(), new quyen_ib(this));
   public Hashtable P;

   public final void a() {
      if (this.b != null) {
         if (this.b.f != null) {
            this.b.f.removeAllElements();
         }

         this.b.f = null;
         this.b.e = null;
      }

      if (this.c != null) {
         if (this.c.f != null) {
            this.c.f.removeAllElements();
         }

         this.c.f = null;
         this.c.e = null;
      }
   }

   public quyen_ia() {
      super.j = "Bạn Bè";
      H = this;
      I = 1;
      this.J = new Vector();
      this.K = new Vector();
      this.L = new Vector();
      this.S = quyen_et.p();
      if (this.S == null) {
         this.S = new Hashtable();
      }

      this.M = true;
      D = Xuka.b("onavt", true);
      this.R = new quyen_cs();
      this.R.c = true;
      this.R.a(1, quyen_cj.i - quyen_et.e - quyen_bt.e - 11, quyen_cj.h - 2, quyen_bt.e + 6);
      this.b = new quyen_b(0, 1, quyen_cj.h - 2, quyen_cj.i - 4 - quyen_et.e, true);
      this.b.a = false;
      this.b.b = Xuka.b("hideOffline", false);
      this.b.c = true;
      this.a(this.b);
      quyen_hr.a(this, this.b);
      this.Q = new Vector();
      this.F = new quyen_ci(this.Q);
      this.Q.addElement(new quyen_bw("Trạng thái", new quyen_im(this)));
      this.Q.addElement(this.g());
      this.Q.addElement(new quyen_bw("Thêm bạn", new quyen_iu(this)));
      this.Q.addElement(new quyen_bw("Chat với..", new quyen_iw(this)));
      this.Q.addElement(new quyen_bw("ID từ chối", new quyen_iy(this)));
      quyen_bw var1 = new quyen_bw("Chức năng khác", null);
      Vector var2;
      (var2 = new Vector()).addElement(new quyen_bw("Mở/tắt ID ẩn", new quyen_iz(this)));
      var2.addElement(new quyen_bw("Mở/tắt avatar", new quyen_ja(this)));
      var2.addElement(new quyen_bw("Gửi tin nhóm", new quyen_ic(this)));
      var1.c = new quyen_ci(var2);
      this.Q.addElement(var1);
      super.m = new quyen_bw("Menu", new quyen_id(this));
      super.n = this.ab;
   }

   public static final void a(quyen_b var0) {
      var0.b = !var0.b;
      var0.b();
      var0.d = 0;
      Xuka.a("hideOffline", var0.b);
   }

   public final void a(long var1, int[] var3) {
      this.b.a(var1, var3);
      if (this.c != null) {
         this.c.a(var1, var3);
      }
   }

   public final quyen_bw g() {
      return new quyen_bw("Chờ kết bạn" + (this.L.size() > 0 ? " (+" + this.L.size() + ")" : ""), new quyen_ie(this));
   }

   public static void a(String var0) {
      quyen_a.c(var0, 1);
      E = var0;
      Xuka.a(d, var0, false);
   }

   public final void h() {
      if (this.X == null) {
         System.gc();
         this.X = new quyen_co();
         this.X.j = "Trạng Thái";
         quyen_hr.a(quyen_hr.h, quyen_hr.i);
         this.X.B += 20;
         this.Y = quyen_bw.a(this.X, quyen_hr.a("Trạng thái", ":", null, null), new String[]{"Hiển thị", "Ẩn danh"});
         this.Z = quyen_bw.b(this.X, quyen_hr.a("Thông điệp", ":", null, null), 0, -1);
         quyen_hr.a(this.X, this.Y);
         this.X.o = new quyen_bw("OK", new quyen_if(this));
         this.X.n = new quyen_bw(quyen_cr.c(), new quyen_ig(this));
         System.gc();
      }

      this.Y.c(C == 1 ? 0 : 1);
      quyen_et.e().a((quyen_cj)this.X);
      this.Z.c(E);
      quyen_et.e().o();
   }

   public final void i() {
      if (this.b.e != null) {
         quyen_bd var1 = this.b.e.a("Ban Be");
         int var2 = 0;

         for (int var3 = var1.a.size(); var2 < var3; var2++) {
            this.f(((quyen_ba)var1.a.elementAt(var2)).l);
         }
      }
   }

   private void m() {
      this.R.c("");
      this.a(this.R);
      quyen_hr.a(this, (quyen_bx)this.R);
      this.G = true;
   }

   private void n() {
      quyen_hr.a(this, this.b);
      this.b(this.R);
      this.G = false;
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var3[0] > 32 && !this.G && super.l.contains(this.b) && (this.U == null || !quyen_hr.b(this, (quyen_bx)this.U))) {
         this.m();
      }

      String var4 = "";
      if (this.G) {
         if (var1[12]) {
            var1[12] = false;
            this.b.b(12);
         } else if (var1[13]) {
            var1[13] = false;
            this.b.b(13);
         } else if (var1[16]) {
            var1[16] = false;
            this.b.b(16);
         }

         var4 = this.R.c();
      }

      super.a(var1, var2, var3);
      if (this.G) {
         if (this.R.c().equals("")) {
            this.n();
         }

         if (!this.R.c().equals(var4)) {
            this.b.c(this.R.c());
         }
      }

      return true;
   }

   public final void a(Vector var1) {
      if (var1.size() > 0) {
         long[] var5 = b(var1);
         quyen_ju var2 = new quyen_ju(5000028, 2);
         quyen_a.a(var5.length, var2);
         int var3 = 0;

         for (int var4 = var5.length; var3 < var4; var3++) {
            quyen_a.a(var5[var3], var2);
         }

         quyen_jv.a(var2);
      }
   }

   public final void j() {
      int var1 = this.Q.size();

      while (--var1 >= 0) {
         if (((quyen_bw)this.Q.elementAt(var1)).a.startsWith("Chờ kết bạn")) {
            ((quyen_bw)this.Q.elementAt(var1)).a = "Chờ kết bạn";
            if (this.L.size() > 0) {
               ((quyen_bw)this.Q.elementAt(var1)).a = quyen_hr.a("Chờ kết bạn", " (+", Integer.toString(this.L.size()), ")");
            }

            quyen_et.c.a((quyen_bw)this.Q.elementAt(var1), var1);
            var1 = 0;
            System.gc();
         }
      }
   }

   public final void a(long var1, String var3) {
      if (this.P == null) {
         this.P = new Hashtable();
      }

      quyen_a.a(var1);
      this.P.put(new Long(var1), var3);
   }

   public final void a(long var1) {
      if (this.P.containsKey(new Long(var1))) {
         String var3 = (String)this.P.get(new Long(var1));
         this.P.remove(new Long(var1));
         quyen_et.c.c(var1, var3);
      }
   }

   public final void a(String var1, String var2) {
      if (this.N == null) {
         this.N = new Hashtable();
      }

      Vector var3;
      if (this.N.containsKey(var1)) {
         var3 = (Vector)this.N.get(var1);
      } else {
         var3 = new Vector();
      }

      var3.addElement(var2);
      this.N.put(var1, var3);
   }

   public final void a(quyen_bb var1) {
      this.O = new quyen_cj();
      this.O.j = "Tin Nhắn Offline";
      quyen_ch var2;
      (var2 = new quyen_ch(0, 0, quyen_cj.h, quyen_cj.i - quyen_et.e)).a(1, 10, 10);
      var2.a(var1, 1, false);
      this.O.a(var2);
      quyen_hr.a(this.O, var2);
      Vector var3;
      (var3 = new Vector()).addElement(new quyen_bw("Xem", new quyen_ii(this, var2)));
      var3.addElement(new quyen_bw("Hồ sơ", new quyen_ij(this, var2)));
      quyen_ci var4 = new quyen_ci(var3);
      var2.d = new quyen_ik(this, var4);
      this.O.n = new quyen_bw(quyen_cr.c(), new quyen_il(this));
      this.k();
   }

   public final void k() {
      if (this.N.size() > 0) {
         String var1 = quyen_hr.a("Tin nhắn offline", " (", Integer.toString(this.N.size()), ")");
         if (this.T == null) {
            this.T = new quyen_bw(var1, new quyen_in(this));
         } else {
            this.T.a = var1;
            this.Q.setElementAt(this.T, this.Q.size());
         }

         if (!this.Q.contains(this.T)) {
            this.Q.addElement(this.T);
            return;
         }
      } else {
         if (this.T != null) {
            this.Q.removeElement(this.T);
         }

         if (this.O != null) {
            quyen_et.c.c(this.O);
         }
      }
   }

   public final void l() {
      if (quyen_et.c.a("Gửi tin nhóm")) {
         quyen_et.c.f("Gửi tin nhóm");
      } else {
         quyen_co var1;
         (var1 = new quyen_co()).j = "Gửi tin nhóm";
         quyen_b var2;
         (var2 = new quyen_b(0, 1, quyen_cj.h - 2, quyen_cj.i - 4 - quyen_et.e, true)).a(this.b.e, -1);
         var2.a("Favorite");
         var2.a(true);
         var2.h();
         var1.a(var2);
         quyen_hr.a(var1, var2);
         var1.n = new quyen_bw(quyen_cr.c(), new quyen_io(this, var1));
         Vector var3;
         (var3 = new Vector()).addElement(new quyen_bw("Gửi tin", new quyen_ip(this, var2, var1)));
         var3.addElement(new quyen_bw("Chọn/Bỏ chọn hết", new quyen_ir(this, var2)));
         quyen_ci var4 = new quyen_ci(var3);
         var1.m = new quyen_bw("Menu", new quyen_is(this, var4));
         var1.b(1);
         quyen_et.c.a((quyen_cj)var1);
         quyen_et.c.e(var1);
      }
   }

   public static void a(String var0, quyen_ba var1, quyen_b var2) {
      if (var2.e == null) {
         var2.e = new quyen_bb();
      }

      var2.e.a(var0, var1);
      var2.b();
   }

   public static void a(long var0, quyen_b var2) {
      if (var2.e != null) {
         var2.e.b(null, var0);
         var2.b();
      }
   }

   public final quyen_ba b(String var1) {
      return this.b.e == null ? null : this.b.e.a(var1, null, 0L);
   }

   public final boolean b(long var1) {
      return c(var1, this.K);
   }

   public final boolean c(long var1) {
      return c(var1, this.J);
   }

   public final boolean d(long var1) {
      return c(var1, this.L);
   }

   public final String e(long var1) {
      if (this.S.containsKey(new Long(var1))) {
         return (String)this.S.get(new Long(var1));
      } else {
         quyen_ba var3;
         return this.b.e != null && (var3 = this.b.e.a(null, null, var1)) != null ? var3.a : null;
      }
   }

   public final long c(String var1) {
      quyen_ba var2;
      return this.b != null && this.b.e != null && (var2 = this.b.e.a(var1, null, 0L)) != null ? var2.l : 0L;
   }

   public final void f(long var1) {
      a(var1, this.J);
   }

   public final void g(long var1) {
      b(var1, this.J);
   }

   public final void h(long var1) {
      a(var1, this.K);
   }

   public final void i(long var1) {
      b(var1, this.K);
   }

   public final void j(long var1) {
      a(var1, this.L);
      this.j();
   }

   public final void k(long var1) {
      b(var1, this.L);
      this.j();
      if (I == 3) {
         this.c.e.b(null, var1);
         this.c.b();
      }
   }

   public final void l(long var1) {
      b(var1, this.K);
      if (I == 2) {
         this.c.e.b(null, var1);
         this.c.b();
         quyen_et.c.d("Xóa ID thành công");
      }
   }

   public final void m(long var1) {
      if (this.b.e != null && !this.b.e.a("Favorite", var1)) {
         quyen_b var7 = this.b;
         quyen_ba var8;
         if ((var8 = var7.e == null ? null : var7.e.a(null, null, var1)) == null) {
            return;
         }

         this.b.e.b("Favorite", var8);
         quyen_bd var9;
         if ((var9 = this.b.e.a("Favorite")) != null && var9.a.size() > 9) {
            var9.a.removeElementAt(var9.a.size() - 1);
         }

         quyen_et.a(this.b.e, false, d);
         this.b.b();
      }
   }

   public final void a(long var1, int var3) {
      if (this.b.e.a("Favorite") != null && this.b.e.a("Favorite", var1)) {
         int var4 = 0;

         for (int var5 = this.b.f.size(); var4 < var5; var4++) {
            quyen_bj var6;
            if ((var6 = (quyen_bj)this.b.f.elementAt(var4)).a == 0 && var6.m == var1) {
               var6.g = var3;
               return;
            }
         }
      }
   }

   public final void a(long[] var1, String[] var2) {
      if (I == 1) {
         if (this.b.e != null) {
            this.b.e.a("Ban Be", var1, var2);
            this.b.b();
            String[] var3 = var2;
            long[] var9 = var1;
            quyen_ia var8 = this;
            if (this.b.e.a("Favorite") != null) {
               int var4 = var1.length;

               while (--var4 >= 0) {
                  if (var8.b.e.a("Favorite", var9[var4])) {
                     int var5 = 0;

                     for (int var6 = var8.b.f.size(); var5 < var6; var5++) {
                        quyen_bj var7;
                        if ((var7 = (quyen_bj)var8.b.f.elementAt(var5)).a == 0 && var7.m == var9[var4]) {
                           var7.g = 1;
                           var7.e = var3[var4];
                           if (var3[var4] != null && var3[var4].length() > 0) {
                              var7.f = quyen_hr.a(var7.d, " - ", var3[var4], null);
                           } else {
                              var7.f = var7.d;
                           }
                        }
                     }
                  }
               }
            }
         }
      } else if (this.c.e != null) {
         if (I == 2) {
            this.c.e.a("Danh sách từ chối", var1, var2);
         } else {
            this.c.e.a("Danh sách kết bạn", var1, var2);
         }

         this.c.b();
      }
   }

   public final void d(String var1) {
      if (var1.equals("")) {
         quyen_et.e().d("ID không hợp lệ.");
      } else if (!this.b.b(var1)) {
         quyen_a.b(var1);
         this.o();
         quyen_et.e().a("Đã gửi yêu cầu kết bạn đến " + var1, (Image) null, 1);
      } else {
         quyen_et.e().d("ID đã tồn tại.");
      }
   }

   private void o() {
      this.e();
      this.c = null;
      this.a(this.b);
      quyen_hr.a(this, this.b);
      super.m = new quyen_bw("Menu", new quyen_it(this));
      quyen_hr.b(H, "Bạn Bè");
      I = 1;
      System.gc();
   }

   private static void a(long var0, Vector var2) {
      var2.addElement(new Long(var0));
   }

   public static void a(long[] var0, Vector var1) {
      var1.removeAllElements();
      int var2 = 0;

      for (int var3 = var0.length; var2 < var3; var2++) {
         var1.addElement(new Long(var0[var2]));
      }
   }

   public static long[] b(Vector var0) {
      long[] var1 = new long[var0.size()];
      int var2 = var0.size();

      while (--var2 >= 0) {
         var1[var2] = ((Long)var0.elementAt(var2)).longValue();
      }

      return var1;
   }

   private static void b(long var0, Vector var2) {
      int var3 = var2.size();

      while (--var3 >= 0) {
         if (((Long)var2.elementAt(var3)).longValue() == var0) {
            var2.removeElementAt(var3);
            return;
         }
      }
   }

   public final void b(long var1, String var3) {
      if (!this.S.contains(new Long(var1))) {
         this.S.put(new Long(var1), var3);
         quyen_et.a(this.S);
      }
   }

   private static boolean c(long var0, Vector var2) {
      int var3 = var2.size();

      while (--var3 >= 0) {
         if (((Long)var2.elementAt(var3)).longValue() == var0) {
            return true;
         }
      }

      return false;
   }

   static quyen_cs a(quyen_ia var0) {
      return var0.R;
   }

   static void b(quyen_ia var0) {
      var0.n();
   }

   static quyen_cs c(quyen_ia var0) {
      return var0.U;
   }

   static void a(quyen_ia var0, quyen_cs var1) {
      var0.U = var1;
   }

   static quyen_ca d(quyen_ia var0) {
      return var0.V;
   }

   static void a(quyen_ia var0, quyen_ca var1) {
      var0.V = var1;
   }

   static quyen_ca e(quyen_ia var0) {
      return var0.W;
   }

   static void b(quyen_ia var0, quyen_ca var1) {
      var0.W = var1;
   }

   static quyen_bw f(quyen_ia var0) {
      if (var0.aa == null) {
         var0.aa = new quyen_bw(quyen_cr.c(), new quyen_ih(var0));
      }

      return var0.aa;
   }

   static quyen_cs g(quyen_ia var0) {
      return var0.Z;
   }

   static quyen_bv h(quyen_ia var0) {
      return var0.Y;
   }

   static quyen_co i(quyen_ia var0) {
      return var0.X;
   }

   static void j(quyen_ia var0) {
      var0.o();
      var0.n = var0.ab;
   }
}
