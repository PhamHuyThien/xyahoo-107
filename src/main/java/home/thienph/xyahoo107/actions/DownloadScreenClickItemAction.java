package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DownloadScreen;

public final class DownloadScreenClickItemAction implements Action {
    private final DownloadScreen downloadScreen;

    public DownloadScreenClickItemAction(DownloadScreen downloadScreen) {
        this.downloadScreen = downloadScreen;
    }

    public void action() {
        GameManager.instance.showContextMenu(this.downloadScreen.contextMenu, 1);
    }
}
