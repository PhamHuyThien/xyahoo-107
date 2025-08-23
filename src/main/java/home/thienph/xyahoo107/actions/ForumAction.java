package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

public final class ForumAction implements Action {
    public ForumAction(GameManager var1) {
    }

    public void action() {
        GameGraphics.instance.initializeConnection();
        PacketSender.sendGetForum();
    }
}
