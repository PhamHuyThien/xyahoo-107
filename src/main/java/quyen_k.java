final class quyen_k implements Action {
   private ContactListComponent a;

   quyen_k(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      PacketSender.a(ContactListComponent.getSelectedItem(this.a).m, false);
      if (FriendScreen.instance.isRequestPending(ContactListComponent.getSelectedItem(this.a).m)) {
         FriendScreen.instance.removeFromPendingList(ContactListComponent.getSelectedItem(this.a).m);
      }
   }
}
