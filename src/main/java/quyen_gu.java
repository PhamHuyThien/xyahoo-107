import javax.microedition.lcdui.Image;

public final class quyen_gu extends quyen_co {
   private static String[] D = new String[]{"admin", "root", "system", "xuka", "yahoo"};
   public quyen_cs a;
   public quyen_cs b;
   private quyen_cs E;
   private String F;
   public String c;
   public String d;

   public quyen_gu() {
      super.j = "Đăng Ký";
      super.m = new quyen_bw(quyen_cr.c(), new quyen_gv(this));
      super.o = new quyen_bw("Đăng ký", new quyen_gw(this));
   }

   public final void a() {
      this.e();
      this.a = null;
      this.b = null;
      this.E = null;
      System.gc();
      quyen_hr.a(quyen_hr.h, quyen_hr.i);
      this.g();
      super.B = quyen_cj.i - (quyen_bt.i * 3 + quyen_cp.a + (quyen_n.k > 180 ? 50 : 31) + quyen_et.e) >> 1;
      quyen_bw.a(this, 0, quyen_cp.c(), quyen_cp.c().getWidth(), quyen_cp.c().getHeight(), false, false);
      if (quyen_n.k > 220) {
         super.B += 15;
      } else if (quyen_n.k > 180 && quyen_n.k <= 220) {
         super.B += 10;
      } else {
         super.B += 5;
      }

      this.a = quyen_bw.a(this, quyen_hr.a("Xubi ID", ":", null, null), 0, -1);
      super.B += 5;
      this.b = quyen_bw.a(this, quyen_hr.a("Mật khẩu", ":", null, null), 2, -1);
      super.B += 5;
      this.E = quyen_bw.a(this, quyen_hr.a("Nhập lại", ":", null, null), 2, -1);
      quyen_hr.a(this, (quyen_bx)this.a);
   }

   protected final void h() {
      quyen_et var1;
      (var1 = quyen_et.e()).a((quyen_cj)var1.j);
      var1.e(var1.j);
      var1.j.b(1);
      var1.d(this);
   }

   public final void i() {
      int var1;
      if ((var1 = quyen_hs.a(this.a.c())) == 1) {
         quyen_et.e().a("ID phải trên 5 ký tự", (Image) null, 1);
         quyen_hr.a(this, (quyen_bx)this.a);
      } else if (var1 == 2) {
         quyen_et.e().a("ID không được bắt đầu bằng số", (Image) null, 1);
         quyen_hr.a(this, (quyen_bx)this.a);
      } else if (var1 == 3) {
         quyen_et.e().a("ID không được chứa ký tự đặc biệt", (Image) null, 1);
         quyen_hr.a(this, (quyen_bx)this.a);
      } else {
         for (int var2 = 0; var2 < D.length; var2++) {
            if (D[var2].equals(this.a.c())) {
               quyen_et.e().a("Xin chọn tên khác", (Image) null, 1);
               this.a.c("");
               quyen_hr.a(this, (quyen_bx)this.a);
               return;
            }
         }

         if (this.b.c().length() >= 6 && this.b.c().length() <= 64) {
            if (!this.b.c().equalsIgnoreCase(this.a.c()) && (!this.b.c().startsWith("12345") || this.b.c().length() >= 7)) {
               if (!this.E.c().equals("") && this.b.c().equals(this.E.c())) {
                  this.a.c(this.a.c().toLowerCase());
                  if (this.F != null && this.F.equals(this.a.c())) {
                     this.d = this.F;
                  } else {
                     this.d = this.a.c();
                  }

                  quyen_et.e().a("Đang đăng ký..", null, new quyen_bw(quyen_cr.c(), new quyen_gx(this)), null).a(true);
                  quyen_et.e().g = new quyen_gy(this);
               } else {
                  quyen_et.e().a("Nhập lại mật khẩu", (Image) null, 1);
                  quyen_hr.a(this, (quyen_bx)this.E);
               }
            } else {
               quyen_et.c.a("Mật khẩu không nên quá đơn giản. Vui lòng chọn mật khẩu khác.", (Image) null, 1);
               quyen_hr.a(this, (quyen_bx)this.b);
            }
         } else {
            quyen_et.e().a("Mật khẩu phải trên 5 ký tự", (Image) null, 1);
            quyen_hr.a(this, (quyen_bx)this.b);
         }
      }
   }

   static void a(quyen_gu var0, String var1) {
      var0.F = var1;
   }
}
