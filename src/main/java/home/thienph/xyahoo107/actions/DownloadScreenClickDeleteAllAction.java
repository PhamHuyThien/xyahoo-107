package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.DownloadScreen;

public final class DownloadScreenClickDeleteAllAction implements Action {
    private final DownloadScreen downloadScreen;

    public DownloadScreenClickDeleteAllAction(DownloadScreen downloadScreen) {
        this.downloadScreen = downloadScreen;
    }

    public void action() {
        this.downloadScreen.deleteAllDownloads();
    }
}
