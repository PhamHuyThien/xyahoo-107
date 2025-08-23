package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hn implements Action {
    private final String a;

    public quyen_hn(ChatScreen var1, String var2) {
        this.a = var2;
    }

    public void action() {
        PacketSender.h(this.a);
    }
}
