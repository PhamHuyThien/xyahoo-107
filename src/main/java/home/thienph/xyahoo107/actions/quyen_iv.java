package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.FriendScreen;

final class quyen_iv implements Action {
    private final FriendClickAddContactAction a;

    quyen_iv(FriendClickAddContactAction var1) {
        this.a = var1;
    }

    public void action() {
        if (FriendScreen.getActiveTextInput(this.a.friendScreen).getText() != null) {
            if (FriendScreen.getActiveTextInput(this.a.friendScreen).getText().length() > 0) {
                this.a.friendScreen.sendFriendRequest(FriendScreen.getActiveTextInput(this.a.friendScreen).getText());
            }
        }
    }
}
