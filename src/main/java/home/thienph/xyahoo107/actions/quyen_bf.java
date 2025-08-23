package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.media.BuddyContact;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DownloadScreen;
import home.thienph.xyahoo107.screens.PhotoViewerScreen;

public final class quyen_bf implements Action {
    private final DownloadScreen a;

    public quyen_bf(DownloadScreen var1) {
        this.a = var1;
    }

    public void action() {
        BuddyContact var1;
        if ((var1 = this.a.downloadListComponent.getSelectedItem().i).downloadType == 0) {
            GameManager.instance.showPhotoViewer(var1.imageBytes, var1.fileName, true, new PhotoViewerScreen());
        } else {
            GameManager.playMediaFile(var1.imageBytes, var1.fileName, true, 2);
        }
    }
}
