import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_cw extends quyen_bx {
   private static int z;
   public static int a;
   private static quyen_dy[] A;
   public static quyen_dy[] b;
   private byte[] B;
   private byte[] C;
   private int D;
   private int E;
   public String c;
   private static int F;
   public int d;
   public quyen_dy[] e;
   private quyen_dy[] G;
   public boolean f;
   public boolean g;
   public boolean u;
   public static boolean v;
   private boolean H;
   private int I;
   private int J;
   private long K;
   private long L;
   private static int M;
   private static boolean N;
   private int O;
   private int P;
   private int Q;
   private int R;
   private int S;
   private int T;
   public quyen_dy[] w;
   public boolean x;
   public static boolean y;
   private quyen_dy[][] U;
   private int V;
   private int W;
   private int X;
   private int Y = 39;
   private int Z;
   private static int[] aa;

   public quyen_cw() {
      quyen_et.i();
      this.E = quyen_cj.i - 48;
      if (quyen_cj.h > 130) {
         ;
      }

      M = 73;
      super.j = 0;
      super.k = 0;
      super.l = quyen_cj.h;
      super.m = quyen_cj.i;
      super.i = true;
      aa = new int[]{0, 6, 12, 18, 24, 30, 36, 42, 50, 56, 62, 68, 74};
   }

   public final void a(byte[] var1) {
      b = null;
      A = null;
      this.e = null;
      this.G = null;
      System.gc();
      z = 0;
      this.B = var1;
      N = true;
      this.x = false;
      b = new quyen_dy[a = this.B.length];
      A = new quyen_dy[z];
      this.e = new quyen_dy[z];
      this.G = new quyen_dy[3];

      for (int var2 = 0; var2 < this.G.length; var2++) {
         this.G[var2] = new quyen_dy();
         this.G[var2].a((quyen_cj.h >> 1) - 30 + var2 * 14, quyen_cj.i - 130 >> 1);
      }

      for (int var3 = 0; var3 < z; var3++) {
         this.e[var3] = new quyen_dy();
      }

      for (int var4 = 0; var4 < a; var4++) {
         b[var4] = new quyen_dy();
         b[var4].a = this.B[var4];
         b[var4].b = (byte)(this.B[var4] >> 2);
         b[var4].c = (byte)(this.B[var4] % 4);
         b[var4].a(50 + var4 * 14, quyen_cj.i - 100);
         if (var4 == a - 1) {
            b[var4].d = true;
         }
      }

      this.D = 0;
      this.g();
      this.I = 0;
      this.J = 0;
      this.K = 10L;
      this.L = System.currentTimeMillis();
   }

   public final void b(int var1, int var2) {
      if (!y && a > 0) {
         int var5 = var2;
         int var4 = var1;
         quyen_cw var3 = this;
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;

         int var10000;
         while (true) {
            if (var8 >= a) {
               var10000 = -1;
               break;
            }

            var6 = b[var8].g;
            var7 = b[var8].h;
            if (var4 > var6 && var4 < var6 + (var8 == a - 1 ? 40 : var3.X) && var5 > var7 && var5 < var7 + 54) {
               var10000 = var8;
               break;
            }

            var8++;
         }

         int var9 = var10000;
         if (var10000 != -1) {
            this.D = var9;
            if (!b[this.D].e) {
               this.b(12);
            } else {
               this.b(13);
            }

            int var10 = quyen_bt.b(quyen_cz.O.o.a);
            var4 = (super.l >> 1) - (var10 >> 1);
            var5 = super.m;
            if (var1 > var4 && var1 < var4 + var10 && var2 > var5 && var2 < var5 + quyen_et.e) {
               this.b(16);
            }
         }
      }
   }

   private static void c(int var0) {
      b[var0].e = true;
      b[var0].h -= 16;
      b[var0].d = true;
      if (var0 > 0) {
         b[var0 - 1].d = true;
      }
   }

   public final boolean b(int var1) {
      if (v) {
         return false;
      } else {
         boolean var2 = true;
         switch (var1) {
            case 12:
               if (!y && a > 0 && !b[this.D].e) {
                  c(this.D);
               }

               var2 = false;
               return var2;
            case 13:
               if (!y && a > 0 && b[this.D].e) {
                  b[this.D].e = false;
                  b[this.D].h += 16;
                  if (this.D != a - 1) {
                     b[this.D].d = true;
                  }

                  if (this.D > 0) {
                     b[this.D - 1].d = true;
                  }

                  var2 = false;
               }

               if (!quyen_cz.O.G) {
                  var2 = false;
               }

               return var2;
            case 14:
               this.D--;
               if (this.D >= 0) {
                  var2 = false;
                  return var2;
               }

               this.D = 0;
               break;
            case 15:
               this.D++;
               if (this.D <= a - 1) {
                  var2 = false;
                  return var2;
               }

               this.D = a - 1;
               break;
            case 16:
               System.out.println("==>");
               System.out.println(quyen_ia.d);
               System.out.println(this.c);
               if (!y && quyen_ia.d.equals(this.c) && !this.x) {
                  System.out.println("=> 111");

                  for (int var3 = 0; var3 < a; var3++) {
                     if (b[var3].e) {
                        z++;
                     }
                  }

                  A = null;
                  this.C = null;
                  System.gc();
                  A = new quyen_dy[z];
                  this.C = new byte[z];
                  var1 = 0;

                  for (int var6 = 0; var6 < a; var6++) {
                     if (b[var6].e) {
                        A[var1] = b[var6];
                        var1++;
                     }
                  }

                  var2 = this.a(A);
                  System.out.println("isValidMove ==");
                  System.out.println(var2);
                  System.out.println("isSentThisTurn ==");
                  System.out.println(this.x);
                  if (!this.x && var2) {
                     System.out.println("is sending");

                     for (int var5 = 0; var5 < z; var5++) {
                        this.C[var5] = (byte)A[var5].a;
                     }

                     quyen_a.a(quyen_cz.d, quyen_ia.d, F, this.C);
                     this.x = true;
                  } else {
                     z = 0;
                     this.x = false;
                     if (!var2) {
                        quyen_et.c.a("Nước đi không hợp lệ", (Image)null, 1);
                     }
                  }
               }
            case 17:
               break;
            default:
               return var2;
         }

         return true;
      }
   }

   public final void a() {
      for (int var1 = 0; var1 < a; var1++) {
         c(var1);
      }
   }

   public final void b() {
      for (int var1 = 0; var1 < a; var1++) {
         if (b[var1].e) {
            b[var1].e = false;
         }
      }

      this.g();
      this.f();
      z = 0;
      this.x = false;
   }

   private void f() {
      if (this.D < 0) {
         this.D = 0;
      }

      if (this.D >= a) {
         this.D = a - 1;
      }
   }

   public final void b(byte[] var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < a; var3++) {
         for (int var4 = 0; var4 < var1.length; var4++) {
            if (b[var3].a == var1[var4]) {
               b[var3].e = true;
               b[var3].f = true;
            } else {
               b[var3].e = false;
            }
         }
      }

      for (int var5 = 0; var5 < a; var5++) {
         if (!b[var5].f) {
            b[var2] = b[var5];
            var2++;
         }
      }

      a -= var1.length;
      this.g();

      for (int var6 = 0; var6 < z; var6++) {
         if (var6 == z - 1) {
            A[var6].d = true;
         }
      }

      z = 0;
      this.f();
   }

   public final void a(Graphics var1) {
      if (quyen_cz.b) {
         var1.setClip(0, -5, quyen_cj.h, quyen_cj.i);
         if (v) {
            Graphics var15 = var1;
            quyen_cw var13 = this;
            int var18 = (quyen_cj.h >> 1) - 50;
            int var10 = quyen_cj.i - 140 >> 1;
            a(var1, var18, var10);
            if (this.I < a) {
               var18 += (b[this.I].g - var18) * (this.J + 1) / 3;
               var10 += (b[this.I].h - var10) * (this.J + 1) / 3;
               a(var1, var18, var10);
            }

            for (int var7 = 0; var7 < var13.I; var7++) {
               if (!b[var7].f && var13.I < a) {
                  var13.a(var15, b[var7]);
               }
            }
         } else {
            if (y) {
               Graphics var4 = var1;
               quyen_cw var3 = this;
               this.V = this.U.length;

               for (int var5 = 0; var5 < var3.V; var5++) {
                  var3.W = var3.U[var5].length;

                  for (int var2 = 0; var2 < var3.W; var2++) {
                     if (var3.U[var5][var2] != null) {
                        var3.a(var4, var3.U[var5][var2]);
                     }
                  }
               }
            } else {
               for (int var8 = 0; var8 < a; var8++) {
                  if (b[var8] != null && !b[var8].f) {
                     if (var8 != this.D && !b[var8].e) {
                        this.a(var1, b[var8]);
                     } else {
                        quyen_dy var16 = b[var8];
                        var1.drawRegion(quyen_et.y, 40, 0, 40, 54, 0, var16.g, var16.h, 20);
                        this.a(var1, var16.g, var16.h, var16.d, var16.b, var16.c);
                     }
                  }
               }
            }

            if (quyen_cz.O.L && N) {
               if (this.u) {
                  if (this.G != null) {
                     this.V = this.G.length;

                     for (int var9 = 0; var9 < this.V; var9++) {
                        if (this.G[var9] != null) {
                           quyen_dy var17 = this.G[var9];
                           a(var1, var17.g, var17.h);
                        }
                     }
                  }
               } else {
                  Graphics var14 = var1;
                  quyen_cw var12 = this;

                  try {
                     if (var12.w != null) {
                        var12.a(var14, var12.w);
                     }

                     if (var12.e != null) {
                        var12.a(var14, var12.e);
                     }
                  } catch (NullPointerException var6) {
                     var6.printStackTrace();
                  }
               }
            }

            if (!y && !quyen_cz.O.c) {
               var1.drawImage(quyen_et.A, this.Z + this.D * this.X + (this.X - 6 >> 1), this.E, 0);
            }
         }
      }
   }

   public final void a(byte[] var1, int var2, int var3) {
      this.e = null;
      System.gc();
      this.H = true;
      this.w = this.e;
      this.V = var1.length;
      this.e = new quyen_dy[this.V];

      for (int var4 = 0; var4 < this.V; var4++) {
         this.e[var4] = new quyen_dy();
         this.e[var4].a = var1[var4];
         this.e[var4].b = (byte)(var1[var4] >> 2);
         this.e[var4].c = (byte)(var1[var4] % 4);
         if (var4 == var1.length - 1) {
            this.e[var4].d = true;
         }
      }

      this.O = quyen_cj.h - ((this.V > 1 ? (this.V - 1) * 14 : 0) + 40) >> 1;
      this.P = quyen_cj.i - 120 >> 1;
      this.Q = (this.O - var2) / 5;
      this.R = (this.P - var3) / 5;
      this.S = var2;
      this.T = var3;
      this.V = this.e.length;

      for (int var5 = 0; var5 < this.V; var5++) {
         this.e[var5].a(var2 + var5 * 14, var3);
      }
   }

   private void a(Graphics var1, quyen_dy[] var2) {
      try {
         this.V = var2.length;

         for (int var3 = 0; var3 < this.V; var3++) {
            if (var2[var3] != null) {
               this.a(var1, var2[var3]);
            }
         }
      } catch (NullPointerException var4) {
         var4.printStackTrace();
      }
   }

   public final void d() {
      long var2;
      if (v && (var2 = System.currentTimeMillis()) - this.L >= this.K) {
         this.L = var2;
         this.J = (this.J + 1) % 2;
         if (this.J == 0) {
            this.I++;
            if (this.I > a) {
               v = false;
               this.I = 0;
            }
         }
      }

      if (this.H) {
         quyen_cw var1;
         int var3;
         label45: {
            var1 = this;
            int var4 = this.S;
            var3 = this.T;
            if (quyen_b.c(this.O - this.S) > quyen_b.c(this.Q)) {
               this.S = this.S + this.Q;
               if (this.S != var4) {
                  break label45;
               }
            }

            this.S = this.O;
         }

         label40: {
            if (quyen_b.c(this.P - this.T) > quyen_b.c(this.R)) {
               this.T = this.T + this.R;
               if (this.T != var3) {
                  break label40;
               }
            }

            this.T = this.P;
         }

         this.V = this.e.length;

         for (int var5 = 0; var5 < var1.V; var5++) {
            var1.e[var5].a(var1.S + var5 * 14, var1.T);
         }

         if (var1.S == var1.O && var1.T == var1.P) {
            var1.w = null;
            var1.H = false;
            if (!quyen_cz.O.B) {
               quyen_cz.O.i();
            }
         }
      }
   }

   private void g() {
      this.X = (quyen_cj.h - this.Y) / (a > 1 ? a - 1 : 1);
      if (this.X > this.Y) {
         this.X = this.Y;
      }

      this.Z = quyen_cj.h - ((a > 1 ? (a - 1) * this.X : 0) + this.Y) >> 1;

      for (int var1 = 0; var1 < a; var1++) {
         b[var1].a(this.Z + this.X * var1, quyen_cj.i - M);
      }
   }

   public final void c() {
      this.U = null;
      System.gc();
      this.U = new quyen_dy[quyen_cz.O.P][];
      this.V = quyen_cz.O.Q.length;

      for (int var1 = 0; var1 < quyen_cz.O.P; var1++) {
         String var2 = quyen_cz.O.C[var1].a;
         int var3 = quyen_cz.O.C[var1].g;

         for (int var4 = 0; var4 < this.V; var4++) {
            if (quyen_cz.O.Q[var4].equals(var2)) {
               this.U[var1] = new quyen_dy[quyen_cz.O.R[var4].length];
               this.W = this.U[var1].length;
               int var7;
               if ((var7 = (quyen_cj.h - this.Y) / (this.W > 1 ? this.W - 1 : 1)) > this.Y) {
                  var7 = this.Y;
               }

               int var5 = quyen_cj.h - ((this.W > 1 ? (this.W - 1) * var7 : 0) + this.Y) >> 1;
               int var6 = 0;
               if (var3 == 0) {
                  var6 = quyen_cj.i - M;
               } else if (var3 == 1) {
                  var5 = quyen_cj.h - this.Y - (this.W > 1 ? this.W - 1 : 1) * var7 - 1;
                  var6 = quyen_cj.i >> 1;
               } else if (var3 != 2 && var3 == 3) {
                  var5 = 1;
                  var6 = (quyen_cj.i >> 1) - 65;
               }

               for (int var8 = 0; var8 < this.W; var8++) {
                  this.U[var1][var8] = new quyen_dy();
                  this.U[var1][var8].a = quyen_cz.O.R[var4][var8];
                  this.U[var1][var8].b = (byte)(quyen_cz.O.R[var4][var8] >> 2);
                  this.U[var1][var8].c = (byte)(quyen_cz.O.R[var4][var8] % 4);
                  this.U[var1][var8].g = var5 + var8 * var7;
                  this.U[var1][var8].h = var6;
                  if (var8 == this.U[var1].length - 1) {
                     this.U[var1][var8].d = true;
                  }
               }
               break;
            }
         }
      }
   }

   private boolean a(quyen_dy[] var1) {
      System.gc();
      boolean var2 = false;

      int[] var9;
      try {
         quyen_dy[] var3 = var1;
         int var4;
         int[] var5 = new int[var4 = var1.length];
         var4 = var4;

         while (--var4 >= 0) {
            var5[var4] = var3[var4].a;
         }

         var9 = var5;
      } catch (Exception var6) {
         return false;
      }

      if (!this.g && quyen_ia.d.equals(this.c)) {
         if (this.f && b(var1) == b(b)) {
            if (var2 = this.a(var9, 0)) {
               this.f = false;
            }
         } else if (!this.f && (var2 = this.a(var9, 0)) && !this.u) {
            int var13 = 0;
            quyen_dy[] var16 = this.e;
            var13 = this.d;
            var1 = A;
            int var10 = F;
            var2 = false;
            if (var10 == var13) {
               if (var1.length == var16.length && var1[var1.length - 1].a > var16[var16.length - 1].a) {
                  var2 = true;
               }
            } else if (var16[var16.length - 1].b == 15) {
               if (var16.length != 1 || var10 != 10 && var10 != 11 && var10 != 12) {
                  if (var16.length == 2 && (var10 == 11 || var10 == 12)) {
                     var2 = true;
                  }
               } else {
                  var2 = true;
               }
            } else if (var13 != 10 || var10 != 12 && var10 != 11) {
               if (var13 == 11 && var10 == 12) {
                  var2 = true;
               }
            } else {
               var2 = true;
            }

            var2 = var2;
         }
      } else {
         boolean var12 = false;
         boolean var15 = false;
         if (var9.length == 8 && this.b(var9, 0)) {
            var15 = true;
         }

         if (var15) {
            if (this.d != 10 && this.d != 11 && (this.e.length != 1 && this.e.length != 2 || this.e[this.e.length - 1].b != 15)) {
               var2 = false;
            } else {
               F = 12;
               var2 = true;
            }
         } else {
            var2 = false;
         }
      }

      System.gc();
      return var2;
   }

   private static int b(quyen_dy[] var0) {
      return var0.length == 0 ? 0 : var0[0].a;
   }

   private boolean a(int[] var1, int var2) {
      boolean var6 = false;
      byte var3 = 0;
      boolean var4;
      if (var1.length == 1) {
         F = 1;
         var4 = true;
      } else if (var1.length == 2) {
         var4 = false;
         int[] var5;
         if ((var5 = this.a(var1)).length == 2 && var5[0] == var5[1]) {
            var4 = true;
         }

         if (var4 && var3 == 1 && !this.f(var1[0], var1[1]) && var5[0] != 15) {
            var4 = false;
         }

         if (var4 = var4) {
            F = 2;
         }
      } else if (var1.length == 3) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         } else {
            int[] var8;
            if (var4 = (var8 = this.a(var1)).length == 3 && var8[0] == var8[1] && var8[1] == var8[2]) {
               F = 3;
            }
         }
      } else if (var1.length == 4) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         } else {
            var4 = false;
            int[] var10;
            if ((var10 = this.a(var1)).length == 4 && var10[0] == var10[1] && var10[2] == var10[3] && var10[0] == var10[2]) {
               var4 = true;
            }

            if (var4 = var4) {
               F = 11;
            }
         }
      } else if (var1.length == 5) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         }
      } else if (var1.length == 6) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         } else if (var4 = this.b(var1, var3)) {
            F = 10;
         }
      } else if (var1.length == 7) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         }
      } else if (var1.length == 8) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         } else if (var4 = this.b(var1, var3)) {
            F = 12;
         }
      } else if (var1.length == 9) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         }
      } else if (var1.length == 10) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         }
      } else if (var1.length == 11) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         }
      } else if (var1.length == 12) {
         if (var4 = this.c(var1, var3)) {
            F = 4;
         }
      } else {
         var4 = false;
      }

      return var4;
   }

   private boolean b(int[] var1, int var2) {
      boolean var3 = false;
      if (var1.length % 2 == 0) {
         int var4;
         int[] var5 = new int[var4 = var1.length >> 1];
         int[] var6 = new int[var4];

         for (int var7 = 0; var7 < var4; var7++) {
            var5[var7] = var1[var7 << 1];
            var6[var7] = var1[1 + (var7 << 1)];
         }

         int var8;
         int var9;
         if (this.c(var5, var2) && this.c(var6, var2) && (var8 = var5[0]) >> 2 == (var9 = var6[0]) >> 2) {
            var3 = true;
            if (var2 == 1 && !this.f(var5[0], var6[0])) {
               var3 = false;
            }
         }
      }

      return var3;
   }

   private boolean c(int[] var1, int var2) {
      boolean var3 = true;
      int var4 = 0;
      int[] var5;
      if ((var5 = this.a(var1))[var5.length - 1] == 15) {
         var3 = false;
      } else {
         int var6 = 0;

         for (int var9 = var5.length - 1; var6 < var9; var6++) {
            if (var5[var6 + 1] - 1 != var5[var6]) {
               var3 = false;
               break;
            }
         }
      }

      if (var2 == 1 && var3) {
         var4 = var1.length;

         for (int var11 = 1; var11 < var4; var11++) {
            if ((var2 = var1[var11]) % 4 != (var2 = var1[var11 - 1]) % 4) {
               var3 = false;
               break;
            }
         }
      }

      return var3;
   }

   private int[] a(int[] var1) {
      int var2;
      int[] var3 = new int[var2 = var1.length];
      var2 = var2;

      while (--var2 >= 0) {
         int var4;
         var3[var2] = (var4 = var1[var2]) >> 2;
      }

      return var3;
   }

   private boolean f(int var1, int var2) {
      return var1 % 4 + var2 % 4 == 1 || var1 % 4 + var2 % 4 == 5;
   }

   public final boolean a(int var1) {
      return false;
   }

   private void a(Graphics var1, quyen_dy var2) {
      int var5 = var2.h;
      int var4 = var2.g;
      var1.drawRegion(quyen_et.y, 0, 0, 40, 54, 0, var4, var5, 20);
      this.a(var1, var2.g, var2.h, var2.d, var2.b, var2.c);
   }

   private void a(Graphics var1, int var2, int var3, boolean var4, int var5, int var6) {
      int var10004 = var2 + 7;
      int var11 = var3 + 8;
      int var10 = var10004;
      int var10003 = var5 - 3;
      boolean var17 = var6 == 0 || var6 == 1;
      boolean var15 = var5 == 10;
      boolean var13 = var17;
      int var9 = var10003;
      var1.drawRegion(quyen_et.w, aa[var9], var13 ? 0 : 9, var15 ? 8 : 6, 9, 0, var10, var11, 3);
      var10003 = var2 + 7;
      var10 = var3 + 19;
      var9 = var10003;
      var1.drawRegion(quyen_et.x, var6 << 3, 0, 8, 8, 0, var9, var10, 3);
      switch (var5) {
         case 11:
            if (var6 != 0 && var6 != 1) {
               var1.drawRegion(quyen_et.D, 23, 0, 23, 37, 0, var9 + 5, var10 - 7, 20);
               return;
            }

            var1.drawRegion(quyen_et.D, 0, 0, 23, 37, 0, var9 + 5, var10 - 7, 20);
            return;
         case 12:
            if (var6 != 0 && var6 != 1) {
               var1.drawRegion(quyen_et.D, 26, 37, 26, 43, 0, var9 + 3, var10 - 13, 20);
               return;
            }

            var1.drawRegion(quyen_et.D, 0, 37, 26, 43, 0, var9 + 3, var10 - 13, 20);
            return;
         case 13:
            if (var6 != 0 && var6 != 1) {
               var1.drawRegion(quyen_et.D, 23, 80, 23, 41, 0, var9 + 5, var10 - 11, 20);
               return;
            }

            var1.drawRegion(quyen_et.D, 0, 80, 23, 41, 0, var9 + 5, var10 - 11, 20);
            return;
         default:
            switch (var6) {
               case 0:
                  var1.drawRegion(quyen_et.C, 72, 0, 22, 31, 0, var9 + 6, var10 - 3, 20);
                  return;
               case 1:
                  var1.drawRegion(quyen_et.C, 47, 0, 26, 31, 0, var9 + 2, var10 - 3, 20);
                  return;
               case 2:
                  var1.drawRegion(quyen_et.C, 23, 0, 24, 31, 0, var9 + 2, var10 - 2, 20);
                  return;
               case 3:
                  var1.drawRegion(quyen_et.C, 0, 0, 23, 31, 0, var9 + 4, var10 - 3, 20);
            }
      }
   }

   private static void a(Graphics var0, int var1, int var2) {
      var0.drawRegion(quyen_et.y, 80, 0, 40, 54, 0, var1, var2, 20);
   }
}
