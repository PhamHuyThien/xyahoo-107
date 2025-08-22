import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Graphics;

public final class quyen_b extends quyen_bx {
   public boolean a;
   public boolean b;
   public boolean c;
   private String u;
   private boolean v;
   private int w;
   private int x;
   private int y;
   private int z;
   private int A;
   private Vector B;
   private int C;
   private int D;
   private int E;
   public int d;
   private quyen_bw F = new quyen_bw("Chọn", null);
   private quyen_bw G = new quyen_bw("", null);
   private quyen_bw H = new quyen_bw("Chọn", null);
   private boolean I = false;
   public quyen_bb e;
   public Vector f;
   public String[] g;
   private int J;
   private int K;
   private int L;
   private quyen_bj M;
   private quyen_bw N;
   private quyen_ci O;
   private int P;
   private int Q;
   private int R;
   private boolean S;
   private boolean T;
   private int U;
   private int V;
   private int W;
   private int X;
   private boolean Y;
   private int Z;
   private int aa;
   private int ab;
   private int ac;
   private boolean ad;
   private int ae;
   private int af;
   private boolean ag;

   static {
      int[][] var10000 = new int[][]{{0, 13}, {13, 11}, {24, 11}, {35, 11}, {46, 11}, {57, 13}, {70, 8}};
   }

   public final void a(boolean var1) {
      this.I = true;
   }

   public final quyen_bb a() {
      return this.e;
   }

   public final void a(quyen_bb var1, int var2) {
      this.e = var1;
      this.d = -1;
      this.b();
      this.e();
   }

   public quyen_b(int var1, int var2, int var3, int var4, boolean var5) {
      super(0, 1, var3, var4, true);
      System.currentTimeMillis();
      this.ag = false;
      super.i = true;
      this.a = true;
      this.C = quyen_bt.e + 4;
      if (this.C < quyen_et.u[0].getHeight()) {
         this.C = quyen_et.u[0].getHeight();
      }

      this.J = var3 - 4 - 35;
      this.K = 54;
      this.g = quyen_bt.c(quyen_cr.a, quyen_n.j - 30);
      this.W = super.l - 23 - 5;
      this.B = new Vector();
   }

   public final void a(final long n, final int[] k) {
      if (this.e != null) {
         final quyen_bb e;
         int i = (e = this.e).a.size() - 1;
         Label_0130:
         while (i >= 0) {
            final quyen_bd quyen_bd;
            int size = (quyen_bd = (quyen_bd) e.a.elementAt(i)).a.size();
            while (true) {
               while (--size >= 0) {
                  final quyen_ba quyen_ba;
                  if ((quyen_ba = (quyen_ba) quyen_bd.a.elementAt(size)).l == n) {
                     final quyen_ba quyen_ba3;
                     final quyen_ba quyen_ba2 = quyen_ba3 = quyen_ba;
                     final quyen_ba quyen_ba4 = quyen_ba3;
                     if (quyen_ba2 != null) {
                        quyen_ba4.a(k);
                     }
                     --i;
                     continue Label_0130;
                  }
               }
               quyen_ba quyen_ba3;
               final quyen_ba quyen_ba2 = quyen_ba3 = null;
               continue;
            }
         }
      }
      quyen_bj quyen_bj3 = null;
      quyen_bj quyen_bj2 = null;
      Label_0200: {
         if (this.f != null) {
            int size2 = this.f.size();
            while (--size2 >= 0) {
               final quyen_bj quyen_bj = (quyen_bj) this.f.elementAt(size2);
               if (quyen_bj.m == n) {
                  quyen_bj2 = (quyen_bj3 = quyen_bj);
                  break Label_0200;
               }
            }
         }
         quyen_bj2 = (quyen_bj3 = null);
      }
      final quyen_bj quyen_bj4 = quyen_bj3;
      if (quyen_bj2 != null) {
         quyen_bj4.k = k;
      }
   }

