package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickCloseAction implements Action {
    public GameScreenClickCloseAction(GameScreen var1) {
    }

    public void action() {
        GameManager.instance.removeScreen(GameScreen.instance);
        System.gc();
    }
}
