final class quyen_ij implements Action {
   private final ListComponent a;

   quyen_ij(FriendScreen var1, ListComponent var2) {
      this.a = var2;
   }

   public final void action() {
      quyen_a.i(this.a.getSelectedItem().c);
   }
}
