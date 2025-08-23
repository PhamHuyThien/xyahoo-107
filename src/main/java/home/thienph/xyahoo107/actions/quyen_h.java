package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.PacketUtils;

final class quyen_h implements Action {
    private final quyen_g a;

    quyen_h(quyen_g var1) {
        this.a = var1;
    }

    public void action() {
        quyen_g var1 = this.a;
        long var4 = ContactListComponent.getSelectedItem(this.a.a).m;
        Packet var3 = new Packet(5000024, 2);
        PacketUtils.writeLong(var4, var3);
        NetworkManager.sendPacket(var3);
    }
}
