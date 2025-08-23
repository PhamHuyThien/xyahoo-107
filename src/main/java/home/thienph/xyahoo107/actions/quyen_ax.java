package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_ax implements Action {
    public void action() {
        GameManager.getInstance().showEmojiPicker(0);
    }
}
