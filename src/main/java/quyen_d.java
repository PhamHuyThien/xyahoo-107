final class quyen_d implements Action {
   private ContactListComponent a;

   quyen_d(ContactListComponent var1) {
      this.a = var1;
   }

   public final void action() {
      quyen_a.i(ContactListComponent.getSelectedItem(this.a).c);
   }
}
