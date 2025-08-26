package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.GameRoomGridComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class GameRoomGridClickJoinDeskAction implements Action {
    private final GameRoomGridComponent gameRoomGridComponent;

    public GameRoomGridClickJoinDeskAction(GameRoomGridComponent var1) {
        this.gameRoomGridComponent = var1;
    }

    public void action() {
        String var1 = GameRoomGridComponent.getRoomData(this.gameRoomGridComponent)[GameRoomGridComponent.getSelectedIndex(this.gameRoomGridComponent)].roomId;
        if (GameRoomGridComponent.getRoomType(this.gameRoomGridComponent) == 0) {
            PacketSender.c(var1, FriendScreen.username);
        }
    }
}
