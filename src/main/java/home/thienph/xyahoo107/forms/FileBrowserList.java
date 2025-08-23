package home.thienph.xyahoo107.forms;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.tasks.ActionExecutor;
import home.thienph.xyahoo107.tasks.FileBrowserInitializer;
import home.thienph.xyahoo107.tasks.FileListRefresher;
import home.thienph.xyahoo107.tasks.PathNavigator;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.media.Manager;
import java.util.Vector;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.List;

public final class FileBrowserList extends List implements CommandListener
{
   public static FileBrowserList instance;
   public static boolean isLoading;
   private int browserMode;
   private static String currentPath;
   public Action selectedAction;
   private Command sendCommand;
   private Command backCommand;
   private Command openCommand;
   private Command shareCommand;
   private Command saveCommand;
   private String[] imageExtensions;
   private String[] videoExtensions;
   private int returnScreen;

   public static FileBrowserList getInstance() {
      if (FileBrowserList.instance == null) {
         FileBrowserList.instance = new FileBrowserList();
      }
      return FileBrowserList.instance;
   }

   public final void showBrowser(final String title, final int d) {
      if (FileBrowserList.isLoading) {
         GameManager.getInstance().showWrappedTextDialog("Vui lòng chờ");
         return;
      }
      this.removeCommand(this.sendCommand);
      this.removeCommand(this.backCommand);
      this.removeCommand(this.openCommand);
      this.removeCommand(this.shareCommand);
      this.removeCommand(this.saveCommand);
      ((Displayable)this).addCommand(this.openCommand);
      ((Displayable)this).addCommand(this.backCommand);
      if ((this.browserMode = d) == 2) {
         this.setSelectCommand(this.saveCommand);
      }
      else if (d == 0) {
         this.setSelectCommand(this.sendCommand);
      }
      else if (d == 1) {
         this.setSelectCommand(this.shareCommand);
      }
      this.setTitle(title);
      Display.getDisplay((MIDlet) Xuka.instance).setCurrent((Displayable)this);
      new Thread(new FileBrowserInitializer(this)).start();
   }

   protected FileBrowserList() {
      super("", 3);
      this.imageExtensions = new String[] { ".png", ".jpg", ".jpeg", ".gif", ".psd", ".tif", ".bmp" };
      this.videoExtensions = new String[] { ".3g2", ".3gp", ".asf", ".avi", ".flv", ".mov", ".mp4", ".mpg", ".mpeg", ".rm", ".wmv", "swf" };
      FileBrowserList.currentPath = "/";
      this.openCommand = new Command("Mở", 1, 1);
      this.backCommand = new Command(TextConstant.close(), 2, 1);
      this.sendCommand = new Command("Gửi", 4, 1);
      this.shareCommand = new Command("Chia sẻ", 4, 1);
      this.saveCommand = new Command("Lưu", 4, 1);
      ((Displayable)this).setCommandListener((CommandListener)this);
   }

   private void navigateToPath(String s) {
      s = s;
      new Thread(new PathNavigator(this, s)).start();
   }

   private void executeAction(Action Action) {
      if ((Action = Action) != null) {
         new Thread(new ActionExecutor(this, Action)).start();
      }
   }

   public static boolean isValidFile(final String s) {
      return s != null && s.length() != 0 && !s.endsWith("/") && !s.equals("..");
   }

   // Lấy loại file (0=image, 1=video, -1=other)
   public final byte getFileType(String lowerCase) {
      lowerCase = lowerCase.toLowerCase();
      for (int i = 0; i < this.imageExtensions.length; ++i) {
         if (lowerCase.endsWith(this.imageExtensions[i])) {
            return 0;
         }
      }
      for (int j = 0; j < this.videoExtensions.length; ++j) {
         if (lowerCase.endsWith(this.videoExtensions[j])) {
            return 1;
         }
      }
      return -1;
   }

   public final boolean isSupportedFile(String lowerCase) {
      lowerCase = lowerCase.toLowerCase();
      return this.isPngFile(lowerCase) || this.isSupportedVideoFile(lowerCase) || hasExtension(lowerCase, this.imageExtensions) || hasExtension(lowerCase, this.videoExtensions);
   }

   private static boolean hasExtension(String lowerCase, final String[] array) {
      lowerCase = lowerCase.toLowerCase();
      for (int i = 0; i < array.length; ++i) {
         if (lowerCase.endsWith(array[i])) {
            return true;
         }
      }
      return false;
   }

   public final boolean isPngFile(final String s) {
      return hasExtension(s, new String[] { ".png" });
   }

