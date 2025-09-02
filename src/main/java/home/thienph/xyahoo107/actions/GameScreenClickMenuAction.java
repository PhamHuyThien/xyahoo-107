package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickMenuAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickMenuAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(GameScreen.getGameMenu(this.gameScreen), 0);
    }
}
