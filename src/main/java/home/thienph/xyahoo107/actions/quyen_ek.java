package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.DownloadDataManager;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_ek implements Action {
    private final LoginScreen a;

    public quyen_ek(LoginScreen var1) {
        this.a = var1;
    }

    public void action() {
        System.gc();
        this.a.usernameInput.setText(this.a.usernameInput.getText().toLowerCase());
        FriendScreen.currentUserId = this.a.usernameInput.getText();
        FriendScreen.userStatus = this.a.invisibleLoginCheckbox.isChecked ? 0 : 1;
        if ((GameManager.loginType = (byte) this.a.accountTypeDropdown.getSelectedIndex()) == 1) {
            String var1;
            if ((var1 = this.a.usernameInput.getText()).indexOf("@") == -1) {
                StringBuffer var2;
                (var2 = new StringBuffer(FriendScreen.currentUserId)).append("@yahoo.com");
                FriendScreen.currentUserId = var2.toString();
            }

            String var5 = var1;
            byte var3 = 0;
            if (var1.indexOf("@ymail") >= 0) {
                var3 = 1;
                var5 = var1.substring(0, var1.indexOf("@ymail"));
            } else if (var1.indexOf("@rocketmail") >= 0) {
                var3 = 2;
                var5 = var1.substring(0, var1.indexOf("@rocketmail"));
            } else if (var1.indexOf("@yahoo") >= 0) {
                var5 = var1.substring(0, var1.indexOf("@yahoo"));
            }

            Xuka.saveYahooID(var5);
            Xuka.saveYahooPassword(this.a.passwordInput.getText());
            Xuka.saveBooleanSetting("statusYahoo", this.a.invisibleLoginCheckbox.isChecked);
            Xuka.saveYahooDomain(var3);
            if (GameManager.instance.yahooChat != null) {
                GameManager.instance.yahooChat.usernameInput.setText(var5);
                GameManager.instance.yahooChat.passwordInput.setText(this.a.passwordInput.getText());
                GameManager.instance.yahooChat.invisibleCheckbox.isChecked = this.a.invisibleLoginCheckbox.isChecked;
                GameManager.instance.yahooChat.domainDropdown.setSelectedIndex(var3);
            }
        }

        Xuka.saveUserID(this.a.usernameInput.getText());
        Xuka.savePassword(this.a.passwordInput.getText());
        Xuka.saveIDType(this.a.accountTypeDropdown.getSelectedIndex());
        Xuka.saveBooleanSetting("status", this.a.invisibleLoginCheckbox.isChecked);
        FriendScreen.currentUserName = FriendScreen.currentUserId;
        GameManager.getInstance().initializeFriendManager();
        int var4;
        if ((var4 = GameManager.loadContactStatus(false)) != -1) {
            DownloadDataManager var6;
            if ((var6 = GameManager.loadBuddyList(false, FriendScreen.currentUserId)) != null) {
                GameManager.instance.friendManager.mainContactList.setContactData(var6, -1);
                GameManager.instance.friendManager.mainContactList.isLoading = false;
                GameManager.instance.friendManager.addAllFriendsToOnline();
                FriendScreen.currentUserTimestamp = GameManager.getUserId(FriendScreen.currentUserId);
            } else {
                var4 = -1;
            }
        }

        String var7;
        FriendScreen.statusMessage = (var7 = Xuka.loadStringData(FriendScreen.currentUserId, false)) == null ? "" : var7;
        if (var7 != null && var7.length() > 0) {
            FriendScreen.updateStatusMessage(FriendScreen.statusMessage);
        }

        System.gc();
        GameGraphics.instance.initializeConnection();
        PacketSender.a(FriendScreen.currentUserId, this.a.passwordInput.getText(), FriendScreen.userStatus, 1, var4, GameManager.loginType, FriendScreen.statusMessage);
    }
}
