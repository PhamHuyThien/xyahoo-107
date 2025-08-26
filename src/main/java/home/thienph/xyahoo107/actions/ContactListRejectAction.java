package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class ContactListRejectAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListRejectAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        PacketSender.approveOrRejectFriendRequest(ContactListComponent.getSelectedItem(this.contactListComponent).contactId, false);
        if (FriendScreen.instance.isRequestPending(ContactListComponent.getSelectedItem(this.contactListComponent).contactId)) {
            FriendScreen.instance.removeFromPendingList(ContactListComponent.getSelectedItem(this.contactListComponent).contactId);
        }
    }
}
