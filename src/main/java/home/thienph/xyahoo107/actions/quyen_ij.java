package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ListComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ij implements Action {
    private final ListComponent a;

    public quyen_ij(FriendScreen var1, ListComponent var2) {
        this.a = var2;
    }

    public void action() {
        PacketSender.i(this.a.getSelectedItem().groupName);
    }
}
