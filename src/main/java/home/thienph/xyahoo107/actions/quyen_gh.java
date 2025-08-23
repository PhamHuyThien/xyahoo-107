package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class quyen_gh implements Action {
    private final String a;
    private final String b;
    private final DialogScreen c;

    public quyen_gh(GameManager var1, String var2, String var3, DialogScreen var4) {
        this.a = var2;
        this.b = var3;
        this.c = var4;
    }

    public void action() {
        PacketSender.b(this.a, this.b);
        GameManager.instance.removeScreen(this.c);
    }
}
