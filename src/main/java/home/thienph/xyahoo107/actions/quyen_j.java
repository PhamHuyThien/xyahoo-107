package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class quyen_j implements Action {
   private ContactListComponent a;

   public quyen_j(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.a(ContactListComponent.getSelectedItem(this.a).m, true);
   }
}
