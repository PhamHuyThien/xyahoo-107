package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_is implements Action {
    private final ContextMenu a;

    public quyen_is(FriendScreen var1, ContextMenu var2) {
        this.a = var2;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.a, 0);
    }
}
