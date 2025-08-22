import javax.microedition.lcdui.Graphics;

public final class quyen_bu extends quyen_bx {
   private String b;
   private int c;
   public boolean a;

   public quyen_bu(String var1, int var2, int var3, int var4, int var5) {
      this.b = var1;
      super.j = var2;
      super.k = var3;
      super.l = var4;
      super.m = var5;
      super.p = new quyen_bw("Chọn", null);
   }

   public final boolean a(int var1) {
      return this.b(var1);
   }

   public final boolean b(int var1) {
      if (var1 == 17) {
         this.c = 2;
         return false;
      } else {
         return true;
      }
   }

   private void a() {
      this.a = !this.a;
   }

   public final void b(int var1, int var2) {
      quyen_hr.a(super.o, this);
      this.a();
   }

   public final void d() {
      if (this.c > 0) {
         this.c--;
         if (this.c == 0) {
            this.a();
         }
      }
   }

   public final void a(Graphics var1) {
      if (this.j()) {
         quyen_bs.b(var1, super.j - 3, super.k, super.l + 9, super.m + 2);
      }

      var1.drawRegion(quyen_et.t, 0, this.a ? 13 : 0, 13, 13, 0, super.j + 8, super.k + (super.m >> 1) + 1, 3);
      quyen_bt.a(quyen_bt.c).a(this.b, super.j + 13 + 5, super.k + 3, var1);
   }
}
