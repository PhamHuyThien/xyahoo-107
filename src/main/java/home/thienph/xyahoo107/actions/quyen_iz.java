package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_iz implements Action {
    private final FriendScreen a;

    public quyen_iz(FriendScreen var1) {
        this.a = var1;
    }

    public void action() {
        FriendScreen.toggleOfflineFilter(this.a.mainContactList);
    }
}
