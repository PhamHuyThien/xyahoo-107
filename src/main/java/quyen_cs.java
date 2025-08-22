import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

public final class quyen_cs extends quyen_bx {
   public quyen_ce a;
   public boolean b;
   public boolean c = false;
   public boolean d = true;
   public static int e = 2;
   private static final int[] A = new int[]{18, 14, 11, 9, 6, 4, 2};
   private static int B = 0;
   public boolean f;
   private static String[] C = new String[]{
      " 0",
      ".,@?!_1'/$-():*+<=>;%&#%^&*[];'/1",
      "abc2áàảãạâấầẩẫậăắằẳẵặ2",
      "def3đéèẻẽẹêếềểễệ3",
      "ghi4íìỉĩị4",
      "jkl5",
      "mno6óòỏõọôốồổỗộơớờởỡợ6",
      "pqrs7",
      "tuv8úùủũụưứừửữự8",
      "wxyz9ýỳỷỹỵ9",
      "*",
      "#"
   };
   private String D = "";
   private String E = "";
   private String F = "";
   private int G = 0;
   private int H = 0;
   private int I = 50000;
   private int J = 0;
   private int K = -1984;
   private int L = 0;
   private int M = 0;
   private int N = 10;
   private int O = 0;
   private static boolean P;
   private static int Q;
   private int R = 0;
   private static String[] S = new String[]{"abc", "Abc", "ABC", "123"};
   private static int T = 11;
   public static Canvas g;
   public static MIDlet u;
   private boolean U;
   public static int v;
   private quyen_bw V = new quyen_bw("Xóa", new quyen_ct(this));
   public quyen_ca w;
   public int x = 26;
   private int W;
   private int X;
   private String[] Y;
   private int Z;
   public boolean y;
   public quyen_ca z;

