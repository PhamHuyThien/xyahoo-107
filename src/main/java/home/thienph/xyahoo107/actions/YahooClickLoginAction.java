package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooClickLoginAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooClickLoginAction(YahooScreen var1) {
        this.yahooScreen = var1;
    }

    public void action() {
        this.yahooScreen.performLogin();
    }
}
