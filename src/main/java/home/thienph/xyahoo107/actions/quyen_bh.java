package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.DownloadScreen;

public final class quyen_bh implements Action {
    private final DownloadScreen a;

    public quyen_bh(DownloadScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.deleteAllDownloads();
    }
}
