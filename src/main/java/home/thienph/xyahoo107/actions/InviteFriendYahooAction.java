package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class InviteFriendYahooAction implements Action {
    public InviteFriendYahooAction(YahooScreen yahooScreen) {
    }

    public void action() {
        NetworkManager.sendPacket(new Packet(33, 4));
    }
}
