import java.util.Vector;

public class quyen_co extends quyen_cj {
   public int A;
   public int B;
   public int C;
   private quyen_ck[] a;
   private int b = -1;
   private Vector c = new Vector();

   public quyen_co() {
      this.g();
   }

   public final void g() {
      this.C = quyen_cj.h - 30;
      if (this.C < 100) {
         this.C = 100;
      }

      if (this.C > 200) {
         this.C = 200;
      }

      this.A = quyen_cj.h - this.C >> 1;
      this.B = 6;
   }

   public final void a(quyen_bx var1) {
      if (!this.c.contains(var1)) {
         var1.o = this;
         this.c.addElement(var1);
         super.a(var1);
         this.B = var1.k + var1.m + 2;
      }
   }

   public final void b(quyen_bx var1) {
      this.c.removeElement(var1);
      super.b(var1);
   }

   public final void e() {
      this.c.removeAllElements();
      super.e();
   }

   public final void a(String[] var1) {
      int var2 = var1.length;
      this.a = new quyen_ck[var2];

      for (int var3 = 0; var3 < var2; this.a[var3].b = var3++) {
         this.a[var3] = new quyen_ck(var1[var3], 0, 0, quyen_cj.h - 1, quyen_bt.e + 2);
         this.a[var3].a = this;
      }
   }

   public final void e(int var1) {
      if (this.b != -1) {
         this.a[this.b].c = false;
      }

      if (this.b == var1) {
         this.b = -1;
      } else {
         this.b = var1;
         this.a[this.b].c = true;
      }

      quyen_co var7 = this;
      super.e();
      int var2 = 5;
      int var3 = 0;
      int var4 = this.c.size();

      for (int var5 = 0; var5 < var4; var5++) {
         quyen_bx var6;
         if ((var6 = (quyen_bx)var7.c.elementAt(var5)).s == -1) {
            if (var2 < var6.k + var6.m) {
               var2 = var6.k + var6.m;
            }

            var7.a(var6);
         } else {
            if (var3 == var6.s) {
               if (var7.l.size() > 0 && !(var7.l.lastElement() instanceof quyen_ck)) {
                  var2 += 10;
               }

               var7.a[var3].k = var2;
               var7.a(var7.a[var3]);
               if (var7.b == var6.s) {
                  quyen_hr.a(var7, var7.a[var3]);
               }

               var2 += var7.a[var3].m;
               var3++;
            }

            if (var7.b == var6.s) {
               if (var6 instanceof quyen_bs) {
                  var2++;
               }

               var6.k = var2;
               var7.a(var6);
               var2 += var6.m;
               if (var6 instanceof quyen_cs) {
                  var2 += 5;
               }
            }
         }
      }

      var7.c(var7.c());
      var7.u = var7.t;
      var7.b();
   }

   public final quyen_bx d(int var1) {
      int var2 = this.c.size();

      for (int var3 = 0; var3 < var2; var3++) {
         quyen_bx var4;
         if ((var4 = (quyen_bx)this.c.elementAt(var3)).n == var1) {
            return var4;
         }
      }

      return null;
   }
}
