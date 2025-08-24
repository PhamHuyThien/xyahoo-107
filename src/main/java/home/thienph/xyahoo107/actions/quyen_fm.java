package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class quyen_fm implements Action {
    private final GameManager a;
    private final long b;
    private final DialogScreen c;

    public quyen_fm(GameManager var1, long var2, DialogScreen var4) {
        this.a = var1;
        this.b = var2;
        this.c = var4;
    }

    public void action() {
        PacketSender.requestReloadData(this.b, true);
        this.a.removeScreen(this.c);
    }
}
