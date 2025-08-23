package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class quyen_d implements Action {
    private final ContactListComponent a;

    public quyen_d(ContactListComponent var1) {
        this.a = var1;
    }

    public void action() {
        PacketSender.i(ContactListComponent.getSelectedItem(this.a).c);
    }
}
