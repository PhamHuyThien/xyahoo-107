package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.managers.GameManager;

public final class ConfigSoftKeyOpenMenuAction implements Action {
    private final ContextMenu contextMenu;

    public ConfigSoftKeyOpenMenuAction(ContextMenu contextMenu) {
        this.contextMenu = contextMenu;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(this.contextMenu, 0);
    }
}
