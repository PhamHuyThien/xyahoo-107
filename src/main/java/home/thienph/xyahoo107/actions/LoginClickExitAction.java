package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginClickExitAction implements Action {
    public LoginClickExitAction(LoginScreen var1) {
    }

    public void action() {
        Xuka.shutdown();
    }
}
