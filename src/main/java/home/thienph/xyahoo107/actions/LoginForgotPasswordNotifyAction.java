package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

final class LoginForgotPasswordNotifyAction implements Action {
    LoginForgotPasswordNotifyAction(LoginHandlerForgotPasswordAction var1) {
    }

    public void action() {
        GameManager.instance.showWrappedTextDialog("Bạn sẽ nhận mật khẩu qua tin nhắn.");
    }
}
