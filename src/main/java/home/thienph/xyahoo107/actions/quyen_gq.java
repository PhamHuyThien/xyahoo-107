package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.PhotoViewerScreen;

public final class quyen_gq implements Action {
    private final PhotoViewerScreen a;

    public quyen_gq(PhotoViewerScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.instance.setUploadData(this.a.title, this.a.imageBytes, (byte) 0);
        GameManager.instance.startFileSend();
    }
}
