package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_js implements Action {
    private final DialogScreen a;

    public quyen_js(YahooScreen var1, DialogScreen var2) {
        this.a = var2;
    }

    public void action() {
        GameManager.instance.removeScreen(this.a);
    }
}
