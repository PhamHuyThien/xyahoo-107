package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickKickPlayerAction implements Action {
    private final GameScreen gameScreen;
    private final int b;

    public GameScreenClickKickPlayerAction(GameScreen var1, int var2) {
        this.gameScreen = var1;
        this.b = var2;
    }

    public void action() {
        PacketSender.requestSendDataUIComponent(GameScreen.currentRoomId, FriendScreen.username, this.gameScreen.playerComponents[this.b].playerName);
    }
}
