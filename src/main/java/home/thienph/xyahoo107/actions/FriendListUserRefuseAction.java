package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;
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
        this.friendScreen.friendsRequestComponent = null;
        System.gc();
        this.friendScreen.friendsRequestComponent = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
        this.friendScreen.friendsRequestComponent.isChatMode = false;
        this.friendScreen.friendsRequestComponent.isLoading = true;
        FriendScreen.toggleOfflineFilter(this.friendScreen.friendsRequestComponent);
        UIUtils.focusComponent(this.friendScreen, this.friendScreen.friendsRequestComponent);
        UIUtils.setScreenSubtitleText(FriendScreen.instance, "ID Từ Chối");
        this.friendScreen.addComponent(this.friendScreen.friendsRequestComponent);
        FriendScreen.currentViewMode = 2;
        this.friendScreen.rightSoftkey = FriendScreen.getBackButton(this.friendScreen);
        if (this.friendScreen.blockedUsers.size() > 0) {
            this.friendScreen.sendBulkRequest(this.friendScreen.blockedUsers);
        } else {
            this.friendScreen.friendsRequestComponent.isLoading = false;
        }
        PacketSender.requestGetListContactByType(2);
    }
}
