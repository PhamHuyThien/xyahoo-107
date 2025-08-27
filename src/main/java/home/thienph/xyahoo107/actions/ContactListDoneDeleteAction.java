package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.PacketUtils;

final class ContactListDoneDeleteAction implements Action {
    private final ContactListDeleteAction contactListDeleteAction;

    ContactListDoneDeleteAction(ContactListDeleteAction contactListDeleteAction) {
        this.contactListDeleteAction = contactListDeleteAction;
    }

    public void action() {
        ContactListDeleteAction var1 = this.contactListDeleteAction;
        long contactId = ContactListComponent.getSelectedItem(this.contactListDeleteAction.contactListComponent).contactId;
        Packet packet = new Packet(5000024, 2);
        PacketUtils.writeLong(contactId, packet);
        NetworkManager.sendPacket(packet);
    }
}
