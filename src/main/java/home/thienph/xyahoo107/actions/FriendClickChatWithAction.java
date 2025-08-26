package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class FriendClickChatWithAction implements Action {
    final FriendScreen friendScreen;

    public FriendClickChatWithAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        if (this.friendScreen.isSearchMode) {
            FriendScreen.getSearchInput(this.friendScreen).setText("");
            this.friendScreen.friendsComponent.setSearchFilter("");
            FriendScreen.exitSearchMode(this.friendScreen);
        }

        if (FriendScreen.getActiveTextInput(this.friendScreen) == null) {
            FriendScreen.setActiveTextInput(this.friendScreen, ButtonAction.createTextInputPopup(this.friendScreen, "Vui lòng nhập Xubi ID", 0, null));
        }

        if (FriendScreen.getSecondaryAction(this.friendScreen) == null) {
            FriendScreen.setSecondaryAction(this.friendScreen, new quyen_ix(this));
        }

        FriendScreen.getActiveTextInput(this.friendScreen).alternateAction = FriendScreen.getSecondaryAction(this.friendScreen);
        this.friendScreen.addComponent(FriendScreen.getActiveTextInput(this.friendScreen));
        UIUtils.showTextInputPopup(this.friendScreen, FriendScreen.getActiveTextInput(this.friendScreen));
    }
}
