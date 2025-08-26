package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.screens.LoginScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class LoginSendFeedbackAction implements Action {
    final LoginScreen loginScreen;

    public LoginSendFeedbackAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        if (this.loginScreen.feedbackInput == null) {
            this.loginScreen.feedbackInput = ButtonAction.createTextInputPopup(this.loginScreen, "Gửi góp ý", 0, new quyen_em(this));
        }

        UIUtils.showTextInputPopup(this.loginScreen, this.loginScreen.feedbackInput);
    }
}
