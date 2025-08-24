package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.ImageCache;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import java.util.Vector;

public final class YahooScreen extends Screen {
    private static final Integer YAHOO_LOGO_INDEX = new Integer(1);
    public ContactListComponent contactList;
    public static String yahooUsername;
    public static String originalUsername;
    public static int yahooStatus;
    public static String statusMessage;
    private static boolean isInvisibleLogin;
    public boolean isSearchMode;
    private boolean isLoggedIn;
    private final Vector contextMenuItems;
    public ContextMenu contextMenu;
    public TextInputComponent searchInput;
    public boolean isConnectionReady;
    private final TextComponent yahooIdLabel;
    public TextInputComponent usernameInput;
    private final TextComponent passwordLabel;
    public TextInputComponent passwordInput;
    public CheckboxComponent invisibleCheckbox;
    private final TextComponent domainLabel;
    public DropdownComponent domainDropdown;
    private final int logoX;
    private final int logoY;
    private TextInputComponent activeTextInput;
    private ButtonAction menuButton;
    private ButtonAction loginButton;
    private ButtonAction backButton;
    private int buddyListRequestId;
    private DialogScreen statusScreen;
    private DropdownComponent statusDropdown;
    private TextInputComponent statusMessageInput;

    public YahooScreen() {
        super.dialogId = 11112;
        String var1 = Xuka.loadYahooID();
        String var2 = Xuka.loadYahooPassword();
        super.title = "Yahoo!";
        this.logoX = Screen.screenWidth - 40 >> 1;
        int var3;
        if ((var3 = (FontRenderer.fontHeight + 3 << 2) + 28 + 40 + 5) <= Screen.screenHeight - GameManager.footerHeight) {
            this.logoY = GameManager.headerHeight - 4 + (Screen.screenHeight - GameManager.footerHeight - var3 >> 1);
        } else {
            this.logoY = GameManager.headerHeight + 5;
        }

        var3 = this.logoY + 40 - 3;
        this.yahooIdLabel = new TextComponent("Yahoo! ID:", UIUtils.leftColumnX, var3 + 3, FontRenderer.fontHeight);
        this.yahooIdLabel.width = UIUtils.leftColumnWidth;
        this.usernameInput = new TextInputComponent();
        this.usernameInput.setBounds(UIUtils.rightColumnX, var3, UIUtils.rightColumnWidth, FontRenderer.fontHeight + 6);
        this.usernameInput.setInputConstraint(0);
        var3 += this.usernameInput.height + 7;
        this.passwordLabel = new TextComponent("Mật khẩu:", UIUtils.leftColumnX, var3 + 3, FontRenderer.fontHeight);
        this.passwordLabel.width = UIUtils.leftColumnWidth;
        this.passwordInput = new TextInputComponent();
        this.passwordInput.setBounds(UIUtils.rightColumnX, var3, UIUtils.rightColumnWidth, FontRenderer.fontHeight + 6);
        this.passwordInput.setInputConstraint(2);
        this.passwordInput.isNavigationMode = true;
        this.usernameInput.setText(var1);
        this.usernameInput.marginOffset = -5;
        this.passwordInput.setText(var2);
        this.passwordInput.marginOffset = -5;
        var3 += this.passwordInput.height + 7;
        this.domainLabel = new TextComponent("Domain:", UIUtils.leftColumnX, var3 + 3, FontRenderer.fontHeight);
        this.domainLabel.width = UIUtils.leftColumnWidth;
        this.domainDropdown = new DropdownComponent(new String[]{"@yahoo", "@ymail", "@rocketmail"}, UIUtils.rightColumnX, var3, UIUtils.rightColumnWidth, FontRenderer.fontHeight + 6);
        this.domainDropdown.setSelectedIndex(Xuka.loadYahooDomain());
        var3 += 6 + this.domainDropdown.height;
        int var4 = Screen.screenWidth - (FontRenderer.getTextWidth("Đăng nhập ẩn") + 13 + 4) >> 1;
        this.invisibleCheckbox = new CheckboxComponent("Đăng nhập ẩn", var4, var3, FontRenderer.getTextWidth("Đăng nhập ẩn") + 13 + 4, FontRenderer.fontHeight + 4);
        this.invisibleCheckbox.isChecked = Xuka.loadBooleanSetting("statusYahoo", false);
        this.searchInput = new TextInputComponent();
        this.searchInput.isNavigationMode = true;
        this.searchInput.setBounds(1, Screen.screenHeight - GameManager.footerHeight - FontRenderer.fontHeight - 7, Screen.screenWidth - 2, FontRenderer.fontHeight + 6);
        this.contactList = new ContactListComponent(0, 1, Screen.screenWidth - 2, Screen.screenHeight - 4 - GameManager.footerHeight, true);
        this.addComponent(this.contactList);
        UIUtils.focusComponent(this, this.contactList);
        this.contactList.isChatMode = true;
        this.contactList.isFilterActive = Xuka.loadBooleanSetting("hideOffline", false);
        this.contextMenuItems = new Vector();
        this.contextMenuItems.addElement(new ButtonAction("Mở/tắt ID ẩn", new quyen_jd(this)));
        this.contextMenuItems.addElement(new ButtonAction("Trạng thái", new quyen_jl(this)));
        this.contextMenuItems.addElement(new ButtonAction("Chat với..", new quyen_jm(this)));
        this.contextMenuItems.addElement(new ButtonAction("Thêm bạn", new quyen_jo(this)));
        this.contextMenuItems.addElement(new ButtonAction("Mời bạn Yahoo!", new quyen_jp(this)));
        this.contextMenuItems.addElement(new ButtonAction("Thoát Yahoo!", new quyen_jq(this)));
    }

