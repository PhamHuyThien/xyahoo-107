package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooClickMenuAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooClickMenuAction(YahooScreen var1) {
        this.yahooScreen = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.yahooScreen.contextMenu, 0);
    }
}
