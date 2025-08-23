package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_ey implements Action {
    public quyen_ey(GameManager var1) {
    }

    public void action() {
        LoginScreen.showSettingsScreen();
    }
}
