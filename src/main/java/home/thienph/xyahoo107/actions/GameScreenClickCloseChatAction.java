package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class GameScreenClickCloseChatAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickCloseChatAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        this.gameScreen.removeComponent(this.gameScreen.chatInputComponent);
        this.gameScreen.isChatMode = false;
        UIUtils.focusComponent(this.gameScreen, GameScreen.getFocusedComponent(this.gameScreen));
        GameScreen.adjustScroll(this.gameScreen);
        this.gameScreen.chatInputComponent.setText("");
    }
}
