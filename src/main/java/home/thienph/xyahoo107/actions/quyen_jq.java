package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jq implements Action {
    private final YahooScreen a;

    public quyen_jq(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.logout();
    }
}
