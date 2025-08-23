package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.CameraCanvas;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_fr implements Action {
    private final GameManager a;

    public quyen_fr(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        byte[] var1;
        if ((var1 = CameraCanvas.getInstance().capturePhoto()) == null) {
            this.a.closeDialog();
            this.a.showWrappedTextDialog("Lỗi camera");
        } else {
            this.a.showPhotoViewer(var1, UIUtils.generateTimestampString(".png"), true, this.a.fileManager);
        }
    }
}
