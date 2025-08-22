import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class quyen_ec extends quyen_co {
   quyen_cs a;
   quyen_cs b;
   quyen_cs c;
   quyen_bu d;
   quyen_bv D;
   private Vector F;
   quyen_ci E;
   private int G;
   private quyen_bw H = new quyen_bw("Đăng ký", new quyen_ed(this));
   private static quyen_co I;

   public final void b(Graphics var1) {
      super.b(var1);
      quyen_bt.a(quyen_bt.c).a(quyen_et.b, this.G, quyen_cj.g + 3, var1);
   }

   public quyen_ec() {
      this.G = quyen_cj.h - quyen_bt.b(quyen_et.b) - 6;
      Vector var1;
      (var1 = new Vector()).addElement(quyen_et.Q);
      var1.addElement(new quyen_bw("Gửi góp ý", new quyen_el(this)));
      var1.addElement(quyen_et.P);
      var1.addElement(quyen_et.R);
      quyen_bw var2;
      (var2 = new quyen_bw("Hỗ trợ", null)).c = new quyen_ci(var1);
      String var6 = Xuka.b();
      String var3 = Xuka.c();
      int var4 = Xuka.g();
      super.o = new quyen_bw("Đăng nhập", new quyen_en(this));
      super.j = " X Yahoo! ";
      quyen_hr.a(quyen_hr.h, quyen_hr.i);
      super.B = quyen_cj.i - ((quyen_bt.i << 2) + quyen_cp.a + (quyen_n.k > 180 ? 40 : 11) + quyen_et.e) >> 1;
      quyen_bw.a(this, 0, quyen_cp.c(), quyen_cp.c().getWidth(), quyen_cp.c().getHeight(), false, false);
      super.B += 10;
      this.a = quyen_bw.a(this, var4 == 0 ? "Xubi ID:" : "Yahoo! ID:", 0, -1);
      super.B += 6;
      this.b = quyen_bw.a(this, quyen_hr.a("Mật khẩu", ":", null, null), 2, -1);
      this.a.x = -5;
      this.b.x = -5;
      super.B += 6;
      quyen_ce var5 = new quyen_ce("Tài khoản:", quyen_hr.d, super.B, quyen_bt.e);
      this.D = new quyen_bv(new String[]{"Xubi", "Yahoo!"}, quyen_hr.e, super.B - 3, quyen_hr.g, quyen_bt.e + 6);
      this.D.c(var4);
      this.D.c = new quyen_eo(this);
      this.a(var5);
      this.a(this.D);
      super.B += 3;
      var4 = quyen_cj.h - (quyen_bt.b("Đăng nhập ẩn") + 13 + 4) >> 1;
      this.d = new quyen_bu("Đăng nhập ẩn", var4, super.B, quyen_bt.b("Đăng nhập ẩn") + 13 + 4, quyen_bt.e + 4);
      this.d.a = Xuka.b("status", false);
      this.a(this.d);
      super.B += 4;
      super.A = quyen_cj.h - quyen_bt.b("Đăng ký tài khoản") >> 1;
      quyen_bw.a(this, "Đăng ký tài khoản", -1, this.H.b, super.A, super.B, super.C);
      quyen_hr.a(this, (quyen_bx)this.a);
      this.F = new Vector();
      this.F.addElement(this.H);
      this.F.addElement(new quyen_bw("Quên mật khẩu?", new quyen_ep(this)));
      this.F.addElement(new quyen_bw("Cấu hình", new quyen_eq(this)));
      this.F.addElement(var2);
      this.F.addElement(new quyen_bw("Thoát", new quyen_er(this)));
      this.E = new quyen_ci(this.F);
      super.m = new quyen_bw("Menu", new quyen_es(this));
      if (var6 != null) {
         this.a.c(var6);
      }

      if (var3 != null) {
         this.b.c(var3);
      }

      if (var6 != null && var6.length() > 0 && var3 != null && var3.length() > 0 && quyen_et.n && !quyen_jv.i) {
         super.o.b.a();
      }
   }

   public static void a() {
      if (I == null) {
         System.gc();
         (I = new quyen_co()).j = "Cấu Hình";
         I.B += 14;
         quyen_bv var0 = quyen_bw.a(I, "Tốc độ phím: ", new String[]{"1", "2", "3", "4", "5", "6", "7"});
         quyen_bu var1 = quyen_bw.a(I, "Âm thanh", !quyen_et.l);
         quyen_bu var2 = quyen_bw.a(I, "Rung", quyen_et.m);
         quyen_bu var3 = quyen_bw.a(I, "Tự đăng nhập", quyen_et.n);
         quyen_bu var4 = quyen_bw.a(I, "Tự đăng nhập Yahoo!", quyen_et.o);
         quyen_bw.a(I, quyen_hr.a("Xóa", " dữ liệu cá nhân", null, null), new quyen_ee(), I.B + 2, 0);
         var0.c(quyen_cs.e);
         quyen_hr.a(I, var0);
         boolean var5 = var2.a;
         boolean var6 = var1.a;
         boolean var7 = var3.a;
         boolean var8 = var4.a;
         int var9 = var0.a();
         I.n = new quyen_bw(quyen_cr.c(), new quyen_ef(var2, var5, var1, var6, var3, var7, var4, var8, var0, var9));
         I.o = new quyen_bw("Lưu", new quyen_eg(var3, var4, var0, var2, var1));
      }

      quyen_et.e().a((quyen_cj)I);
      I.b(-1);
      quyen_et.e().o();
   }

   public final void h() {
      String var1;
      String var2 = quyen_hr.a(var1 = quyen_hr.a("Bạn sẽ nhận mật khẩu qua tin nhắn.", "\n", "Gửi tin: ", quyen_et.J), this.a.c(), Xuka.f, "\nĐến số: ");
      quyen_et.c.a(quyen_hr.a(var1, var2, null, null), new quyen_eh(this));
   }

   public final void i() {
      quyen_n.b();
      if (this.a.c().equals("")) {
         quyen_hr.a(this, (quyen_bx)this.a);
      } else if (this.b.c().equals("")) {
         quyen_hr.a(this, (quyen_bx)this.b);
      } else {
         quyen_jv.i = false;
         int var2 = Xuka.a;
         quyen_ju var3 = new quyen_ju(500, 2);
         quyen_a.a(var2, var3);
         quyen_jv.a(var3);
         quyen_a.e();
         quyen_et.e().a(quyen_hr.a("Đăng nhập với ", this.a.c(), null, null), null, null, new quyen_bw(quyen_cr.c(), new quyen_ej(this))).a(true);
         quyen_et.e().g();
         quyen_ek var1 = new quyen_ek(this);
         quyen_et.e().g = var1;
      }
   }

   static quyen_co j() {
      return I;
   }
}
