package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class GameManagerClickMenuAction implements Action {
    private final GameManager gameManager;

    public GameManagerClickMenuAction(GameManager var1) {
        this.gameManager = var1;
    }

    public void action() {
        this.gameManager.showContextMenu(GameManager.getMainMenuList(this.gameManager), 0);
    }
}
