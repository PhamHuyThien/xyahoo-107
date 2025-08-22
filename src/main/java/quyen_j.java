final class quyen_j implements Action {
   private ContactListComponent a;

   quyen_j(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_a.a(ContactListComponent.getSelectedItem(this.a).m, true);
   }
}
