package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class FriendApproveAddUserGroupAction implements Action {
    private final GameManager gameManager;
    private final long userId;
    private final DialogScreen screen;

    public FriendApproveAddUserGroupAction(GameManager gameManager, long userId, DialogScreen screen) {
        this.gameManager = gameManager;
        this.userId = userId;
        this.screen = screen;
    }

    public void action() {
        PacketSender.requestSendDataUIComponent(this.userId, true);
        this.gameManager.removeScreen(this.screen);
    }
}
