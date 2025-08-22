import javax.microedition.lcdui.Graphics;

public final class quyen_bv extends quyen_bx {
   public quyen_ce a;
   public String[] b;
   private int d;
   private int e;
   public quyen_ca c;
   private String f = "";
   private int g;

   public quyen_bv(String[] var1, int var2, int var3, int var4, int var5) {
      this.e = 0;
      this.b = var1;
      super.j = var2;
      super.k = var3;
      super.l = var4;
      super.m = var5;
      this.g();
   }

   public final int a() {
      return this.d;
   }

   public final void c(int var1) {
      this.d = var1;
      this.g();
   }

   public final boolean a(int var1) {
      if (var1 == 14) {
         this.c();
         return false;
      } else if (var1 == 15) {
         this.f();
         return false;
      } else {
         return true;
      }
   }

   private void c() {
      this.d--;
      if (this.d < 0) {
         this.d = this.b.length - 1;
      }

      if (this.c != null) {
         this.c.a();
      }

      this.g();
   }

   private void f() {
      this.d++;
      if (this.d >= this.b.length) {
         this.d = 0;
      }

      if (this.c != null) {
         this.c.a();
      }

      this.g();
   }

   public final boolean b(int var1) {
      if (this.b.length == 0) {
         return true;
      } else if (var1 == 14) {
         this.c();
         return false;
      } else if (var1 == 15) {
         this.f();
         return false;
      } else {
         return true;
      }
   }

   public final void b(int var1, int var2) {
      quyen_hr.a(super.o, this);
      this.d++;
      if (this.d >= this.b.length) {
         this.d = 0;
      }

      if (this.c != null) {
         this.c.a();
      }

      this.g();
   }

   private void g() {
      if (this.b.length != 0) {
         this.f = quyen_bt.b(this.b[this.d], super.l - 30);
      }

      this.g = super.j + (super.l - quyen_bt.b(this.b.length != 0 ? this.f : " ") >> 1);
   }

   public final void a(Graphics var1) {
      boolean var4;
      if (var4 = this.j()) {
         var1.setColor(66826);
         var1.fillRect(super.j + 2, super.k + 2, super.l - 3, super.m - 3);
      }

      int var2 = super.k + 3 + (quyen_bt.a ? 0 : 1);
      if (this.b.length == 0) {
         quyen_bt.a(quyen_bt.c).a(" ", this.g, var2, var1);
      } else {
         quyen_bt.a(quyen_bt.c).a(this.f, this.g, var2, var1);
      }

      var2 = super.m - 2;
      int var3 = super.k + 1;
      var1.setColor(var4 ? 8700157 : 9478569);
      quyen_bs.a(var1, super.j + 1, var3, super.l - 2, var2);
      var2 = super.k + (super.m >> 1);
      var1.drawRegion(quyen_et.v[2], 0, 0, 7, 7, 0, super.j + 9, var2, 3);
      var1.drawRegion(quyen_et.v[2], 7, 0, 7, 7, 0, super.j + super.l - 9, var2, 3);
   }

   public final void a(quyen_ca var1) {
      this.c = var1;
      if (super.r != null) {
         super.r.b = var1;
      }
   }

   public final void d() {
      if (this.e > 0) {
         this.e--;
         if (this.e == 0 && this.c != null) {
            this.c.a();
         }
      }
   }

   public final String b() {
      return this.d >= 0 && this.d < this.b.length ? this.b[this.d] : null;
   }
}
