package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.CheckboxComponent;
import home.thienph.xyahoo107.components.DropdownComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_eg implements Action {
   private final CheckboxComponent a;
   private final CheckboxComponent b;
   private final DropdownComponent c;
   private final CheckboxComponent d;
   private final CheckboxComponent e;

   public quyen_eg(CheckboxComponent var1, CheckboxComponent var2, DropdownComponent var3, CheckboxComponent var4, CheckboxComponent var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final void action() {
      if (GameManager.instance.loginScreen != null) {
         GameManager.instance.loginScreen.startSlideAnimation(1);
      } else {
         GameManager.instance.mainMenu.startSlideAnimation(1);
      }

      GameManager.instance.removeScreen(LoginScreen.getSettingsScreen());
      if (GameManager.autoLogin != this.a.isChecked) {
         GameManager.autoLogin = this.a.isChecked;
         Xuka.saveBooleanSetting("atlog", GameManager.autoLogin);
      }

      if (GameManager.autoLoginYahoo != this.b.isChecked) {
         GameManager.autoLoginYahoo = this.b.isChecked;
         Xuka.saveBooleanSetting("atlogY", GameManager.autoLoginYahoo);
      }

      if (TextInputComponent.inputModeIndex != this.c.getSelectedIndex()) {
         Xuka.saveCaret(TextInputComponent.inputModeIndex = this.c.getSelectedIndex());
      }

      if (GameManager.vibrateEnabled != this.d.isChecked) {
         GameManager.vibrateEnabled = this.d.isChecked;
         Xuka.saveBooleanSetting("vibrate", GameManager.vibrateEnabled);
      }

      if (GameManager.soundEnabled != !this.e.isChecked) {
         GameManager.soundEnabled = !this.e.isChecked;
         Xuka.saveBooleanSetting("sound", GameManager.soundEnabled);
      }
   }
}
