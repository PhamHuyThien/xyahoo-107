package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class GameManagerClickManagerAction implements Action {
    private final GameManager gameManager;

    public GameManagerClickManagerAction(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void action() {
        this.gameManager.showContextMenu(GameManager.getGameMenuList(this.gameManager), 2);
    }
}
