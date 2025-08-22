import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_cb extends quyen_bx {
   private Integer[] d;
   private int[] e;
   private Vector f;
   private int g;
   private int u;
   private int v;
   private int w;
   private int x;
   private int y;
   private int z;
   public int a = 0;
   public int b = 0;
   private int A = 0;
   public int c = 0;
   private int B = 0;
   private int C;
   private int D;
   private boolean E;
   private int F;
   private int G;
   private int H;
   private int I;
   private int J;
   private int K;
   private int L;
   private int M;
   private int N;
   private boolean O;
   private boolean P;
   private int Q;
   private int R;
   private int S = 0;
   private int T;

   public quyen_cb(int var1, int var2, int var3, int var4, int var5, String[] var6, int[] var7, Integer[] var8, int var9, int var10, boolean var11, int var12) {
      super.j = 0;
      super.k = 0;
      super.l = var3;
      super.m = var4;
      super.i = true;
      this.v = var5;
      this.f = new Vector();
      var1 = 0;

      for (int var14 = var6.length; var1 < var14; var1++) {
         String[] var17 = quyen_bt.a(var6[var1], '-');
         this.f.addElement(var17);
      }

      this.e = var7;
      this.d = var8;
      this.C = var9;
      this.D = var10;
      this.E = false;
      super.t = true;
      this.F = 2;
      var2 = (this.C < 30 ? 30 : this.C) + (quyen_n.j > 220 ? 25 : 23);
      this.c = super.l / var2;
      this.B = this.v % this.c == 0 ? this.v / this.c : this.v / this.c + 1;
      this.g = (super.l - this.c * this.C) / (this.c + 1) + 3;
      this.u = 28;
      this.y = this.u + this.D + 6;
      this.w = (super.l - this.c * (this.C + this.g) >> 1) + (this.g >> 1);
      this.x = super.k;
      var2 = this.x + (this.B + 1) * this.y - super.m;
      this.z = var2 / this.y;
      this.A = 0;
      this.a = 0;
      this.b = 0;
      this.G = 11;
      this.Q = this.C + this.G;
      if (this.Q < 50) {
         this.Q = 50;
         this.G = this.Q - this.C;
      }

      this.R = this.D + 15 - 4;
      this.H = this.Q >> 1;
      this.I = this.D + 10 >> 1;
   }

   private boolean f(int var1, int var2) {
      return var1 == this.b && var2 == this.a;
   }

   private boolean g(int var1, int var2) {
      return var1 * this.c + var2 <= this.v - 1;
   }

   public final int a() {
      return this.e[this.b * this.c + this.a];
   }

   private void a(Graphics var1, String var2, int var3, int var4) {
      quyen_bt.a(quyen_bt.c).a(var2, var3 + (this.C - quyen_bt.b(var2) >> 1), var4, var1);
   }

   public final boolean a(int var1) {
      if (var1 != 13 && var1 != 12 && var1 != 14 && var1 != 15) {
         return true;
      } else {
         this.b(var1);
         return false;
      }
   }

   public final boolean b(int i) {
      boolean b = true;
      switch (i) {
         case 14: {
            if (this.a > 0) {
               --this.a;
               b = false;
               break;
            }
            break;
         }
         case 15: {
            if (this.a < this.c - 1 && this.g(this.b, this.a + 1)) {
               ++this.a;
               b = false;
               break;
            }
            break;
         }
         case 12: {
            if (this.b > 0) {
               --this.b;
               if (this.A < 0) {
                  this.A += this.y;
               }
            }
            else {
               this.b = this.B - 1;
               i = this.z;
               if (!this.g(this.b, this.a)) {
                  --this.b;
                  --i;
               }
               if (this.x + this.b * this.y > quyen_cj.i - quyen_et.e - 30) {
                  this.A -= i * this.y;
               }
            }
            this.b();
            b = false;
            quyen_cq.a(true);
            break;
         }
         case 13: {
            i = this.a;
            while (i >= 0) {
               if (this.b == this.B - 1) {
                  this.b = 0;
                  this.A = 0;
                  break;
               }
               if (this.g(this.b + 1, i)) {
                  ++this.b;
                  this.a = i;
                  i = quyen_cj.i - quyen_et.e - 30;
                  final int n = this.B * this.y;
                  if (this.x + this.b * this.y > i && n + this.A > i) {
                     this.A -= this.y;
                     break;
                  }
                  break;
               }
               else {
                  --i;
               }
            }
            this.b();
            b = false;
            quyen_cq.a(true);
            break;
         }
      }
      return b;
   }

   private void b() {
      this.S = 0;
      if (this.b != 0) {
         int var1 = (this.b + 1) * this.y + this.A + 5;
         if (super.m - var1 > 20 && this.b == this.B - 1 && this.A < 0) {
            this.S = 30;
         } else {
            if (super.m - var1 < 0) {
               this.S = super.m - var1;
            }
         }
      }
   }

   public final void a(Graphics var1) {
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      Graphics var2 = var1;
      quyen_cb var11 = this;
      this.N = this.x + this.A + this.S + quyen_cj.g + 15;
      int var3 = this.v;

      while (--var3 >= 0) {
         var11.L = var3 / var11.c;
         var11.M = var3 % var11.c;
         var11.J = var11.w + var11.M * (var11.C + var11.g);
         var11.K = var11.L * (var11.y - 4) + var11.N;
         String[] var4 = (String[])var11.f.elementAt(var3);
         var11.O = var11.f(var11.L, var11.M);
         var11.P = var11.F == 2 && var4.length > 1 && var4[1] != null;
         if (var11.K + var11.D + 10 > var11.k && var11.K < quyen_cj.i) {
            Image var10002 = var11.E ? null : quyen_ea.a(var11.d[var3]);
            boolean var10 = var11.O;
            int var9 = var11.K;
            int var8 = var11.J;
            Image var7 = var10002;
            var8 -= var11.G >> 1;
            var9 -= 5;
            if (var10) {
               quyen_bs.b(var2, var8 - 1, var9 - 1, var11.Q, var11.R);
            }

            var2.drawImage(var7, var8 + var11.H, var9 + var11.I, 3);
            var11.a(var2, var4[0], var11.J, var11.K + var11.D + 5);
            if (var11.P) {
               var11.K = var11.K + (quyen_bt.e - 2);
               var11.a(var2, var4[1], var11.J, var11.K + var11.D + 1);
            }
         }
      }
   }

   public final void e() {
      if (this.x + this.B * this.y > quyen_cj.i) {
         quyen_cq.a = true;
         quyen_cq.a(this.B);
      } else {
         quyen_cq.a = false;
      }
   }

   public final void b(Graphics var1) {
      quyen_cq.a(var1, this.b);
   }

   public final void a(int var1, int var2) {
      this.T = var2;
   }

   public final void b(int var1, int var2) {
      var2 += quyen_cj.g;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      for (int var7 = 0; var7 < this.v; var7++) {
         var5 = var7 / this.c;
         var6 = var7 % this.c;
         var3 = this.w + var6 * (this.C + this.g);
         var4 = this.x + var5 * this.y + this.A + 5;
         if (var1 > var3 - 4 && var1 < var3 + this.C + 4 && var2 > var4 && var2 < var4 + this.D + 24) {
            if (this.f(var5, var6)) {
               super.r.b.a();
            } else {
               this.b = var5;
               this.a = var6;
            }
            break;
         }
      }

      quyen_cq.a(true);
   }

   public final void c(int var1, int var2) {
      if (quyen_b.c(var1 = var2 - this.T) > 10) {
         if (var1 > 0) {
            this.A += var1;
            if (this.A > 0) {
               this.A = 0;
            }
         } else {
            this.A += var1;
            if (this.A < -this.z * this.y + 15) {
               this.A = -this.z * this.y + 15;
            }
         }

         this.T = var2;
      }

      quyen_cq.a(true);
   }

   public final void d() {
   }
}