   public final void a() {
      TextBox var1;
      (var1 = new TextBox("", "", 500, 0)).addCommand(new Command("OK", 4, 0));
      var1.addCommand(new Command(quyen_cr.c(), 3, 0));
      var1.setCommandListener(new quyen_cu(this, var1));

      try {
         if (this.f) {
            var1.setConstraints(3);
         } else if (this.O == 2) {
            var1.setConstraints(65536);
         } else if (this.O == 1) {
            var1.setConstraints(2);
         } else {
            var1.setConstraints(0);
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      var1.setString(this.D);
      var1.setMaxSize(this.I);
      Display.getDisplay(u).setCurrent(var1);
   }

   public static void c(int var0) {
      v = var0;
      if (var0 == 1) {
         C[0] = "0";
         C[10] = " *";
         C[11] = "#";
         T = 35;
      } else if (var0 == 0) {
         C[0] = " 0";
         C[10] = "*";
         C[11] = "#";
         T = 35;
      } else {
         if (var0 == 2) {
            C[0] = "0";
            C[10] = "*";
            C[11] = " #";
            T = 42;
         }
      }
   }

   private static void f() {
      B = quyen_bt.e + 1;
      Q = quyen_bt.b("ABC") + 1;
   }

   public quyen_cs() {
      this.D = "";
      f();
   }

   public quyen_cs(String var1, int var2) {
      this.D = var1;
      this.O = var2;
      f();
   }

   public final void b() {
      if (this.D.length() == 1) {
         this.h();
      }

      if (this.G > 0 && this.D.length() > 0) {
         this.D = this.D.substring(0, this.G - 1) + this.D.substring(this.G, this.D.length());
         this.G--;
         this.i();
         this.k();
      }
   }

   private void g() {
      super.q = this.V;
      quyen_hr.b(this);
   }

   private void h() {
      super.q = null;
      if (this.w != null) {
         this.w.a();
      }

      quyen_hr.b(this);
   }

   private void i() {
      if (this.O == 2) {
         this.F = this.E;
      } else {
         this.F = this.D;
      }

      if (this.J < 0 && quyen_bt.b(this.F) + this.J < super.l - 6 - 13 - Q) {
         this.J = super.l - 10 - Q - quyen_bt.b(this.F);
      }

      if (this.J + quyen_bt.b(this.F.substring(0, this.G)) <= 0) {
         this.J = -quyen_bt.b(this.F.substring(0, this.G));
         this.J += 40;
      } else if (this.J + quyen_bt.b(this.F.substring(0, this.G)) >= super.l - 12 - Q) {
         this.J = super.l + this.x - Q - quyen_bt.b(this.F.substring(0, this.G)) - 12;
      }

      if (this.J > 0) {
         this.J = 0;
      }
   }

   private void e(int var1) {
      this.U = true;
      if (this.f) {
         this.a();
      } else {
         this.a(var1, null);
      }
   }

   private void a(int var1, String var2) {
      if (this.D.length() < this.I) {
         this.g();
         String var3 = this.D.substring(0, this.G);
         if (var2 == null) {
            var3 = var3 + (char)var1;
         } else {
            var3 = var3 + var2;
         }

         if (this.G < this.D.length()) {
            var3 = var3 + this.D.substring(this.G, this.D.length());
         }

         this.D = var3;
         this.G++;
         this.k();
         this.i();
      }
   }

   private void f(int var1) {
      if (this.O == 3 && (this.D.length() == 2 || this.D.length() == 5)) {
         this.a(var1, "/");
      }
   }

   public final boolean b(int var1) {
      if (this.D.length() <= 0 && var1 == 16) {
         this.a();
         return false;
      } else {
         if (var1 >= 65 && var1 <= 122) {
            if (this.O == 1 || this.O == 3) {
               return false;
            }

            P = true;
         }

         if (P) {
            this.U = true;
            if (var1 == 45) {
               if (var1 == this.K && this.L < A[e]) {
                  this.D = this.D.substring(0, this.G - 1) + '_';
                  this.F = this.D;
                  this.k();
                  this.i();
                  this.K = -1984;
                  this.g();
                  return false;
               }

               this.K = 45;
            }

            if (var1 >= 32) {
               this.e(var1);
               if (this.O == 3) {
                  this.f(var1);
               }

               return false;
            }
         }

         if (var1 == T) {
            this.R++;
            if (this.R > 3) {
               this.R = 0;
            }

            this.L = 1;
            this.K = var1;
            return false;
         } else {
            if (var1 == 42) {
               var1 = 58;
            }

            if (var1 == 35) {
               var1 = 59;
            }

            if (var1 < 48 || var1 > 59) {
               this.M = 0;
               this.K = -1984;
               if (var1 == 14 && !this.c) {
                  if (this.G > 0) {
                     this.G--;
                     this.i();
                     this.N = 10;
                     return false;
                  }
               } else {
                  if (var1 == 15) {
                     if (!this.c && this.G < this.D.length()) {
                        this.G++;
                        this.i();
                        this.N = 10;
                        return false;
                     }

                     this.U = !this.U;
                     if (this.U) {
                        return false;
                     }

                     return true;
                  }

                  if (var1 == 19) {
                     this.b();
                     return false;
                  }

                  this.K = var1;
               }
            } else if (this.O == 0 || this.O == 2) {
               this.U = false;
               if (this.f) {
                  this.a();
               } else {
                  this.g();
                  if (var1 == this.K) {
                     this.M = (this.M + 1) % C[var1 - 48].length();
                     char var3 = C[var1 - 48].charAt(this.M);
                     if (this.R == 0) {
                        var3 = Character.toLowerCase(var3);
                     } else if (this.R == 1) {
                        var3 = Character.toUpperCase(var3);
                     } else if (this.R == 2) {
                        var3 = Character.toUpperCase(var3);
                     } else {
                        var3 = C[var1 - 48].charAt(C[var1 - 48].length() - 1);
                     }

                     String var5 = this.D.substring(0, this.G - 1) + var3;
                     if (this.G < this.D.length()) {
                        var5 = var5 + this.D.substring(this.G, this.D.length());
                     }

                     this.D = var5;
                     this.L = A[e];
                     this.k();
                  } else if (this.D.length() < this.I) {
                     if (this.R == 1 && this.K != -1984) {
                        this.R = 0;
                     }

                     this.M = 0;
                     char var6 = C[var1 - 48].charAt(this.M);
                     if (this.R == 0) {
                        var6 = Character.toLowerCase(var6);
                     } else if (this.R == 1) {
                        var6 = Character.toUpperCase(var6);
                     } else if (this.R == 2) {
                        var6 = Character.toUpperCase(var6);
                     } else {
                        var6 = C[var1 - 48].charAt(C[var1 - 48].length() - 1);
                     }

                     String var8 = this.D.substring(0, this.G) + var6;
                     if (this.G < this.D.length()) {
                        var8 = var8 + this.D.substring(this.G, this.D.length());
                     }

                     this.D = var8;
                     this.L = A[e];
                     this.G++;
                     this.k();
                     this.i();
                  }

                  this.K = var1;
               }
            } else if (this.O == 1 || this.O == 3) {
               this.e(var1);
               this.L = 1;
               this.f(var1);
            }

            return true;
         }
      }
   }

   public final boolean a(int var1) {
      if (!P && var1 < C.length) {
         this.b();
         this.e(C[var1].charAt(C[var1].length() - 1));
         this.L = A[e];
      }

      if (var1 == 19) {
         this.c("");
      }

      return true;
   }

   public final void b(int var1, int var2) {
      if (this.j()) {
         this.a();
      } else {
         quyen_hr.a(super.o, (quyen_bx)this);
      }
   }

   public final void a(String var1) {
      this.y = true;
      this.Z = super.m + 9;
      this.X = quyen_cj.i - quyen_et.e - (quyen_bt.e << 1) - 6;
      if (var1 != null && var1.length() > 0) {
         this.Y = quyen_bt.c(var1, quyen_cj.h - 30);
         this.Z = super.m + 16 + 4 + this.Y.length * (quyen_bt.e + 2);
         this.X = quyen_cj.i - quyen_et.e - this.Z - 3;
      }
   }

   public final boolean b(String var1) {
      StringBuffer var2 = new StringBuffer(0);
      int var3 = 0;

      for (int var4 = this.Y.length; var3 < var4; var3++) {
         var2.append(this.Y[var3]);
         if (var3 < var4 - 1) {
            var2.append(" ");
         }
      }

      return var2.toString().equals(var1);
   }

   public final void a(Graphics var1) {
      int var2 = 0;
      int var3 = super.k + (super.m - quyen_bt.e >> 1);
      boolean var4 = this.j();
      if (this.y) {
         var1.setColor(8700157);
         int var10003 = quyen_cj.h - 10;
         int var8 = this.Z;
         int var7 = var10003;
         int var6 = this.X;
         byte var5 = 5;
         var1.fillRect(var5, var6 - 1, var7, var8 + 2);
         var1.fillRect(var5 - 1, var6, var7 + 2, var8);
         var1.setColor(284567);
         var1.fillRect(5, this.X, quyen_cj.h - 10, this.Z);
         if (this.Y != null) {
            for (int var9 = 0; var9 < this.Y.length; var9++) {
               quyen_bt.a(quyen_bt.c).a(this.Y[var9], quyen_n.j - quyen_bt.b(this.Y[var9]) >> 1, this.X + 8 + var9 * (quyen_bt.e + 2), var1);
            }
         }
      }

      if (this.O == 2) {
         this.F = this.E;
      } else {
         this.F = this.D;
      }

      if (var4 && this.d) {
         var2 = super.j + super.l - 3;
         var1.setColor(66826);
         var1.fillRect(super.j + 2, super.k + 2, super.l - 3, super.m - 3);
         if (!P && !this.b) {
            var1.setColor(9478569);
            quyen_bs.a(var1, var2 - Q, super.k + 3, Q, super.m - 6);
            quyen_bt.a(quyen_bt.c).a(S[this.R], var2 - Q + (Q - quyen_bt.b(S[this.R]) >> 1) + (quyen_bt.a ? 0 : 1), var3, var1);
         }
      }

      Graphics var10000;
      int var10001;
      if (!var4) {
         var10000 = var1;
         var10001 = 9478569;
      } else {
         var10000 = var1;
         var10001 = var4 && !this.d ? 11320516 : 8700157;
      }

      var10000.setColor(var10001);
      quyen_bs.a(var1, super.j + 1, super.k + 1, super.l - 2, super.m - 2);
      var2 = super.k + 1;
      this.W = 6 + this.J + super.j;
      var1.setClip(super.j + 3, var2 > super.o.u ? var2 : super.o.u, super.l, super.m - 4);
      quyen_bt.a(quyen_bt.c).a(this.F, this.W, var3, var1);
      if (var4) {
         if (this.L != 0 || this.N <= 0 && this.H / 5 % 2 != 0) {
            var1.setColor(9360375);
         } else {
            var1.setColor(2767169);
         }

         var1.fillRect(this.W + quyen_bt.b(this.F.substring(0, this.G)) + (quyen_bt.a ? 1 : 0), super.k + (super.m - B >> 1) + 2, 1, B);
      }
   }

   private void k() {
      if (this.O == 2) {
         this.E = "";

         for (int var1 = 0; var1 < this.D.length(); var1++) {
            this.E = this.E + "*";
         }

         if (this.L > 0 && this.G > 0) {
            this.E = this.E.substring(0, this.G - 1) + this.D.charAt(this.G - 1) + this.E.substring(this.G, this.E.length());
         }
      }
   }

   public final void d() {
      this.H++;
      if (this.L > 0) {
         this.L--;
         if (this.L == 0) {
            this.M = 0;
            if (this.R == 1 && this.K != T) {
               this.R = 0;
            }

            this.K = -1984;
            this.k();
         }
      }

      if (this.N > 0) {
         this.N--;
      }
   }

   public final String c() {
      return this.D;
   }

   public final void c(String var1) {
      if (var1 != null) {
         if (var1.length() == 0) {
            this.h();
         } else {
            this.g();
         }

         this.K = -1984;
         this.L = 0;
         this.M = 0;
         this.D = var1;
         this.F = var1;
         this.k();
         this.G = var1.length();
         this.i();
      }
   }

   public final void d(String var1) {
      if (var1 != null && var1.length() != 0) {
         this.g();
         this.D = this.D.substring(0, this.G) + var1 + this.D.substring(this.G);
         this.k();
         this.G = this.G + var1.length();
         this.i();
      }
   }

   public final void d(int var1) {
      this.O = var1;
   }
}
