package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendSendToGroupAction implements Action {
    private final FriendScreen friendScreen;

    public FriendSendToGroupAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        this.friendScreen.showGroupMessageDialog();
    }
}
