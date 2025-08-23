package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_k implements Action {
    private final ContactListComponent a;

    public quyen_k(ContactListComponent var1) {
        this.a = var1;
    }

    public void action() {
        PacketSender.a(ContactListComponent.getSelectedItem(this.a).m, false);
        if (FriendScreen.instance.isRequestPending(ContactListComponent.getSelectedItem(this.a).m)) {
            FriendScreen.instance.removeFromPendingList(ContactListComponent.getSelectedItem(this.a).m);
        }
    }
}
