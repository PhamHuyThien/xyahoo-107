package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginClickMenuAction implements Action {
    private final LoginScreen loginScreen;

    public LoginClickMenuAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.loginScreen.contextMenu, 0);
    }
}
