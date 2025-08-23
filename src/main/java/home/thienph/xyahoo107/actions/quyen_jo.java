package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jo implements Action {
    private final YahooScreen a;

    public quyen_jo(YahooScreen yahooScreen2) {
        this.a = yahooScreen2;
    }

    public void action() {
        if (YahooScreen.checkConnectionReady(this.a)) {
            return;
        }
        this.a.showAddFriendDialog((String) null);
    }
}
