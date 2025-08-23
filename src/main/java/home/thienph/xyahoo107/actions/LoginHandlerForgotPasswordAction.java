package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginHandlerForgotPasswordAction implements Action {
    private final LoginScreen loginScreen;

    public LoginHandlerForgotPasswordAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        Xuka.sendRequest(GameManager.smsContent + this.loginScreen.usernameInput.getText(), GameManager.instance.getSmsNumber(), new LoginForgotPasswordNotifyAction(this), null, true);
    }
}
