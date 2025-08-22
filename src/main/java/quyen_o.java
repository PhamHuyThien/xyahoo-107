import java.util.Date;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class quyen_o extends quyen_bx {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;
   private Vector f;
   private int g;
   private int u;
   private int v = -1;
   private int w;
   private int x;
   private int y;
   private Integer z;
   private String A;
   private int B;
   private int C;
   private int D;
   private boolean E;
   private int F;
   private int G;

   static {
      new Date();
   }

   public final boolean a() {
      return this.d > this.e - 50;
   }

   public quyen_o(int var1, int var2, int var3, int var4) {
      super(0, 0, var3, var4, true);
      super.i = true;
      super.h = false;
      this.g = var4 / quyen_bt.h + 2;
      this.f = new Vector();
      super.r = new quyen_bw("Chat", null);
   }

   public final void a(String var1, int var2) {
      int var3;
      while ((var3 = var1.indexOf("http://")) > 0 || (var3 = var1.indexOf("vtp://")) > 0) {
         this.a(var1.substring(0, var3), var2);
         if ((var3 = (var1 = var1.substring(var3)).indexOf(" ")) == -1) {
            break;
         }

         this.a(var1.substring(0, var3), var2);
         var1 = var1.substring(var3);
      }

      if (!var1.startsWith("http://") && !var1.startsWith("vtp://")) {
         String[] var8 = quyen_bt.c(var1, super.l - 100);
         this.w = var8.length;

         for (int var5 = 0; var5 < this.w; var5++) {
            var8[var5] = (char)(var2 + 31000) + var8[var5];
         }

         for (int var6 = 0; var6 < this.w; var6++) {
            if (var8[var6].length() > 0) {
               this.f.addElement(var8[var6]);
            }
         }

         this.g();
      } else {
         var1 = "祼" + var1;
         this.f.addElement(var1);
         this.g();
      }
   }

   public final void a(String var1, String var2, int var3) {
      var1 = quyen_bt.a(var1, 16);
      if ((var2 = quyen_hs.b(var2)).startsWith("http")) {
         this.a(var1, quyen_cr.d(), var3);
         var2 = "祼" + var2;
         this.f.addElement(var2);
         this.g();
      } else {
         var2 = quyen_bt.a(var2, true);
         String[] var5;
         if ((var5 = quyen_bt.c(quyen_hr.a(quyen_hr.a(String.valueOf((char)(var3 + 31000)), var1, ": ", "紀"), var2, null, null), super.l - 8)) != null
            && var5.length > 0) {
            this.w = var5.length;

            for (int var8 = 0; var8 < this.w; var8++) {
               if (var5[var8].length() > 0) {
                  this.f.addElement(var5[var8]);
               }
            }

            this.g();
         }
      }
   }

   private void g() {
      this.y = this.f.size();
      this.e = (this.y - this.g + 2) * quyen_bt.h + 8;
      this.e();
   }

   public final boolean b(int var1) {
      if (var1 == 12) {
         if (this.v > 0) {
            this.v--;
         }

         this.a = this.a - quyen_bt.h;
         if (this.a < -quyen_bt.h) {
            this.a = -quyen_bt.h;
         }

         quyen_cq.a(true);
      } else if (var1 == 13) {
         if (this.v < this.y - 1) {
            this.v++;
         }

         this.a = this.a + quyen_bt.h;
         if (this.a > this.e) {
            this.a = this.e;
         }

         quyen_cq.a(true);
      }

      return true;
   }

   public final boolean a(int var1) {
      this.b(var1);
      return true;
   }

   public final void a(Graphics var1) {
      var1.setClip(super.j, super.k, super.l, super.m);
      var1.translate(0, -this.d + 3);
      if (this.v != -1) {
         this.z = quyen_bt.c;
         var1.setColor(66826);
         var1.fillRoundRect(3, this.v * quyen_bt.h, super.l - 6, quyen_bt.h, 5, 5);
      }

      this.w = this.u + this.g;

      for (int var2 = this.u - 1; var2 < this.w; var2++) {
         if (var2 >= 0) {
            if (var2 >= this.y) {
               break;
            }

            String var3 = (String)this.f.elementAt(var2);
            this.x = var3.length();
            if (this.x != 0) {
               byte var4 = 0;
               this.z = quyen_bt.c;
               int var5 = 0;
               if (var3.charAt(0) >= 31000) {
                  if ((var5 = var3.charAt(0) - 31000) == 0 || var5 == 100) {
                     this.z = quyen_bt.d;
                  } else if (var5 == 3) {
                     this.z = quyen_bt.b;
                  } else if (var5 == 1 || var5 == 2) {
                     this.z = quyen_bt.c;
                  }

                  var4 = 1;
               }

               this.C = 6;
               this.B = 0;

               for (int var6 = var4; var6 < this.x; var6++) {
                  char var8;
                  if ((var8 = var3.charAt(var6)) == 32000) {
                     this.A = var3.substring(1, var6);
                     quyen_bt.a(this.z).a(this.A, this.C, var2 * quyen_bt.h, var1);
                     this.C = this.C + quyen_bt.b(this.A);
                     this.z = quyen_bt.c;
                     this.B = var6;
                  } else if (var8 >= 30000) {
                     this.A = var3.substring(this.B, var6);
                     quyen_bt.a(this.z).a(this.A, this.C, var2 * quyen_bt.h, var1);
                     this.C = this.C + quyen_bt.b(this.A);
                     var1.drawRegion(
                        quyen_et.p, (var8 - 30000) * 18, 0, 18, 18, 0, this.C + 10, var2 * quyen_bt.h + (quyen_bt.h >> 1) + (this.D < 11 ? -1 : 0), 3
                     );
                     this.C += 20;
                     this.B = var6;
                  }
               }

               quyen_bt.a(this.z).a(var3.substring(this.B, this.x), this.C, var2 * quyen_bt.h, var1);
            }
         }
      }

      var1.translate(0, this.d - 3);
   }

   public final void d() {
      if (this.d != this.a) {
         this.b = this.a - this.d << 2;
         this.c = this.c + this.b;
         this.d = this.d + (this.c >> 3);
         this.c &= 15;
         if (this.d > this.e) {
            this.d = this.e;
         }

         if (this.d < 0) {
            this.d = 0;
         }

         this.u = this.d / quyen_bt.h - 1;
         if (this.u < 0) {
            this.u = 0;
         }
      }

      if (this.D++ > 21) {
         this.D = 0;
      }
   }

   public final void e() {
      if (super.k + this.y * (quyen_bt.h + 2) >= super.m) {
         quyen_cq.a = true;
         quyen_cq.a(this.y);
      } else {
         quyen_cq.a = false;
      }
   }

   public final void b(Graphics var1) {
      quyen_cq.a(var1, this.v);
   }

   public final void a(int var1, int var2) {
      this.F = var1;
      this.G = var2;
   }

   public final void b(int var1, int var2) {
      if (this.E) {
         this.E = false;
         this.a = this.a - (var2 - this.G << 3);
         if (this.a < 0) {
            this.a = 0;
         } else if (this.a > this.e) {
            this.a = this.e;
         }
      }

      quyen_cq.a(true);
   }

   public final void c(int var1, int var2) {
      if (quyen_b.c(var1 - this.F) > 1 || quyen_b.c(var2 - this.G) > 1) {
         this.E = true;
         this.a = this.a - (var2 - this.G);
         if (this.a < 0) {
            this.a = 0;
         } else if (this.a > this.e) {
            this.a = this.e;
         }

         this.d = this.a;
         this.u = this.d / quyen_bt.h - 1;
         if (this.u < 0) {
            this.u = 0;
         }

         this.F = var1;
         this.G = var2;
      }

      quyen_cq.a(true);
   }

   public final void b() {
      this.u = this.y - this.g;
      this.v = this.y - 1;
      this.a = this.e;
   }

   public final String c() {
      return this.v == -1 ? "" : (String)this.f.elementAt(this.v);
   }

   public final String f() {
      if (this.v == -1) {
         return "";
      } else {
         int var1 = this.v;
         int var2 = this.v;

         for (var1 = var1; ((String)this.f.elementAt(var2)).charAt(0) < 31000; var2--) {
            if (var2 <= 0) {
               var2 = 0;
               break;
            }
         }

         while (true) {
            if (((String)this.f.elementAt(var1)).charAt(0) >= 31000) {
               if (--var1 < 0) {
                  var1 = 0;
               }
               break;
            }

            if (var1 >= this.y - 1) {
               var1 = this.y - 1;
               break;
            }

            var1++;
         }

         if (var1 < var2) {
            var1 = var2;
         }

         String var3 = "";

         for (int var7 = var2; var7 <= var1; var7++) {
            var3 = var3 + (String)this.f.elementAt(var7) + " ";
         }

         for (int var8 = 0; var8 < var3.length(); var8++) {
            if (var3.charAt(var8) == 32000) {
               var3 = var3.substring(var8 + 1);
            }
         }

         try {
            for (int var9 = 0; var9 < var3.length(); var9++) {
               if (var3.charAt(var9) >= 30000) {
                  var3 = var3.substring(0, var9) + quyen_bt.f[var3.charAt(var9) - 30000] + var3.substring(var9 + 1);
               }
            }
         } catch (Exception var4) {
         }

         return var3;
      }
   }
}
