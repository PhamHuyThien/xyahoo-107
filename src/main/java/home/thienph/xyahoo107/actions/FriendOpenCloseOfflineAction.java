package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendOpenCloseOfflineAction implements Action {
    private final FriendScreen friendScreen;

    public FriendOpenCloseOfflineAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        FriendScreen.toggleOfflineFilter(this.friendScreen.mainContactList);
    }
}