   public final boolean isSupportedVideoFile(final String s) {
      final String[] d;
      int length = (d = getSupportedVideoTypes()).length;
      while (--length >= 0) {
         d[length] = this.parseFileExtension(d[length]);
      }
      System.gc();
      return hasExtension(s, d);
   }

   public final void setReturnScreen(final int m) {
      this.returnScreen = m;
   }

   public final void commandAction(final Command command, final Displayable displayable) {
      if (!command.getLabel().equals(TextConstant.close())) {
         if (command.getLabel().equals("Gửi")) {
            try {
               if (this.browserMode != 0) {
                  return;
               }
               final String string;
               if (!(string = this.getString(this.getSelectedIndex())).endsWith("/") && !string.equals("..")) {
                  this.executeAction((Action)null);
                  return;
               }
               this.navigateToPath(string);
               return;
            }
            catch (final Exception ex) {
               return;
            }
         }
         if (command.getLabel().equals("Mở")) {
            try {
               final String string2 = this.getString(this.getSelectedIndex());
               if (this.browserMode == 2) {
                  if (string2.endsWith("/") || string2.equals("..")) {
                     this.navigateToPath(string2);
                  }
                  return;
               }
               else {
                  if (!string2.endsWith("/") && !string2.equals("..")) {
                     this.executeAction(this.selectedAction);
                     return;
                  }
                  this.navigateToPath(string2);
                  return;
               }
            }
            catch (final Exception ex2) {
               return;
            }
         }
         if (command.getLabel().equals("Lưu")) {
            if (this.browserMode == 2) {
               this.executeAction(this.selectedAction);
            }
         }
         else if (command.getLabel().equals("Chia sẻ") && this.browserMode == 1) {
            this.executeAction((Action)null);
         }
         return;
      }
      if (this.returnScreen == 0) {
         Display.getDisplay((MIDlet) Xuka.instance).setCurrent((Displayable) SaveFileForm.getInstance());
         return;
      }
      if (this.returnScreen == 1) {
         MediaPlayerForm.getInstance().setReturnMode(2);
         Display.getDisplay((MIDlet) Xuka.instance).setCurrent((Displayable) MediaPlayerForm.getInstance());
         return;
      }
      GameManager.getInstance();
      GameManager.showMainScreen();
   }

   public final String getSelectedFilePath(final boolean b) {
      final String string;
      if ((string = this.getString(this.getSelectedIndex())).endsWith("/") || string.equals("..")) {
         return null;
      }
      if (b) {
         return UIUtils.concatStrings("file:///", FileBrowserList.currentPath, string, null);
      }
      return string;
   }

   public static String getCurrentPathUrl() {
      return UIUtils.concatStrings("file:///", FileBrowserList.currentPath, null, null);
   }

   public final void refreshFileList() {
      new Thread(new FileListRefresher(this)).start();
   }

   public final String parseFileExtension(String obj) {
      final String s = obj;
      final String s2 = "/";
      obj = s;
      final Vector vector = new Vector();
      final String s3 = s2;
      for (int i = obj.indexOf(s3); i >= 0; i = (obj = obj.substring(i + s3.length())).indexOf(s3)) {
         vector.addElement(obj.substring(0, i));
      }
      vector.addElement(obj);
      final String[] array = new String[vector.size()];
      if (vector.size() > 0) {
         for (int j = 0; j < vector.size(); ++j) {
            array[j] = (String)vector.elementAt(j);
         }
      }
      if ((obj = array[1]).toLowerCase().equals("mpeg")) {
         obj = ".mpg";
      }
      else if (obj.toLowerCase().equals("3gpp")) {
         obj = ".3gp";
      }
      else if (obj.toLowerCase().equals("3gpp2")) {
         obj = ".3g2";
      }
      else if (obj.toLowerCase().equals("mpeg4")) {
         obj = ".mp4";
      }
      else {
         obj = "." + obj.toLowerCase();
      }
      return obj;
   }

   public static String[] getSupportedVideoTypes() {
      final String[] supportedContentTypes;
      final int length;
      final int[] array = new int[length = (supportedContentTypes = Manager.getSupportedContentTypes((String)null)).length];
      int n = 0;
      for (int i = 0; i < length; ++i) {
         if (supportedContentTypes[i].length() != 5 && supportedContentTypes[i].substring(0, 5).toLowerCase().equals("video")) {
            array[n] = i;
            ++n;
         }
      }
      final String[] array2 = new String[n];
      for (int j = 0; j < n; ++j) {
         array2[j] = supportedContentTypes[array[j]];
      }
      return array2;
   }

   public static void setCurrentPath(final String e) {
      FileBrowserList.currentPath = e;
   }

   public static String getCurrentPath() {
      return FileBrowserList.currentPath;
   }
}
