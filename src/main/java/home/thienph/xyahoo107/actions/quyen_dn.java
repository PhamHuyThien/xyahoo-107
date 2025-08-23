package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_dn implements Action {
    private final GameScreen a;

    public quyen_dn(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.removeComponent(this.a.chatInputComponent);
        this.a.isChatMode = false;
        UIUtils.focusComponent(this.a, GameScreen.getFocusedComponent(this.a));
        if (GameScreen.totalRooms == 0) {
            PacketSender.a(GameScreen.totalRooms, GameScreen.currentRoomId, FriendScreen.currentUserId, this.a.chatInputComponent.getText());
        }

        GameScreen.adjustScroll(this.a);
        this.a.chatInputComponent.setText("");
    }
}
