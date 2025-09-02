package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooClickCloseAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooClickCloseAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        GameManager.getInstance().removeScreen(this.yahooScreen);
    }
}
