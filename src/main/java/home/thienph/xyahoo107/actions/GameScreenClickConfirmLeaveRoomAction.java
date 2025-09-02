package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickConfirmLeaveRoomAction implements Action {
    final GameScreen gameScreen;

    public GameScreenClickConfirmLeaveRoomAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        GameManager.instance.showConfirmDialog("Bạn có muốn rời bàn?", new GameScreenConfirmOutRoomAction(this));
    }
}
