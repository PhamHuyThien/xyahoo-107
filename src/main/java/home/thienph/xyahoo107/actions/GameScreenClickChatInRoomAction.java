package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class GameScreenClickChatInRoomAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickChatInRoomAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        this.gameScreen.removeComponent(this.gameScreen.chatInputComponent);
        this.gameScreen.isChatMode = false;
        UIUtils.focusComponent(this.gameScreen, GameScreen.getFocusedComponent(this.gameScreen));
        if (GameScreen.totalRooms == 0) {
            PacketSender.requestSendDataUIComponent(GameScreen.totalRooms, GameScreen.currentRoomId, FriendScreen.username, this.gameScreen.chatInputComponent.getText());
        }

        GameScreen.adjustScroll(this.gameScreen);
        this.gameScreen.chatInputComponent.setText("");
    }
}
