package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.ContactSource;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class LoginHandlerAction implements Action {
    private final LoginScreen loginScreen;

    public LoginHandlerAction(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        System.gc();
        this.loginScreen.usernameInput.setText(this.loginScreen.usernameInput.getText().toLowerCase());
        FriendScreen.currentUserId = this.loginScreen.usernameInput.getText();
        FriendScreen.userStatus = this.loginScreen.invisibleLoginCheckbox.isChecked ? 0 : 1;
        GameManager.loginType = (byte) this.loginScreen.accountTypeDropdown.getSelectedIndex();
        if (GameManager.loginType == 1) {
            String usernameInputText = this.loginScreen.usernameInput.getText();
            if (usernameInputText.indexOf("@") == -1) {
                FriendScreen.currentUserId = FriendScreen.currentUserId + "@yahoo.com";
            }
            String var5 = usernameInputText;
            byte var3 = 0;
            if (usernameInputText.indexOf("@ymail") >= 0) {
                var3 = 1;
                var5 = usernameInputText.substring(0, usernameInputText.indexOf("@ymail"));
            } else if (usernameInputText.indexOf("@rocketmail") >= 0) {
                var3 = 2;
                var5 = usernameInputText.substring(0, usernameInputText.indexOf("@rocketmail"));
            } else if (usernameInputText.indexOf("@yahoo") >= 0) {
                var5 = usernameInputText.substring(0, usernameInputText.indexOf("@yahoo"));
            }

            Xuka.saveYahooID(var5);
            Xuka.saveYahooPassword(this.loginScreen.passwordInput.getText());
            Xuka.saveBooleanSetting("statusYahoo", this.loginScreen.invisibleLoginCheckbox.isChecked);
            Xuka.saveYahooDomain(var3);
            if (GameManager.instance.yahooChat != null) {
                GameManager.instance.yahooChat.usernameInput.setText(var5);
                GameManager.instance.yahooChat.passwordInput.setText(this.loginScreen.passwordInput.getText());
                GameManager.instance.yahooChat.invisibleCheckbox.isChecked = this.loginScreen.invisibleLoginCheckbox.isChecked;
                GameManager.instance.yahooChat.domainDropdown.setSelectedIndex(var3);
            }
        }

        Xuka.saveUserID(this.loginScreen.usernameInput.getText());
        Xuka.savePassword(this.loginScreen.passwordInput.getText());
        Xuka.saveIDType(this.loginScreen.accountTypeDropdown.getSelectedIndex());
        Xuka.saveBooleanSetting("status", this.loginScreen.invisibleLoginCheckbox.isChecked);
        FriendScreen.currentUserName = FriendScreen.currentUserId;
        GameManager.getInstance().initializeFriendManager();
        int currentUserId = GameManager.loadContactStatus(false);
        if (currentUserId != -1) {
            ContactSource var6 = GameManager.loadBuddyList(false, FriendScreen.currentUserId);
            if (var6 != null) {
                GameManager.instance.friendManager.mainContactList.setContactData(var6, -1);
                GameManager.instance.friendManager.mainContactList.isLoading = false;
                GameManager.instance.friendManager.addAllFriendsToOnline();
                FriendScreen.currentUserTimestamp = GameManager.getUserId(FriendScreen.currentUserId);
            } else {
                currentUserId = -1;
            }
        }

        String var7 = Xuka.loadStringData(FriendScreen.currentUserId, false);
        FriendScreen.statusMessage = var7 == null ? "" : var7;
        if (var7 != null && var7.length() > 0) {
            FriendScreen.updateStatusMessage(FriendScreen.statusMessage);
        }

        System.gc();
        GameGraphics.instance.initializeConnection();
        PacketSender.sendLogin(FriendScreen.currentUserId,
                this.loginScreen.passwordInput.getText(),
                FriendScreen.userStatus,
                1,
                currentUserId,
                GameManager.loginType,
                FriendScreen.statusMessage);
    }
}
