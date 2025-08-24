package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;

final class ChatRoomAcceptDeleteRoomAction implements Action {
    private final ChatRoomDeleteRoomAction chatRoomDeleteRoomAction;

    ChatRoomAcceptDeleteRoomAction(ChatRoomDeleteRoomAction var1) {
        this.chatRoomDeleteRoomAction = var1;
    }

    public void action() {
        ChatRoomDeleteRoomAction var1 = this.chatRoomDeleteRoomAction;
        PacketSender.b(this.chatRoomDeleteRoomAction.chatRoomScreen.roomId, 4812);
    }
}