   public final void b() {
      if (this.f == null) {
         this.f = new Vector();
      } else {
         this.f.removeAllElements();
      }

      System.gc();
      if (this.e != null && this.e.a != null && this.e.a.size() != 0) {
         Vector var1 = this.e.a;
         boolean var2 = false;
         int var3 = var1.size();
         int var4 = 0;

         for (int var5 = 0; var5 < var3; var5++) {
            quyen_bd var11 = (quyen_bd)var1.elementAt(var5);
            quyen_bj var6;
            (var6 = new quyen_bj()).a = 1;
            var6.g = var11.b;
            var6.c = var11.a();
            var6.d = quyen_hr.a(var11.a(), " (", String.valueOf(var11.a.size()), ")");
            this.f.addElement(var6);
            if (var6.g != 1) {
               Vector var13 = var11.a;
               var4 = var11.a.size();

               for (int var7 = 0; var7 < var4; var7++) {
                  quyen_ba var8 = (quyen_ba)var13.elementAt(var7);
                  quyen_bj var9;
                  (var9 = new quyen_bj()).m = var8.l;
                  var9.k = var8.a();
                  var9.c = var8.a;
                  var9.g = var8.c;
                  var9.d = var8.b;
                  var8.b();
                  var9.b = null;
                  var9.b = new Integer(var8.b());
                  var9.h = var8.g;
                  var9.e = var8.f;
                  if (var9.e != null && var9.e.length() != 0) {
                     var9.f = var9.d + " - " + var9.e;
                  } else {
                     var9.f = var9.d;
                  }

                  var9.i = var8;
                  if (!this.b || var9.g != 0 && var9.g != 0 && var9.g != -1) {
                     if (this.v) {
                        if (var9.c.indexOf(this.u) == -1 && var9.d.indexOf(this.u) == -1) {
                           continue;
                        }

                        if (!var2) {
                           this.d = this.f.size();
                           var2 = true;
                        }
                     }

                     this.f.addElement(var9);
                  }
               }
            }
         }

         System.gc();
         this.L = this.f.size();
         if (this.d < 0) {
            this.d = 0;
         }

         if (this.d >= this.L) {
            this.d = this.L - 1;
         }

         this.E = super.m / this.C + 1;
         this.A = this.L * this.C - super.m + 3 + this.C;
         this.w = this.d * this.C - (super.m >> 1);
         this.D = this.d - (this.E >> 1);
         if (this.f.size() - this.d < this.E >> 1) {
            this.D = this.L - this.E;
         }

         if (this.D < 0) {
            this.D = 0;
         }

         this.k();
      } else {
         this.D = 0;
         this.E = 0;
         this.L = this.f.size();
         this.A = 0;
      }
   }

