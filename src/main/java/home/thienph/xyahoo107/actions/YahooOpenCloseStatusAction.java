package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class YahooOpenCloseStatusAction implements Action {
    private final YahooScreen yahooScreen;

    public YahooOpenCloseStatusAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        FriendScreen.toggleOfflineFilter(this.yahooScreen.contactList);
    }
}
