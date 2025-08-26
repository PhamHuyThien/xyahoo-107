package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendClickCloseAction implements Action {
    private final FriendScreen friendScreen;

    public FriendClickCloseAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        GameManager.getInstance().removeScreen(FriendScreen.getStatusDialog(this.friendScreen));
    }
}
