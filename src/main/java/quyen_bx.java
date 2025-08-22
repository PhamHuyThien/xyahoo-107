import javax.microedition.lcdui.Graphics;

public abstract class quyen_bx {
   public boolean h;
   public boolean i;
   public int j;
   public int k;
   public int l;
   public int m;
   public int n;
   public quyen_cj o;
   public quyen_bw p;
   public quyen_bw q;
   public quyen_bw r;
   int s = -1;
   public boolean t = false;

   public quyen_bx() {
      this.h = true;
   }

   public quyen_bx(int var1, int var2, int var3, int var4, boolean var5) {
      this.j = var1;
      this.k = var2;
      this.l = var3;
      this.m = var4;
      this.h = true;
   }

   public final boolean j() {
      return this.o == null ? false : quyen_hr.b(this.o, this);
   }

   public final void d(int var1, int var2) {
      this.j = var1;
      this.k = var2;
   }

   public final void e(int var1, int var2) {
      this.l = var1;
      this.m = var2;
   }

   public final void a(int var1, int var2, int var3, int var4) {
      this.d(var1, var2);
      this.e(var3, var4);
   }

   public abstract void a(Graphics var1);

   public abstract void d();

   public abstract boolean b(int var1);

   public abstract boolean a(int var1);

   public void e() {
   }

   public void b(Graphics var1) {
   }

   public void b(int var1, int var2) {
   }

   public void c(int var1, int var2) {
   }

   public void a(int var1, int var2) {
   }
}
