package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.GameRoomGridComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_cy implements Action {
    private final GameRoomGridComponent a;

    public quyen_cy(GameRoomGridComponent var1) {
        this.a = var1;
    }

    public void action() {
        String var1 = GameRoomGridComponent.getRoomData(this.a)[GameRoomGridComponent.getSelectedIndex(this.a)].roomId;
        if (GameRoomGridComponent.getRoomType(this.a) == 0) {
            PacketSender.c(var1, FriendScreen.currentUserId);
        }
    }
}
