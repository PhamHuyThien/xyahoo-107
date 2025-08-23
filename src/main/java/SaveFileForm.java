import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public final class SaveFileForm extends Form implements CommandListener {
   private ChoiceGroup formatChoiceGroup;
   private TextField fileNameField;
   public static SaveFileForm instance;
   private Command previewCommand;
   private Command sendCommand;
   private Command saveCommand;
   private Command backCommand;
   private String fullFileName;
   public byte[] fileData;

   public static final SaveFileForm getInstance() {
      if (instance == null) {
         instance = new SaveFileForm();
      }

      return instance;
   }

   public SaveFileForm() {
      super("Lưu file");
      FileBrowserList.getInstance();
      String[] var1 = FileBrowserList.getSupportedVideoTypes();
      this.formatChoiceGroup = new ChoiceGroup("Chọn định dạng của tập tin", 1, var1, null);
      this.fileNameField = new TextField("Tên file", "", 1024, 0);
      this.append(this.fileNameField);
      this.append(this.formatChoiceGroup);
      this.previewCommand = new Command("Xem lại", 1, 1);
      this.sendCommand = new Command("Gửi", 1, 1);
      this.saveCommand = new Command("Lưu", 4, 0);
      this.backCommand = new Command(TextConstant.close(), 3, 0);
      this.addCommand(this.previewCommand);
      this.addCommand(this.sendCommand);
      this.addCommand(this.saveCommand);
      this.addCommand(this.backCommand);
      this.setCommandListener(this);
      Display.getDisplay(Xuka.instance).setCurrent(this);
   }

   public final void setFileName(String var1) {
      this.fileNameField.setString(var1);
   }

   public final void cleanup() {
      this.formatChoiceGroup = null;
      this.fileNameField = null;
      this.fullFileName = null;
      this.fileData = null;
      instance = null;
      GameManager.instance.completeFileSend();
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals(TextConstant.close())) {
         GameManager.showMainScreen();
         this.cleanup();
      } else {
         String var3 = this.fileNameField.getString().trim();
         String var4 = this.formatChoiceGroup.getString(this.formatChoiceGroup.getSelectedIndex()).toString().trim();
         var4 = FileBrowserList.getInstance().parseFileExtension(var4);
         this.fullFileName = var3 + var4;
         if (var1 == this.saveCommand) {
            TextInputForm.getInstance();
            if (TextInputForm.isValidFilename(this.fileNameField.getString())) {
               GameGraphics.clearKeyStates();
               FileBrowserList var6;
               (var6 = FileBrowserList.getInstance()).setReturnScreen(0);

               try {
                  FileSystemInterface var7 = FileSystemInterface.getInstance();
                  var6.selectedAction = new quyen_hz(this, var6, var7);
                  var6.showBrowser("Chọn thư mục", 2);
               } catch (ClassNotFoundException var5) {
                  GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
               }
            } else {
               GameManager.getInstance();
               GameManager.showAlert("Xubi", "Tên file không hợp lệ", true);
            }
         } else if (var1 == this.sendCommand) {
            if (this.fileData != null) {
               GameManager.instance.a(this.fullFileName, this.fileData, (byte)1);
               GameManager.instance.startFileSend();
            } else {
               showNoVideoAlert();
            }
         } else {
            if (var1 == this.previewCommand) {
               if (this.fileData != null) {
                  GameManager.a(this.fileData, this.fullFileName, false, 0);
                  return;
               }

               showNoVideoAlert();
            }
         }
      }
   }

   private static void showNoVideoAlert() {
      Alert var0 = new Alert("X Yahoo!", "Bạn chưa quay video", null, AlertType.ERROR);
      Display.getDisplay(Xuka.instance).setCurrent(var0);
   }

   static String getFullFileName(SaveFileForm var0) {
      return var0.fullFileName;
   }
}
