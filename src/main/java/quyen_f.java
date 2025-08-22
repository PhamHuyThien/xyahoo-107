final class quyen_f implements Action {
   private ContactListComponent a;

   quyen_f(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      long var1 = ContactListComponent.getSelectedItem(this.a).m;
      Packet var3 = new Packet(5000019, 2);
      PacketUtils.writeLong(var1, var3);
      NetworkManager.sendPacket(var3);
   }
}
