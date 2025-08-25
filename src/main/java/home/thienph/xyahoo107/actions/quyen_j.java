package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class quyen_j implements Action {
    private final ContactListComponent a;

    public quyen_j(ContactListComponent var1) {
        this.a = var1;
    }

    public void action() {
        PacketSender.requestSendDataUIComponent(ContactListComponent.getSelectedItem(this.a).timestamp, true);
    }
}
