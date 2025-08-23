package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_z implements Action {
    public quyen_z(ChatRoomScreen var1) {
    }

    public void action() {
        GameManager.instance.showEmojiPicker(0);
    }
}
