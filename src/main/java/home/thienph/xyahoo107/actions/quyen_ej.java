package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.screens.LoginScreen;

public final class quyen_ej implements Action {
    public quyen_ej(LoginScreen var1) {
    }

    public void action() {
        NetworkManager.forceDisconnect = true;
        NetworkManager.forceDisconnect();
    }
}