    public void logout() {
        GameManager.instance.resetConnectionCounters();
        if (this.isConnectionReady || this.isLoggedIn) {
            this.isConnectionReady = false;
            PacketSender.d(yahooUsername, 2);
            this.switchToMode(false);
        }

        GameManager.instance.removeScreen(this.statusScreen);
        this.statusScreen = null;
    }

    public void showAddFriendDialog(String var1) {
        DialogScreen var2;
        (var2 = new DialogScreen()).title = "Thêm bạn";
        TextInputComponent var3 = ButtonAction.createTextInput(var2, "Thêm bạn", 0);
        if (var1 != null) {
            var3.setText(var1);
        }

        TextInputComponent var5 = ButtonAction.createTextInput(var2, "Vào nhóm mới:", 0);
        DropdownComponent var4 = ButtonAction.createChoiceBox(var2, "hoặc đã có:", this.contactList.getGroupNames());
        UIUtils.focusComponent(var2, (UIComponent) var3);
        var4.setChangeAction(new quyen_jr(this, var4, var5));
        if (var4.optionList != null && var4.optionList.length != 0) {
            var5.setText(var4.getSelectedText());
        } else {
            var5.setText("Friends");
        }

        var2.rightSoftkey = new ButtonAction(TextConstant.close(), new quyen_js(this, var2));
        var2.centerSoftkey = new ButtonAction("OK", new quyen_je(this, var3, var5, var2));
        var2.startSlideAnimation(1);
        GameManager.instance.addScreenToStack((Screen) var2);
        GameManager.instance.switchToLastScreen();
    }

    public void switchToMode(boolean var1) {
        this.removeAllComponents();
        this.isLoggedIn = var1;
        if (var1) {
            if (this.contextMenu == null) {
                this.contextMenu = new ContextMenu(this.contextMenuItems);
                this.menuButton = new ButtonAction("Menu", new quyen_jf(this));
            }

            super.leftSoftkey = this.menuButton;
            super.centerSoftkey = null;
            this.addComponent(this.contactList);
            UIUtils.focusComponent(this, this.contactList);
        } else {
            if (this.loginButton == null) {
                this.loginButton = new ButtonAction("Đăng nhập", new quyen_jg(this));
                this.backButton = new ButtonAction(TextConstant.close(), new quyen_jh(this));
            }

            super.leftSoftkey = null;
            super.centerSoftkey = this.loginButton;
            super.rightSoftkey = this.backButton;
            this.exitSearchMode();
            this.addComponent(this.yahooIdLabel);
            this.addComponent(this.usernameInput);
            this.addComponent(this.passwordLabel);
            this.addComponent(this.passwordInput);
            this.addComponent(this.domainLabel);
            this.addComponent(this.domainDropdown);
            this.addComponent(this.invisibleCheckbox);
            if (this.usernameInput.getText().length() > 0) {
                UIUtils.focusComponent(this, this.domainDropdown);
            } else {
                UIUtils.focusComponent(this, (UIComponent) this.usernameInput);
            }
        }

        super.currentScrollY = super.targetScrollY = 0;
        this.contactList.onFocusGained();
        System.gc();
    }

