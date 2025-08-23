package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_in implements Action {
    private final FriendScreen a;

    public quyen_in(FriendScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.instance.addScreenToStack(this.a.offlineMessageScreen);
        this.a.offlineMessageScreen.startSlideAnimation(1);
        GameManager.instance.switchToScreen(this.a.offlineMessageScreen);
    }
}
