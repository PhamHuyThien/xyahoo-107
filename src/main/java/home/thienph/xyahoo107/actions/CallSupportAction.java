package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

public final class CallSupportAction implements Action {
    public CallSupportAction(GameManager var1) {
    }

    public void action() {
        GameManager.isConnected = true;
        GameGraphics.instance.initializeConnection();
        PacketSender.sendCallSupport();
    }
}
