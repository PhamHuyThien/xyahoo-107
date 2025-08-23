package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.connections.PacketSender;

public final class quyen_e implements Action {
   private ContactListComponent a;

   public quyen_e(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.h(ContactListComponent.getSelectedItem(this.a).c);
   }
}
