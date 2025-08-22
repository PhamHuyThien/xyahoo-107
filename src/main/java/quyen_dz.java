import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class quyen_dz extends quyen_bx {
   public String a;
   private quyen_bc E;
   private int F;
   private int G;
   private int H;
   private long I;
   private String J;
   private boolean K;
   private String L = "";
   public int b;
   public int c;
   private boolean M;
   public boolean d;
   public byte[] e;
   public boolean f;
   public int g;
   public boolean u;
   private String N;
   public int v;
   public long w;
   public boolean x;
   public byte y;
   public int z;
   private int O;
   private int P;
   private int Q;
   private int R;
   public Integer A;
   private int S;
   public boolean B;
   private String T;
   private int U;
   private Image V;
   private String[] W;
   private int X;
   private int Y;
   private int Z;
   private int aa;
   public boolean C;
   private byte ab;
   private long ac;
   boolean D;
   private int ad;
   private long ae;

   public final long a() {
      return this.I;
   }

   public final void a(long var1) {
      this.I = var1;
      this.J = quyen_hr.a(quyen_hr.a(var1), " $", null, null);
   }

   public quyen_dz() {
      new Vector();
      new Vector();
   }

   public quyen_dz(String var1, long var2, int var4, boolean var5) {
      this.K = var5;
      if (var1 == null) {
         this.a = "";
      } else {
         this.a = var1;
      }

      this.a(var2);
      this.g = var4;
      int var6 = 32 > quyen_bt.e << 1 ? 32 : quyen_bt.e << 1;
      int var7 = quyen_cj.i - quyen_et.d - 40 - var6 - 7;
      this.B = var4 == 1 || var4 == 3;
      this.N = quyen_bt.a(this.a, 9);
      if (!this.B) {
         this.b = (quyen_cj.h >> 1) - 20;
         this.c = var4 == 0 ? var7 : 5;
         this.U = this.P = this.O = this.b + 4 + 40;
         this.Q = this.b;
         this.R = this.c - 11;
      } else {
         this.c = (var7 >> 1) - 15;
         this.b = this.U = this.P = this.Q = this.O = var4 == 1 ? quyen_cj.h - 5 : 5;
         if (var4 == 1) {
            this.O = this.b - quyen_bt.b(this.J);
            this.P = this.b - quyen_bt.b(this.N);
            this.Q = this.b - 40;
         }

         this.R = this.c - 4;
      }

      this.K = var5;
      this.L = "Chủ bàn";
      this.U = this.g == 1 ? this.b - quyen_bt.b(this.L) : this.U;
   }

   public final void a(quyen_bc var1) {
      this.E = var1;
      this.G = this.Q + (this.g == 3 ? 56 : -16);
      if (this.B) {
         this.F = this.g == 1 ? this.b - quyen_bt.b(var1.b) : this.P;
      } else {
         this.F = this.P;
      }

      this.H = this.R + 20;
   }

   public final void a(boolean var1) {
      this.M = var1;
      if (!this.K) {
         if (var1) {
            this.L = "Sẵn sàng";
            this.U = this.g == 1 ? this.b - quyen_bt.b(this.L) : this.U;
            return;
         }

         this.L = null;
      }
   }

   public final boolean b() {
      return this.M;
   }

   public final void a(Graphics var1) {
      if (this.a != null && !this.f) {
         this.V = quyen_ea.a(this.A);
         var1.drawImage(this.V, this.g == 1 ? this.b - this.V.getWidth() : this.Q, this.R, 20);
         if (!quyen_cz.O.B && this.L != null) {
            if (this.B) {
               quyen_bt.a(quyen_bt.c).a(this.L, this.U, this.R - quyen_bt.e - 2, var1);
            } else {
               this.S = this.c - 4 + quyen_bt.e;
               quyen_bt.a(quyen_bt.c).a(this.L, this.U, this.S + quyen_bt.e, var1);
            }
         }

         if (this.u) {
            Graphics var10000;
            Image var10001;
            int var10002;
            int var10003;
            if (this.B) {
               var10000 = var1;
               var10001 = quyen_et.z;
               var10002 = this.Q + 20;
               var10003 = this.R - 11 - 4;
            } else {
               var10000 = var1;
               var10001 = quyen_et.z;
               var10002 = this.Q + 20;
               var10003 = this.g == 0 ? this.R - 11 - 4 : this.R + 40 + 4;
            }

            var10000.drawImage(var10001, var10002, var10003, 17);
         }

         if (this.B) {
            this.S = this.c + 40;
            quyen_bt.a(quyen_bt.c).a(this.N, this.P, this.S, var1);
            if (this.E != null && this.E.b != null) {
               quyen_bt.a(quyen_bt.c).a(this.E.b, this.F, this.S + (quyen_bt.e << 1), var1);
            }

            quyen_bt.a(quyen_bt.d).a(this.J, this.O, this.S + quyen_bt.e, var1);
         } else {
            this.S = this.c - 4 - quyen_bt.e;
            quyen_bt.a(quyen_bt.c).a(this.N, this.P, this.S, var1);
            if (this.E != null && this.E.b != null) {
               quyen_bt.a(quyen_bt.c).a(this.E.b, this.F, this.S + (quyen_bt.e << 1), var1);
            }

            quyen_bt.a(quyen_bt.d).a(this.J, this.O, this.S + quyen_bt.e, var1);
         }

         if (this.E != null && this.E.a.intValue() != -1) {
            var1.drawImage(quyen_ea.a(this.E.a), this.G, this.H, 3);
         }

         if (this.x) {
            if (14 - (byte)((int)(System.currentTimeMillis() / 1000L - (long)this.y)) > 0) {
               quyen_hr.a(var1, 1 + (this.g == 1 ? this.Q : this.b), this.c - (this.B ? 22 : (this.g == 2 ? -25 : 33)), this.z);
            } else {
               this.x = false;
            }
         }

         if (this.D && this.ad >= 0) {
            quyen_cz.O.n.a = "";
            quyen_cz.O.o.a = "";
            if (this.B) {
               quyen_bt.a(quyen_bt.d).a(this.T, this.g == 1 ? this.b - 20 : this.Q, this.R - quyen_bt.e - 4, var1);
               return;
            }

            if (this.g == 2) {
               quyen_bt.a(quyen_bt.d).a(this.T, this.Q, this.R + 40 + 4, var1);
               return;
            }

            quyen_cz.O.n.a = "Bỏ lượt";
            quyen_cz.O.o.a = "Đánh bài";
            quyen_bt.a(quyen_bt.d).a(this.T, this.Q, this.R - quyen_bt.e - 4, var1);
         }
      }
   }

   public final void a(String var1) {
      this.W = quyen_bt.c(var1, quyen_cj.h - 30);
      this.Z = 0;
      int var4 = 0;

      for (int var2 = this.W.length; var4 < var2; var4++) {
         int var3 = quyen_bt.b(this.W[var4]) + 5;
         if (this.Z < var3) {
            this.Z = var3;
         }
      }

      this.aa = this.W.length * quyen_bt.h;
      if (this.g == 0 || this.g == 2) {
         this.X = (quyen_cj.h - this.Z >> 1) - 9;
      } else if (this.g == 1) {
         this.X = quyen_cj.h - this.Z - 6;
      } else {
         this.X = 11;
      }

      this.Y = this.c + (this.B ? 21 : (this.g == 2 ? 84 : 15)) - this.aa;
      this.C = true;
      this.ab = (byte)((int)(System.currentTimeMillis() / 1000L));
   }

   public final void c(Graphics var1) {
      if (10 - (byte)((int)(System.currentTimeMillis() / 1000L - (long)this.ab)) > 0) {
         quyen_hr.a(var1, this.X, this.Y, this.Z, this.aa, this.W, this.g);
      } else {
         this.C = false;
      }
   }

   public final void c(int var1) {
      this.D = true;
      this.ac = 30L;
      this.ae = System.currentTimeMillis();
      this.T = "";
      quyen_hr.b(this);
   }

   public final boolean b(int var1) {
      return true;
   }

   public final void d() {
      if (this.D) {
         this.ad = (int)(this.ac - (System.currentTimeMillis() - this.ae) / 1000L);
         if (this.ad <= 0) {
            this.D = false;
            return;
         }

         this.T = quyen_cz.O.e(this.ad);
      }
   }

   public final boolean a(int var1) {
      return false;
   }
}
