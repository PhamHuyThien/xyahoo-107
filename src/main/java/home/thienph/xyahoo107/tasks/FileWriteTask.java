package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.forms.FileSystemImpl;
import home.thienph.xyahoo107.main.Xuka;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import java.io.OutputStream;

public final class FileWriteTask implements Runnable {
    private final String filePath;
    private final byte[] fileData;

    public FileWriteTask(FileSystemImpl var1, String var2, byte[] var3) {
        this.filePath = var2;
        this.fileData = var3;
    }

    public void run() {
        try {
            FileConnection var1;
            if ((var1 = (FileConnection) Connector.open(this.filePath, 3)).exists()) {
                var1.delete();
            }

            var1.create();

            try {
                OutputStream var5;
                (var5 = var1.openOutputStream()).write(this.fileData);
                if (var5 != null) {
                    var5.close();
                }
            } catch (Exception var3) {
            }

            var1.close();
        } catch (Exception var4) {
            Alert var2 = new Alert("saveFile", var4.getMessage(), null, AlertType.ERROR);
            Display.getDisplay(Xuka.instance).setCurrent(var2);
            var4.printStackTrace();
        }
    }
}
