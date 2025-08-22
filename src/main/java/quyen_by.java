import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class quyen_by {
   public quyen_bw a;
   public quyen_bw b;
   public quyen_bw c;
   private String[] d;
   private boolean e = false;
   private Vector f;
   private int g;
   private int h;
   private int i;
   private String j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u;
   private int v;

   public quyen_by(String var1, int var2, Vector var3, int var4, quyen_bw var5, quyen_bw var6, quyen_bw var7) {
      this.j = var1;
      this.f = var3;
      this.g = var4;
      this.h = var2;
      this.i = var3.size();
      this.a(var5, var6, var7);
      this.a();
   }

   public quyen_by(String var1, quyen_bw var2, quyen_bw var3, quyen_bw var4) {
      this.d = quyen_bt.c(var1, quyen_n.j - 30);
      this.a(var2, var3, var4);
      this.a();
   }

   public quyen_by(String[] var1, quyen_bw var2, quyen_bw var3, quyen_bw var4) {
      this.d = var1;
      this.a(var2, var3, var4);
      this.a();
   }

   private void a(quyen_bw var1, quyen_bw var2, quyen_bw var3) {
      this.a = var1;
      this.c = var3;
      this.b = var2;
      if (this.b != null) {
         this.u = quyen_n.j - quyen_bt.b(this.b.a) >> 1;
      }

      if (this.c != null) {
         this.v = quyen_n.j - quyen_bt.b(this.c.a) - 4;
      }
   }

   public final void a(boolean var1) {
      this.e = var1;
      this.a();
   }

   private void a() {
      if (this.f == null) {
         this.k = this.d.length;
         this.p = this.k * (quyen_bt.e + 2) + (this.e ? 20 : 0);
         this.q = this.p + (quyen_bt.e << 1) - 1;
         if (this.q < 30) {
            this.q = 30;
         }

         if (this.q > quyen_n.k - 35) {
            this.q = this.p = quyen_n.k - 35;
         }

         for (int var1 = 0; var1 < this.k; var1++) {
            int var2 = quyen_bt.b(this.d[var1]) + 10;
            if (this.r < var2) {
               this.r = var2;
            }
         }
      } else {
         for (int var4 = 0; var4 < this.i; var4++) {
            for (int var6 = 0; var6 < this.g; var6++) {
               int var3 = quyen_bt.b(((String[])this.f.elementAt(var4))[var6]) + 10;
               if (this.r < var3) {
                  this.r = var3;
               }
            }
         }

         this.q = 0;
         if (this.j != null) {
            this.q = this.q + quyen_bt.e + 11;
         }

         for (int var5 = 0; var5 < this.i; var5++) {
            for (int var7 = 0; var7 < this.g; var7++) {
               this.q = this.q + quyen_bt.e + 2;
            }

            this.q += 12;
         }
      }

      this.r += 60;
      if (this.r < 100) {
         this.r = 100;
      }

      if (this.r > quyen_n.j - 15) {
         this.r = quyen_n.j - 15;
      }

      this.s = quyen_n.k - this.q >> 1;
      quyen_by var10000;
      int var10001;
      int var10002;
      if (this.f == null) {
         var10000 = this;
         var10001 = this.s + (this.q - this.p >> 1);
         var10002 = 1;
      } else {
         var10000 = this;
         var10001 = this.s;
         var10002 = this.j != null ? 5 : 6;
      }

      var10000.t = var10001 + var10002;
      this.m = this.s + 1;
      this.n = this.r - 2;
      this.o = this.q - 2;
   }

   public final void a(Graphics var1) {
      this.l = (quyen_n.j - this.r >> 1) + 1;
      var1.setClip(this.l, this.m, this.n, this.o);
      int var2 = this.r / 50 + 1;

      while (--var2 >= 0) {
         int var3 = this.q / 50 + 1;

         while (--var3 >= 0) {
            var1.drawImage(quyen_et.r, this.l + var2 * 50, this.m + var3 * 50, 0);
         }
      }

      if (this.r > 110) {
         var1.drawRegion(quyen_et.s, 0, 0, 55, 20, 0, this.l, this.m, 0);
         var1.drawRegion(quyen_et.s, 87, 0, 55, 20, 0, this.l + this.n - 55, this.m, 0);
         var1.setClip(this.l + 55, this.m, this.n - 110, 20);
         int var9 = (this.n - 110 >> 5) + 1;

         while (--var9 >= 0) {
            var1.drawRegion(quyen_et.s, 55, 0, 32, 20, 0, this.l + 55 + var9 * 32, this.m, 0);
         }
      }

      var1.setClip(-1000, -1000, 5000, 5000);
      var1.setColor(14545919);
      quyen_bs.a(var1, this.l - 1, this.s, this.r - 1, this.q - 1);
      var1.drawRect(this.l - 1, this.s, this.r - 1, this.q - 1);
      quyen_bs.a(var1, this.l - 2, this.s - 1, this.r + 1, this.q + 1);
      var1.setClip(-1000, -1000, 5000, 5000);
      if (this.f == null) {
         for (int var6 = 0; var6 < this.k; var6++) {
            quyen_bt.a(quyen_bt.c).a(this.d[var6], quyen_n.j - quyen_bt.b(this.d[var6]) >> 1, this.t + var6 * (quyen_bt.e + 2), var1);
         }

         if (this.e) {
            quyen_et.c.a(var1, quyen_cp.d, this.t + this.k * quyen_bt.e + quyen_bt.e + 3);
         }
      } else {
         var1.setColor(11320516);
         if (this.j != null) {
            quyen_bt.a(quyen_bt.c).a(this.j, quyen_n.j - quyen_bt.b(this.j) >> 1, this.t, var1);
            var2 = this.t + quyen_bt.e;
            var1.fillRect(this.l, var2 + 5, this.n, 2);
            var2 += 12;
         } else {
            var2 = this.t;
         }

         for (int var10 = 0; var10 < this.i; var10++) {
            for (int var4 = 0; var4 < this.g; var4++) {
               String[] var5 = (String[])this.f.elementAt(var10);
               quyen_bt.a(quyen_bt.c).a(var5[var4], this.h == 0 ? this.l + 10 : quyen_n.j - quyen_bt.b(var5[var4]) >> 1, var2, var1);
               var2 += quyen_bt.e + 2;
            }

            if (var10 < this.i - 1) {
               var1.fillRect(this.l, var2 + 5, this.n, 1);
            }

            var2 += 12;
         }
      }

      quyen_cj.f(var1);
      if (this.a != null) {
         quyen_bt.a(quyen_bt.c).a(this.a.a, 4, quyen_cj.z, var1);
      }

      if (this.b != null) {
         quyen_bt.a(quyen_bt.c).a(this.b.a, this.u, quyen_cj.z, var1);
      }

      if (this.c != null) {
         quyen_bt.a(quyen_bt.c).a(this.c.a, this.v, quyen_cj.z, var1);
      }
   }
}
