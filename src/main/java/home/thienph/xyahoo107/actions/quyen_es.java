package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_es implements Action {
    private final LoginScreen a;

    public quyen_es(LoginScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
    }
}
