package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class RejectInviteRoomAction implements Action {
    private final DialogScreen dialogScreen;

    public RejectInviteRoomAction(GameManager gameManager, DialogScreen dialogScreen) {
        this.dialogScreen = dialogScreen;
    }

    public void action() {
        GameManager.instance.removeScreen(this.dialogScreen);
    }
}
