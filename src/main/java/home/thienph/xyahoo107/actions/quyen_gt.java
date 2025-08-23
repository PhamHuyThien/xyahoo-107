package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.forms.FileSystemInterface;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

final class quyen_gt implements Action {
    private final quyen_gs a;
    private final FileBrowserList b;
    private final FileSystemInterface c;

    quyen_gt(quyen_gs var1, FileBrowserList var2, FileSystemInterface var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void action() {
        if (!FileBrowserList.getCurrentPathUrl().equals("/")) {
            GameManager.instance.closeDialog();
            FileSystemInterface var10000 = this.c;
            String var10001 = FileBrowserList.getCurrentPathUrl();
            quyen_gs var1 = this.a;
            quyen_gr var2 = this.a.a;
            var10001 = UIUtils.concatStrings(var10001, this.a.a.a.title, null, null);
            var1 = this.a;
            quyen_gr var4 = this.a.a;
            var10000.writeFile(var10001, this.a.a.a.imageBytes);
            GameManager.showMainScreen();
        }
    }
}
