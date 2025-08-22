import javax.microedition.lcdui.Graphics;

public final class quyen_cx extends quyen_bx {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int u;
   private int v;
   private int w;
   private int x;
   private int y;
   private int z;
   private int A;
   private int B;
   private int C;
   private quyen_cv[] D;
   private int E;
   private boolean F;
   private int G;

   public quyen_cx(int var1, int var2, int var3) {
      super.l = var1;
      super.m = var2;
      super.i = true;
      this.e = var3;
      this.a = quyen_et.E.getWidth();
      this.b = quyen_et.E.getHeight();
      this.c = this.a >> 1;
      this.d = this.b >> 1;
      super.r = new quyen_bw("Vào bàn", new quyen_cy(this));
   }

   public final void a(quyen_cv[] var1) {
      this.D = var1;
      this.E = var1.length;
      this.g = quyen_cj.h / (this.a + 20);
      this.f = this.E % this.g == 0 ? this.E / this.g : this.E / this.g + 1;
      this.w = (quyen_cj.h - this.g * 50) / (this.g + 1);
      this.x = this.w + 25;
      this.A = 50 + this.w;
      this.y = 25;
      this.z = 0;
      this.B = this.b << 1;
      this.C = (this.y + this.f * this.B + this.b + 15 - super.m) / this.B;
      this.v = 0;
      this.u = 0;
      this.e();
   }

   private boolean f(int var1, int var2) {
      return var1 == this.u && var2 == this.v;
   }

   private boolean g(int var1, int var2) {
      return var1 * this.g + var2 <= this.E - 1;
   }

   public final void a(Graphics var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      for (int var6 = 0; var6 < this.D.length; var6++) {
         var4 = var6 / this.g;
         var5 = var6 % this.g;
         var2 = this.x + var5 * this.A;
         var3 = this.y + var4 * this.B + this.z;
         if (this.f(var4, var5)) {
            quyen_bs.b(var1, var2 - this.c - 11, var3 - this.d - 12, (this.c << 1) + 21, (this.d << 1) + 34);
         }

         var1.drawImage(quyen_et.E, var2, var3, 3);
         if (this.D[var6].a() > 0) {
            var1.drawRegion(quyen_et.G, 0, 18, 18, 22, 0, var2, var3 - 23, 17);
         }

         if (this.D[var6].a() > 1) {
            var1.drawRegion(quyen_et.G, 19, 0, 18, 21, 0, var2, var3 + 1, 17);
         }

         if (this.D[var6].a() > 2) {
            var1.drawRegion(quyen_et.G, 0, 0, 19, 18, 0, var2 - 27, var3, 6);
         }

         if (this.D[var6].a() > 3) {
            var1.drawRegion(quyen_et.G, 18, 21, 22, 18, 0, var2 + 4, var3, 6);
         }

         if (this.D[var6].b == 1) {
            var1.drawImage(quyen_et.F, var2, var3, 3);
         }

         quyen_cp.a(quyen_cz.O.e(var6 + 1), var2 + this.c - 6, var3 - this.d - 7, 0, var1, 1);
         quyen_bt.a(quyen_bt.c).a(this.D[var6].c, var2 - this.c + (this.a - quyen_bt.b(this.D[var6].c) >> 1), var3 + this.d + 7, var1);
      }
   }

   public final boolean b(int var1) {
      boolean var2 = true;
      switch (var1) {
         case 12:
            if (this.u > 0) {
               this.u--;
               if (this.z < 0) {
                  this.z = this.z + this.B;
               }
            } else {
               this.u = this.f - 1;
               var1 = this.C;
               if (!this.g(this.u, this.v)) {
                  this.u--;
                  var1--;
               }

               this.z = this.z - var1 * this.B;
            }

            var2 = false;
            quyen_cq.a(true);
            break;
         case 13:
            for (var1 = this.v; var1 >= 0; var1--) {
               if (this.u == this.f - 1) {
                  this.u = 0;
                  this.z = 0;
                  break;
               }

               if (this.g(this.u + 1, var1)) {
                  this.u++;
                  this.v = var1;
                  var1 = quyen_cj.i - quyen_et.e - (this.b << 1);
                  if (this.y + this.u * this.B > var1) {
                     this.z = this.z - this.B;
                  }
                  break;
               }
            }

            var2 = false;
            quyen_cq.a(true);
            break;
         case 14:
            if (this.v > 0) {
               this.v--;
               var2 = false;
            }
            break;
         case 15:
            if (this.v < this.g - 1 && this.g(this.u, this.v + 1)) {
               this.v++;
               var2 = false;
            }
      }

      return var2;
   }

   public final void d() {
   }

   public final boolean a(int var1) {
      if (var1 != 13 && var1 != 12) {
         return true;
      } else {
         this.b(var1);
         return false;
      }
   }

   public final void e() {
      quyen_cq.a = true;
      quyen_cq.a(this.f);
   }

   public final void b(Graphics var1) {
      quyen_cq.a(var1, this.u);
   }

   public final void a(int var1, int var2) {
      this.G = var2;
   }

   public final void b(int var1, int var2) {
      if (this.F) {
         this.F = false;
      } else {
         var2 += quyen_cj.g;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;
         int var6 = 0;

         for (int var7 = 0; var7 < this.E; var7++) {
            var5 = var7 / this.g;
            var6 = var7 % this.g;
            var3 = this.x + var6 * this.A;
            var4 = this.y + var5 * this.B + this.z;
            if (var1 > var3 - 25 && var1 < var3 + this.a - 15 && var2 > var4 - 10 && var2 < var4 + this.b + 15) {
               if (this.f(var5, var6)) {
                  super.r.b.a();
               } else {
                  this.u = var5;
                  this.v = var6;
               }
               break;
            }
         }

         quyen_cq.a(true);
      }
   }

   public final void c(int var1, int var2) {
      if (quyen_b.c(var1 = var2 - this.G) > 10) {
         this.F = true;
         if (var1 > 0) {
            this.z += var1;
            if (this.z > 0) {
               this.z = 0;
            }
         } else {
            this.z += var1;
            if (this.z < -this.C * this.B) {
               this.z = -this.C * this.B;
            }
         }

         this.G = var2;
      }

      quyen_cq.a(true);
   }

   static quyen_cv[] a(quyen_cx var0) {
      return var0.D;
   }

   static int b(quyen_cx var0) {
      return var0.u * var0.g + var0.v;
   }

   static int c(quyen_cx var0) {
      return var0.e;
   }
}
