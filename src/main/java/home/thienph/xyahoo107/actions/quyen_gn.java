package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_gn implements Action {
    final GameManager a;
    private final String b;
    private final Action c;

    public quyen_gn(GameManager var1, String var2, Action var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void action() {
        this.a.closeDialog();
        Xuka.sendRequest(this.b, this.a.getSmsMessage(), new quyen_ev(this), new quyen_ew(this, this.c), false);
    }
}
