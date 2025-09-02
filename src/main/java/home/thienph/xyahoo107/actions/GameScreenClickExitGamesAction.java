package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickExitGamesAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickExitGamesAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        this.gameScreen.exitGame(true);
    }
}
