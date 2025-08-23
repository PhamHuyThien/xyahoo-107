package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.CheckboxComponent;
import home.thienph.xyahoo107.components.DropdownComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class SettingClickCloseAction implements Action {
    private final CheckboxComponent ringCheckbox;
    private final boolean isRingCheckbox;
    private final CheckboxComponent soundCheckbox;
    private final boolean isSoundCheckbox;
    private final CheckboxComponent autoLoginCheckbox;
    private final boolean isAutoLoginCheckbox;
    private final CheckboxComponent autoLoginYahooCheckbox;
    private final boolean isAutoLoginYahooCheckbox;
    private final DropdownComponent keyboardSpeedChoice;
    private final int keyboardSpeedChoiceIndex;

    public SettingClickCloseAction(CheckboxComponent var1, boolean var2, CheckboxComponent var3, boolean var4, CheckboxComponent var5, boolean var6, CheckboxComponent var7, boolean var8, DropdownComponent var9, int var10) {
        this.ringCheckbox = var1;
        this.isRingCheckbox = var2;
        this.soundCheckbox = var3;
        this.isSoundCheckbox = var4;
        this.autoLoginCheckbox = var5;
        this.isAutoLoginCheckbox = var6;
        this.autoLoginYahooCheckbox = var7;
        this.isAutoLoginYahooCheckbox = var8;
        this.keyboardSpeedChoice = var9;
        this.keyboardSpeedChoiceIndex = var10;
    }

    public void action() {
        GameManager.instance.removeScreen(LoginScreen.getSettingsScreen());
        this.ringCheckbox.isChecked = this.isRingCheckbox;
        this.soundCheckbox.isChecked = this.isSoundCheckbox;
        this.autoLoginCheckbox.isChecked = this.isAutoLoginCheckbox;
        this.autoLoginYahooCheckbox.isChecked = this.isAutoLoginYahooCheckbox;
        this.keyboardSpeedChoice.setSelectedIndex(this.keyboardSpeedChoiceIndex);
    }
}