   private void k() {
      if (((quyen_bj)this.f.elementAt(this.d)).a == 1) {
         super.r = this.G;
      } else if (this.I) {
         super.r = this.H;
      } else {
         super.r = this.F;
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

   public final boolean b(int var1) {
      if (this.c) {
         return true;
      } else if (this.f != null && this.L != 0) {
         if (var1 == 12) {
            System.currentTimeMillis();
            this.d--;
            if (this.d < 0) {
               this.d = this.L - 1;
            }
         }

         if (var1 == 13) {
            System.currentTimeMillis();
            this.d++;
            if (this.d >= this.L) {
               this.d = 0;
            }
         }

         if (var1 == 12 || var1 == 13) {
            this.k();
            this.w = this.d * this.C - (super.m >> 1);
            this.D = this.d - (this.E >> 1);
            if (this.L - this.d < this.E >> 1) {
               this.D = this.L - this.E;
            }

            if (this.D < 0) {
               this.D = 0;
            }

            this.c();
            quyen_n.b();
            quyen_cq.a(true);
            this.m();
            quyen_hr.b(this);
         }

         if (var1 == 16) {
            this.l();
            quyen_n.b();
         }

         return true;
      } else {
         return true;
      }
   }

   public final void c() {
      this.Z = 0;
      this.Y = false;
   }

   private void l() {
      if (this.d != -1) {
         this.M = (quyen_bj)this.f.elementAt(this.d);
         if (this.M.a == 0) {
            if (this.M.g == 8) {
               if (this.M.c.startsWith("http://")) {
                  try {
                     Xuka.i.platformRequest(this.M.c);
                     return;
                  } catch (ConnectionNotFoundException var6) {
                     return;
                  }
               }
            } else if (this.M.g == 4) {
               return;
            }

            if (this.I) {
               quyen_bj var8 = (quyen_bj)this.f.elementAt(this.d);
               var8.h = !var8.h;
               var8.i.g = !var8.i.g;
            } else {
               if (this.N == null) {
                  this.N = new quyen_bw("Chat", new quyen_c(this));
               }

               if (this.a) {
                  this.N.b.a();
               } else {
                  if (this.O == null) {
                     Vector var7 = new Vector();
                     quyen_bw var2 = new quyen_bw("Hồ sơ", new quyen_d(this));
                     quyen_bw var3 = new quyen_bw("Media", new quyen_e(this));
                     if (quyen_ia.I == 1) {
                        quyen_bw var4 = new quyen_bw("Từ chối ID", new quyen_f(this));
                        quyen_bw var5 = new quyen_bw("Xóa ID", new quyen_g(this));
                        var7.addElement(this.N);
                        var7.addElement(var3);
                        var7.addElement(var2);
                        var7.addElement(var5);
                        var7.addElement(var4);
                     } else if (quyen_ia.I == 2) {
                        quyen_bw var9 = new quyen_bw("Bỏ từ chối", new quyen_i(this));
                        var7.addElement(var2);
                        var7.addElement(var9);
                     } else {
                        quyen_bw var10 = new quyen_bw("Đồng ý", new quyen_j(this));
                        quyen_bw var11 = new quyen_bw(quyen_cr.e(), new quyen_k(this));
                        var7.addElement(var2);
                        var7.addElement(var10);
                        var7.addElement(var11);
                     }

                     this.O = new quyen_ci(var7);
                  }

                  quyen_et.e().a(this.O, 1);
               }
            }
         } else {
            quyen_bd var1;
            if ((var1 = this.e.a(this.M.c)) != null) {
               var1.b = this.M.g == 0 ? 1 : 0;
            }

            this.b();
         }
      }
   }

   private void m() {
      this.V = 0;
      this.X = 0;
      this.S = false;
   }

   public final void a(Graphics var1) {
      var1.setClip(super.j, super.k, super.l + 1, super.m);
      if (this.c) {
         quyen_bt.a(quyen_bt.c).a("Vui lòng chờ", quyen_cj.h - quyen_bt.b("Vui lòng chờ") >> 1, 20, var1);
         quyen_et.c.a(var1, quyen_cp.d, quyen_bt.e + 35);
      } else if (this.E == 0) {
         int var12 = this.g.length;

         while (--var12 >= 0) {
            quyen_bt.a(quyen_bt.c).a(this.g[var12], quyen_cj.h - quyen_bt.b(this.g[var12]) >> 1, 20 + var12 * quyen_bt.e, var1);
         }
      } else if (this.f != null) {
         var1.translate(2, 2);
         var1.translate(0, -this.z);
         int var2 = this.D * this.C;
         this.P = this.D + this.E;
         this.Q = this.L;
         this.R = this.C + 2;
         int var3 = 0;
         this.aa = super.l + 4;
         quyen_bj var4 = null;

         for (int var5 = this.D; var5 <= this.P && var5 < this.Q; var5++) {
            var4 = (quyen_bj)this.f.elementAt(var5);
            var3 = this.C;
            if (var5 == this.d) {
               if (((quyen_bj)var4).a == 0) {
                  var3 <<= 1;
               }

               var1.setColor(66826);
               var1.fillRect(-2, var2 + 1, this.aa, var3);
               var1.setColor(9478569);
               var1.drawRect(-3, var2 + 1, this.aa, var3);
               if (var3 > this.C) {
                  if (this.X == 0) {
                     this.U = 23;
                     this.X = quyen_bt.b(((quyen_bj)var4).f);
                     this.ab = quyen_bt.b(((quyen_bj)var4).c);
                     this.X = this.X > this.ab ? this.X : this.ab;
                     if (this.X > this.W) {
                        this.S = this.T = true;
                     } else {
                        this.S = false;
                     }
                  }

                  if (this.S && this.V++ > 20) {
                     this.V = 21;
                     if (this.T) {
                        if (this.U > -(this.X - this.W) + 23 - 5) {
                           this.U--;
                        } else {
                           this.T = false;
                        }
                     } else if (this.U < 23) {
                        this.U++;
                     } else {
                        this.T = true;
                     }
                  }
               }
            }

            if (((quyen_bj)var4).a == 1) {
               var1.drawImage(quyen_et.v[((quyen_bj)var4).g], 9, var2 + (this.C >> 1) + 2, 3);
               quyen_bt.a(quyen_bt.d).a(((quyen_bj)var4).d, 18, var2 + 3, var1);
            } else {
               quyen_bt.a(((quyen_bj)var4).b).a(((quyen_bj)var4).f, var5 == this.d ? this.U : 23, var2 + 3, var1);
               if (var5 == this.d) {
                  quyen_bt.a(quyen_bt.d).a(((quyen_bj)var4).c, this.U, var2 + this.R, var1);
               }

               var1.drawImage(quyen_et.u[((quyen_bj)var4).g == 1 ? 1 : 0], var5 == this.d ? this.U - 12 : 11, var2 + (this.C >> 1) + 2, 3);
               if (this.I && ((quyen_bj)var4).g != 3) {
                  var1.drawRegion(quyen_et.t, 0, ((quyen_bj)var4).h ? 13 : 0, 13, 13, 0, super.l - 12, var2 + (this.C >> 1), 3);
               }
            }

            var2 += var3;
         }

         var1.translate(0, this.z);
         var1.translate(-2, -2);
         if (quyen_ia.D && !this.a && !this.I) {
            if (++this.Z > 30) {
               this.Z = 31;
               if (!this.Y) {
                  this.Y = true;
                  if ((var4 = (quyen_bj)this.f.elementAt(this.d)).a != 1) {
                     String var17 = var4.c;
                     if (var4.c != null && !this.B.contains(var17)) {
                        this.B.addElement(var17);
                        long var8 = var4.m;
                        quyen_ju var10 = new quyen_ju(3, 6);
                        quyen_a.a(var8, var10);
                        quyen_jv.a(var10);
                     }
                  }
               }
            }

            int[] var11;
            quyen_ba var18;
            if (((quyen_bj)this.f.elementAt(this.d)).a != 1
                && (var18 = (this.d < 0 ? null : (quyen_bj)this.f.elementAt(this.d)).i) != null
                && (var11 = var18.a()) != null
                && var11.length > 0) {
               this.P = var11.length;

               for (int var14 = 0; var14 < this.P; var14++) {
                  var1.drawImage(quyen_ea.a(var18.i[var14]), this.J + (var11[var14] >> 24), this.K + (var11[var14] << 8 >> 24), 0);
               }
            }
         }
      }
   }

   public final void d() {
      this.ac++;
      if (this.ac > 1000) {
         this.ac = 0;
      }

      if (this.z != this.w) {
         this.x = this.w - this.z << 2;
         this.y = this.y + this.x;
         this.z = this.z + (this.y >> 4);
         this.y &= 15;
         if (this.z > this.A) {
            this.z = this.A;
         }

         if (this.z < 0) {
            this.z = 0;
         }

         this.D = this.z / this.C - 1;
         if (this.D < 0) {
            this.D = 0;
         }
      }
   }

   public final void e() {
      if (this.f != null) {
         if (super.k + this.L * this.C >= super.m) {
            quyen_cq.a = true;
            quyen_cq.a(this.L);
         } else {
            quyen_cq.a = false;
         }
      }
   }

   public final void b(Graphics var1) {
      quyen_cq.a(var1, this.d);
   }

   public final void a(int var1, int var2) {
      this.ae = var1;
      this.af = var2;
   }

   public final void b(int var1, int var2) {
      if (this.ad) {
         this.ad = false;
         this.w = this.w - (var2 - this.af) * 5;
         if (this.w < 0) {
            this.w = 0;
         } else if (this.w > this.A) {
            this.w = this.A;
         }
      } else {
         if (this.f == null) {
            return;
         }

         if ((var1 = (var2 + this.z) / this.C) < 0) {
            var1 = 0;
         }

         if (var1 > this.L - 1) {
            var1 = this.L - 1;
         }

         if (this.d == var1) {
            this.l();
            return;
         }

         if (this.d > var1) {
            this.d = var1;
         } else {
            quyen_bj var4;
            if ((var4 = (quyen_bj)this.f.elementAt(this.d)).d != null && !var4.d.equals("")) {
               if (this.d == var1 - 1) {
                  this.l();
                  return;
               }

               this.d = var1 - 1;
            } else {
               this.d = var1;
            }
         }

         this.k();
         this.c();
         this.m();
         quyen_hr.b(this);
      }

      quyen_cq.a(true);
   }

   public final void c(int var1, int var2) {
      if (c(var1 - this.ae) > 1 || c(var2 - this.af) > 1) {
         this.ad = true;
         this.w = this.w - (var2 - this.af);
         if (this.w < 0) {
            this.w = 0;
         } else if (this.w > this.A) {
            this.w = this.A;
         }

         this.z = this.w;
         this.D = this.z / this.C - 1;
         if (this.D < 0) {
            this.D = 0;
         }

         this.ae = var1;
         this.af = var2;
      }

      quyen_cq.a(true);
   }

   public static int c(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public final boolean a(String var1, int var2) {
      if (this.e == null) {
         return false;
      } else {
         int var5 = var2;
         String var4 = var1;
         quyen_bb var3 = this.e;

         for (int var6 = this.e.a.size() - 1; var6 >= 0; var6--) {
            quyen_ba var7;
            if ((var7 = ((quyen_bd)var3.a.elementAt(var6)).a(var4)) != null) {
               var7.c = var5;
            }
         }

         if (this.f == null) {
            return false;
         } else {
            boolean var10 = false;
            int var11 = this.L;

            while (--var11 >= 0) {
               quyen_bj var12;
               if ((var12 = (quyen_bj)this.f.elementAt(var11)).a == 0 && var12.c.equals(var1) && var12.g != var2) {
                  var12.g = var2;
                  var10 = true;
               }
            }

            if (this.b) {
               this.b();
            }

            return var10;
         }
      }
   }

   public final boolean a(long var1, int var3) {
      if (this.e == null) {
         return false;
      } else {
         int var5 = var3;
         long var8 = var1;
         quyen_bb var4 = this.e;
         int var6 = 0;
         int var7 = var4.a.size();

         label45:
         while (--var7 >= 0) {
            quyen_bd var10;
            int var11 = (var10 = (quyen_bd)var4.a.elementAt(var7)).a.size();

            while (--var11 >= 0) {
               quyen_ba var12;
               if ((var12 = (quyen_ba)var10.a.elementAt(var11)).l == var8) {
                  var12.c = var5;
                  if (++var6 > 1) {
                     break label45;
                  }
               }
            }
         }

         if (this.f == null) {
            return false;
         } else {
            boolean var13 = false;
            var5 = this.L;

            while (--var5 >= 0) {
               quyen_bj var15;
               if ((var15 = (quyen_bj)this.f.elementAt(var5)).a == 0 && var15.m == var1 && var15.g != var3) {
                  var15.g = var3;
                  var13 = true;
               }
            }

            if (this.b) {
               this.b();
            }

            return var13;
         }
      }
   }

   public final boolean a(long var1, String var3) {
      if (this.e == null) {
         return false;
      } else {
         String var5 = var3;
         long var8 = var1;
         quyen_bb var4 = this.e;
         int var6 = 0;
         int var7 = var4.a.size();

         label46:
         while (--var7 >= 0) {
            quyen_bd var10;
            int var11 = (var10 = (quyen_bd)var4.a.elementAt(var7)).a.size();

            while (--var11 >= 0) {
               quyen_ba var12;
               if ((var12 = (quyen_ba)var10.a.elementAt(var11)).l == var8) {
                  var12.f = var5;
                  if (++var6 > 1) {
                     break label46;
                  }
               }
            }
         }

         if (this.f == null) {
            return false;
         } else {
            boolean var13 = false;
            int var14 = this.L;

            while (--var14 >= 0) {
               quyen_bj var15;
               if ((var15 = (quyen_bj)this.f.elementAt(var14)).a == 0 && var15.m == var1) {
                  var15.e = var3;
                  if (var3 != null && var3.length() > 0) {
                     var15.f = var15.d + " - " + var3;
                     var13 = true;
                  } else {
                     var15.f = var15.d;
                  }
               }
            }

            return var13;
         }
      }
   }

   public final void a(String var1, String var2, int var3) {
      if (this.e != null) {
         String var5 = var2;
         String var4 = var1;
         quyen_bb var10 = this.e;

         for (int var6 = this.e.a.size() - 1; var6 >= 0; var6--) {
            quyen_ba var7;
            if ((var7 = ((quyen_bd)var10.a.elementAt(var6)).a(var4)) != null) {
               var7.f = var5;
            }
         }

         if (this.f != null) {
            var3 = this.L;

            while (--var3 >= 0) {
               quyen_bj var12;
               if ((var12 = (quyen_bj)this.f.elementAt(var3)).a == 0 && var12.c.equals(var1)) {
                  var12.e = var2;
                  if (var2 != null && var2.length() != 0) {
                     var12.f = var12.d + " - " + var2;
                  }
               }
            }

            if (this.b) {
               this.b();
            }
         }
      }
   }

   public final void a(String var1) {
      String var2 = var1;
      quyen_bb var4 = this.e;

      for (int var3 = this.e.a.size() - 1; var3 >= 0; var3--) {
         if (((quyen_bd)var4.a.elementAt(var3)).a().equals(var2)) {
            var4.a.removeElementAt(var3);
            break;
         }
      }

      this.b();
      this.c();
   }

   public final boolean b(String var1) {
      int var2 = this.L;

      while (--var2 >= 0) {
         quyen_bj var3;
         if ((var3 = (quyen_bj)this.f.elementAt(var2)).a == 0 && var3.c.equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public final void c(String var1) {
      if (var1.equals("")) {
         this.v = false;
      } else {
         this.v = true;
         this.u = var1;
         this.b = false;
      }

      this.b();
      this.c();
   }

   public final String[] f() {
      int var1;
      String[] var2 = new String[var1 = this.e.a.size()];

      for (int var3 = 0; var3 < var1; var3++) {
         var2[var3] = ((quyen_bd)this.e.a.elementAt(var3)).a();
      }

      return var2;
   }

   public final void g() {
      if (this.I) {
         this.ag = !this.ag;

         for (int var1 = this.L - 1; var1 >= 0; var1--) {
            quyen_bj var2;
            if ((var2 = (quyen_bj)this.f.elementAt(var1)).a == 0) {
               var2.h = this.ag;
               var2.i.g = this.ag;
            }
         }
      }
   }

   public final void h() {
      this.ag = true;
      this.g();
   }

   public final long[] i() {
      final Vector vector = new Vector();
      if (this.I) {
         for (int i = this.L - 1; i >= 0; --i) {
            final quyen_bj quyen_bj;
            if ((quyen_bj = (quyen_bj) this.f.elementAt(i)).a == 0 && quyen_bj.h) {
               quyen_bj.h = false;
               vector.addElement(new Long(quyen_bj.m));
            }
         }
      }
      if (vector.size() > 0) {
         final long[] array = new long[vector.size()];
         int size = vector.size();
         while (--size >= 0) {
            array[size] = ((Long) vector.elementAt(size)).longValue();
         }
         return array;
      }
      return null;
   }

   static quyen_bj a(quyen_b var0) {
      return var0.M;
   }
}
