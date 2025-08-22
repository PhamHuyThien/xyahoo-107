import javax.microedition.lcdui.Image;

public final class quyen_gu extends DialogScreen {
   private static String[] D = new String[]{"admin", "root", "system", "xuka", "yahoo"};
   public TextInputComponent a;
   public TextInputComponent b;
   private TextInputComponent E;
   private String F;
   public String c;
   public String d;

   public quyen_gu() {
      super.title = "Đăng Ký";
      super.leftSoftkey = new UIFactory(quyen_cr.c(), new quyen_gv(this));
      super.centerSoftkey = new UIFactory("Đăng ký", new quyen_gw(this));
   }

   public final void a() {
      this.removeAllComponents();
      this.a = null;
      this.b = null;
      this.E = null;
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

      this.a = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Xubi ID", ":", null, null), 0, -1);
      super.nextComponentY += 5;
      this.b = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Mật khẩu", ":", null, null), 2, -1);
      super.nextComponentY += 5;
      this.E = UIFactory.createTextInputWithID(this, UIUtils.concatStrings("Nhập lại", ":", null, null), 2, -1);
      UIUtils.focusComponent(this, (UIComponent)this.a);
   }

   protected final void h() {
      GameManager var1;
      (var1 = GameManager.getInstance()).addScreenToStack((Screen)var1.loginScreen);
      var1.e(var1.loginScreen);
      var1.loginScreen.startSlideAnimation(1);
      var1.destroyScreen(this);
   }

   public final void i() {
      int var1;
      if ((var1 = TextValidator.validateUsername(this.a.getText())) == 1) {
         GameManager.getInstance().showNotification("ID phải trên 5 ký tự", (Image) null, 1);
         UIUtils.focusComponent(this, (UIComponent)this.a);
      } else if (var1 == 2) {
         GameManager.getInstance().showNotification("ID không được bắt đầu bằng số", (Image) null, 1);
         UIUtils.focusComponent(this, (UIComponent)this.a);
      } else if (var1 == 3) {
         GameManager.getInstance().showNotification("ID không được chứa ký tự đặc biệt", (Image) null, 1);
         UIUtils.focusComponent(this, (UIComponent)this.a);
      } else {
         for (int var2 = 0; var2 < D.length; var2++) {
            if (D[var2].equals(this.a.getText())) {
               GameManager.getInstance().showNotification("Xin chọn tên khác", (Image) null, 1);
               this.a.setText("");
               UIUtils.focusComponent(this, (UIComponent)this.a);
               return;
            }
         }

         if (this.b.getText().length() >= 6 && this.b.getText().length() <= 64) {
            if (!this.b.getText().equalsIgnoreCase(this.a.getText()) && (!this.b.getText().startsWith("12345") || this.b.getText().length() >= 7)) {
               if (!this.E.getText().equals("") && this.b.getText().equals(this.E.getText())) {
                  this.a.setText(this.a.getText().toLowerCase());
                  if (this.F != null && this.F.equals(this.a.getText())) {
                     this.d = this.F;
                  } else {
                     this.d = this.a.getText();
                  }

                  GameManager.getInstance().a("Đang đăng ký..", null, new UIFactory(quyen_cr.c(), new quyen_gx(this)), null).a(true);
                  GameManager.getInstance().gameController = new quyen_gy(this);
               } else {
                  GameManager.getInstance().showNotification("Nhập lại mật khẩu", (Image) null, 1);
                  UIUtils.focusComponent(this, (UIComponent)this.E);
               }
            } else {
               GameManager.instance.showNotification("Mật khẩu không nên quá đơn giản. Vui lòng chọn mật khẩu khác.", (Image) null, 1);
               UIUtils.focusComponent(this, (UIComponent)this.b);
            }
         } else {
            GameManager.getInstance().showNotification("Mật khẩu phải trên 5 ký tự", (Image) null, 1);
            UIUtils.focusComponent(this, (UIComponent)this.b);
         }
      }
   }

   static void a(quyen_gu var0, String var1) {
      var0.F = var1;
   }
}
