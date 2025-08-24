package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomViewUserInRoomAction implements Action {
    private final ChatRoomScreen chatRoomScreen;

    public ChatRoomViewUserInRoomAction(ChatRoomScreen var1) {
        this.chatRoomScreen = var1;
    }

    public void action() {
        PacketSender.b(this.chatRoomScreen.roomId, 4811);
    }
}
