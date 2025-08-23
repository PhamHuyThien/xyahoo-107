package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fz implements Action {
    private final GameManager a;

    public quyen_fz(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        this.a.cancelFileSend();
    }
}
