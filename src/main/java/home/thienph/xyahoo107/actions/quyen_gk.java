package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_gk implements Action {
    private final GameManager a;

    public quyen_gk(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.resetToLoginScreen(this.a);
    }
}
