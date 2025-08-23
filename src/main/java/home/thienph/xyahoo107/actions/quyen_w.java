package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_w implements Action {
    private final ChatRoomScreen a;

    public quyen_w(ChatRoomScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(ChatRoomScreen.getContextMenu(this.a), 0);
    }
}
