package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jg implements Action {
    private final YahooScreen a;

    public quyen_jg(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.performLogin();
    }
}
