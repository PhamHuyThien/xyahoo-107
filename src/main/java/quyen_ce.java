import javax.microedition.lcdui.Graphics;

public final class quyen_ce extends quyen_bx {
   public String a;
   private boolean e;
   public Integer b = quyen_bt.c;
   private int f;
   private boolean g;
   public boolean c;
   private boolean u;
   private boolean v;
   private int w;
   private int x;
   private int y;
   private int z;
   public boolean d;

   public quyen_ce() {
      this.g = true;
   }

   private quyen_ce(String var1) {
      super.h = false;
      this.b(var1);
   }

   private void b(String var1) {
      this.a = quyen_bt.a(var1, false);
      if (this.a == null) {
         this.e = false;
         this.a = var1;
      } else {
         this.e = true;
      }

      this.f = this.a.length();
   }

   public final void a(String var1) {
      this.b(var1);
      this.a();
   }

   private void a() {
      super.l = quyen_bt.b(this.a);
      int var1 = quyen_bt.j * 18;
      this.z = quyen_bt.b(this.a) + var1;
      super.l += var1;
   }

   public quyen_ce(String var1, int var2, int var3, int var4, int var5) {
      this(var1);
      super.j = var2;
      super.k = var3;
      super.m = var4;
      super.s = var5;
      this.f = this.a.length();
      this.a();
   }

   public quyen_ce(String var1, int var2, int var3, int var4) {
      this(var1, var2, var3, var4, -1);
      this.a();
   }

   public final boolean b(int var1) {
      return true;
   }

   private void b() {
      if (this.y == 0) {
         this.w = super.j;
         this.y = quyen_cj.h - super.j;
         if (super.j + super.l > quyen_cj.h) {
            this.u = this.v = true;
         }
      }

      if (this.u && this.x++ > 20) {
         this.x = 21;
         if (this.v) {
            if (this.w > -(this.z - this.y) + super.j - 10) {
               this.w--;
               return;
            }

            this.x = 10;
            this.v = false;
            return;
         }

         if (this.w < super.j) {
            this.w++;
            return;
         }

         this.x = 10;
         this.v = true;
      }
   }

   private void a(Graphics var1, boolean var2) {
      if (var2) {
         quyen_bs.b(var1, super.j - 3, super.k - 2, super.l + 9, super.m + 2);
      }

      if (this.c) {
         if (this.d) {
            this.b();
            return;
         }

         if (var2) {
            this.b();
            return;
         }

         this.x = 0;
      }

      this.w = super.j;
   }

   public final void a(Graphics var1) {
      if (!this.g) {
         boolean var2 = this.j();
         if (this.c && (var2 || this.d)) {
            var1.setClip(super.j - 3, super.k - 2, super.l + 10, super.m + 10);
         }

         if (!this.e) {
            this.a(var1, var2);
            this.a(var1, this.a, this.w + 2, super.k);
         }

         if (this.f == 0) {
            var1.setColor(11320516);
            var1.fillRect(super.j, super.k + (super.m >> 1), super.l, 1);
         } else if (this.e) {
            this.a(var1, var2);
            String var7 = "";
            int var3 = 0;
            int var4 = super.k;

            for (int var5 = 0; var5 < this.f; var5++) {
               char var6;
               if ((var6 = this.a.charAt(var5)) >= 30000) {
                  this.a(var1, var7, this.w + 2 + var3, var4);
                  var3 += quyen_bt.b(var7);
                  var7 = "";
                  var6 -= 30000;
                  var1.drawRegion(quyen_et.p, var6 * 18, 0, 18, 18, 0, this.w + 2 + var3 + 10, super.k + (quyen_bt.e >> 1), 3);
                  var3 += 20;
               } else {
                  var7 = var7 + var6;
               }
            }

            this.a(var1, var7, this.w + 2 + var3, var4);
         }
      }
   }

   private void a(Graphics var1, String var2, int var3, int var4) {
      quyen_bt.a(this.b).a(var2, var3, var4, var1);
   }

   public final void b(int var1, int var2) {
      if (super.h) {
         quyen_hr.a(super.o, this);
      }
   }

   public final void d() {
   }

   public final boolean a(int var1) {
      return true;
   }
}
