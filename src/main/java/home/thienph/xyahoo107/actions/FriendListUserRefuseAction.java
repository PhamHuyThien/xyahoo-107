package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class FriendListUserRefuseAction implements Action {
    private final FriendScreen friendScreen;

    public FriendListUserRefuseAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        this.friendScreen.removeAllComponents();
        this.friendScreen.secondaryContactList = null;
        System.gc();
        this.friendScreen.secondaryContactList = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
        this.friendScreen.secondaryContactList.isChatMode = false;
        this.friendScreen.secondaryContactList.isLoading = true;
        FriendScreen.toggleOfflineFilter(this.friendScreen.secondaryContactList);
        UIUtils.focusComponent(this.friendScreen, this.friendScreen.secondaryContactList);
        UIUtils.setScreenSubtitleText(FriendScreen.instance, "ID Từ Chối");
        FriendScreen.currentViewMode = 2;
        this.friendScreen.rightSoftkey = FriendScreen.getBackButton(this.friendScreen);
        if (this.friendScreen.blockedUsers.size() > 0) {
            this.friendScreen.sendBulkRequest(this.friendScreen.blockedUsers);
        } else {
            this.friendScreen.secondaryContactList.isLoading = false;
        }
    }
}
