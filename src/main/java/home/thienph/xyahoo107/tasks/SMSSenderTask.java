package home.thienph.xyahoo107.tasks;

import home.thienph.xyahoo107.actions.Action;
import home.thienph.xyahoo107.managers.GameManager;

import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

public final class SMSSenderTask implements Runnable {
    private final String phoneNumber;
    private final String messageText;
    private final Action successAction;
    private final boolean shouldCloseDialog;
    private final Action errorAction;

    public SMSSenderTask(String var1, String var2, Action var3, boolean var4, Action var5) {
        this.phoneNumber = var1;
        this.messageText = var2;
        this.successAction = var3;
        this.shouldCloseDialog = var4;
        this.errorAction = var5;
    }

    public void run() {
        try {
            MessageConnection var1 = null;
            TextMessage var2;
            (var2 = (TextMessage) (var1 = (MessageConnection) Connector.open(this.phoneNumber)).newMessage("text")).setAddress(this.phoneNumber);
            var2.setPayloadText(this.messageText);
            var1.send(var2);
            if (this.successAction == null) {
                GameManager.instance.closeDialog();
                GameManager.instance.showWrappedTextDialog("Gửi SMS thành công");
            } else {
                this.successAction.action();
            }
        } catch (Exception var3) {
            if (this.shouldCloseDialog) {
                GameManager.instance.closeDialog();
            }

            if (this.errorAction == null) {
                GameManager.instance.showWrappedTextDialog("Lỗi gửi SMS");
            } else {
                this.errorAction.action();
            }
        }
    }
}
