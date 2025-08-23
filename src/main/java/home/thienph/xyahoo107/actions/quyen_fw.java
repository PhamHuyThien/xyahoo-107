package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.forms.FileBrowserList;
import home.thienph.xyahoo107.managers.GameManager;

final class quyen_fw implements Action {
    private final quyen_fv a;
    private final FileBrowserList b;
    private final String c;

    quyen_fw(quyen_fv var1, FileBrowserList var2, String var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void action() {
        quyen_fv var1 = this.a;
        GameManager.setUploadType(this.a.a, (byte) -1);
        if (this.b.isPngFile(this.c)) {
            var1 = this.a;
            GameManager.setUploadType(this.a.a, (byte) 0);
        } else if (this.b.isSupportedVideoFile(this.c)) {
            var1 = this.a;
            GameManager.setUploadType(this.a.a, (byte) 1);
        }

        var1 = this.a;
        if (GameManager.getUploadType(this.a.a) != -1) {
            var1 = this.a;
            this.a.a.startFileOperation(true);
        } else {
            var1 = this.a;
            this.a.a.showWrappedTextDialog("Điện thoại không hổ trợ xem file này");
        }
    }
}
