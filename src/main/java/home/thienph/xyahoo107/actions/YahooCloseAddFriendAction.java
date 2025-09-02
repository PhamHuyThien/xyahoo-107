package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooCloseAddFriendAction implements Action {
    private final DialogScreen dialogScreen;

    public YahooCloseAddFriendAction(YahooScreen var1, DialogScreen var2) {
        this.dialogScreen = var2;
    }

    public void action() {
        GameManager.instance.removeScreen(this.dialogScreen);
    }
}
