package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class ChatClickCopyAction implements Action {
    private final ChatScreen chatScreen;

    public ChatClickCopyAction(ChatScreen var1) {
        this.chatScreen = var1;
    }

    public void action() {
        String var1;
        if (!(var1 = this.chatScreen.chatComponent.getFullSelectedMessage()).equals("")) {
            GameManager.emptyString = var1;
        }
    }
}
