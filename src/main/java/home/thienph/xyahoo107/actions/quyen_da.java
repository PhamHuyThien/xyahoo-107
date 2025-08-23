package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_da implements Action {
    public quyen_da(GameScreen var1) {
    }

    public void action() {
        GameManager.getInstance().showEmojiPicker(0);
    }
}
