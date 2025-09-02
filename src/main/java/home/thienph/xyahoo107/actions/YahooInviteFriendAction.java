package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooInviteFriendAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooInviteFriendAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        if (!YahooScreen.checkConnectionReady(this.yahooScreen)) {
            this.yahooScreen.showInviteFriendDialog();
        }
    }
}
