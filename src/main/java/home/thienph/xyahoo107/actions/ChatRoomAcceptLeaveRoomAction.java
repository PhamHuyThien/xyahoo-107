package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;

final class ChatRoomAcceptLeaveRoomAction implements Action {
    private final ChatRoomClickLeaveRoomAction chatRoomClickLeaveRoomAction;

    ChatRoomAcceptLeaveRoomAction(ChatRoomClickLeaveRoomAction var1) {
        this.chatRoomClickLeaveRoomAction = var1;
    }

    public void action() {
        ChatRoomClickLeaveRoomAction var1 = this.chatRoomClickLeaveRoomAction;
        GameManager.instance.destroyScreen(this.chatRoomClickLeaveRoomAction.chatRoomScreen);
        var1 = this.chatRoomClickLeaveRoomAction;
        PacketSender.leaveRoomChat(this.chatRoomClickLeaveRoomAction.chatRoomScreen.roomId);
        GameManager.instance.currentChatRoom = null;
    }
}
