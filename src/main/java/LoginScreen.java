import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class LoginScreen extends DialogScreen {
   TextInputComponent usernameInput;
   TextInputComponent passwordInput;
   TextInputComponent c;
   CheckboxComponent invisibleLoginCheckbox;
   DropdownComponent accountTypeDropdown;
   private Vector menuItems;
   ContextMenu contextMenu;
   private int versionTextX;
   private UIFactory registerButton = new UIFactory("Đăng ký", new quyen_ed(this));
   private static DialogScreen settingsScreen;

   public final void render(Graphics var1) {
      super.render(var1);
      FontRenderer.getFontInstance(FontRenderer.COLOR_WHITE).drawText(GameManager.version, this.versionTextX, Screen.screenY + 3, var1);
   }

   public LoginScreen() {
      this.versionTextX = Screen.screenWidth - FontRenderer.getTextWidth(GameManager.version) - 6;
      Vector var1;
      (var1 = new Vector()).addElement(GameManager.infoButton);
      var1.addElement(new UIFactory("Gửi góp ý", new quyen_el(this)));
      var1.addElement(GameManager.helpButton);
      var1.addElement(GameManager.forumButton);
      UIFactory var2;
      (var2 = new UIFactory("Hỗ trợ", null)).parentContainer = new ContextMenu(var1);
      String var6 = Xuka.loadUserID();
      String var3 = Xuka.loadPassword();
      int var4 = Xuka.loadIDType();
      super.centerSoftkey = new UIFactory("Đăng nhập", new quyen_en(this));
      super.title = " X Yahoo! ";
      UIUtils.calculateColumnLayout(UIUtils.layoutParam1, UIUtils.layoutParam2);
      super.nextComponentY = Screen.screenHeight - ((FontRenderer.paragraphSpacing << 2) + TextRenderer.CHAR_SPACING + (GameGraphics.screenHeight > 180 ? 40 : 11) + GameManager.footerHeight) >> 1;
      UIFactory.createImageComponent(this, 0, TextRenderer.getLogoImage(), TextRenderer.getLogoImage().getWidth(), TextRenderer.getLogoImage().getHeight(), false, false);
      super.nextComponentY += 10;
      this.usernameInput = UIFactory.createTextInputWithID(this, var4 == 0 ? "Xubi ID:" : "Yahoo! ID:", 0, -1);
      super.nextComponentY += 6;
      this.passwordInput = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Mật khẩu", ":", null, null), 2, -1);
      this.usernameInput.marginOffset = -5;
      this.passwordInput.marginOffset = -5;
      super.nextComponentY += 6;
      TextComponent var5 = new TextComponent("Tài khoản:", UIUtils.leftColumnX, super.nextComponentY, FontRenderer.fontHeight);
      this.accountTypeDropdown = new DropdownComponent(new String[]{"Xubi", "Yahoo!"}, UIUtils.rightColumnX, super.nextComponentY - 3, UIUtils.rightColumnWidth, FontRenderer.fontHeight + 6);
      this.accountTypeDropdown.setSelectedIndex(var4);
      this.accountTypeDropdown.changeAction = new quyen_eo(this);
      this.addComponent(var5);
      this.addComponent(this.accountTypeDropdown);
      super.nextComponentY += 3;
      var4 = Screen.screenWidth - (FontRenderer.getTextWidth("Đăng nhập ẩn") + 13 + 4) >> 1;
      this.invisibleLoginCheckbox = new CheckboxComponent("Đăng nhập ẩn", var4, super.nextComponentY, FontRenderer.getTextWidth("Đăng nhập ẩn") + 13 + 4, FontRenderer.fontHeight + 4);
      this.invisibleLoginCheckbox.isChecked = Xuka.loadBooleanSetting("status", false);
      this.addComponent(this.invisibleLoginCheckbox);
      super.nextComponentY += 4;
      super.dialogX = Screen.screenWidth - FontRenderer.getTextWidth("Đăng ký tài khoản") >> 1;
      UIFactory.createCustomButton(this, "Đăng ký tài khoản", -1, this.registerButton.action, super.dialogX, super.nextComponentY, super.dialogWidth);
      UIUtils.focusComponent(this, (UIComponent)this.usernameInput);
      this.menuItems = new Vector();
      this.menuItems.addElement(this.registerButton);
      this.menuItems.addElement(new UIFactory("Quên mật khẩu?", new quyen_ep(this)));
      this.menuItems.addElement(new UIFactory("Cấu hình", new quyen_eq(this)));
      this.menuItems.addElement(var2);
      this.menuItems.addElement(new UIFactory("Thoát", new quyen_er(this)));
      this.contextMenu = new ContextMenu(this.menuItems);
      super.leftSoftkey = new UIFactory("Menu", new quyen_es(this));
      if (var6 != null) {
         this.usernameInput.setText(var6);
      }

      if (var3 != null) {
         this.passwordInput.setText(var3);
      }

      if (var6 != null && var6.length() > 0 && var3 != null && var3.length() > 0 && GameManager.autoLogin && !NetworkManager.forceDisconnect) {
         super.centerSoftkey.action.action();
      }
   }

   public static void showSettingsScreen() {
      if (settingsScreen == null) {
         System.gc();
         (settingsScreen = new DialogScreen()).title = "Cấu Hình";
         settingsScreen.nextComponentY += 14;
         DropdownComponent var0 = UIFactory.createChoiceBox(settingsScreen, "Tốc độ phím: ", new String[]{"1", "2", "3", "4", "5", "6", "7"});
         CheckboxComponent var1 = UIFactory.createCheckbox(settingsScreen, "Âm thanh", !GameManager.soundEnabled);
         CheckboxComponent var2 = UIFactory.createCheckbox(settingsScreen, "Rung", GameManager.vibrateEnabled);
         CheckboxComponent var3 = UIFactory.createCheckbox(settingsScreen, "Tự đăng nhập", GameManager.autoLogin);
         CheckboxComponent var4 = UIFactory.createCheckbox(settingsScreen, "Tự đăng nhập Yahoo!", GameManager.autoLoginYahoo);
         UIFactory.createButton(settingsScreen, UIUtils.concatStrings("Xóa", " dữ liệu cá nhân", null, null), new quyen_ee(), settingsScreen.nextComponentY + 2, 0);
         var0.setSelectedIndex(TextInputComponent.inputModeIndex);
         UIUtils.focusComponent(settingsScreen, var0);
         boolean var5 = var2.isChecked;
         boolean var6 = var1.isChecked;
         boolean var7 = var3.isChecked;
         boolean var8 = var4.isChecked;
         int var9 = var0.getSelectedIndex();
         settingsScreen.rightSoftkey = new UIFactory(TextConstant.close(), new quyen_ef(var2, var5, var1, var6, var3, var7, var4, var8, var0, var9));
         settingsScreen.centerSoftkey = new UIFactory("Lưu", new quyen_eg(var3, var4, var0, var2, var1));
      }

      GameManager.getInstance().addScreenToStack((Screen) settingsScreen);
      settingsScreen.startSlideAnimation(-1);
      GameManager.getInstance().o();
   }

   public final void showForgotPasswordSMS() {
      String var1;
      String var2 = UIUtils.concatStrings(var1 = UIUtils.concatStrings("Bạn sẽ nhận mật khẩu qua tin nhắn.", "\n", "Gửi tin: ", GameManager.smsContent), this.usernameInput.getText(), Xuka.refCode, "\nĐến số: ");
      GameManager.instance.a(UIUtils.concatStrings(var1, var2, null, null), new quyen_eh(this));
   }

   public final void performLogin() {
      GameGraphics.clearKeyStates();
      if (this.usernameInput.getText().equals("")) {
         UIUtils.focusComponent(this, (UIComponent)this.usernameInput);
      } else if (this.passwordInput.getText().equals("")) {
         UIUtils.focusComponent(this, (UIComponent)this.passwordInput);
      } else {
         NetworkManager.forceDisconnect = false;
         int var2 = Xuka.versionCode;
         Packet var3 = new Packet(500, 2);
         PacketUtils.writeInt(var2, var3);
         NetworkManager.sendPacket(var3);
         PacketSender.e();
         GameManager.getInstance().a(UIUtils.concatStrings("Đăng nhập với ", this.usernameInput.getText(), null, null), null, null, new UIFactory(TextConstant.close(), new quyen_ej(this))).setLoadingVisible(true);
         GameManager.getInstance().checkConnection();
         quyen_ek var1 = new quyen_ek(this);
         GameManager.getInstance().gameController = var1;
      }
   }

   static DialogScreen getSettingsScreen() {
      return settingsScreen;
   }
}
