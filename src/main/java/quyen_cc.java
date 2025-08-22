import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_cc extends quyen_bx {
   private quyen_ca b;
   public boolean a;
   private int c;
   private int d;
   private int[] e = null;
   private Integer[] f;
   private Integer g;
   private Image u;

   public quyen_cc() {
      super.h = false;
   }

   public final boolean b(int var1) {
      return true;
   }

   public final void a(String var1, quyen_ca var2) {
      if (var2 != null) {
         this.b = var2;
         super.r = new quyen_bw(var1, new quyen_cd(this));
      }
   }

   public final void b(int var1, int var2) {
      if (super.h) {
         if (this.j()) {
            if (this.b != null) {
               this.b.a();
               return;
            }
         } else {
            quyen_hr.a(super.o, this);
         }
      }
   }

   public final void a(Graphics var1) {
      if (this.a) {
         this.c = super.j + 6;
         this.d = super.k + 6;
         int var10003 = super.l - 1;
         int var10004 = super.m - 1;
         byte var2 = 8;
         int var6 = var10004;
         int var5 = var10003;
         int var4 = super.k;
         int var3 = super.j;
         var1.setColor(11320516);
         var1.drawRoundRect(var3, var4, var5, var6, 8, 8);
      } else {
         this.c = super.j;
         this.d = super.k;
      }

      if (this.j()) {
         if (this.a) {
            quyen_bs.b(var1, super.j, super.k, super.l - 1, super.m - 1);
         } else {
            quyen_bs.b(var1, super.j - 6, super.k - 6, super.l + 9, super.m + 9);
         }
      }

      if (this.u != null) {
         var1.drawImage(this.u, this.c, this.d, 0);
      } else if (this.e == null) {
         var1.drawImage(quyen_ea.a(this.g), this.c, this.d, 0);
      } else {
         for (int var7 = 0; var7 < this.e.length; var7++) {
            var1.drawImage(quyen_ea.a(this.f[var7]), super.j + (super.l >> 1) + (this.e[var7] >> 24), super.k + (super.m >> 1) + (this.e[var7] << 8 >> 24), 0);
         }
      }
   }

   public final void c(int var1) {
      this.g = new Integer(var1);
   }

   public final void a(Image var1) {
      this.u = var1;
   }

   public final void a(int[] var1) {
      this.e = var1;
      this.f = new Integer[var1.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         this.f[var2] = new Integer((short)var1[var2]);
      }
   }

   public final void d() {
   }

   public final boolean a(int var1) {
      return true;
   }
}
