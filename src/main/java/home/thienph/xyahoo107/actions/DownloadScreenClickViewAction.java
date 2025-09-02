package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DownloadScreen;
import home.thienph.xyahoo107.screens.PhotoViewerScreen;

public final class DownloadScreenClickViewAction implements Action {
    private final DownloadScreen downloadScreen;

    public DownloadScreenClickViewAction(DownloadScreen downloadScreen) {
        this.downloadScreen = downloadScreen;
    }

    public void action() {
        BuddyInfo var1 = this.downloadScreen.downloadListComponent.getSelectedItem().contactRef;
        if (var1.mediaType == 0) {
            GameManager.instance.showPhotoViewer(var1.mediaData, var1.mediaExtension, true, new PhotoViewerScreen());
        } else {
            GameManager.playMediaFile(var1.mediaData, var1.mediaExtension, true, 2);
        }
    }
}
