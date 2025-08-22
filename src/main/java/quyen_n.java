import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public final class quyen_n extends Canvas implements Runnable {
   public static quyen_n a;
   static boolean b;
   private static boolean[] n = new boolean[21];
   private static boolean[] o = new boolean[21];
   private static int[] p = new int[1];
   static boolean c;
   static boolean d;
   static boolean e;
   static boolean f;
   public static int g;
   public static int h;
   public static int i;
   public static int j;
   public static int k;
   public static boolean l;
   private static int q;
   public static boolean m = false;

   static {
      new Object();
   }

   public quyen_n() {
      System.gc();
      this.setFullScreenMode(true);
      a = this;
      l = this.getKeyCode(8) == -20;
      j = this.getWidth();
      k = this.getHeight();
      i = 0;
      quyen_bt.a();
      quyen_he var1 = quyen_he.a();
      quyen_jv.a(2, var1);
      quyen_jv.a(4, quyen_hf.a());
      quyen_jv.a(39, var1);
      quyen_jv.a(5, var1);
      quyen_jv.a(6, var1);
      quyen_jv.a(37, var1);
      quyen_jv.a(48, var1);
      quyen_jv.b = var1;
      quyen_et var2;
      quyen_he.a = var2 = quyen_et.e();
      quyen_hf.a = var2;
      quyen_jv.a(new quyen_ju(2, 5));
      new Thread(this).start();
   }

   public final void a() {
      if (!quyen_jv.c && !quyen_jv.d) {
         String[] var1 = Xuka.i();
         int[] var2 = Xuka.j();
         System.out.println("Loaded IPs");
         System.out.println(var1.length);

         for (int var3 = 0; var3 < var1.length; var3++) {
            System.out.println(var1[var3]);
            System.out.println(var2[var3]);
         }

         if (var1.length == 0 || quyen_et.a || !quyen_et.a && var2.length > 0 && var2[0] == 11112) {
            var1 = Xuka.b;
            var2 = Xuka.c;
         }

         int var5 = (int)(System.currentTimeMillis() % (long)var1.length);
         int var4 = (int)(System.currentTimeMillis() % (long)Xuka.b.length);
         quyen_jv.a(var1[var5], Xuka.b[var4], var2[var5], Xuka.c[var4]);
      }
   }

   protected final void paint(Graphics var1) {
      try {
         switch (i) {
            case 0:
               quyen_af.a(var1);
            default:
               return;
            case 1:
               quyen_et.c.a(var1);
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public final void run() {
      b = true;

      while (b) {
         long var1 = System.currentTimeMillis();

         try {
            switch (i) {
               case 0:
                  quyen_af.b();
                  break;
               case 1:
                  quyen_et.c.a(n, o, p);
            }
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         this.repaint();
         this.serviceRepaints();
         long var6;
         var1 = (var6 = System.currentTimeMillis() - var1) < 35L ? 35L - var6 : 1L;

         try {
            Thread.sleep(var1);
         } catch (Exception var4) {
         }
      }

      Xuka.i.destroyApp(false);
      Xuka.i.notifyDestroyed();
   }

   protected final void keyPressed(int var1) {
      if (l) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         p[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            n[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            n[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            n[17] = true;
            return;
         case -39:
         case -2:
            n[13] = true;
            return;
         case -38:
         case -1:
            n[12] = true;
            return;
         case -11:
            n[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            n[16] = true;
            return;
         case -4:
            n[15] = true;
            return;
         case -3:
            n[14] = true;
            return;
         case 35:
            n[11] = true;
            return;
         case 42:
            n[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            n[var1 - 48] = true;
            return;
      }
   }

   protected final void keyRepeated(int var1) {
      if (l) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
            case 22:
               var1 = -7;
               break;
            case -21:
            case 21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      if (var1 >= 32) {
         p[0] = var1;
      }

      switch (var1) {
         case -204:
         case -8:
         case 8:
            o[19] = true;
            return;
         case -203:
         case -22:
         case -7:
            o[18] = true;
            return;
         case -202:
         case -21:
         case -6:
            o[17] = true;
            return;
         case -39:
         case -2:
            o[13] = true;
            return;
         case -38:
         case -1:
            o[12] = true;
            return;
         case -11:
            o[20] = true;
            return;
         case -5:
         case 10:
         case 13:
            o[16] = true;
            return;
         case -4:
            o[15] = true;
            return;
         case -3:
            o[14] = true;
            return;
         case 35:
            o[11] = true;
            return;
         case 42:
            o[10] = true;
            return;
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            o[var1 - 48] = true;
            return;
      }
   }

   protected final void keyReleased(int var1) {
      if (l) {
         switch (var1) {
            case -23:
               var1 = -8;
               break;
            case -22:
               var1 = -7;
               break;
            case -21:
               var1 = -6;
               break;
            case -20:
               var1 = -5;
               break;
            case -6:
               var1 = -2;
               break;
            case -5:
               var1 = -4;
               break;
            case -2:
               var1 = -3;
         }
      }

      switch (var1) {
         case -39:
         case -2:
            o[13] = false;
            return;
         case -38:
         case -1:
            o[12] = false;
            return;
         case -22:
         case -7:
            o[18] = false;
            return;
         case -21:
         case -6:
            o[17] = false;
            return;
         case -11:
            o[20] = false;
            return;
         case -8:
         case 8:
            o[19] = false;
            return;
         case -5:
         case 10:
         case 13:
            o[16] = false;
            return;
         case -4:
            o[15] = false;
            return;
         case -3:
            o[14] = false;
            return;
         case 35:
            o[11] = false;
            return;
         case 42:
            o[10] = false;
            return;
         case 48:
         case 49:
            q++;
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            o[var1 - 48] = false;
            return;
      }
   }

   public static void b() {
      for (int var0 = 0; var0 < 21; var0++) {
         n[var0] = false;
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      c = true;
      f = true;
      g = var1;
      h = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      c = true;
      e = true;
      g = var1;
      h = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      c = false;
      d = true;
      g = var1;
      h = var2;
   }
}
