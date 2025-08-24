package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dx implements Action {
    private final GameScreen a;
    private final int b;

    public quyen_dx(GameScreen var1, int var2) {
        this.a = var1;
        this.b = var2;
    }

    public void action() {
        PacketSender.requestReloadData(GameScreen.currentRoomId, FriendScreen.currentUserId, this.a.playerComponents[this.b].playerName);
    }
}
