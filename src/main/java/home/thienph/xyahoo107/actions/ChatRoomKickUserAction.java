package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomKickUserAction implements Action {
    private final ChatRoomScreen chatRoomScreen;

    public ChatRoomKickUserAction(ChatRoomScreen var1) {
        this.chatRoomScreen = var1;
    }

    public void action() {
        PacketSender.getListUserInRoom(this.chatRoomScreen.roomId, 4805);
    }
}
