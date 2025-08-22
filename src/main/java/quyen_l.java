import java.io.ByteArrayOutputStream;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.RecordControl;
import javax.microedition.media.control.VideoControl;

public final class quyen_l extends Canvas implements CommandListener {
   public quyen_ca a;
   public quyen_ca b;
   private Player d = null;
   private VideoControl e = null;
   private static quyen_l f;
   private boolean g;
   private String h = null;
   private RecordControl i = null;
   public ByteArrayOutputStream c;
   private Command j = new Command("OK", 4, 1);
   private Command k = new Command(quyen_cr.f(), 4, 1);
   private Command l = new Command("Dừng", 4, 1);
   private Command m = new Command(quyen_cr.c(), 2, 1);
   private int n;

   public static final quyen_l a() {
      if (f == null) {
         f = new quyen_l();
      }

      return f;
   }

   protected quyen_l() {
      this.setCommandListener(this);
   }

   public final void a(int var1) {
      this.n = var1;
      quyen_et.c();
      this.c();
      String var2 = null;
      String var3 = null;
      this.removeCommand(this.l);
      if (var1 == 0) {
         this.removeCommand(this.k);
         this.addCommand(this.j);
         var2 = "capture://image";
         var3 = "capture://video";
      } else if (var1 == 1) {
         this.removeCommand(this.j);
         this.addCommand(this.k);
         var2 = "capture://video";
         var3 = "capture://image";
      }

      this.addCommand(this.m);

      try {
         if (quyen_cs.v == 0) {
            try {
               this.d = Manager.createPlayer(var2);
            } catch (Exception var8) {
               this.d = Manager.createPlayer(var3);
            }
         } else {
            try {
               this.d = Manager.createPlayer(var3);
            } catch (Exception var7) {
               this.d = Manager.createPlayer(var2);
            }
         }

         this.d.realize();
      } catch (Exception var9) {
         this.g = true;
         this.h = var9.toString();
         System.gc();
         return;
      }

      System.gc();
      this.e = (VideoControl)this.d.getControl("javax.microedition.media.control.VideoControl");
      this.e.initDisplayMode(1, this);

      try {
         this.e.setDisplayLocation(0, 0);
         this.e.setDisplaySize(this.getWidth(), this.getHeight());
      } catch (MediaException var6) {
         try {
            this.e.setDisplayFullScreen(true);
         } catch (MediaException var5) {
            this.g = true;
            this.h = var5.toString();
         }
      }

      this.e.setVisible(true);
      Display.getDisplay(Xuka.i).setCurrent(this);

      try {
         this.d.start();
      } catch (MediaException var4) {
         this.g = true;
         this.h = var4.toString();
      }
   }

   public final void paint(Graphics var1) {
      var1.setColor(0);
      var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      if (this.g) {
         quyen_bt.a(quyen_bt.c).a("Lỗi camera", 10, 10, var1);
         quyen_bt.a(quyen_bt.c).a(this.h, 10, 10 + quyen_bt.i, var1);
      }
   }

   public final byte[] b() {
      byte[] byArray = null;
      try {
         try {
            byArray = this.e.getSnapshot("encoding=jpeg");
         }
         catch (Exception exception) {
            byArray = this.e.getSnapshot(null);
         }
      }
      catch (Exception exception) {
         this.g = true;
         byArray = null;
         this.h = exception.toString();
      }
      return byArray;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (this.n == 0) {
         quyen_et.e();
         quyen_et.a();
         if (var1.getLabel().equals("OK")) {
            new Thread(new quyen_m(this)).start();
         }

         if (var1.getLabel().equals(quyen_cr.c())) {
            if (this.b != null) {
               this.b.a();
            }

            this.c();
            this.e();
            return;
         }
      } else if (this.n == 1) {
         if (var1.getLabel().equals(quyen_cr.f())) {
            this.removeCommand(this.k);
            this.removeCommand(this.m);
            this.addCommand(this.l);
            quyen_l var4 = this;

            try {
               var4.i = (RecordControl)var4.d.getControl("RecordControl");
               var4.c = new ByteArrayOutputStream();
               var4.i.setRecordStream(var4.c);
               var4.i.startRecord();
            } catch (Exception var3) {
               Alert var5 = new Alert("Error start", var3.toString(), null, AlertType.ERROR);
               Display.getDisplay(Xuka.i).setCurrent(var5);
               return;
            }
         } else {
            if (var1.getLabel().equals("Dừng")) {
               this.removeCommand(this.l);
               this.addCommand(this.k);
               this.addCommand(this.m);
               this.d();
               this.c();
               if (this.a != null) {
                  this.a.a();
               }

               this.e();
               return;
            }

            if (var1.getLabel().equals(quyen_cr.c())) {
               this.d();
               this.c();
               if (this.b != null) {
                  this.b.a();
               }

               this.e();
            }
         }
      }
   }

   private void d() {
      if (this.d != null) {
         try {
            try {
               if (this.i != null) {
                  this.i.stopRecord();
                  this.i.commit();
               }
            } catch (Exception var3) {
               this.h = var3.toString();
            }

            try {
               this.c.close();
            } catch (Exception var2) {
            }

            this.i = null;
            this.d.stop();
            this.d.deallocate();
            this.d = null;
            return;
         } catch (Exception var4) {
            Alert var1 = new Alert("Error stop", var4.getMessage(), null, AlertType.ERROR);
            Display.getDisplay(Xuka.i).setCurrent(var1);
         }
      }
   }

   private void e() {
      this.a = null;
      this.b = null;
      this.c = null;
      f = null;
      System.gc();
   }

   public final void c() {
      this.e = null;
      if (this.d != null) {
         try {
            this.d.stop();
         } catch (MediaException var2) {
            this.h = var2.toString();
         }

         this.d.deallocate();
      }

      this.d = null;
      System.gc();
   }

   static void a(quyen_l var0) {
      var0.e();
   }
}
