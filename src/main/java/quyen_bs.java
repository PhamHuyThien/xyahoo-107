import javax.microedition.lcdui.Graphics;

public final class quyen_bs extends quyen_bx {
   private String b;
   private int c;
   private int d;
   public quyen_ca a;
   private static int e;
   private static int f;
   private static int g;
   private static int u;

   public quyen_bs() {
   }

   public quyen_bs(String var1, int var2, int var3) {
      this.d = 0;
      super.l = var2;
      super.m = var3;
      super.r = new quyen_bw("Chọn", null);
      this.b = var1;
      this.c = super.l - quyen_bt.b(var1) >> 1;
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
         this.a.a();
      } else {
         quyen_hr.a(super.o, this);
      }
   }

   public final void a(Graphics var1) {
      boolean var2 = this.j();
      var1.setColor(var2 ? 1588055 : 1124399);
      var1.fillRect(super.j + 2, super.k + 1, super.l - 3, super.m - 4 >> 1);
      var1.setColor(var2 ? 1389387 : 728097);
      var1.fillRect(super.j + 2, super.k + (super.m - 4 >> 1), super.l - 3, super.m - 4 >> 1);
      var1.setColor(var2 ? 8700157 : 9478569);
      a(var1, super.j + 1, super.k, super.l - 2, super.m - 4);
      quyen_bt.a(quyen_bt.c).a(this.b, super.j + this.c, super.k + 3, var1);
   }

   public final void d() {
      if (this.d > 0) {
         this.d--;
         if (this.d == 0 && this.a != null) {
            this.a.a();
         }
      }
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4) {
      var3++;
      var4++;
      f = var1 + var3 - 2;
      u = var2 + var4 - 2;
      g = var1 + 1;
      var0.fillRect(g, u, 1, 1);
      var0.fillRect(f, u, 1, 1);
      u = var2 + 1;
      var0.fillRect(g, u, 1, 1);
      var0.fillRect(f, u, 1, 1);
      e = var4 - 4;
      f = var2 + 2;
      var0.fillRect(var1, f, 1, e);
      var0.fillRect(var1 + var3 - 1, f, 1, e);
      e = var1 + 2;
      f = var3 - 4;
      var0.fillRect(e, var2, f, 1);
      var0.fillRect(e, var2 + var4 - 1, f, 1);
   }

   public static void b(Graphics var0, int var1, int var2, int var3, int var4) {
      var0.setColor(66826);
      var0.fillRect(var1 + 1, var2 + 1, var3 - 1, var4 - 1);
      var0.setColor(8700157);
      a(var0, var1, var2, var3, var4);
   }

   public final boolean a(int var1) {
      return true;
   }
}
