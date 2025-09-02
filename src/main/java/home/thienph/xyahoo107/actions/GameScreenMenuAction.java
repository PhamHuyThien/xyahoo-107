package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenMenuAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenMenuAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(GameScreen.getLobbyMenu(this.gameScreen), 0);
    }
}
