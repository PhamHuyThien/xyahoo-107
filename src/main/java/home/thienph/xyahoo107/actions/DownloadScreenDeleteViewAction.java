package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.DownloadScreen;

public final class DownloadScreenDeleteViewAction implements Action {
    private final DownloadScreen downloadScreen;

    public DownloadScreenDeleteViewAction(DownloadScreen var1) {
        this.downloadScreen = var1;
    }

    public void action() {
        String var1 = this.downloadScreen.downloadListComponent.getSelectedItem().groupName;
        this.downloadScreen.buddyGroupList.removeContact(var1, 0L);
        this.downloadScreen.downloadListComponent.buildListItems();
    }
}
