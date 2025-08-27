package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.PacketUtils;

public final class ContactListBlockAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListBlockAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        long contactId = ContactListComponent.getSelectedItem(this.contactListComponent).contactId;
        Packet packet = new Packet(5000019, 2);
        PacketUtils.writeLong(contactId, packet);
        NetworkManager.sendPacket(packet);
    }
}
