import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class quyen_hg extends quyen_cj {
   private quyen_bw A = new quyen_bw(quyen_cr.c(), new quyen_hh(this));
   public long a;
   private boolean B;
   private String C;
   public String b;
   public quyen_o c;
   quyen_cs d;
   private final quyen_ci D;
   private final Vector E;

   public quyen_hg(String var1, boolean var2, int[] var3, String var4) {
      super.s = true;
      this.B = var2;
      super.j = var1;
      this.C = var4;
      this.d = new quyen_cs();
      this.d.d = false;
      this.d.a(1, quyen_cj.i - quyen_et.e - quyen_bt.i - 1, quyen_cj.h - 3, quyen_bt.e + 6);
      this.d.q = this.A;
      this.d.w = new quyen_hj(this);
      this.c = new quyen_o(0, 0, quyen_cj.h, quyen_cj.i - (quyen_et.e + quyen_bt.i));
      this.a(this.c);
      this.a(this.d);
      quyen_hr.a(this, (quyen_bx)this.d);
      this.E = new Vector();
      this.E.addElement(new quyen_bw("Biểu cảm", new quyen_hk(this)));
      this.E.addElement(new quyen_bw("BUZZ!", new quyen_hl(this, var2)));
      if ((var2 ? !quyen_et.c.i.a.b(var4) : !quyen_et.c.h.b.b(var1)) && !var1.equals(quyen_ia.d)) {
         this.E.addElement(new quyen_bw("Thêm bạn", new quyen_hm(this, var2, var4, var1)));
      }

      if (!var2) {
         this.E.addElement(new quyen_bw("Media", new quyen_hn(this, var1)));
         this.E.addElement(new quyen_bw("Hồ sơ", new quyen_ho(this, var1)));
      }

      this.E.addElement(new quyen_bw("Copy", new quyen_hp(this)));
      this.E.addElement(new quyen_bw("Dán", new quyen_hq(this)));
      this.D = new quyen_ci(this.E);
      super.m = new quyen_bw("Menu", new quyen_hi(this));
      super.o = new quyen_bw("Chat", null);
      if (quyen_et.K != null) {
         this.c.a(quyen_et.K, 2);
      }
   }

   public final void a(long var1) {
      this.a = var1;
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if (var1[16]) {
         var1[16] = false;
         this.d.c(quyen_hs.b(this.d.c()));
         if (this.d.c().equals("")) {
            String var7;
            int var9;
            if ((var9 = (var7 = this.c.c()).indexOf("http://")) >= 0) {
               String var8 = var7.substring(var9);

               try {
                  Xuka.i.platformRequest(var8);
               } catch (ConnectionNotFoundException var4) {
               }

               return false;
            } else {
               this.d.a();
               return false;
            }
         } else {
            if (this.d.c().equals("plf")) {
               this.c.a("", Xuka.j, 0);
            }

            Object var5 = null;
            if (this.B) {
               quyen_a.a((String)(var5 = quyen_jc.b), this.C, this.d.c(), 2);
            } else {
               quyen_a.a(this.a, this.d.c());
            }

            this.c.a(this.B ? quyen_jc.c : quyen_ia.B, this.d.c(), 0);
            this.c.b();
            this.d.c("");
            return false;
         }
      } else if (var1[12] || var2[12]) {
         var1[12] = false;
         this.c.a(12);
         return false;
      } else if (!var1[13] && !var2[13]) {
         return super.a(var1, var2, var3);
      } else {
         var1[13] = false;
         this.c.a(13);
         return false;
      }
   }

   public final void b() {
      this.c.e();
   }

   public final void a(Graphics var1) {
      this.c.b(var1);
   }

   static quyen_bw a(quyen_hg var0) {
      return var0.A;
   }

   static String b(quyen_hg var0) {
      return var0.C;
   }

   static Vector c(quyen_hg var0) {
      return var0.E;
   }

   static quyen_ci d(quyen_hg var0) {
      return var0.D;
   }
}
