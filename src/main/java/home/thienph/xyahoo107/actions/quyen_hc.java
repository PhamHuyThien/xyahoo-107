package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.GameLobbyScreen;

public final class quyen_hc implements Action {
    public quyen_hc(GameLobbyScreen var1) {
    }

    public void action() {
        PacketSender.d();
    }
}
