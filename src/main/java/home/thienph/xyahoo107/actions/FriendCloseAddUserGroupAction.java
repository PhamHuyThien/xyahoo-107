package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class FriendCloseAddUserGroupAction implements Action {
    private final GameManager gameManager;
    private final boolean isYahoo;
    private final long userId;
    private final DialogScreen screen;

    public FriendCloseAddUserGroupAction(GameManager var1, boolean var2, long var3, DialogScreen var5) {
        this.gameManager = var1;
        this.isYahoo = var2;
        this.userId = var3;
        this.screen = var5;
    }

    public void action() {
        if (!this.isYahoo) {
            this.gameManager.friendScreen.addToPendingList(this.userId);
        }

        this.gameManager.removeScreen(this.screen);
    }
}
