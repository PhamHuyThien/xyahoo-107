package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooClickLogoutAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooClickLogoutAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        this.yahooScreen.logout();
    }
}
