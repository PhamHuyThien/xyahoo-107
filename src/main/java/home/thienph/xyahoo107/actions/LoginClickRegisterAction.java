package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginClickRegisterAction implements Action {
    public LoginClickRegisterAction(LoginScreen var1) {
    }

    public void action() {
        GameManager.instance.showRegisterScreen();
    }
}
