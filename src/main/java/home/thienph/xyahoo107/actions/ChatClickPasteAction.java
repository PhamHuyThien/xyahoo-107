package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class ChatClickPasteAction implements Action {
    private final ChatScreen chatScreen;

    public ChatClickPasteAction(ChatScreen var1) {
        this.chatScreen = var1;
    }

    public void action() {
        if (!GameManager.emptyString.equals("")) {
            this.chatScreen.textInputComponent.insertText(GameManager.emptyString);
        }
    }
}
