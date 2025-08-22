import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class quyen_p extends quyen_co {
   public String a;
   private boolean D;
   public quyen_o b;
   quyen_cs c;
   public boolean d = true;
   private final quyen_ci E;
   private final Vector F;
   private quyen_bw G = new quyen_bw(quyen_cr.c(), new quyen_q(this));

   public quyen_p(String var1, String var2, boolean var3) {
      super.s = true;
      super.j = var1;
      this.a = var2;
      this.D = var3;
      this.c = new quyen_cs();
      this.c.d = false;
      this.c.a(1, quyen_cj.i - quyen_et.e - quyen_bt.i - 1, quyen_cj.h - 3, quyen_bt.e + 6);
      this.c.q = this.G;
      this.c.w = new quyen_y(this);
      quyen_bw.a(quyen_hr.a("Chào mừng bạn vào ", var1, null, null), this, -1, 16777215, false, true);
      this.b = new quyen_o(0, 0, quyen_cj.h, quyen_cj.i - (quyen_et.e + quyen_bt.i));
      this.a(this.c);
      quyen_hr.a(this, (quyen_bx)this.c);
      this.F = new Vector();
      this.F.addElement(new quyen_bw("Biểu cảm", new quyen_z(this)));
      this.F.addElement(new quyen_bw("Copy", new quyen_aa(this)));
      this.F.addElement(new quyen_bw("Dán", new quyen_ab(this)));
      this.F.addElement(new quyen_bw("Bạn trong phòng", new quyen_ac(this)));
      if (this.D) {
         quyen_bw var4 = new quyen_bw("Chức năng khác", null);
         Vector var5;
         (var5 = new Vector()).addElement(new quyen_bw("Mời bạn chat", new quyen_ad(this)));
         var5.addElement(new quyen_bw("Đá khỏi phòng", new quyen_ae(this)));
         var5.addElement(new quyen_bw("Đổi tên phòng", new quyen_r(this)));
         var5.addElement(new quyen_bw("Đổi mật khẩu", new quyen_s(this)));
         var5.addElement(new quyen_bw("Gia hạn phòng", new quyen_t(this)));
         var5.addElement(new quyen_bw("Xóa phòng", new quyen_u(this)));
         var4.c = new quyen_ci(var5);
         this.F.addElement(var4);
      }

      this.E = new quyen_ci(this.F);
      super.m = new quyen_bw("Menu", new quyen_w(this));
      super.o = new quyen_bw("Chat", null);
   }

   public final void a() {
      this.e();
      this.a(this.b);
      this.a(this.c);
      quyen_hr.a(this, (quyen_bx)this.c);
      this.d = false;
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.c.c(quyen_hs.b(this.c.c()));
         if (this.c.c().equals("")) {
            String var5;
            int var7;
            if ((var7 = (var5 = this.b.f()).indexOf("http://")) >= 0) {
               String var6 = var5.substring(var7);

               try {
                  Xuka.i.platformRequest(var6);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.c.a();
               return false;
            }
         } else {
            quyen_a.a(this.a, this.c.c());
            this.c.c("");
            return false;
         }
      } else if (var1[12] || var2[12]) {
         var1[12] = false;
         this.b.a(12);
         return false;
      } else if (!var1[13] && !var2[13]) {
         return super.a(var1, var2, var3);
      } else {
         var1[13] = false;
         this.b.a(13);
         return false;
      }
   }

   public final void b() {
      this.b.e();
   }

   public final void a(Graphics var1) {
      this.b.b(var1);
   }

   static quyen_bw a(quyen_p var0) {
      return var0.G;
   }

   static quyen_ci b(quyen_p var0) {
      return var0.E;
   }
}
