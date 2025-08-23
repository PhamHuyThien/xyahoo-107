package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.data.packet.Packet;
import home.thienph.xyahoo107.managers.NetworkManager;
import home.thienph.xyahoo107.utils.PacketUtils;

public final class quyen_f implements Action {
   private ContactListComponent a;

   public quyen_f(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      long var1 = ContactListComponent.getSelectedItem(this.a).m;
      Packet var3 = new Packet(5000019, 2);
      PacketUtils.writeLong(var1, var3);
      NetworkManager.sendPacket(var3);
   }
}
