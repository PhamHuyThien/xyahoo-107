package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickBetAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickBetAction(GameScreen var1) {
        this.gameScreen = var1;
    }

    public void action() {
        GameScreen.showBetInput(this.gameScreen);
    }
}
