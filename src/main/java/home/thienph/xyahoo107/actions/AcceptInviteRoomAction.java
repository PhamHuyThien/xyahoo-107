package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class AcceptInviteRoomAction implements Action {
    private final String roomKey;
    private final String password;
    private final DialogScreen dialogScreen;

    public AcceptInviteRoomAction(GameManager gameManager, String roomKey, String password, DialogScreen var4) {
        this.roomKey = roomKey;
        this.password = password;
        this.dialogScreen = var4;
    }

    public void action() {
        PacketSender.acceptInviteJoinRoom(this.roomKey, this.password);
        GameManager.instance.removeScreen(this.dialogScreen);
    }
}
