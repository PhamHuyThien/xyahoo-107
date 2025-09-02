package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class GameScreenClickCloseBetAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickCloseBetAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        this.gameScreen.removeComponent(GameScreen.getBetInputComponent(this.gameScreen));
        this.gameScreen.isBettingMode = false;
        UIUtils.focusComponent(this.gameScreen, GameScreen.getFocusedComponent(this.gameScreen));
        GameScreen.adjustScroll(this.gameScreen);
        GameScreen.getBetInputComponent(this.gameScreen).setText("");
    }
}
