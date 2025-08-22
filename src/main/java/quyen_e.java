final class quyen_e implements Action {
   private ContactListComponent a;

   quyen_e(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.h(ContactListComponent.getSelectedItem(this.a).c);
   }
}
