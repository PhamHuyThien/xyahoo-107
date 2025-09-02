package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.components.*;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.PacketUtils;
import home.thienph.xyahoo107.utils.TextRenderer;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Graphics;
import java.util.Vector;

public final class LoginScreen extends DialogScreen {
    public TextInputComponent usernameInput;
    public TextInputComponent passwordInput;
    public TextInputComponent feedbackInput;
    public CheckboxComponent invisibleLoginCheckbox;
    public DropdownComponent accountTypeDropdown;
    private final Vector menuItems;
    public ContextMenu contextMenu;
    private final int versionTextX;
    private final ButtonAction registerButton = new ButtonAction("Đăng ký", new LoginClickRegisterAction(this));
    private static DialogScreen settingsScreen;

    public void render(Graphics var1) {
        super.render(var1);
        FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(GameManager.version, this.versionTextX, screenY + 3, var1);
    }

    public LoginScreen() {
        this.versionTextX = screenWidth - FontRenderer.getTextWidth(GameManager.version) - 6;
        Vector supportMenuContext = new Vector();
        supportMenuContext.addElement(GameManager.infoButton);
        supportMenuContext.addElement(new ButtonAction("Gửi góp ý", new LoginSendFeedbackAction(this)));
        supportMenuContext.addElement(GameManager.helpButton);
        supportMenuContext.addElement(GameManager.forumButton);

        ButtonAction buttonSupport = new ButtonAction("Hỗ trợ", null);
        buttonSupport.parentContainer = new ContextMenu(supportMenuContext);

        String username = Xuka.loadUserID();
        String password = Xuka.loadPassword();
        int loginType = Xuka.loadIDType();
        super.centerSoftkey = new ButtonAction("Đăng nhập", new LoginClickAction(this));
        super.title = " X Yahoo! ";
        UIUtils.calculateColumnLayout(UIUtils.layoutParam1, UIUtils.layoutParam2);
        super.nextComponentY = screenHeight - ((FontRenderer.paragraphSpacing << 2) + TextRenderer.CHAR_SPACING + (GameGraphics.screenHeight > 180 ? 40 : 11) + GameManager.footerHeight) >> 1;
        ButtonAction.createImageComponent(this, 0, TextRenderer.getLogoImage(), TextRenderer.getLogoImage().getWidth(), TextRenderer.getLogoImage().getHeight(), false, false);
        super.nextComponentY += 10;
        this.usernameInput = ButtonAction.createTextInputWithID(this, loginType == 0 ? "Xubi ID:" : "Yahoo! ID:", 0, -1);
        super.nextComponentY += 6;
        this.passwordInput = ButtonAction.createTextInputWithID(this, UIUtils.concatStrings("Mật khẩu", ":", null, null), 2, -1);
        this.usernameInput.marginOffset = -5;
        this.passwordInput.marginOffset = -5;
        super.nextComponentY += 6;
        TextComponent usernameLabel = new TextComponent("Tài khoản:", UIUtils.leftColumnX, super.nextComponentY, FontRenderer.fontHeight);
        this.accountTypeDropdown = new DropdownComponent(new String[]{"Xubi", "Yahoo!"}, UIUtils.rightColumnX, super.nextComponentY - 3, UIUtils.rightColumnWidth, FontRenderer.fontHeight + 6);
        this.accountTypeDropdown.setSelectedIndex(loginType);
        this.accountTypeDropdown.changeAction = new LoginChangeAccountTypeAction(this);
        this.addComponent(usernameLabel);
        this.addComponent(this.accountTypeDropdown);
        super.nextComponentY += 3;
        loginType = screenWidth - (FontRenderer.getTextWidth("Đăng nhập ẩn") + 13 + 4) >> 1;
        this.invisibleLoginCheckbox = new CheckboxComponent("Đăng nhập ẩn", loginType, super.nextComponentY, FontRenderer.getTextWidth("Đăng nhập ẩn") + 13 + 4, FontRenderer.fontHeight + 4);
        this.invisibleLoginCheckbox.isChecked = Xuka.loadBooleanSetting("status", false);
        this.addComponent(this.invisibleLoginCheckbox);
        super.nextComponentY += 4;
        super.dialogX = screenWidth - FontRenderer.getTextWidth("Đăng ký tài khoản") >> 1;
        ButtonAction.createCustomButton(this, "Đăng ký tài khoản", -1, this.registerButton.action, super.dialogX, super.nextComponentY, super.dialogWidth);
        UIUtils.focusComponent(this, (UIComponent) this.usernameInput);
        this.menuItems = new Vector();
        this.menuItems.addElement(this.registerButton);
        this.menuItems.addElement(new ButtonAction("Quên mật khẩu?", new LoginClickForgotPasswordAction(this)));
        this.menuItems.addElement(new ButtonAction("Cấu hình", new LoginClickSettingsAction(this)));
        this.menuItems.addElement(buttonSupport);
        this.menuItems.addElement(new ButtonAction("Thoát", new LoginClickExitAction(this)));
        this.contextMenu = new ContextMenu(this.menuItems);
        super.leftSoftkey = new ButtonAction("Menu", new LoginClickMenuAction(this));
        if (username != null) {
            this.usernameInput.setText(username);
        }

        if (password != null) {
            this.passwordInput.setText(password);
        }

        if (username != null && username.length() > 0 && password != null && password.length() > 0 && GameManager.autoLogin && !NetworkManager.forceDisconnect) {
            super.centerSoftkey.action.action();
        }
    }

