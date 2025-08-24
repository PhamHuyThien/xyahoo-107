package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomClickEmojiAction implements Action {
    public ChatRoomClickEmojiAction(ChatRoomScreen var1) {
    }

    public void action() {
        GameManager.instance.showEmojiPicker(0);
    }
}
