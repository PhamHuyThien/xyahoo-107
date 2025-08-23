package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.PhotoViewerScreen;

public final class quyen_gp implements Action {
    private final PhotoViewerScreen a;

    public quyen_gp(PhotoViewerScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.photoComponent = null;
        this.a.imageBytes = null;
        this.a.displayImage = null;
        PhotoViewerScreen.showSaveButton(this.a, null);
    }
}
