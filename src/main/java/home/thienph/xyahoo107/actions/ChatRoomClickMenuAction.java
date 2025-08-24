package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomClickMenuAction implements Action {
    private final ChatRoomScreen chatRoomScreen;

    public ChatRoomClickMenuAction(ChatRoomScreen var1) {
        this.chatRoomScreen = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(ChatRoomScreen.getContextMenu(this.chatRoomScreen), 0);
    }
}
