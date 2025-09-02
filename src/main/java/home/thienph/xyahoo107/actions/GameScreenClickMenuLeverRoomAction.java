package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickMenuLeverRoomAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickMenuLeverRoomAction(GameScreen var1) {
        this.gameScreen = var1;
    }

    public void action() {
        GameManager.getInstance().showContextMenu(GameScreen.getGameMenu(this.gameScreen), 0);
    }
}
