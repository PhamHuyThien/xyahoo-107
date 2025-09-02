package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickPlayOnAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickPlayOnAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        this.gameScreen.a(false, false);
        if (!this.gameScreen.gameFinished) {
            this.gameScreen.prepareFinalResults();
        }

        this.gameScreen.initializeGameRoom((byte) this.gameScreen.finalPlayerCount, this.gameScreen.finalPlayerNames2, this.gameScreen.finalPlayerMoney, this.gameScreen.playerAvatarIds);
    }
}
