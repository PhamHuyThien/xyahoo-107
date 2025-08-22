import java.io.ByteArrayInputStream;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Item;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.VideoControl;
import javax.microedition.media.control.VolumeControl;

public final class quyen_ht extends Form implements CommandListener, PlayerListener {
   private static quyen_ht a;
   private quyen_ca b;
   private Command c = new Command(quyen_cr.c(), 2, 1);
   private Command d;
   private Command e = new Command("Âm lượng", 1, 2);
   private Command f = new Command("Tạm ngưng", 1, 1);
   private Command g = new Command("Chơi tiếp", 1, 1);
   private Command h = new Command(quyen_cr.b(), 2, 1);
   private int i;
   private byte[] j;
   private String k;
   private Gauge l = new Gauge("Volume: 50", true, 100, 50);
   private VolumeControl m;
   private Form n = new Form("Âm lượng");
   private Player o;
   private ByteArrayInputStream p;
   private Item q;

   public final void a(int var1) {
      this.i = var1;
   }

   public static final quyen_ht a() {
      if (a == null) {
         a = new quyen_ht();
      }

      return a;
   }

   public quyen_ht() {
      super("");
      this.addCommand(this.c);
      this.addCommand(this.e);
      this.addCommand(this.f);
      this.addCommand(this.g);
      this.setCommandListener(this);
      this.n.append(this.l);
      this.n.addCommand(this.h);
      this.n.setItemStateListener(new quyen_hu(this));
      this.n.setCommandListener(this);
      Display.getDisplay(Xuka.i).setCurrent(this);
   }

   public final void a(byte[] var1, String var2) {
      String var4 = "";
      String var3;
      if ((var3 = var2.toLowerCase()).endsWith(".mp3")) {
         var4 = "audio/mpeg";
      } else if (var3.endsWith(".3gp")) {
         var4 = "video/3gpp";
      } else if (var3.endsWith(".3g2")) {
         var4 = "video/3gpp2";
      } else if (var3.endsWith(".wav")) {
         var4 = "audio/x-wav";
      } else if (var3.endsWith(".mpg")) {
         var4 = "video/mpeg";
      } else if (var3.endsWith(".mp4")) {
         var4 = "video/mp4";
      }

      var3 = var4;
      if (var4.length() == 0) {
         var3 = "video/mpeg";
      }

      this.j = var1;
      this.k = var2;
      this.d();
      Display.getDisplay(Xuka.i).setCurrent(a);

      try {
         this.p = new ByteArrayInputStream(var1);
         this.o = Manager.createPlayer(this.p, var3);
         this.o.realize();
         this.o.addPlayerListener(this);
         this.m = (VolumeControl)this.o.getControl("VolumeControl");
         this.m.setLevel(50);
         this.l.setValue(this.m.getLevel());
         this.l.setLabel(quyen_hr.a("Âm lượng", ": ", Integer.toString(this.m.getLevel()), null));
         this.o.start();
      } catch (Exception var5) {
         var5.printStackTrace();
         quyen_et.a();
         this.e();
         quyen_et.c.d("Điện thoại không hỗ trợ chức năng này");
      }
   }

   private void d() {
      if (this.o != null) {
         try {
            this.o.stop();
         } catch (MediaException var3) {
         }

         this.o.deallocate();

         try {
            this.o.close();
         } catch (Exception var2) {
         }
      }

      this.o = null;

      try {
         if (this.p != null) {
            this.p.close();
            this.p = null;
         }
      } catch (Exception var1) {
      }

      System.gc();
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("Tạm ngưng")) {
         try {
            this.o.stop();
         } catch (Exception var3) {
         }
      } else if (var1.getLabel().equals("Chơi tiếp")) {
         try {
            this.o.start();
         } catch (Exception var4) {
         }
      } else {
         if (var1.getLabel().equals("Lưu")) {
            this.d();
            if (this.b != null) {
               this.b.a();
               return;
            }
         } else {
            if (var1.getLabel().equals("Âm lượng")) {
               Display.getDisplay(Xuka.i).setCurrent(this.n);
               return;
            }

            if (var1.getLabel().equals(quyen_cr.c())) {
               if (this.i == 0) {
                  Display.getDisplay(Xuka.i).setCurrent(quyen_hy.a());
               } else if (this.i == 2) {
                  quyen_et.a();
               }

               this.e();
               return;
            }

            if (var1.getLabel().equals(quyen_cr.b()) && var2 == this.n) {
               Display.getDisplay(Xuka.i).setCurrent(this);
               return;
            }

            if (var1.getLabel().equals(quyen_cr.b())) {
               this.d();
               Display.getDisplay(Xuka.i).setCurrent(quyen_hy.a());
            }
         }
      }
   }

   private void e() {
      this.d();
      this.j = null;
      this.l = null;
      this.m = null;
      this.n = null;
      this.o = null;
      a = null;
      System.gc();
   }

   public final void b() {
      this.removeCommand(this.d);
   }

   public final void c() {
      if (this.b == null) {
         this.b = new quyen_hv(this);
      }

      if (this.d == null) {
         this.d = new Command("Lưu", 1, 1);
      }

      this.addCommand(this.d);
   }

   public final void playerUpdate(Player var1, String var2, Object var3) {
      if (var2.equals("started")) {
         VideoControl var6;
         if ((var6 = (VideoControl)this.o.getControl("VideoControl")) != null) {
            if (this.q == null) {
               this.q = (Item)var6.initDisplayMode(0, null);
            }

            try {
               var6.setDisplayFullScreen(true);
            } catch (MediaException var5) {
            }

            var6.setVisible(true);

            try {
               this.append(this.q);
               Display.getDisplay(Xuka.i).setCurrent(this);
               return;
            } catch (Exception var4) {
               return;
            }
         }
      } else if (var2.equals("closed")) {
         this.deleteAll();
      }
   }

   static VolumeControl a(quyen_ht var0) {
      return var0.m;
   }

   static Gauge b(quyen_ht var0) {
      return var0.l;
   }

   static String c(quyen_ht var0) {
      return var0.k;
   }

   static byte[] d(quyen_ht var0) {
      return var0.j;
   }
}
