package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickBetSendAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickBetSendAction(GameScreen var1) {
        this.gameScreen = var1;
    }

    public void action() {
        GameScreen.getBetInputComponent(this.gameScreen).rightSoftKey = GameScreen.getBetSendButton(this.gameScreen);
    }
}
