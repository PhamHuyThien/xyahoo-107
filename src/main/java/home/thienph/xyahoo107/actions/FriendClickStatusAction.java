package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendClickStatusAction implements Action {
    private final FriendScreen friendScreen;

    public FriendClickStatusAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        this.friendScreen.showStatusDialog();
    }
}
