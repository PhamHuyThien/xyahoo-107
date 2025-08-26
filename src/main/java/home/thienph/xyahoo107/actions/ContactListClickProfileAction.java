package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class ContactListClickProfileAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListClickProfileAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        PacketSender.i(ContactListComponent.getSelectedItem(this.contactListComponent).groupName);
    }
}
