package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jk implements Action {
    private final YahooScreen a;

    public quyen_jk(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().removeScreen(YahooScreen.getStatusScreen(this.a));
    }
}
