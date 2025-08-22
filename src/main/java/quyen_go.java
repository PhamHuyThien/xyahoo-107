import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_go extends quyen_cj {
   public Image a;
   public byte[] b;
   private int d;
   private int A;
   private int B;
   private int C;
   private int D;
   private int E;
   private int F;
   private int G;
   private int H;
   private int I;
   private int J;
   private int K;
   private quyen_ce L;
   public quyen_bz c;
   private boolean M;
   private int N;
   private int O;
   private quyen_bw P;

   public quyen_go() {
      this.a((String)null);
      this.c = new quyen_bz();
      this.c.h = true;
      this.a(this.c);
      quyen_hr.a((quyen_cj)this, this.c);
      this.n = quyen_et.a(this, true, new quyen_gp(this));
   }

   private final void a(int var1, quyen_bw var2) {
      if (var1 == 0) {
         super.m = var2;
      } else if (var1 == 1) {
         super.o = var2;
      } else {
         if (var1 == 2) {
            super.n = var2;
         }
      }
   }

   public final void a(final byte[] b) {
      this.b = b;
      Image image;
      try {
         image = Image.createImage(b, 0, b.length);
      }
      catch (final Exception ex) {
         image = null;
         ex.printStackTrace();
      }
      if (image != null) {
         final Image a = image;
         this.a = a;
         final int n = 0;
         this.B = n;
         this.I = n;
         final int n2 = 0;
         this.C = n2;
         this.I = n2;
         final int width = a.getWidth();
         this.J = width - quyen_cj.h;
         this.K = a.getHeight() - quyen_cj.i + quyen_et.e + ((this.L == null) ? 0 : (quyen_et.e + 2)) - 1;
         this.d = ((width > quyen_cj.h) ? 0 : (quyen_cj.h - width >> 1));
         this.A = quyen_cj.g + ((this.L == null) ? 0 : (quyen_et.e + 2));
      }
   }

   public final void a(String var1) {
      if (var1 == null || var1.length() == 0) {
         super.j = "Photo";
      } else if (!var1.equals(" ")) {
         super.j = var1;
      }

      quyen_hr.a(this, super.j);
   }

   public final void b(String var1) {
      if (var1 != null) {
         int var2 = quyen_bt.b(var1);
         int var3 = 3;
         if (quyen_cj.h > var2 + 3) {
            var3 = quyen_cj.h - var2 >> 1;
         }

         if (this.L == null) {
            this.L = new quyen_ce(var1, var3, 2, quyen_bt.i);
            this.L.n = 20041987;
            this.L.h = false;
            this.L.d = true;
            this.L.c = true;
            this.L.b = quyen_bt.c;
            this.a(this.L);
            return;
         }

         this.L.a = var1;
      }
   }

   public final void b(Graphics var1) {
      if (this.a != null) {
         var1.setClip(0, quyen_cj.g, quyen_cj.h, quyen_cj.i);
         var1.setColor(0);
         var1.translate(-this.H, -this.I);
         var1.drawImage(this.a, this.d, this.A, 0);
         var1.translate(this.H, this.I);
      }

      this.d(var1);
      this.c(var1);
   }

   public final boolean a(boolean[] var1, boolean[] var2, int[] var3) {
      if ((!var1[14] || this.H > 0) && (!var1[15] || this.H < this.J) && quyen_hr.b(this, this.c)) {
         if (var1[10]) {
            quyen_n.b();
            quyen_et.e().n();
            return false;
         } else if (var1[11]) {
            quyen_n.b();
            quyen_et.e().m();
            return false;
         } else {
            if (var2[12] || var1[12]) {
               this.C -= 85;
            }

            if (var2[13] || var1[13]) {
               this.C += 85;
            }

            if (var2[14] || var1[14]) {
               this.B -= 85;
            }

            if (var2[15] || var1[15]) {
               this.B += 85;
            }

            if (this.B < 0) {
               this.B = 0;
            }

            if (this.B > this.J) {
               this.B = this.J;
            }

            if (this.C <= 0) {
               this.C = 0;
               if (this.L != null) {
                  this.L.k = 2;
               }
            }

            if (this.C > this.K) {
               this.C = this.K;
            }

            if (this.C > quyen_et.e && this.L != null) {
               this.L.k = -100;
            }

            if (this.H != this.B || this.I != this.C) {
               this.D = this.B - this.H << 2;
               this.E = this.C - this.I << 2;
               this.F = this.F + this.D;
               this.H = this.H + (this.F >> 4);
               this.F &= 15;
               this.G = this.G + this.E;
               this.I = this.I + (this.G >> 4);
               this.G &= 15;
               if (this.H > this.J) {
                  this.H = this.J;
               }

               if (this.H < 0) {
                  this.H = 0;
               }

               if (this.I > this.K) {
                  this.I = this.K;
               }

               if (this.I < 0) {
                  this.I = 0;
               }
            }

            var1[12] = false;
            var1[13] = false;
            var1[14] = false;
            var1[15] = false;
            return super.a(var1, var2, var3);
         }
      } else {
         return super.a(var1, var2, var3);
      }
   }

   public final void c(int var1, int var2) {
      this.N = var1;
      this.O = var2;
   }

   public final void a(int var1, int var2) {
      if (this.M) {
         this.M = false;
         this.C = this.C - (var2 - this.O << 3);
         if (this.C < 0) {
            this.C = 0;
         } else if (this.C > this.K) {
            this.C = this.K;
         }

         this.B = this.B - (var1 - this.N << 3);
         if (this.B < 0) {
            this.B = 0;
            return;
         }

         if (this.B > this.J) {
            this.B = this.J;
         }
      }
   }

   public final void b(int var1, int var2) {
      if (quyen_b.c(var1 - this.N) > 1 || quyen_b.c(var2 - this.O) > 1) {
         this.M = true;
         this.C = this.C - (var2 - this.O);
         if (this.C < 0) {
            this.C = 0;
         } else if (this.C > this.K) {
            this.C = this.K;
         }

         this.B = this.B - (var1 - this.N);
         if (this.B < 0) {
            this.B = 0;
         } else if (this.B > this.J) {
            this.B = this.J;
         }
      }

      this.N = var1;
      this.O = var2;
   }

   public final void e(int var1) {
      quyen_bw var2 = new quyen_bw("Gửi", new quyen_gq(this));
      this.a(0, var2);
   }

   public final void a() {
      this.a(0, null);
   }

   public final void f(int var1) {
      if (this.P == null) {
         this.P = new quyen_bw("Lưu", new quyen_gr(this));
      }

      this.a(1, this.P);
   }

   static void a(quyen_go var0, quyen_ce var1) {
      var0.L = null;
   }
}
