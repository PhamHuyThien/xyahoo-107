package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooAddFriendAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooAddFriendAction(YahooScreen yahooScreen2) {
        this.yahooScreen = yahooScreen2;
    }

    public void action() {
        if (YahooScreen.checkConnectionReady(this.yahooScreen)) {
            return;
        }
        this.yahooScreen.showAddFriendDialog((String) null);
    }
}
