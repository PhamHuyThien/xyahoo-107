package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.screens.GameLobbyScreen;

public final class quyen_hb implements Action {
    private final GameLobbyScreen a;

    public quyen_hb(GameLobbyScreen var1) {
        this.a = var1;
    }

    public void action() {
        NetworkManager.sendPacket(new Packet(5000012, 39));
    }
}
