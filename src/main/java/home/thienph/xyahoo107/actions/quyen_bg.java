package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.DownloadScreen;

public final class quyen_bg implements Action {
    private final DownloadScreen a;

    public quyen_bg(DownloadScreen var1) {
        this.a = var1;
    }

    public void action() {
        String var1 = this.a.downloadListComponent.getSelectedItem().c;
        this.a.buddyListManager.removeContact(var1, 0L);
        this.a.downloadListComponent.buildListItems();
    }
}
