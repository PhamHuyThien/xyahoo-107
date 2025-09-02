package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickEmojiAction implements Action {
    public GameScreenClickEmojiAction(GameScreen var1) {
    }

    public void action() {
        GameManager.getInstance().showEmojiPicker(0);
    }
}
