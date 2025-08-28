package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

final class ChatRoomAcceptLeaveRoomAction implements Action {
    private final ChatRoomClickLeaveRoomAction chatRoomClickLeaveRoomAction;

    ChatRoomAcceptLeaveRoomAction(ChatRoomClickLeaveRoomAction var1) {
        this.chatRoomClickLeaveRoomAction = var1;
    }

    public void action() {
        GameManager.instance.destroyScreen(this.chatRoomClickLeaveRoomAction.chatRoomScreen);
        PacketSender.leaveRoomChat(this.chatRoomClickLeaveRoomAction.chatRoomScreen.roomId);
        GameManager.instance.currentChatRoom = null;
    }
}
