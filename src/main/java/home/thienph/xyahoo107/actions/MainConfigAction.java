package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class MainConfigAction implements Action {
    public MainConfigAction(GameManager var1) {
    }

    public void action() {
        LoginScreen.showSettingsScreen();
    }
}
