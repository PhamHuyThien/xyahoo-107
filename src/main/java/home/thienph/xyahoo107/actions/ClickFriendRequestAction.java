package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class ClickFriendRequestAction implements Action {
    private final FriendScreen friendScreen;

    public ClickFriendRequestAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        if (GameManager.instance.containsScreenInstance(GameManager.instance.friendScreen)) {
            GameManager.instance.switchToScreen(GameManager.instance.friendScreen);
        } else {
            GameManager.instance.initializeFriendManager();
            GameManager.instance.addScreenToStack(GameManager.instance.friendScreen);
            GameManager.instance.switchToScreen(GameManager.instance.friendScreen);
        }

        this.friendScreen.removeAllComponents();
        this.friendScreen.friendsRequestComponent = null;
        System.gc();
        this.friendScreen.friendsRequestComponent = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
        this.friendScreen.friendsRequestComponent.isChatMode = false;
        this.friendScreen.friendsRequestComponent.isLoading = true;
        FriendScreen.toggleOfflineFilter(this.friendScreen.friendsRequestComponent);
        UIUtils.focusComponent(this.friendScreen, this.friendScreen.friendsRequestComponent);
        UIUtils.setScreenSubtitleText(FriendScreen.instance, "Chờ Kết Bạn");
        friendScreen.addComponent(this.friendScreen.friendsRequestComponent);
        FriendScreen.currentViewMode = 3;
        this.friendScreen.rightSoftkey = FriendScreen.getBackButton(this.friendScreen);
        if (this.friendScreen.pendingRequests.size() > 0) {
            this.friendScreen.sendBulkRequest(this.friendScreen.pendingRequests);
        } else {
            this.friendScreen.friendsRequestComponent.isLoading = false;
        }
        PacketSender.requestGetListContactByType(3);
    }
}
