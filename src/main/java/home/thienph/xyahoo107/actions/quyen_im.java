package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_im implements Action {
    private final FriendScreen a;

    public quyen_im(FriendScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.showStatusDialog();
    }
}
