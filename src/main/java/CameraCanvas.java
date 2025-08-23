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

public final class CameraCanvas extends Canvas implements CommandListener {
   public Action completionAction;
   public Action cancelAction;
   private Player cameraPlayer = null;
   private VideoControl videoControl = null;
   private static CameraCanvas instance;
   private boolean hasError;
   private String errorMessage = null;
   private RecordControl recordControl = null;
   public ByteArrayOutputStream recordOutputStream;
   private Command okCommand = new Command("OK", 4, 1);
   private Command recordCommand = new Command(TextConstant.start(), 4, 1);
   private Command stopCommand = new Command("Dừng", 4, 1);
   private Command backCommand = new Command(TextConstant.close(), 2, 1);
   private int cameraMode;

   public static final CameraCanvas getInstance() {
      if (instance == null) {
         instance = new CameraCanvas();
      }

      return instance;
   }

   protected CameraCanvas() {
      this.setCommandListener(this);
   }

   public final void initializeCamera(int var1) {
      this.cameraMode = var1;
      GameManager.garbageCollect();
      this.stopPlayer();
      String var2 = null;
      String var3 = null;
      this.removeCommand(this.stopCommand);
      if (var1 == 0) {
         this.removeCommand(this.recordCommand);
         this.addCommand(this.okCommand);
         var2 = "capture://image";
         var3 = "capture://video";
      } else if (var1 == 1) {
         this.removeCommand(this.okCommand);
         this.addCommand(this.recordCommand);
         var2 = "capture://video";
         var3 = "capture://image";
      }

      this.addCommand(this.backCommand);

      try {
         if (TextInputComponent.keyboardLayout == 0) {
            try {
               this.cameraPlayer = Manager.createPlayer(var2);
            } catch (Exception var8) {
               this.cameraPlayer = Manager.createPlayer(var3);
            }
         } else {
            try {
               this.cameraPlayer = Manager.createPlayer(var3);
            } catch (Exception var7) {
               this.cameraPlayer = Manager.createPlayer(var2);
            }
         }

         this.cameraPlayer.realize();
      } catch (Exception var9) {
         this.hasError = true;
         this.errorMessage = var9.toString();
         System.gc();
         return;
      }

      System.gc();
      this.videoControl = (VideoControl)this.cameraPlayer.getControl("javax.microedition.media.control.VideoControl");
      this.videoControl.initDisplayMode(1, this);

      try {
         this.videoControl.setDisplayLocation(0, 0);
         this.videoControl.setDisplaySize(this.getWidth(), this.getHeight());
      } catch (MediaException var6) {
         try {
            this.videoControl.setDisplayFullScreen(true);
         } catch (MediaException var5) {
            this.hasError = true;
            this.errorMessage = var5.toString();
         }
      }

      this.videoControl.setVisible(true);
      Display.getDisplay(Xuka.instance).setCurrent(this);

      try {
         this.cameraPlayer.start();
      } catch (MediaException var4) {
         this.hasError = true;
         this.errorMessage = var4.toString();
      }
   }

   public final void paint(Graphics var1) {
      var1.setColor(0);
      var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      if (this.hasError) {
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText("Lỗi camera", 10, 10, var1);
         FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(this.errorMessage, 10, 10 + FontRenderer.paragraphSpacing, var1);
      }
   }

   public final byte[] capturePhoto() {
      byte[] byArray = null;
      try {
         try {
            byArray = this.videoControl.getSnapshot("encoding=jpeg");
         }
         catch (Exception exception) {
            byArray = this.videoControl.getSnapshot(null);
         }
      }
      catch (Exception exception) {
         this.hasError = true;
         byArray = null;
         this.errorMessage = exception.toString();
      }
      return byArray;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (this.cameraMode == 0) {
         GameManager.getInstance();
         GameManager.showMainScreen();
         if (var1.getLabel().equals("OK")) {
            new Thread(new CameraCaptureTask(this)).start();
         }

         if (var1.getLabel().equals(TextConstant.close())) {
            if (this.cancelAction != null) {
               this.cancelAction.action();
            }

            this.stopPlayer();
            this.cleanup();
            return;
         }
      } else if (this.cameraMode == 1) {
         if (var1.getLabel().equals(TextConstant.start())) {
            this.removeCommand(this.recordCommand);
            this.removeCommand(this.backCommand);
            this.addCommand(this.stopCommand);
            CameraCanvas var4 = this;

            try {
               var4.recordControl = (RecordControl)var4.cameraPlayer.getControl("RecordControl");
               var4.recordOutputStream = new ByteArrayOutputStream();
               var4.recordControl.setRecordStream(var4.recordOutputStream);
               var4.recordControl.startRecord();
            } catch (Exception var3) {
               Alert var5 = new Alert("Error start", var3.toString(), null, AlertType.ERROR);
               Display.getDisplay(Xuka.instance).setCurrent(var5);
               return;
            }
         } else {
            if (var1.getLabel().equals("Dừng")) {
               this.removeCommand(this.stopCommand);
               this.addCommand(this.recordCommand);
               this.addCommand(this.backCommand);
               this.stopRecording();
               this.stopPlayer();
               if (this.completionAction != null) {
                  this.completionAction.action();
               }

               this.cleanup();
               return;
            }

            if (var1.getLabel().equals(TextConstant.close())) {
               this.stopRecording();
               this.stopPlayer();
               if (this.cancelAction != null) {
                  this.cancelAction.action();
               }

               this.cleanup();
            }
         }
      }
   }

   private void stopRecording() {
      if (this.cameraPlayer != null) {
         try {
            try {
               if (this.recordControl != null) {
                  this.recordControl.stopRecord();
                  this.recordControl.commit();
               }
            } catch (Exception var3) {
               this.errorMessage = var3.toString();
            }

            try {
               this.recordOutputStream.close();
            } catch (Exception var2) {
            }

            this.recordControl = null;
            this.cameraPlayer.stop();
            this.cameraPlayer.deallocate();
            this.cameraPlayer = null;
            return;
         } catch (Exception var4) {
            Alert var1 = new Alert("Error stop", var4.getMessage(), null, AlertType.ERROR);
            Display.getDisplay(Xuka.instance).setCurrent(var1);
         }
      }
   }

   private void cleanup() {
      this.completionAction = null;
      this.cancelAction = null;
      this.recordOutputStream = null;
      instance = null;
      System.gc();
   }

   public final void stopPlayer() {
      this.videoControl = null;
      if (this.cameraPlayer != null) {
         try {
            this.cameraPlayer.stop();
         } catch (MediaException var2) {
            this.errorMessage = var2.toString();
         }

         this.cameraPlayer.deallocate();
      }

      this.cameraPlayer = null;
      System.gc();
   }

   static void cleanup(CameraCanvas var0) {
      var0.cleanup();
   }
}
