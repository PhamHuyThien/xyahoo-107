import javax.microedition.lcdui.Image;

public class UIFactory {
   public String text;
   public Action action;
   public ContextMenu parentContainer;

   public UIFactory(String var1, Action var2) {
      this.text = var1;
      this.action = var2;
   }

   public static TextInputComponent createPopupDialog(Screen var0, String var1, int var2, Action var3) {
      TextInputComponent var5;
      (var5 = new TextInputComponent("", var2)).setBounds(10, GameGraphics.screenHeight + 1000, Screen.screenWidth - 21, FontRenderer.paragraphSpacing);
      var5.showHelpText(var1);
      var5.alternateAction = var3;
      var5.isVisible = false;
      var5.leftSoftKey = GameManager.createCloseButton();
      UIFactory var4 = new UIFactory(TextConstant.close(), new quyen_cl(var0, var5));
      var5.rightSoftKey = var4;
      var5.onCompleteAction = new quyen_cm(var5, var4);
      var5.middleSoftKey = new UIFactory("OK", new quyen_cn(var5, var0));
      var0.addComponent(var5);
      return var5;
   }

   public static TextInputComponent createTextInput(DialogScreen var0, String var1, int var2) {
      return createLabeledTextInput(var0, var1, 0, -1);
   }

   public static TextInputComponent createTextInputWithID(DialogScreen var0, String var1, int var2, int var3) {
      TextComponent var5;
      (var5 = new TextComponent(var1, UIUtils.leftColumnX, var0.nextComponentY, FontRenderer.fontHeight, -1)).id = -1;
      int var4 = var0.nextComponentY;
      var0.addComponent(var5);
      var0.nextComponentY = var4 - 3;
      TextInputComponent var6;
      (var6 = new TextInputComponent()).selectedIndex = -1;
      var6.setBounds(UIUtils.rightColumnX, var0.nextComponentY, UIUtils.rightColumnWidth, FontRenderer.paragraphSpacing);
      var5.width = FontRenderer.getTextWidth(var1) + 5;
      var6.setInputConstraint(var2);
      var0.addComponent(var6);
      return var6;
   }

   public static TextInputComponent createLabeledTextInput(DialogScreen var0, String var1, int var2, int var3) {
      TextComponent var5;
      (var5 = new TextComponent(var1, var0.dialogX, var0.nextComponentY, FontRenderer.fontHeight, var3)).id = -1;
      var0.addComponent(var5);
      TextInputComponent var4;
      (var4 = new TextInputComponent()).selectedIndex = var3;
      var4.setBounds(var0.dialogX, var0.nextComponentY, var0.dialogWidth, FontRenderer.paragraphSpacing);
      var4.setInputConstraint(var2);
      var4.textInputHandler = var5;
      var0.addComponent(var4);
      var0.nextComponentY += 2;
      return var4;
   }

   public static DropdownComponent createChoiceBox(DialogScreen var0, String var1, String[] var2) {
      return createChoiceBoxWithID(var0, var1, var2, -1);
   }

   public static DropdownComponent createChoiceBoxWithID(DialogScreen var0, String var1, String[] var2, int var3) {
      TextComponent var4 = new TextComponent(var1, var0.dialogX, var0.nextComponentY, FontRenderer.fontHeight, var3);
      var0.addComponent(var4);
      DropdownComponent var5;
      (var5 = new DropdownComponent(var2, var0.dialogX, var0.nextComponentY, var0.dialogWidth, FontRenderer.paragraphSpacing)).selectedIndex = var3;
      var5.textInputHandler = var4;
      var0.addComponent(var5);
      var0.nextComponentY += 2;
      return var5;
   }

   public static TextComponent createSpacer(DialogScreen var0, int var1) {
      TextComponent var2;
      (var2 = new TextComponent("", 5, var0.nextComponentY, 10)).selectedIndex = var1;
      var2.width = Screen.screenWidth - var2.posX - 5;
      var0.addComponent(var2);
      return var2;
   }

   public static TextComponent createLabel(String var0, DialogScreen var1, int var2) {
      if (var0.equals("")) {
         return createSpacer(var1, -1);
      } else {
         TextComponent var3;
         (var3 = new TextComponent(var0, var1.dialogX, var1.nextComponentY, FontRenderer.fontHeight + 2)).selectedIndex = -1;
         var1.addComponent(var3);
         return var3;
      }
   }

   public static TextComponent[] createWrappedText(String var0, DialogScreen var1, int var2, int var3, boolean var4, boolean var5) {
      String[] var8;
      TextComponent[] var6 = new TextComponent[(var8 = FontRenderer.wrapTextToLines(var0, Screen.screenWidth - 10)).length];

      for (int var7 = 0; var7 < var8.length; var7++) {
         var6[var7] = new TextComponent(var8[var7], 5, var1.nextComponentY, FontRenderer.fontHeight + 2);
         var6[var7].selectedIndex = var2;
         var6[var7].isVisible = true;
         var6[var7].textColor = new Integer(var3);
         var6[var7].isVisible = var4 && !var0.trim().equals("");
         var1.addComponent(var6[var7]);
      }

      return var6;
   }

   public static ButtonComponent createButton(DialogScreen var0, String var1, Action var2, int var3, int var4) {
      int var5 = FontRenderer.getTextWidth(var1) + 20;
      if (var4 < var5) {
         var4 = var5;
      }

      ButtonComponent var6;
      (var6 = new ButtonComponent(var1, var4, FontRenderer.fontHeight + 10)).posX = Screen.screenWidth - var4 >> 1;
      var6.posY = var3 + 3;
      var6.buttonAction = var2;
      var6.middleSoftKey.action = var2;
      if (var0 != null) {
         var0.addComponent(var6);
      }

      var0.nextComponentY += 3;
      return var6;
   }

   public static TextLinkComponent createCustomButton(DialogScreen var0, String var1, int var2, Action var3, int var4, int var5, int var6) {
      TextLinkComponent var7;
      (var7 = new TextLinkComponent(var1, var4, var5, FontRenderer.fontHeight + 4)).selectedIndex = var2;
      var7.setLinkAction(var3);
      if (var0 != null) {
         var0.addComponent(var7);
      }

      return var7;
   }

   public static CheckboxComponent createCheckbox(DialogScreen var0, String var1, boolean var2) {
      int var3 = FontRenderer.getTextWidth(var1) + 13 + 4;
      CheckboxComponent var4;
      (var4 = new CheckboxComponent(var1, var0.dialogX, var0.nextComponentY, var3, FontRenderer.fontHeight + 4)).isChecked = var2;
      if (var0 != null) {
         var0.addComponent(var4);
      }

      return var4;
   }

   public static TextComponent[] createSimpleText(DialogScreen var0, String var1) {
      return createWrappedText(var1, var0, -1, 16777215, true, true);
   }

   public static ImageComponent createImageComponent(DialogScreen var0, int var1, Image var2, int var3, int var4, boolean var5, boolean var6) {
      ImageComponent var7;
      (var7 = new ImageComponent()).setSize(var3, var4);
      var7.isVisible = var5;
      if (var2 != null) {
         var7.setCustomImage(var2);
      } else {
         var7.setSingleImageId(var1);
      }

      var7.setPosition(Screen.screenWidth - var3 >> 1, var0.nextComponentY == 6 ? var0.nextComponentY : var0.nextComponentY + 2);
      var7.hasBorder = var6;
      var0.addComponent(var7);
      var0.nextComponentY += 2;
      return var7;
   }
}
