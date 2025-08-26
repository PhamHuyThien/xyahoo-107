package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class ChatClickMenuAction implements Action {
    private final ChatScreen chatScreen;

    public ChatClickMenuAction(ChatScreen var1) {
        this.chatScreen = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(ChatScreen.getContextMenu(this.chatScreen), 0);
    }
}
