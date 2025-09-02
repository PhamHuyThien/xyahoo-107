package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameCenterClickCenterSoftkeyAction implements Action {
    private final GameScreen gameScreen;

    public GameCenterClickCenterSoftkeyAction(GameScreen var1) {
        this.gameScreen = var1;
    }

    public void action() {
        if (this.gameScreen.centerSoftkey.text.equals("Chơi ngay!")) {
            PacketSender.e(GameScreen.currentRoomId, FriendScreen.username);
        } else {
            if (this.gameScreen.centerSoftkey.text.equals("Sẵn sàng")) {
                int var1 = this.gameScreen.playerComponents.length;

                while (--var1 >= 0) {
                    if (this.gameScreen.playerComponents[var1].playerName.equals(FriendScreen.username)) {
                        this.gameScreen.centerSoftkey.text = "";
                        PacketSender.d(GameScreen.currentRoomId, FriendScreen.username);
                    }
                }
            }
        }
    }
}
