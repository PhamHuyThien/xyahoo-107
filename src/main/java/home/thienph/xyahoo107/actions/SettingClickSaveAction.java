package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.CheckboxComponent;
import home.thienph.xyahoo107.components.DropdownComponent;
import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class SettingClickSaveAction implements Action {
    private final CheckboxComponent autoLoginCheckbox;
    private final CheckboxComponent autoLoginYahooCheckbox;
    private final DropdownComponent keyboardSpeedChoice;
    private final CheckboxComponent ringCheckbox;
    private final CheckboxComponent soundCheckbox;

    public SettingClickSaveAction(CheckboxComponent var1, CheckboxComponent var2, DropdownComponent var3, CheckboxComponent var4, CheckboxComponent var5) {
        this.autoLoginCheckbox = var1;
        this.autoLoginYahooCheckbox = var2;
        this.keyboardSpeedChoice = var3;
        this.ringCheckbox = var4;
        this.soundCheckbox = var5;
    }

    public void action() {
        if (GameManager.instance.loginScreen != null) {
            GameManager.instance.loginScreen.startSlideAnimation(1);
        } else {
            GameManager.instance.mainMenu.startSlideAnimation(1);
        }

        GameManager.instance.removeScreen(LoginScreen.getSettingsScreen());
        if (GameManager.autoLogin != this.autoLoginCheckbox.isChecked) {
            GameManager.autoLogin = this.autoLoginCheckbox.isChecked;
            Xuka.saveBooleanSetting("atlog", GameManager.autoLogin);
        }

        if (GameManager.autoLoginYahoo != this.autoLoginYahooCheckbox.isChecked) {
            GameManager.autoLoginYahoo = this.autoLoginYahooCheckbox.isChecked;
            Xuka.saveBooleanSetting("atlogY", GameManager.autoLoginYahoo);
        }

        if (TextInputComponent.inputModeIndex != this.keyboardSpeedChoice.getSelectedIndex()) {
            Xuka.saveCaret(TextInputComponent.inputModeIndex = this.keyboardSpeedChoice.getSelectedIndex());
        }

        if (GameManager.vibrateEnabled != this.ringCheckbox.isChecked) {
            GameManager.vibrateEnabled = this.ringCheckbox.isChecked;
            Xuka.saveBooleanSetting("vibrate", GameManager.vibrateEnabled);
        }

        if (GameManager.soundEnabled == this.soundCheckbox.isChecked) {
            GameManager.soundEnabled = !this.soundCheckbox.isChecked;
            Xuka.saveBooleanSetting("sound", GameManager.soundEnabled);
        }
    }
}
