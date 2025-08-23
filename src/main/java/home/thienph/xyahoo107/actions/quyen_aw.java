package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.main.Xuka;
import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_aw implements Action {
    private final String a;
    private final String b;

    public quyen_aw(String var1, String var2) {
        this.a = var1;
        this.b = var2;
    }

    public void action() {
        GameManager.instance.showWrappedTextDialog("Vui lòng chờ");
        Xuka.sendRequest(this.a, this.b, null, null, true);
    }
}
