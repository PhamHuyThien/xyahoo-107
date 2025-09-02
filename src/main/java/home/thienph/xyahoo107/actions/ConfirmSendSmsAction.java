package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

public final class ConfirmSendSmsAction implements Action {
    private final String content;
    private final String phoneNumber;

    public ConfirmSendSmsAction(String var1, String var2) {
        this.content = var1;
        this.phoneNumber = var2;
    }

    public void action() {
        GameManager.instance.showWrappedTextDialog("Vui lòng chờ");
        Xuka.sendRequest(this.content, this.phoneNumber, null, null, true);
    }
}
