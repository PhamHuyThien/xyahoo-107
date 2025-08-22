final class quyen_ir implements Action {
   private final ContactListComponent a;

   quyen_ir(FriendScreen var1, ContactListComponent var2) {
      this.a = var2;
   }

   public final void action() {
      this.a.toggleSelectAll();
   }
}
