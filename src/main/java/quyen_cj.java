import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public class quyen_cj {
   private boolean a;
   public boolean e;
   public static int f;
   public static int g;
   public static int h;
   public static int i;
   public String j;
   public String k = "";
   public Vector l;
   public quyen_bw m;
   public quyen_bw n;
   public quyen_bw o;
   private int b;
   public boolean p = true;
   public boolean q;
   public int r;
   private int c;
   public boolean s;
   public int t;
   public int u;
   private int d;
   private int A;
   public int v;
   public boolean w = false;
   public int x;
   public boolean y = false;
   private String B = "";
   private String C = "";
   private String D = "";
   public static int z;
   private static int E = 0;
   private boolean F;
   private int G;
   private int H;

   public final void a(int var1) {
      this.b = var1;
      this.p = true;
   }

   public final int c() {
      return this.b;
   }

   public final void b(int var1) {
      this.q = true;
      if (var1 == -1) {
         this.r = h;
         this.c = -h >> 2;
      } else {
         this.r = -h;
         this.c = h >> 2;
      }
   }

   public quyen_cj() {
      this.l = new Vector();
      this.a(-1);
   }

   public void b(Graphics var1) {
      this.e(var1);
      this.d(var1);
      var1.setClip(0, 0, 1000, 1000);
      this.a(var1);
      this.c(var1);
   }

   public final void c(Graphics var1) {
      var1.setClip(0, 0, 1000, 1000);
      f(var1);
      this.B = this.C = this.D = "";
      if (this.m != null) {
         this.B = this.m.a;
      }

      if (this.n != null) {
         this.C = this.n.a;
      }

      if (this.o != null) {
         this.D = this.o.a;
      }

      if (this.b != -1) {
         quyen_bx var2;
         if ((var2 = (quyen_bx)this.l.elementAt(this.b)).p != null) {
            this.B = var2.p.a;
         }

         if (var2.q != null) {
            this.C = var2.q.a;
         }

         if (var2.r != null) {
            this.D = var2.r.a;
         }
      }

      if (this.p) {
         this.p = false;
         quyen_hr.a(this.D, this.C);
      }

      quyen_bt.a(quyen_bt.c).a(this.B, 4, z, var1);
      quyen_bt.a(quyen_bt.c).a(this.C, quyen_hr.c, z, var1);
      quyen_bt.a(quyen_bt.c).a(this.D, quyen_hr.b, z, var1);
   }

   public final void d(Graphics var1) {
      for (int var2 = 0; var2 < this.x; var2++) {
         var1.setClip(0, g, h, i - quyen_et.e);
         var1.translate(0, -this.u);
         var1.translate(0, g);
         quyen_bx var3;
         if ((var3 = (quyen_bx)this.l.elementAt(var2)).k - this.u + var3.m > 0 && var3.k - this.u < i - quyen_et.e - 10) {
            var3.a(var1);
         }

         var1.translate(0, -g);
         var1.translate(0, this.u);
      }

      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
   }

   public void e(Graphics var1) {
   }

   public void a(quyen_bx var1) {
      if (!this.l.contains(var1)) {
         var1.o = this;
         this.l.addElement(var1);
         this.d();
         if (var1 instanceof quyen_ch || var1 instanceof quyen_cb) {
            this.a = true;
         }
      }
   }

   public final void d() {
      this.x = this.l.size();
      int var2 = 0;
      if (this.x > 1) {
         quyen_bx var3;
         var2 = (var3 = (quyen_bx)this.l.elementAt(this.x - 1)).k + var3.m + 6 + quyen_et.e;
      }

      if (var2 > i) {
         quyen_cq.a = true;
         quyen_cq.a(this.x);
         this.H = var2 - i;
      } else {
         quyen_cq.a = false;
      }
   }

   public void b(quyen_bx var1) {
      this.l.removeElement(var1);
      this.d();
   }

   public void e() {
      this.l.removeAllElements();
      this.d();
   }

   public final void c(int var1) {
      quyen_bx var4;
      int var2 = (var4 = (quyen_bx)this.l.elementAt(var1)).k + g + var4.m;
      if (var4.k < this.t + 6 && this.b != 0) {
         this.t = var4.k - (quyen_bt.h << 1);
         if (this.t < 0) {
            this.t = 0;
            return;
         }
      } else if (var2 > this.t + i + 1 && !this.y) {
         this.t = var2 - i + quyen_bt.h * 3 + 2;
         if (this.t > this.H) {
            this.t = this.H;
            return;
         }
      } else if (var4.k < this.u) {
         this.t = var4.k - 6;
      }
   }

   public final void f() {
      if (this.q) {
         this.r = this.r + this.c;
         if (this.r < 10 && this.r > -10) {
            this.q = false;
         }
      }
   }

   private void a() {
      int var1 = this.b;
      if (!quyen_hr.a((quyen_bx)this.l.elementAt(var1))) {
         quyen_bx var2;
         do {
            if (--var1 == -1) {
               var1 = this.x - 1;
            }
         } while (quyen_hr.c(var2 = (quyen_bx)this.l.elementAt(var1)) || !var2.h);

         this.e(var1);
      }
   }

   private void g() {
      int var1 = this.b;
      if (!quyen_hr.a((quyen_bx)this.l.elementAt(var1))) {
         quyen_bx var2;
         do {
            if (++var1 == this.x) {
               var1 = 0;
            }
         } while (quyen_hr.c(var2 = (quyen_bx)this.l.elementAt(var1)) || !var2.h);

         this.e(var1);
      }
   }

   private void e(int var1) {
      this.a(var1);
      this.c(var1);
      quyen_cq.a(true);
   }

   public boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      boolean var4 = false;
      if (this.u != this.t) {
         this.A = this.t - this.u << 2;
         this.d = this.d + this.A;
         this.u = this.u + (this.d >> 4);
         this.d &= 15;
      }

      if (this.b != -1) {
         if (var3[0] > 0) {
            ((quyen_bx)this.l.elementAt(this.b)).b(var3[0]);
            var3[0] = 0;

            for (int var9 = 0; var9 < var1.length; var9++) {
               var1[var9] = false;
            }

            return false;
         }

         for (int var7 = 0; var7 < 21; var7++) {
            if (var2[var7] && ++E > 4) {
               if (((quyen_bx)this.l.elementAt(this.b)).a(var7)) {
                  if (var7 == 12) {
                     this.a();
                  } else if (var7 == 13) {
                     this.g();
                  }

                  var2[var7] = false;
               }

               E = 4;
            } else if (var1[var7]) {
               if (((quyen_bx)this.l.elementAt(this.b)).b(var7)) {
                  if (var7 == 12) {
                     this.a();
                  } else if (var7 == 13) {
                     this.g();
                  } else {
                     quyen_ca var5 = null;
                     if (var7 == 17) {
                        if (this.m != null) {
                           var5 = this.m.b;
                        }

                        quyen_bx var10;
                        if (this.b != -1 && (var10 = (quyen_bx)this.l.elementAt(this.b)).p != null) {
                           var5 = var10.p.b;
                        }
                     } else if (var7 == 18) {
                        if (this.n != null) {
                           var5 = this.n.b;
                        }

                        quyen_bx var11;
                        if (this.b != -1 && (var11 = (quyen_bx)this.l.elementAt(this.b)).q != null) {
                           var5 = var11.q.b;
                        }
                     } else if (var7 == 16) {
                        if (this.o != null) {
                           var5 = this.o.b;
                        }

                        quyen_bx var12;
                        if (this.b != -1 && (var12 = (quyen_bx)this.l.elementAt(this.b)).r != null) {
                           var5 = var12.r.b;
                        }
                     }

                     if (var5 != null) {
                        var5.a();
                     }
                  }

                  var4 = true;
               } else {
                  var4 = false;
               }

               var1[var7] = false;
            }
         }
      }

      int var8 = this.x;

      while (--var8 >= 0) {
         ((quyen_bx)this.l.elementAt(var8)).d();
      }

      return var4;
   }

   public void a(int var1, int var2) {
      if (this.F && !this.s) {
         this.F = false;
         this.t = this.t - (var2 - this.G) * 5;
      } else {
         int var3 = this.l.size();

         while (--var3 >= 0) {
            quyen_bx var4 = (quyen_bx)this.l.elementAt(var3);
            if (var1 > var4.j && var2 + this.u > var4.k && var1 < var4.j + var4.l && var2 + this.u < var4.k + var4.m) {
               var4.b(var1 - var4.j, var2 + this.u - var4.k);
               return;
            }
         }

         quyen_cq.a(true);
      }
   }

   public void b(int var1, int var2) {
      int var3 = this.x;

      while (--var3 >= 0) {
         quyen_bx var4 = (quyen_bx)this.l.elementAt(var3);
         if (var1 > var4.j && var2 + this.u > var4.k && var1 < var4.j + var4.l && var2 + this.u < var4.k + var4.m && var4.i) {
            var4.c(var1 - var4.j, var2 + this.u - var4.k);
            return;
         }
      }

      if (!this.s && quyen_b.c(var2 - this.G) > 1) {
         this.F = true;
         this.t = this.t - (var2 - this.G);
         if (this.t < 0) {
            this.t = 0;
         } else if (this.t > this.H) {
            this.t = this.H;
         }

         this.u = this.t;
         this.G = var2;
      }

      quyen_cq.a(true);
   }

   public void c(int var1, int var2) {
      int var3 = this.x;

      while (--var3 >= 0) {
         quyen_bx var4 = (quyen_bx)this.l.elementAt(var3);
         if (var1 > var4.j && var2 + this.u > var4.k && var1 < var4.j + var4.l && var2 + this.u < var4.k + var4.m && var4.i) {
            var4.a(var1 - var4.j, var2 + this.u - var4.k);
            return;
         }
      }

      if (!this.s) {
         this.G = var2;
      }
   }

   public final void d(int var1, int var2) {
      if (!this.s) {
         this.G = var2;
      }
   }

   public static void f(Graphics var0) {
      if (quyen_bt.a) {
         var0.drawImage(quyen_et.q, 0, i + 2, 20);
      }
   }

   public quyen_bx d(int var1) {
      int var2 = this.x;

      while (--var2 >= 0) {
         quyen_bx var3;
         if ((var3 = (quyen_bx)this.l.elementAt(var2)).n == var1) {
            return var3;
         }
      }

      return null;
   }

   public void b() {
      if (this.x > 0 && this.a && ((quyen_bx)this.l.elementAt(0)).t) {
         ((quyen_bx)this.l.elementAt(0)).e();
      }
   }

   public void a(Graphics var1) {
      if (this.x > 0 && this.a && ((quyen_bx)this.l.elementAt(0)).t) {
         ((quyen_bx)this.l.elementAt(0)).b(var1);
      } else {
         quyen_cq.a(var1, this.b);
      }
   }
}
