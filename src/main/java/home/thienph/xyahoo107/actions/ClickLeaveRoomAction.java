package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ClickLeaveRoomAction implements Action {
    private final GameManager gameManager;
    private final String roomName;
    private final String roomId;
    private final long accountId;

    public ClickLeaveRoomAction(GameManager gameManager, String roomName, String roomId, long accountId) {
        this.gameManager = gameManager;
        this.roomName = roomName;
        this.roomId = roomId;
        this.accountId = accountId;
    }

    public void action() {
        ChatRoomScreen chatRoomScreen = (ChatRoomScreen) this.gameManager.setActiveScreen(this.gameManager.currentChatRoom);
        if (chatRoomScreen != null) {
            PacketSender.leaveRoomChat(chatRoomScreen.roomId);
            this.gameManager.removeScreen(chatRoomScreen);
            this.gameManager.joinChatRoom(this.roomName, this.roomId, this.accountId);
        }
    }
}