    public static void showSettingsScreen() {
        if (settingsScreen == null) {
            System.gc();
            (settingsScreen = new DialogScreen()).title = "Cấu Hình";
            settingsScreen.nextComponentY += 14;
            DropdownComponent keyboardSpeedChoice = ButtonAction.createChoiceBox(settingsScreen, "Tốc độ phím: ", new String[]{"1", "2", "3", "4", "5", "6", "7"});
            CheckboxComponent soundCheckbox = ButtonAction.createCheckbox(settingsScreen, "Âm thanh", !GameManager.soundEnabled);
            CheckboxComponent ringCheckbox = ButtonAction.createCheckbox(settingsScreen, "Rung", GameManager.vibrateEnabled);
            CheckboxComponent autoLoginCheckbox = ButtonAction.createCheckbox(settingsScreen, "Tự đăng nhập", GameManager.autoLogin);
            CheckboxComponent autoLoginYahooCheckbox = ButtonAction.createCheckbox(settingsScreen, "Tự đăng nhập Yahoo!", GameManager.autoLoginYahoo);
            ButtonAction.createButton(settingsScreen, UIUtils.concatStrings("Xóa", " dữ liệu cá nhân", null, null), new SettingClickClearDataAction(), settingsScreen.nextComponentY + 2, 0);
            keyboardSpeedChoice.setSelectedIndex(TextInputComponent.inputModeIndex);
            UIUtils.focusComponent(settingsScreen, keyboardSpeedChoice);
            boolean isRingCheckbox = ringCheckbox.isChecked;
            boolean isSoundCheckbox = soundCheckbox.isChecked;
            boolean isAutoLoginCheckbox = autoLoginCheckbox.isChecked;
            boolean isAutoLoginYahooCheckbox = autoLoginYahooCheckbox.isChecked;
            int keyboardSpeedChoiceIndex = keyboardSpeedChoice.getSelectedIndex();
            settingsScreen.rightSoftkey = new ButtonAction(TextConstant.close(), new SettingClickCloseAction(ringCheckbox, isRingCheckbox, soundCheckbox, isSoundCheckbox, autoLoginCheckbox, isAutoLoginCheckbox, autoLoginYahooCheckbox, isAutoLoginYahooCheckbox, keyboardSpeedChoice, keyboardSpeedChoiceIndex));
            settingsScreen.centerSoftkey = new ButtonAction("Lưu", new SettingClickSaveAction(autoLoginCheckbox, autoLoginYahooCheckbox, keyboardSpeedChoice, ringCheckbox, soundCheckbox));
        }

        GameManager.getInstance().addScreenToStack((Screen) settingsScreen);
        settingsScreen.startSlideAnimation(-1);
        GameManager.getInstance().switchToLastScreen();
    }

    public void showForgotPasswordSMS() {
        String textForgotPassword = UIUtils.concatStrings("Bạn sẽ nhận mật khẩu qua tin nhắn.", "\n", "Gửi tin: ", GameManager.smsContent);
        String textForgotPassword2 = UIUtils.concatStrings(textForgotPassword, this.usernameInput.getText(), Xuka.refCode, "\nĐến số: ");
        GameManager.instance.showConfirmDialog(UIUtils.concatStrings(textForgotPassword, textForgotPassword2, null, null), new LoginHandlerForgotPasswordAction(this));
    }

    public void performLogin() {
        GameGraphics.clearKeyStates();
        if (this.usernameInput.getText().equals("")) {
            UIUtils.focusComponent(this, (UIComponent) this.usernameInput);
        } else if (this.passwordInput.getText().equals("")) {
            UIUtils.focusComponent(this, (UIComponent) this.passwordInput);
        } else {
            NetworkManager.forceDisconnect = false;
            int versionCode = Xuka.versionCode;
            Packet var3 = new Packet(500, 2);
            PacketUtils.writeInt(versionCode, var3);
            NetworkManager.sendPacket(var3);
            PacketSender.sendAppInfo();
            GameManager.getInstance().createSimpleDialog(UIUtils.concatStrings("Đăng nhập với ", this.usernameInput.getText(), null, null), null, null, new ButtonAction(TextConstant.close(), new LoginClickCloseLoadingAction(this))).setLoadingVisible(true);
            GameManager.getInstance().checkConnection();
            LoginHandlerAction var1 = new LoginHandlerAction(this);
            GameManager.getInstance().gameController = var1;
        }
    }

    public static DialogScreen getSettingsScreen() {
        return settingsScreen;
    }
}
