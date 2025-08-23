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

public final class MediaPlayerForm extends Form implements CommandListener, PlayerListener {
   private static MediaPlayerForm instance;
   private Action saveAction;
   private Command backCommand = new Command(TextConstant.close(), 2, 1);
   private Command saveCommand;
   private Command volumeCommand = new Command("Âm lượng", 1, 2);
   private Command pauseCommand = new Command("Tạm ngưng", 1, 1);
   private Command resumeCommand = new Command("Chơi tiếp", 1, 1);
   private Command okCommand = new Command(TextConstant.back(), 2, 1);
   private int returnMode; //Mode trở về (0,1,2)
   private byte[] mediaData;
   private String fileName;
   private Gauge volumeGauge = new Gauge("Volume: 50", true, 100, 50);
   private VolumeControl volumeControl;
   private Form volumeForm = new Form("Âm lượng");
   private Player mediaPlayer;
   private ByteArrayInputStream inputStream;
   private Item videoItem;

   public final void setReturnMode(int var1) {
      this.returnMode = var1;
   }

   public static final MediaPlayerForm getInstance() {
      if (instance == null) {
         instance = new MediaPlayerForm();
      }

      return instance;
   }

   public MediaPlayerForm() {
      super("");
      this.addCommand(this.backCommand);
      this.addCommand(this.volumeCommand);
      this.addCommand(this.pauseCommand);
      this.addCommand(this.resumeCommand);
      this.setCommandListener(this);
      this.volumeForm.append(this.volumeGauge);
      this.volumeForm.addCommand(this.okCommand);
      this.volumeForm.setItemStateListener(new quyen_hu(this));
      this.volumeForm.setCommandListener(this);
      Display.getDisplay(Xuka.instance).setCurrent(this);
   }

   public final void playMedia(byte[] var1, String var2) {
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

      this.mediaData = var1;
      this.fileName = var2;
      this.stopAndCleanupPlayer();
      Display.getDisplay(Xuka.instance).setCurrent(instance);

      try {
         this.inputStream = new ByteArrayInputStream(var1);
         this.mediaPlayer = Manager.createPlayer(this.inputStream, var3);
         this.mediaPlayer.realize();
         this.mediaPlayer.addPlayerListener(this);
         this.volumeControl = (VolumeControl)this.mediaPlayer.getControl("VolumeControl");
         this.volumeControl.setLevel(50);
         this.volumeGauge.setValue(this.volumeControl.getLevel());
         this.volumeGauge.setLabel(UIUtils.concatStrings("Âm lượng", ": ", Integer.toString(this.volumeControl.getLevel()), null));
         this.mediaPlayer.start();
      } catch (Exception var5) {
         var5.printStackTrace();
         GameManager.showMainScreen();
         this.cleanup();
         GameManager.instance.d("Điện thoại không hỗ trợ chức năng này");
      }
   }

   private void stopAndCleanupPlayer() {
      if (this.mediaPlayer != null) {
         try {
            this.mediaPlayer.stop();
         } catch (MediaException var3) {
         }

         this.mediaPlayer.deallocate();

         try {
            this.mediaPlayer.close();
         } catch (Exception var2) {
         }
      }

      this.mediaPlayer = null;

      try {
         if (this.inputStream != null) {
            this.inputStream.close();
            this.inputStream = null;
         }
      } catch (Exception var1) {
      }

      System.gc();
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals("Tạm ngưng")) {
         try {
            this.mediaPlayer.stop();
         } catch (Exception var3) {
         }
      } else if (var1.getLabel().equals("Chơi tiếp")) {
         try {
            this.mediaPlayer.start();
         } catch (Exception var4) {
         }
      } else {
         if (var1.getLabel().equals("Lưu")) {
            this.stopAndCleanupPlayer();
            if (this.saveAction != null) {
               this.saveAction.action();
               return;
            }
         } else {
            if (var1.getLabel().equals("Âm lượng")) {
               Display.getDisplay(Xuka.instance).setCurrent(this.volumeForm);
               return;
            }

            if (var1.getLabel().equals(TextConstant.close())) {
               if (this.returnMode == 0) {
                  Display.getDisplay(Xuka.instance).setCurrent(SaveFileForm.getInstance());
               } else if (this.returnMode == 2) {
                  GameManager.showMainScreen();
               }

               this.cleanup();
               return;
            }

            if (var1.getLabel().equals(TextConstant.back()) && var2 == this.volumeForm) {
               Display.getDisplay(Xuka.instance).setCurrent(this);
               return;
            }

            if (var1.getLabel().equals(TextConstant.back())) {
               this.stopAndCleanupPlayer();
               Display.getDisplay(Xuka.instance).setCurrent(SaveFileForm.getInstance());
            }
         }
      }
   }

   private void cleanup() {
      this.stopAndCleanupPlayer();
      this.mediaData = null;
      this.volumeGauge = null;
      this.volumeControl = null;
      this.volumeForm = null;
      this.mediaPlayer = null;
      instance = null;
      System.gc();
   }

   public final void removeSaveCommand() {
      this.removeCommand(this.saveCommand);
   }

   public final void addSaveCommand() {
      if (this.saveAction == null) {
         this.saveAction = new quyen_hv(this);
      }

      if (this.saveCommand == null) {
         this.saveCommand = new Command("Lưu", 1, 1);
      }

      this.addCommand(this.saveCommand);
   }

   public final void playerUpdate(Player var1, String var2, Object var3) {
      if (var2.equals("started")) {
         VideoControl var6;
         if ((var6 = (VideoControl)this.mediaPlayer.getControl("VideoControl")) != null) {
            if (this.videoItem == null) {
               this.videoItem = (Item)var6.initDisplayMode(0, null);
            }

            try {
               var6.setDisplayFullScreen(true);
            } catch (MediaException var5) {
            }

            var6.setVisible(true);

            try {
               this.append(this.videoItem);
               Display.getDisplay(Xuka.instance).setCurrent(this);
               return;
            } catch (Exception var4) {
               return;
            }
         }
      } else if (var2.equals("closed")) {
         this.deleteAll();
      }
   }

   static VolumeControl getVolumeControl(MediaPlayerForm var0) {
      return var0.volumeControl;
   }

   static Gauge getVolumeGauge(MediaPlayerForm var0) {
      return var0.volumeGauge;
   }

   static String getFileName(MediaPlayerForm var0) {
      return var0.fileName;
   }

   static byte[] getMediaData(MediaPlayerForm var0) {
      return var0.mediaData;
   }
}
