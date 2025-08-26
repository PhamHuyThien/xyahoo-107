package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class ContactListClickMediaAction implements Action {
    private final ContactListComponent contactListComponent;

    public ContactListClickMediaAction(ContactListComponent var1) {
        this.contactListComponent = var1;
    }

    public void action() {
        PacketSender.h(ContactListComponent.getSelectedItem(this.contactListComponent).groupName);
    }
}
