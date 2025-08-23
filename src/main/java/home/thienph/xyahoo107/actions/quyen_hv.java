package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;
import home.thienph.xyahoo107.forms.MediaPlayerForm;
import home.thienph.xyahoo107.forms.TextInputForm;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

import javax.microedition.lcdui.Display;

public final class quyen_hv implements Action {
    final MediaPlayerForm a;

    public quyen_hv(MediaPlayerForm var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().closeDialog();
        FileBrowserList var1;
        (var1 = FileBrowserList.getInstance()).setReturnScreen(1);
        TextInputForm var2 = TextInputForm.getInstance();

        try {
            FileSystemInterface var3 = FileSystemInterface.getInstance();
            var2.setupForm("Tên file", "Tên file", MediaPlayerForm.getFileName(this.a), 0);
            var2.completionAction = new quyen_hw(this, var2, var1, var3);
            Display.getDisplay(Xuka.instance).setCurrent(TextInputForm.instance);
        } catch (ClassNotFoundException var4) {
            GameManager.getInstance();
            GameManager.showAlert("Xubi", "Điện thoại không hỗ trợ chức năng này", true);
        }
    }
}
