package home.thienph.xyahoo107.actions;

import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginClickAction implements Action {
    private final LoginScreen loginScreen;

    public LoginClickAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        this.loginScreen.performLogin();
    }
}
