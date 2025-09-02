package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

final class quyen_fa implements Action {
    private final MainFeedbackAction a;

    quyen_fa(MainFeedbackAction var1) {
        this.a = var1;
    }

    public void action() {
        MainFeedbackAction var1 = this.a;
        if (GameManager.getInputHandler(this.a.gameManager).getText() != null) {
            var1 = this.a;
            if (GameManager.getInputHandler(this.a.gameManager).getText().length() > 0) {
                var1 = this.a;
                PacketSender.f(GameManager.getInputHandler(this.a.gameManager).getText());
            }
        }
    }
}
