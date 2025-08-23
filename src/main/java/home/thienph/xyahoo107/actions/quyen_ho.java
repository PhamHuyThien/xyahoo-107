package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_ho implements Action {
    private final String a;

    public quyen_ho(ChatScreen var1, String var2) {
        this.a = var2;
    }

    public void action() {
        PacketSender.i(this.a);
    }
}
