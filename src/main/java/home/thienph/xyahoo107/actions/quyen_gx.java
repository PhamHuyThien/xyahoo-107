package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.screens.RegistrationScreen;

public final class quyen_gx implements Action {
    public quyen_gx(RegistrationScreen var1) {
    }

    public void action() {
        NetworkManager.forceDisconnect = true;
        NetworkManager.forceDisconnect();
    }
}
