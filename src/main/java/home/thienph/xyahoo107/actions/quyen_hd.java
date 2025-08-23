package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameLobbyScreen;

public final class quyen_hd implements Action {
    private final GameLobbyScreen a;

    public quyen_hd(GameLobbyScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.a.contextMenu, 0);
    }
}
