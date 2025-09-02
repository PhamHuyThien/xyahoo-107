package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooStatusAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooStatusAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        if (!YahooScreen.checkConnectionReady(this.yahooScreen)) {
            YahooScreen.showStatusDialog(this.yahooScreen);
        }
    }
}
