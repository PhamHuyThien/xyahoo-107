package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomClickCopyAction implements Action {
    private final ChatRoomScreen a;

    public ChatRoomClickCopyAction(ChatRoomScreen var1) {
        this.a = var1;
    }

    public void action() {
        String var1;
        if (!(var1 = this.a.chatComponent.getFullSelectedMessage()).equals("")) {
            GameManager.emptyString = var1;
        }
    }
}
