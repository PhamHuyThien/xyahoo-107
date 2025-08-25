package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class quyen_fj implements Action {
    private final GameManager a;
    private final String b;
    private final TextInputComponent c;
    private final DialogScreen d;

    public quyen_fj(GameManager var1, String var2, TextInputComponent var3, DialogScreen var4) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = var4;
    }

    public void action() {
        PacketSender.requestSendDataUIComponent(this.b, this.c.getText(), (byte) 0);
        this.a.removeScreen(this.d);
    }
}
