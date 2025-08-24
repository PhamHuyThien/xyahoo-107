package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendClickMenuAction implements Action {
    private final FriendScreen friendScreen;

    public FriendClickMenuAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.friendScreen.contextMenu, 0);
    }
}
