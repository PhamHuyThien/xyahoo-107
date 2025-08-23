package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.screens.LoginScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_el implements Action {
    final LoginScreen loginScreen;

    public quyen_el(LoginScreen var1) {
        this.loginScreen = var1;
    }

    public void action() {
        if (this.loginScreen.c == null) {
            this.loginScreen.c = UIFactory.createPopupDialog(this.loginScreen, "Gửi góp ý", 0, new quyen_em(this));
        }

        UIUtils.showTextInput(this.loginScreen, this.loginScreen.c);
    }
}
