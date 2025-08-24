package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;
import home.thienph.xyahoo107.screens.FriendScreen;

final class quyen_iq implements Action {
    private final quyen_ip a;
    private final long[] b;
    private final DialogScreen c;

    quyen_iq(quyen_ip var1, long[] var2, DialogScreen var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void action() {
        quyen_ip var1 = this.a;
        PacketSender.requestReloadData(this.b, FriendScreen.getActiveTextInput(this.a.a).getText());
        var1 = this.a;
        FriendScreen.setActiveTextInput(this.a.a, (TextInputComponent) null);
        GameManager.instance.removeScreen(this.c);
        System.gc();
    }
}
