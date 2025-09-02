package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickChatAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickChatAction(GameScreen var1) {
        this.gameScreen = var1;
    }

    public void action() {
        GameScreen.showChatInput(this.gameScreen);
    }
}
