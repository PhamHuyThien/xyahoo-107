package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class FriendMainClickCloseAction implements Action {
    public FriendMainClickCloseAction(FriendScreen var1) {
    }

    public void action() {
        GameManager.instance.removeScreen(FriendScreen.instance);
    }
}
