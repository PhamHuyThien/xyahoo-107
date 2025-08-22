import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class quyen_ch extends quyen_bx {
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
   private int D;
   private int E;
   private int F;
   public quyen_bw a;
   private quyen_bw G;
   private quyen_bw H;
   private boolean I;
   private int J;
   private int K;
   public quyen_bb b;
   public Vector c;
   private int L;
   private int M;
   private StringBuffer N;
   private boolean O;
   private quyen_bj P;
   public quyen_ca d;
   private boolean Q;
   private boolean R;
   private int S;
   private int T;
   private int U;
   private int V;
   private int W;
   private int X;
   private int Y;
   private int Z;
   private boolean aa;
   private int ab;
   private int ac;
   private boolean ad;

   public final void a(int var1, int var2, int var3) {
      this.e = var1;
      this.g = var2;
      this.u = var3;
   }

   public final void c(int var1) {
      this.f = var1;
   }

   public final int a() {
      return this.e;
   }

   public final void a(boolean var1) {
      this.I = var1;
   }

   public final void a(quyen_bb var1, int var2, boolean var3) {
      this.K = var2;
      this.F = 0;
      if (var3) {
         super.m = super.m - (quyen_et.e + 2);
      }

      this.U = super.l - 36 - this.g;
      this.A = this.B = quyen_bt.e + 8;
      this.C = (this.B << 1) - 3;
      if (this.K == 0) {
         if (this.B < this.u + 8) {
            this.B = this.u + 8;
            this.C = (this.B << 1) - 4;
         }
      } else if (this.K == 1 && this.C < this.u + 8) {
         this.C = this.u + 8;
      }

      this.b = var1;
      this.Z = this.e != 0 ? 15 + this.g : 9;
      this.J = super.l - 18;
      if (this.f != 0) {
         this.J -= 12;
      }

      if (this.e != 0) {
         this.J = this.J - (6 + this.g);
      }

      this.b();
   }

   public quyen_ch(int var1, int var2, int var3, int var4) {
      super(0, 0, var3, var4, true);
      new Vector();
      this.a = new quyen_bw("Chọn", null);
      this.G = new quyen_bw("", null);
      this.H = new quyen_bw("Chọn", null);
      this.I = false;
      String[] var10000 = new String[]{"Vui lòng chờ"};
      this.Z = 22;
      this.ad = false;
      super.t = true;
      super.i = true;
   }

   public final void b() {
      if (this.c == null) {
         this.c = new Vector();
      } else {
         this.c.removeAllElements();
      }

      System.gc();
      if (this.b != null && this.b.a != null && this.b.a.size() != 0) {
         this.M = 0;
         Vector var1 = this.b.a;
         int var2 = this.b.a.size();
         int var3 = 0;

         for (int var4 = 0; var4 < var2; var4++) {
            quyen_bd var9 = (quyen_bd)var1.elementAt(var4);
            quyen_bj var5;
            (var5 = new quyen_bj()).c = var9.a();
            if (var5.c != null && var5.c.length() > 0) {
               var5.a = 1;
               var5.g = var9.b;
               this.c.addElement(var5);
               if (var5.g == 1) {
                  continue;
               }
            }

            Vector var11 = var9.a;
            var3 = var9.a.size();

            for (int var6 = 0; var6 < var3; var6++) {
               quyen_ba var7 = (quyen_ba)var11.elementAt(var6);
               quyen_bj var8;
               (var8 = new quyen_bj()).k = var7.a();
               var8.c = var7.a;
               var8.g = var7.c;
               var8.d = var7.b;
               var7.b();
               var8.b = null;
               var8.b = new Integer(var7.b());
               var8.m = var7.l;
               var8.j = var7.h;
               var8.l = var7.d;
               var8.n = var7.m;
               var8.o = var7.n;
               if (var8.l != null && quyen_n.j < 160) {
                  if (this.N == null) {
                     this.N = new StringBuffer();
                  } else {
                     this.N.delete(0, this.N.length());
                  }

                  this.N.append(var8.d);
                  this.N.append(" - ");
                  this.N.append(var8.l);
                  var8.d = this.N.toString();
                  var8.l = null;
               }

               if (this.M == 0 && var8.l != null) {
                  this.M = super.l - (quyen_bt.b(var8.l) + 31);
               }

               var8.h = var7.g;
               var8.e = var7.f;
               var8.i = var7;
               this.c.addElement(var8);
            }
         }

         this.L = this.c.size();
         if (this.F < 0) {
            this.F = 0;
         }

         if (this.F >= this.L) {
            this.F = this.L - 1;
         }

         if (this.K == 0) {
            this.E = super.m / this.A + 2;
            this.z = this.L * this.B - super.m;
         } else if (this.K == 1) {
            this.E = super.m / this.C + (var2 > 1 ? var2 : 2);
            this.z = this.L * this.C - super.m;
         }

         this.h();
         this.i();
         this.e();
         System.gc();
      } else {
         this.D = 0;
         this.E = 0;
         this.z = 0;
      }
   }

   private void h() {
      if (this.F == -1 || this.F >= this.c.size() || this.c.size() == 0) {
         super.r = null;
      } else if (((quyen_bj)this.c.elementAt(this.F)).a == 1) {
         super.r = this.G;
      } else if (this.I) {
         super.r = this.H;
      } else {
         super.r = this.a;
      }
   }

   public final boolean a(int var1) {
      if (var1 != 13 && var1 != 12) {
         return true;
      } else {
         this.b(var1);
         return false;
      }
   }

   private void i() {
      if (this.K == 0) {
         this.v = this.F * this.B - (super.m >> 1);
      } else {
         this.v = this.F * this.C - (super.m >> 1);
      }

      this.D = this.F - (this.E >> 1) - 1;
      if (this.L - this.F < this.E >> 1) {
         this.D = this.L - this.E;
      }

      if (this.D < 0) {
         this.D = 0;
      }
   }

   public final boolean b(int var1) {
      if (this.c != null && this.L != 0) {
         label38: {
            this.O = true;
            if (var1 == 12) {
               this.F--;
               if (this.F >= 0) {
                  break label38;
               }

               this.F = this.L - 1;
            } else if (var1 == 13) {
               this.F++;
               if (this.F < this.L) {
                  break label38;
               }

               this.F = 0;
            }

            this.O = false;
         }

         if (var1 == 12 || var1 == 13) {
            this.h();
            this.i();
            quyen_n.b();
            quyen_cq.a(true);
            this.l();
            quyen_hr.b(this);
         }

         if (var1 == 16) {
            this.k();
            quyen_n.b();
         }

         return !this.O;
      } else {
         return true;
      }
   }

   private void k() {
      if (this.F == -1) {
         return;
      }
      this.P = (quyen_bj)this.c.elementAt(this.F);
      if (this.P.a == 0) {
         if (this.I) {
            quyen_bj quyen_bj2 = (quyen_bj)this.c.elementAt(this.F);
            ((quyen_bj)this.c.elementAt(this.F)).h = !quyen_bj2.h;
            quyen_bj2.i.g = !quyen_bj2.i.g;
            return;
         }
         if (this.d != null) {
            this.d.a();
            return;
         }
      } else {
         quyen_bd quyen_bd2 = this.b.a(this.P.c);
         if (quyen_bd2 != null) {
            quyen_bd2.b = this.P.g == 0 ? 1 : 0;
         }
         this.b();
      }
   }

   private void l() {
      this.T = 0;
      this.V = 0;
      this.Q = false;
   }

   public final void a(Graphics var1) {
      var1.setClip(super.j, super.k, super.l, super.m);
      var1.translate(0, -this.y);
      if (this.K == 0) {
         this.Y = this.D * this.B - 2;
      } else {
         this.Y = this.D * this.C - 2;
      }

      this.W = this.D + this.E;
      this.X = this.L;
      int var2 = 0;
      int var3 = 0;

      for (int var4 = this.D; var4 <= this.W && var4 < this.X; var4++) {
         quyen_bj var5;
         if ((var5 = (quyen_bj)this.c.elementAt(var4)).a == 1) {
            var3 = this.A;
            var1.setColor(2440262);
            var1.fillRect(0, var4 == 0 ? this.Y + 1 : this.Y + 2, super.l, var3);
            if (var4 == this.F) {
               this.a(var1, var4, var3);
            }

            var2 = this.Y + (this.A >> 1) + 1;
            var1.drawImage(quyen_et.v[var5.g], 10, var2, 3);
            quyen_bt.a(quyen_bt.d).a(var5.c, 22, this.Y + 5, var1);
         } else {
            var3 = this.B;
            if (this.K == 1) {
               var3 = this.C;
            }

            if (var4 == this.F) {
               this.a(var1, var4, var3);
            }

            if (var4 == this.F) {
               if (this.V == 0) {
                  this.S = this.Z;
                  this.V = quyen_bt.b(var5.d);
                  var2 = var5.e == null ? 0 : quyen_bt.b(var5.e);
                  if (this.V < var2) {
                     this.V = var2;
                  }

                  if (this.V > this.U) {
                     this.Q = this.R = true;
                  } else {
                     this.Q = false;
                  }
               }

               if (this.Q && this.T++ > 20) {
                  this.T = 21;
                  if (this.R) {
                     if (this.S > -(this.V - this.U) + this.Z - 9) {
                        this.S--;
                     } else {
                        this.T = 10;
                        this.R = false;
                     }
                  } else if (this.S < this.Z) {
                     this.S++;
                  } else {
                     this.T = 10;
                     this.R = true;
                  }
               }
            }

            var2 = this.Y + (this.K == 0 ? (this.B - quyen_bt.e >> 1) - 1 : this.C - (quyen_bt.e << 1) - 5 >> 1) + 2;
            if (this.f != 0) {
               var1.setClip(-5, var1.getClipY(), this.Z + this.J, var1.getClipHeight());
            }

            if (var5.d != null) {
               quyen_bt.a(var5.b).a(var5.d, var4 == this.F ? this.S : this.Z, var2, var1);
            }

            if (this.K == 1 && var5.e != null) {
               quyen_bt.a(quyen_bt.d).a(var5.e, var4 == this.F ? this.S : this.Z, var2 + quyen_bt.e + 3, var1);
            }

            if (this.f != 0) {
               var1.setClip(super.j, var1.getClipY(), super.l, var1.getClipHeight());
            }

            if (this.I && var5.g != 3) {
               var1.drawRegion(quyen_et.t, 0, var5.h ? 13 : 0, 13, 13, 0, super.l - 12, this.Y + (this.B >> 1), 3);
            } else if (this.f != 0) {
               var1.drawImage(quyen_et.u[this.f == 1 ? var5.g : 6], super.l - 9 - 10, this.Y + ((this.K == 0 ? this.B : this.C) >> 1) + 1, 6);
            }

            if (var5.l != null) {
               if (this.K == 1) {
                  var2 = this.Y + (this.C - quyen_bt.e >> 1);
               }

               quyen_bt.a(quyen_bt.d).a(var5.l, this.M, var2, var1);
            }

            var2 = this.Y + ((this.K == 0 ? this.B : this.C) >> 1) + 1;
            if (this.e != 0) {
               if (this.e != 1) {
                  var1.setClip(var4 == this.F ? this.S - 6 - this.g : 9, this.Y < this.y ? this.y : this.Y + 2, this.g, var3 - 1);
                  var1.drawImage(var5.o == null ? quyen_ea.a(var5.n) : var5.o, var4 == this.F ? this.S - 6 - this.g : 9, var2, 6);
                  var1.setClip(super.j, super.k + this.y, super.l, super.m);
               } else {
                  var1.drawImage(quyen_et.u[5], var4 == this.F ? this.S - 6 - this.g : 9, var2, 6);
               }
            }
         }

         if (var4 == this.F) {
            var1.setColor(8700157);
            var1.fillRect(0, this.Y + 1, super.l, 1);
         } else {
            var1.setColor(6781570);
         }

         var1.fillRect(0, this.Y + var3 + 1, super.l, 1);
         this.Y += var3;
      }

      var1.translate(0, this.y);
   }

   private void a(Graphics var1, int var2, int var3) {
      var1.setColor(66826);
      var1.fillRect(0, var2 == 0 ? this.Y + 1 : this.Y + 2, super.l, var3);
   }

   public final void d() {
      if (this.y != this.v) {
         this.w = this.v - this.y << 2;
         this.x = this.x + this.w;
         this.y = this.y + (this.x >> 4);
         this.x &= 15;
         if (this.y > this.z) {
            this.y = this.z;
         }

         if (this.y < 0) {
            this.y = 0;
         }

         this.D = this.y / (this.K == 0 ? this.B : this.C) - 1;
         if (this.D < 0) {
            this.D = 0;
         }
      }
   }

   public final void e() {
      if (this.c != null) {
         if (super.k + this.L * this.B >= super.m) {
            quyen_cq.a = true;
            quyen_cq.a(this.L);
         } else {
            quyen_cq.a = false;
         }
      }
   }

   public final void b(Graphics var1) {
      quyen_cq.a(var1, this.F);
   }

   public final void a(int var1, int var2) {
      this.ab = var1;
      this.ac = var2;
   }

   public final void b(int var1, int var2) {
      if (this.aa) {
         this.aa = false;
         this.v = this.v - (var2 - this.ac) * 5;
         if (this.v < 0) {
            this.v = 0;
         } else if (this.v > this.z) {
            this.v = this.z;
         }
      } else {
         if (this.K == 0) {
            var1 = (var2 + this.y) / this.B;
         } else {
            var1 = (var2 + this.y) / this.C;
         }

         if (var1 < 0) {
            var1 = 0;
         }

         if (var1 > this.L - 1) {
            var1 = this.L - 1;
         }

         if (this.F == var1) {
            this.k();
            return;
         }

         this.F = var1;
         this.h();
         this.l();
         quyen_hr.b(this);
      }

      quyen_cq.a(true);
   }

   public final void c(int var1, int var2) {
      if (quyen_b.c(var1 - this.ab) > 1 || quyen_b.c(var2 - this.ac) > 1) {
         this.aa = true;
         this.v = this.v - (var2 - this.ac);
         if (this.v < 0) {
            this.v = 0;
         }

         if (this.v > this.z) {
            this.v = this.z;
         }

         this.y = this.v;
         this.D = this.y / (this.K == 0 ? this.B : this.C) - 1;
         if (this.D < 0) {
            this.D = 0;
         }

         this.ab = var1;
         this.ac = var2;
      }

      quyen_cq.a(true);
   }

   public final quyen_bj c() {
      return this.F < 0 ? null : (quyen_bj)this.c.elementAt(this.F);
   }

   public final String[] f() {
      if (this.I) {
         Vector var1 = new Vector();

         for (int var2 = this.L - 1; var2 >= 0; var2--) {
            quyen_bj var3;
            if ((var3 = (quyen_bj)this.c.elementAt(var2)).a == 0 && var3.h) {
               var3.h = false;
               var1.addElement(var3.j);
            }
         }

         if (var1.size() > 0) {
            String[] var4 = new String[var1.size()];
            var1.copyInto(var4);
            return var4;
         }
      }

      return null;
   }

   public final void g() {
      if (this.I) {
         this.ad = !this.ad;

         for (int var1 = this.L - 1; var1 >= 0; var1--) {
            quyen_bj var2;
            if ((var2 = (quyen_bj)this.c.elementAt(var1)).a == 0) {
               var2.h = this.ad;
               var2.i.g = this.ad;
            }
         }
      }
   }
}
