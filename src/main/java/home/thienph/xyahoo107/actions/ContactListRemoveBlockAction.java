package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.PacketUtils;

public final class ContactListRemoveBlockAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListRemoveBlockAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        long var1 = ContactListComponent.getSelectedItem(this.contactListComponent).contactId;
        Packet var3 = new Packet(5000020, 2);
        PacketUtils.writeLong(var1, var3);
        NetworkManager.sendPacket(var3);
    }
}
