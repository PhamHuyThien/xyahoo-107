package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dd implements Action {
    private final GameScreen a;

    public quyen_dd(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        if (this.a.centerSoftkey.text.equals("Chơi ngay!")) {
            PacketSender.e(GameScreen.currentRoomId, FriendScreen.currentUserId);
        } else {
            if (this.a.centerSoftkey.text.equals("Sẵn sàng")) {
                int var1 = this.a.playerComponents.length;

                while (--var1 >= 0) {
                    if (this.a.playerComponents[var1].playerName.equals(FriendScreen.currentUserId)) {
                        this.a.centerSoftkey.text = "";
                        PacketSender.d(GameScreen.currentRoomId, FriendScreen.currentUserId);
                    }
                }
            }
        }
    }
}
