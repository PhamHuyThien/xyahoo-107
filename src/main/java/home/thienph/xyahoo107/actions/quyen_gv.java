package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.RegistrationScreen;

public final class quyen_gv implements Action {
    private final RegistrationScreen a;

    public quyen_gv(RegistrationScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.returnToLoginScreen();
    }
}