    public void renderBackground(Graphics var1) {
        if (!this.isLoggedIn) {
            var1.drawImage(ImageCache.getImage(YAHOO_LOGO_INDEX), this.logoX, this.logoY, 0);
        }

        super.renderBackground(var1);
    }

    public void performLogin() {
        if (GameManager.instance.hasExceededReconnectLimit()) {
            GameManager.instance.showWrappedTextDialog("Tài khoản Yahoo của bạn bị khóa. Vui lòng đăng nhập lại sau.");
        } else {
            this.usernameInput.setText(this.usernameInput.getText().trim().toLowerCase());
            String var1 = this.usernameInput.getText();
            String var2 = this.passwordInput.getText();
            if (var1.equals("")) {
                UIUtils.focusComponent(this, (UIComponent) this.usernameInput);
            } else if (var2.equals("")) {
                UIUtils.focusComponent(this, (UIComponent) this.passwordInput);
            } else {
                yahooUsername = var1;
                originalUsername = var1;
                yahooStatus = this.invisibleCheckbox.isChecked ? 12 : 0;
                isInvisibleLogin = this.invisibleCheckbox.isChecked;
                String var3;
                statusMessage = (var3 = Xuka.loadStringData(yahooUsername, true)) == null ? "" : var3;
                Xuka.saveYahooID(var1);
                Xuka.saveYahooPassword(var2);
                int var4 = this.domainDropdown.getSelectedIndex();
                Xuka.saveYahooDomain(this.domainDropdown.getSelectedIndex());
                if (var4 == 1 || var4 == 2) {
                    yahooUsername = yahooUsername + this.domainDropdown.getSelectedText() + ".com";
                }

                this.contactList.isLoading = true;
                this.switchToMode(true);
                this.buddyListRequestId = GameManager.loadContactStatus(true);
                if (this.buddyListRequestId != -1) {
                    BuddyGroupList var5;
                    if ((var5 = GameManager.loadBuddyList(true, yahooUsername)) != null) {
                        GameManager.instance.yahooChat.contactList.setContactData(var5, -1);
                    } else {
                        this.buddyListRequestId = -1;
                    }
                }

                PacketSender.sendLogin(yahooUsername, var2, yahooStatus, 2, this.buddyListRequestId, (byte) 0, "");
            }
        }
    }

    public void focusFirstComponent() {
        this.contactList.onFocusGained();
    }

    public void renderSpecialComponent(Graphics var1) {
        this.contactList.renderFocusIndicator(var1);
    }

    public void clearContactData() {
        if (this.contactList.displayItems != null) {
            this.contactList.displayItems.removeAllElements();
        }

        this.contactList.displayItems = null;
        this.contactList.contactData = null;
    }

    private void enterSearchMode() {
        this.searchInput.setText("");
        this.addComponent(this.searchInput);
        UIUtils.focusComponent(this, (UIComponent) this.searchInput);
        this.isSearchMode = true;
    }

    private void exitSearchMode() {
        UIUtils.focusComponent(this, this.contactList);
        this.removeComponent(this.searchInput);
        this.isSearchMode = false;
    }

