package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_ay implements Action {
    private final ContextMenu a;

    public quyen_ay(ContextMenu var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.a, 0);
    }
}
