package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class FriendClickAddContactAction implements Action {
    final FriendScreen friendScreen;

    public FriendClickAddContactAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        if (this.friendScreen.isSearchMode) {
            FriendScreen.getSearchInput(this.friendScreen).setText("");
            this.friendScreen.friendsComponent.setSearchFilter("");
            FriendScreen.exitSearchMode(this.friendScreen);
        }

        if (FriendScreen.getActiveTextInput(this.friendScreen) == null) {
            FriendScreen.setActiveTextInput(this.friendScreen, ButtonAction.createPopupDialog(this.friendScreen, "Vui lòng nhập Xubi ID", 0, null));
        }

        if (FriendScreen.getPrimaryAction(this.friendScreen) == null) {
            FriendScreen.setPrimaryAction(this.friendScreen, new quyen_iv(this));
        }

        FriendScreen.getActiveTextInput(this.friendScreen).alternateAction = FriendScreen.getPrimaryAction(this.friendScreen);
        this.friendScreen.addComponent(FriendScreen.getActiveTextInput(this.friendScreen));
        UIUtils.showTextInput(this.friendScreen, FriendScreen.getActiveTextInput(this.friendScreen));
    }
}