    public boolean handleInput(boolean[] var1, boolean[] var2, int[] var3) {
        if (var3[0] > 32 && !this.isSearchMode && this.isLoggedIn && (this.activeTextInput == null || !UIUtils.isComponentSelected(this, (UIComponent) this.activeTextInput))) {
            this.enterSearchMode();
        }

        String var4 = "";
        if (this.isSearchMode) {
            if (var1[12]) {
                var1[12] = false;
                this.contactList.handleKeyPress(12);
            } else if (var1[13]) {
                var1[13] = false;
                this.contactList.handleKeyPress(13);
            } else if (var1[16]) {
                var1[16] = false;
                this.contactList.handleKeyPress(16);
            }

            var4 = this.searchInput.getText();
        }

        boolean var5 = super.handleInput(var1, var2, var3);
        if (this.isSearchMode) {
            if (this.searchInput.getText().equals("")) {
                this.exitSearchMode();
            }

            if (!this.searchInput.getText().equals(var4)) {
                this.contactList.setSearchFilter(this.searchInput.getText());
            }
        }

        return var5;
    }

    public void showInviteFriendDialog() {
        Xuka.setSpamFlag(yahooUsername);
        GameManager.getInstance().showConfirmDialog("Mời bạn Yahoo! dùng X Yahoo!", new quyen_ji(this));
    }

    public static boolean checkConnectionReady(YahooScreen var0) {
        if (!var0.isConnectionReady) {
            GameManager.instance.showNotification("Vui lòng chờ", (Image) null, 1);
            return true;
        } else {
            return false;
        }
    }

    public static void showStatusDialog(YahooScreen var0) {
        if (isInvisibleLogin) {
            GameManager.instance.showNotification("Vui lòng thoát Yahoo! và bỏ chọn đăng nhập ẩn", (Image) null, 1);
        } else if (GameManager.showConnectionStatus) {
            GameManager.instance.showNotification("Vui lòng chờ 10s", (Image) null, 1);
        } else {
            if (var0.statusScreen == null) {
                System.gc();
                var0.statusScreen = new DialogScreen();
                var0.statusScreen.title = "Trạng Thái";
                UIUtils.calculateColumnLayout(UIUtils.layoutParam1, UIUtils.layoutParam2);
                var0.statusScreen.nextComponentY += 20;
                var0.statusDropdown = ButtonAction.createChoiceBox(var0.statusScreen, UIUtils.concatStrings("Trạng thái", ":", null, null), new String[]{"Hiển thị", "Ẩn danh"});
                var0.statusMessageInput = ButtonAction.createLabeledTextInput(var0.statusScreen, UIUtils.concatStrings("Thông điệp", ":", null, null), 0, -1);
                UIUtils.focusComponent(var0.statusScreen, var0.statusDropdown);
                var0.statusScreen.centerSoftkey = new ButtonAction("OK", new quyen_jj(var0));
                var0.statusScreen.rightSoftkey = new ButtonAction(TextConstant.close(), new quyen_jk(var0));
                System.gc();
            }

            var0.statusDropdown.setSelectedIndex(yahooStatus == 0 ? 0 : 1);
            GameManager.getInstance().addScreenToStack((Screen) var0.statusScreen);
            var0.statusMessageInput.setText(statusMessage);
            GameManager.getInstance().switchToLastScreen();
        }
    }

    public static void exitSearchMode(YahooScreen var0) {
        var0.exitSearchMode();
    }

    public static TextInputComponent getActiveTextInput(YahooScreen var0) {
        return var0.activeTextInput;
    }

    public static void setActiveTextInput(YahooScreen var0, TextInputComponent var1) {
        var0.activeTextInput = var1;
    }

    public static TextInputComponent getStatusMessageInput(YahooScreen var0) {
        return var0.statusMessageInput;
    }

    public static DropdownComponent getStatusDropdown(YahooScreen var0) {
        return var0.statusDropdown;
    }

    public static void updateStatusMessage(YahooScreen var0, String var1) {
        PacketSender.c(var1, 2);
        statusMessage = var1;
        Xuka.saveStringData(yahooUsername, var1, true);
    }

    public static DialogScreen getStatusScreen(YahooScreen var0) {
        return var0.statusScreen;
    }
}
