final class quyen_i implements Action {
   private ContactListComponent a;

   quyen_i(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      long var1 = ContactListComponent.getSelectedItem(this.a).m;
      Packet var3 = new Packet(5000020, 2);
      quyen_a.a(var1, var3);
      NetworkManager.sendPacket(var3);
   }
}
