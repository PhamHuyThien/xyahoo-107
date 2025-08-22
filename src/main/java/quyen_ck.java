import javax.microedition.lcdui.Graphics;

public final class quyen_ck extends quyen_bx {
   private String d;
   private int e;
   public quyen_co a;
   public int b;
   private int f;
   public boolean c;

   public quyen_ck() {
   }

   public quyen_ck(String var1, int var2, int var3, int var4, int var5) {
      this();
      this.e = 0;
      this.d = var1;
      super.j = 0;
      super.k = 0;
      super.l = var4;
      super.m = var5 < 19 ? var5 : 19;
   }

   public final boolean b(int var1) {
      if (var1 == 16) {
         this.e = 2;
         return false;
      } else {
         return true;
      }
   }

   public final void b(int var1, int var2) {
      this.a.e(this.b);
   }

   public final void a(Graphics var1) {
      if (this.j()) {
         this.f = quyen_bt.b(this.d);
         var1.setColor(66826);
         var1.fillRoundRect(super.j + 19, super.k + 1, this.f + 10, super.m, 8, 8);
      }

      quyen_bt.a(quyen_bt.d).a(this.d, super.j + 22, super.k + (super.m - quyen_bt.e >> 1), var1);
      var1.drawImage(quyen_et.v[this.c ? 0 : 1], super.j + 10, super.k + (super.m >> 1), 3);
   }

   public final void d() {
      if (this.e > 0) {
         this.e--;
         if (this.e == 0) {
            this.a.e(this.b);
         }
      }
   }

   public final boolean a(int var1) {
      return true;
   }
}
