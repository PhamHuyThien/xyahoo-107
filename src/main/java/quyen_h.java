final class quyen_h implements Action {
   private quyen_g a;

   quyen_h(quyen_g var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_g var1 = this.a;
      long var4 = ContactListComponent.getSelectedItem(this.a.a).m;
      Packet var3 = new Packet(5000024, 2);
      quyen_a.a(var4, var3);
      NetworkManager.sendPacket(var3);
   }
}
