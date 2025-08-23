package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;

final class quyen_em implements Action {
    private final LoginSendFeedbackAction a;

    quyen_em(LoginSendFeedbackAction var1) {
        this.a = var1;
    }

    public void action() {
        LoginSendFeedbackAction var1 = this.a;
        if (this.a.loginScreen.feedbackInput.getText() != null) {
            var1 = this.a;
            if (this.a.loginScreen.feedbackInput.getText().length() > 0) {
                GameGraphics.instance.initializeConnection();
                var1 = this.a;
                PacketSender.f(this.a.loginScreen.feedbackInput.getText());
            }
        }
    }
}
