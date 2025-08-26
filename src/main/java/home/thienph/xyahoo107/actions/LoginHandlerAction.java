package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginHandlerAction implements Action {
    private final LoginScreen loginScreen;

    public LoginHandlerAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    /*
     * Ý nghĩa: Xử lý action đăng nhập từ UI
     * Thu thập thông tin từ form, xử lý đặc biệt cho Yahoo account,
     * lưu thông tin người dùng và gửi request đăng nhập
     */
    public void action() {
        System.gc();
        this.loginScreen.usernameInput.setText(this.loginScreen.usernameInput.getText().toLowerCase());
        FriendScreen.username = this.loginScreen.usernameInput.getText();
        FriendScreen.userStatus = this.loginScreen.invisibleLoginCheckbox.isChecked ? 0 : 1;
        GameManager.loginType = (byte) this.loginScreen.accountTypeDropdown.getSelectedIndex();

        // Xử lý đặc biệt cho Yahoo account
        if (GameManager.loginType == 1) {
            String usernameText = this.loginScreen.usernameInput.getText();
            if (usernameText.indexOf("@") == -1) {
                FriendScreen.username = FriendScreen.username + "@yahoo.com";
            }

            String yahooUsername = usernameText;
            byte yahooDomainType = 0;

            if (usernameText.indexOf("@ymail") >= 0) {
                yahooDomainType = 1;
                yahooUsername = usernameText.substring(0, usernameText.indexOf("@ymail"));
            } else if (usernameText.indexOf("@rocketmail") >= 0) {
                yahooDomainType = 2;
                yahooUsername = usernameText.substring(0, usernameText.indexOf("@rocketmail"));
            } else if (usernameText.indexOf("@yahoo") >= 0) {
                yahooUsername = usernameText.substring(0, usernameText.indexOf("@yahoo"));
            }

            // Lưu thông tin Yahoo
            Xuka.saveYahooID(yahooUsername);
            Xuka.saveYahooPassword(this.loginScreen.passwordInput.getText());
            Xuka.saveBooleanSetting("statusYahoo", this.loginScreen.invisibleLoginCheckbox.isChecked);
            Xuka.saveYahooDomain(yahooDomainType);

            // Cập nhật Yahoo chat UI nếu có
            if (GameManager.instance.yahooChat != null) {
                GameManager.instance.yahooChat.usernameInput.setText(yahooUsername);
                GameManager.instance.yahooChat.passwordInput.setText(this.loginScreen.passwordInput.getText());
                GameManager.instance.yahooChat.invisibleCheckbox.isChecked = this.loginScreen.invisibleLoginCheckbox.isChecked;
                GameManager.instance.yahooChat.domainDropdown.setSelectedIndex(yahooDomainType);
            }
        }

        // Lưu thông tin đăng nhập chung
        Xuka.saveUserID(this.loginScreen.usernameInput.getText());
        Xuka.savePassword(this.loginScreen.passwordInput.getText());
        Xuka.saveIDType(this.loginScreen.accountTypeDropdown.getSelectedIndex());
        Xuka.saveBooleanSetting("status", this.loginScreen.invisibleLoginCheckbox.isChecked);

        FriendScreen.currentUserName = FriendScreen.username;
        GameManager.getInstance().initializeFriendManager();

        // Tải danh sách bạn bè từ cache
        int contactListVersion = GameManager.loadContactStatus(false);
        if (contactListVersion != -1) {
            BuddyGroupList buddyGroupList = GameManager.loadBuddyList(false, FriendScreen.username);
            if (buddyGroupList != null) {
                GameManager.instance.friendScreen.friendsComponent.setContactData(buddyGroupList, -1);
                GameManager.instance.friendScreen.friendsComponent.isLoading = false;
                GameManager.instance.friendScreen.addAllFriendsToOnline();
                FriendScreen.currentUserAccountId = GameManager.getUserId(FriendScreen.username);
            } else {
                contactListVersion = -1;
            }
        }

        // Tải status message
        String savedStatusMessage = Xuka.loadStringData(FriendScreen.username, false);
        FriendScreen.statusMessage = savedStatusMessage == null ? "" : savedStatusMessage;
        if (savedStatusMessage != null && savedStatusMessage.length() > 0) {
            FriendScreen.updateStatusMessage(FriendScreen.statusMessage);
        }

        System.gc();
        GameGraphics.instance.initializeConnection();

        // Gửi login request
        PacketSender.sendLogin(FriendScreen.username,
                this.loginScreen.passwordInput.getText(),
                FriendScreen.userStatus,
                1,
                contactListVersion,
                GameManager.loginType,
                FriendScreen.statusMessage);
    }
}
