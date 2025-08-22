import javax.microedition.lcdui.Graphics;

public final class quyen_cf extends quyen_bx {
   public String a;
   public Integer b;
   private int d;
   private int e;
   public quyen_ca c;
   private boolean f;
   private boolean g;
   private int u;
   private int v;
   private int w;
   private int x;

   public quyen_cf() {
   }

   public quyen_cf(String var1, int var2, int var3, int var4) {
      this.d = 0;
      this.a = var1;
      this.b = quyen_bt.d;
      this.e = quyen_bt.b(var1);
      super.j = var2;
      super.k = var3;
      super.l = this.e;
      super.m = var4;
      super.r = new quyen_bw("Chọn", null);
   }

   public final boolean b(int var1) {
      if (var1 == 16) {
         this.d = 2;
         return false;
      } else {
         return true;
      }
   }

   public final void b(int var1, int var2) {
      if (this.j()) {
         if (this.c != null) {
            this.c.a();
            return;
         }
      } else {
         quyen_hr.a(super.o, this);
      }
   }

   public final void a(Graphics var1) {
      boolean var2;
      if (var2 = this.j()) {
         var1.setClip(super.j - 2, super.k - 2, super.l + 11, super.m + 10);
         var1.setColor(66826);
         var1.fillRoundRect(super.j - 1, super.k - 1, super.l + 7, super.m + 1, 8, 8);
         if (this.w == 0) {
            this.u = super.j;
            this.w = quyen_cj.h - super.j;
            if (super.j + super.l > quyen_cj.h) {
               this.f = this.g = true;
            }
         }

         if (this.f && this.v++ > 20) {
            this.v = 21;
            if (this.g) {
               if (this.u > -(this.e - this.w) + super.j - 10) {
                  this.u--;
               } else {
                  this.v = 10;
                  this.g = false;
               }
            } else if (this.u < super.j) {
               this.u++;
            } else {
               this.v = 10;
               this.g = true;
            }
         }
      } else {
         this.v = 0;
         this.u = super.j;
      }

      this.x = this.u + 2;
      quyen_bt.a(this.b).a(this.a, this.x, super.k, var1);
      if (var2) {
         var1.setColor(8111862);
         var1.fillRect(this.x, super.k + quyen_bt.e, this.e + 2, 1);
      }
   }

   public final void a(quyen_ca var1) {
      this.c = var1;
      super.r.b = new quyen_cg(this);
   }

   public final void d() {
      if (this.d > 0) {
         this.d--;
         if (this.d == 0 && this.c != null) {
            this.c.a();
         }
      }
   }

   public final boolean a(int var1) {
      return true;
   }
}
