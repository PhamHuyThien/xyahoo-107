package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;

final class LoginSendFeedBackConfirmAction implements Action {
    private final LoginSendFeedbackAction loginSendFeedbackAction;

    LoginSendFeedBackConfirmAction(LoginSendFeedbackAction var1) {
        this.loginSendFeedbackAction = var1;
    }

    public void action() {
        LoginSendFeedbackAction var1 = this.loginSendFeedbackAction;
        if (this.loginSendFeedbackAction.loginScreen.feedbackInput.getText() != null) {
            var1 = this.loginSendFeedbackAction;
            if (this.loginSendFeedbackAction.loginScreen.feedbackInput.getText().length() > 0) {
                GameGraphics.instance.initializeConnection();
                var1 = this.loginSendFeedbackAction;
                PacketSender.f(this.loginSendFeedbackAction.loginScreen.feedbackInput.getText());
            }
        }
    }
}
