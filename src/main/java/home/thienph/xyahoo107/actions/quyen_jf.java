package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jf implements Action {
    private final YahooScreen a;

    public quyen_jf(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
    }
}
