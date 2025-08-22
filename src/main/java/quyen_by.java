import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class quyen_by {
   public UIFactory a;
   public UIFactory b;
   public UIFactory c;
   private String[] d;
   private boolean e = false;
   private Vector f;
   private int g;
   private int h;
   private int i;
   private String j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u;
   private int v;

   public quyen_by(String var1, int var2, Vector var3, int var4, UIFactory var5, UIFactory var6, UIFactory var7) {
      this.j = var1;
      this.f = var3;
      this.g = var4;
      this.h = var2;
      this.i = var3.size();
      this.a(var5, var6, var7);
      this.a();
   }

   public quyen_by(String var1, UIFactory var2, UIFactory var3, UIFactory var4) {
      this.d = FontRenderer.wrapTextToLines(var1, GameGraphics.screenWidth - 30);
      this.a(var2, var3, var4);
      this.a();
   }

   public quyen_by(String[] var1, UIFactory var2, UIFactory var3, UIFactory var4) {
      this.d = var1;
      this.a(var2, var3, var4);
      this.a();
   }

   private void a(UIFactory var1, UIFactory var2, UIFactory var3) {
      this.a = var1;
      this.c = var3;
      this.b = var2;
      if (this.b != null) {
         this.u = GameGraphics.screenWidth - FontRenderer.getTextWidth(this.b.text) >> 1;
      }

      if (this.c != null) {
         this.v = GameGraphics.screenWidth - FontRenderer.getTextWidth(this.c.text) - 4;
      }
   }

   public final void a(boolean var1) {
      this.e = var1;
      this.a();
   }

   private void a() {
      if (this.f == null) {
         this.k = this.d.length;
         this.p = this.k * (FontRenderer.fontHeight + 2) + (this.e ? 20 : 0);
         this.q = this.p + (FontRenderer.fontHeight << 1) - 1;
         if (this.q < 30) {
            this.q = 30;
         }

         if (this.q > GameGraphics.screenHeight - 35) {
            this.q = this.p = GameGraphics.screenHeight - 35;
         }

         for (int var1 = 0; var1 < this.k; var1++) {
            int var2 = FontRenderer.getTextWidth(this.d[var1]) + 10;
            if (this.r < var2) {
               this.r = var2;
            }
         }
      } else {
         for (int var4 = 0; var4 < this.i; var4++) {
            for (int var6 = 0; var6 < this.g; var6++) {
               int var3 = FontRenderer.getTextWidth(((String[])this.f.elementAt(var4))[var6]) + 10;
               if (this.r < var3) {
                  this.r = var3;
               }
            }
         }

         this.q = 0;
         if (this.j != null) {
            this.q = this.q + FontRenderer.fontHeight + 11;
         }

         for (int var5 = 0; var5 < this.i; var5++) {
            for (int var7 = 0; var7 < this.g; var7++) {
               this.q = this.q + FontRenderer.fontHeight + 2;
            }

            this.q += 12;
         }
      }

      this.r += 60;
      if (this.r < 100) {
         this.r = 100;
      }

      if (this.r > GameGraphics.screenWidth - 15) {
         this.r = GameGraphics.screenWidth - 15;
      }

      this.s = GameGraphics.screenHeight - this.q >> 1;
      quyen_by var10000;
      int var10001;
      int var10002;
      if (this.f == null) {
         var10000 = this;
         var10001 = this.s + (this.q - this.p >> 1);
         var10002 = 1;
      } else {
         var10000 = this;
         var10001 = this.s;
         var10002 = this.j != null ? 5 : 6;
      }

      var10000.t = var10001 + var10002;
      this.m = this.s + 1;
      this.n = this.r - 2;
      this.o = this.q - 2;
   }

   public final void a(Graphics var1) {
      this.l = (GameGraphics.screenWidth - this.r >> 1) + 1;
      var1.setClip(this.l, this.m, this.n, this.o);
      int var2 = this.r / 50 + 1;

      while (--var2 >= 0) {
         int var3 = this.q / 50 + 1;

         while (--var3 >= 0) {
            var1.drawImage(GameManager.backgroundImage, this.l + var2 * 50, this.m + var3 * 50, 0);
         }
      }

      if (this.r > 110) {
         var1.drawRegion(GameManager.dialogBackground, 0, 0, 55, 20, 0, this.l, this.m, 0);
         var1.drawRegion(GameManager.dialogBackground, 87, 0, 55, 20, 0, this.l + this.n - 55, this.m, 0);
         var1.setClip(this.l + 55, this.m, this.n - 110, 20);
         int var9 = (this.n - 110 >> 5) + 1;

         while (--var9 >= 0) {
            var1.drawRegion(GameManager.dialogBackground, 55, 0, 32, 20, 0, this.l + 55 + var9 * 32, this.m, 0);
         }
      }

      var1.setClip(-1000, -1000, 5000, 5000);
      var1.setColor(14545919);
      ButtonComponent.drawRoundedBorder(var1, this.l - 1, this.s, this.r - 1, this.q - 1);
      var1.drawRect(this.l - 1, this.s, this.r - 1, this.q - 1);
      ButtonComponent.drawRoundedBorder(var1, this.l - 2, this.s - 1, this.r + 1, this.q + 1);
      var1.setClip(-1000, -1000, 5000, 5000);
      if (this.f == null) {
         for (int var6 = 0; var6 < this.k; var6++) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.d[var6], GameGraphics.screenWidth - FontRenderer.getTextWidth(this.d[var6]) >> 1, this.t + var6 * (FontRenderer.fontHeight + 2), var1);
         }

         if (this.e) {
            GameManager.instance.drawLoading(var1, quyen_cp.d, this.t + this.k * FontRenderer.fontHeight + FontRenderer.fontHeight + 3);
         }
      } else {
         var1.setColor(11320516);
         if (this.j != null) {
            FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.j, GameGraphics.screenWidth - FontRenderer.getTextWidth(this.j) >> 1, this.t, var1);
            var2 = this.t + FontRenderer.fontHeight;
            var1.fillRect(this.l, var2 + 5, this.n, 2);
            var2 += 12;
         } else {
            var2 = this.t;
         }

         for (int var10 = 0; var10 < this.i; var10++) {
            for (int var4 = 0; var4 < this.g; var4++) {
               String[] var5 = (String[])this.f.elementAt(var10);
               FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(var5[var4], this.h == 0 ? this.l + 10 : GameGraphics.screenWidth - FontRenderer.getTextWidth(var5[var4]) >> 1, var2, var1);
               var2 += FontRenderer.fontHeight + 2;
            }

            if (var10 < this.i - 1) {
               var1.fillRect(this.l, var2 + 5, this.n, 1);
            }

            var2 += 12;
         }
      }

      Screen.renderHeader(var1);
      if (this.a != null) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.a.text, 4, Screen.softkeyY, var1);
      }

      if (this.b != null) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.b.text, this.u, Screen.softkeyY, var1);
      }

      if (this.c != null) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.c.text, this.v, Screen.softkeyY, var1);
      }
   }
}
