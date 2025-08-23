package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.quyen_gv;
import home.thienph.xyahoo107.actions.quyen_gw;
import home.thienph.xyahoo107.actions.quyen_gx;
import home.thienph.xyahoo107.actions.quyen_gy;
import home.thienph.xyahoo107.canvas.GameGraphics;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.UIComponent;
import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.FontRenderer;
import home.thienph.xyahoo107.utils.TextRenderer;
import home.thienph.xyahoo107.utils.TextValidator;
import home.thienph.xyahoo107.utils.UIUtils;

import javax.microedition.lcdui.Image;

public final class RegistrationScreen extends DialogScreen {
   private static String[] RESERVED_USERNAMES = new String[]{"admin", "root", "system", "xuka", "yahoo"};
   public TextInputComponent usernameInput;
   public TextInputComponent passwordInput;
   private TextInputComponent confirmPasswordInput;
   private String suggestedUsername;
   public String c;
   public String finalUsername;

   public RegistrationScreen() {
      super.title = "Đăng Ký";
      super.leftSoftkey = new UIFactory(TextConstant.close(), new quyen_gv(this));
      super.centerSoftkey = new UIFactory("Đăng ký", new quyen_gw(this));
   }

   public final void initializeComponents() {
      this.removeAllComponents();
      this.usernameInput = null;
      this.passwordInput = null;
      this.confirmPasswordInput = null;
      System.gc();
      UIUtils.calculateColumnLayout(UIUtils.layoutParam1, UIUtils.layoutParam2);
      this.calculateDialogDimensions();
      super.nextComponentY = Screen.screenHeight - (FontRenderer.paragraphSpacing * 3 + TextRenderer.CHAR_SPACING + (GameGraphics.screenHeight > 180 ? 50 : 31) + GameManager.footerHeight) >> 1;
      UIFactory.createImageComponent(this, 0, TextRenderer.getLogoImage(), TextRenderer.getLogoImage().getWidth(), TextRenderer.getLogoImage().getHeight(), false, false);
      if (GameGraphics.screenHeight > 220) {
         super.nextComponentY += 15;
      } else if (GameGraphics.screenHeight > 180 && GameGraphics.screenHeight <= 220) {
         super.nextComponentY += 10;
      } else {
         super.nextComponentY += 5;
      }

      this.usernameInput = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Xubi ID", ":", null, null), 0, -1);
      super.nextComponentY += 5;
      this.passwordInput = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Mật khẩu", ":", null, null), 2, -1);
      super.nextComponentY += 5;
      this.confirmPasswordInput = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Nhập lại", ":", null, null), 2, -1);
      UIUtils.focusComponent(this, (UIComponent) this.usernameInput);
   }

   public final void returnToLoginScreen() {
      GameManager var1;
      (var1 = GameManager.getInstance()).addScreenToStack((Screen)var1.loginScreen);
      var1.switchToScreen(var1.loginScreen);
      var1.loginScreen.startSlideAnimation(1);
      var1.destroyScreen(this);
   }

   public final void performRegistration() {
      int var1;
      if ((var1 = TextValidator.validateUsername(this.usernameInput.getText())) == 1) {
         GameManager.getInstance().showNotification("ID phải trên 5 ký tự", (Image) null, 1);
         UIUtils.focusComponent(this, (UIComponent)this.usernameInput);
      } else if (var1 == 2) {
         GameManager.getInstance().showNotification("ID không được bắt đầu bằng số", (Image) null, 1);
         UIUtils.focusComponent(this, (UIComponent)this.usernameInput);
      } else if (var1 == 3) {
         GameManager.getInstance().showNotification("ID không được chứa ký tự đặc biệt", (Image) null, 1);
         UIUtils.focusComponent(this, (UIComponent)this.usernameInput);
      } else {
         for (int var2 = 0; var2 < RESERVED_USERNAMES.length; var2++) {
            if (RESERVED_USERNAMES[var2].equals(this.usernameInput.getText())) {
               GameManager.getInstance().showNotification("Xin chọn tên khác", (Image) null, 1);
               this.usernameInput.setText("");
               UIUtils.focusComponent(this, (UIComponent)this.usernameInput);
               return;
            }
         }

         if (this.passwordInput.getText().length() >= 6 && this.passwordInput.getText().length() <= 64) {
            if (!this.passwordInput.getText().equalsIgnoreCase(this.usernameInput.getText()) && (!this.passwordInput.getText().startsWith("12345") || this.passwordInput.getText().length() >= 7)) {
               if (!this.confirmPasswordInput.getText().equals("") && this.passwordInput.getText().equals(this.confirmPasswordInput.getText())) {
                  this.usernameInput.setText(this.usernameInput.getText().toLowerCase());
                  if (this.suggestedUsername != null && this.suggestedUsername.equals(this.usernameInput.getText())) {
                     this.finalUsername = this.suggestedUsername;
                  } else {
                     this.finalUsername = this.usernameInput.getText();
                  }

                  GameManager.getInstance().createSimpleDialog("Đang đăng ký..", null, new UIFactory(TextConstant.close(), new quyen_gx(this)), null).setLoadingVisible(true);
                  GameManager.getInstance().gameController = new quyen_gy(this);
               } else {
                  GameManager.getInstance().showNotification("Nhập lại mật khẩu", (Image) null, 1);
                  UIUtils.focusComponent(this, (UIComponent)this.confirmPasswordInput);
               }
            } else {
               GameManager.instance.showNotification("Mật khẩu không nên quá đơn giản. Vui lòng chọn mật khẩu khác.", (Image) null, 1);
               UIUtils.focusComponent(this, (UIComponent)this.passwordInput);
            }
         } else {
            GameManager.getInstance().showNotification("Mật khẩu phải trên 5 ký tự", (Image) null, 1);
            UIUtils.focusComponent(this, (UIComponent)this.passwordInput);
         }
      }
   }

   public static void setSuggestedUsername(RegistrationScreen var0, String var1) {
      var0.suggestedUsername = var1;
   }
}
