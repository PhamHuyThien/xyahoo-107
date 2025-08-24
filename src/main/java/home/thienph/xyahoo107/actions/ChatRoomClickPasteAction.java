package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomClickPasteAction implements Action {
    private final ChatRoomScreen chatRoomScreen;

    public ChatRoomClickPasteAction(ChatRoomScreen var1) {
        this.chatRoomScreen = var1;
    }

    public void action() {
        if (!GameManager.emptyString.equals("")) {
            this.chatRoomScreen.textInputComponent.insertText(GameManager.emptyString);
        }
    }
}
