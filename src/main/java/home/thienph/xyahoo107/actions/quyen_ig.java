package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ig implements Action {
    private final FriendScreen a;

    public quyen_ig(FriendScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().removeScreen(FriendScreen.getStatusDialog(this.a));
    }
}
