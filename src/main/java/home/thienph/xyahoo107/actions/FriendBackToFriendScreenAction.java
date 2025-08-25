package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendBackToFriendScreenAction implements Action {
    private final FriendScreen friendScreen;

    public FriendBackToFriendScreenAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        FriendScreen.switchToMainViewAndSetRightSoftkey(this.friendScreen);
    }
}
