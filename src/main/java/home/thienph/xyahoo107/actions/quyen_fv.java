package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fv implements Action {
    final GameManager a;
    private final FileBrowserList b;
    private final FileSystemInterface c;

    public quyen_fv(GameManager var1, FileBrowserList var2, FileSystemInterface var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void action() {
        String var1 = this.b.getSelectedFilePath(true);
        if (FileBrowserList.isValidFile(var1) && this.b.isSupportedFile(var1)) {
            GameManager.showMainScreen();
            int var2;
            if ((var2 = this.c.getFileSize(var1)) < 0) {
                this.a.showWrappedTextDialog("Lỗi đọc file.");
            } else {
                this.a.showFileSizeConfirmDialog(var2, new quyen_fw(this, this.b, var1), new quyen_fx(this));
            }
        } else {
            GameManager.showAlert("Xubi", "Không hỗ trợ file này", true);
        }
    }
}
