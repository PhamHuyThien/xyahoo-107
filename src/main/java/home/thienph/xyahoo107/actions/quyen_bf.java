package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DownloadScreen;
import home.thienph.xyahoo107.screens.PhotoViewerScreen;

public final class quyen_bf implements Action {
    private final DownloadScreen a;

    public quyen_bf(DownloadScreen var1) {
        this.a = var1;
    }

    public void action() {
        BuddyInfo var1;
        if ((var1 = this.a.downloadListComponent.getSelectedItem().contactRef).mediaType == 0) {
            GameManager.instance.showPhotoViewer(var1.mediaData, var1.mediaExtension, true, new PhotoViewerScreen());
        } else {
            GameManager.playMediaFile(var1.mediaData, var1.mediaExtension, true, 2);
        }
    }
}
