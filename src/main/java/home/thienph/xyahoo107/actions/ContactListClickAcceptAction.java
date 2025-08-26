package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class ContactListClickAcceptAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListClickAcceptAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        PacketSender.approveOrRejectFriendRequest(ContactListComponent.getSelectedItem(this.contactListComponent).contactId, true);
    }
}
