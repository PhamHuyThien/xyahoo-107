final class quyen_ip implements Action {
   final FriendScreen a;
   private final ContactListComponent b;
   private final DialogScreen c;

   quyen_ip(FriendScreen var1, ContactListComponent var2, DialogScreen var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void action() {
      long[] var1;
      if ((var1 = this.b.getSelectedContactIds()) != null) {
         FriendScreen.setActiveTextInput(this.a, UIFactory.createPopupDialog(this.c, "Nhập nội dung tin nhắn", 0, new quyen_iq(this, var1, this.c)));
         UIUtils.showTextInput(this.c, FriendScreen.getActiveTextInput(this.a));
      } else {
         GameManager.instance.d("Vui lòng chọn ID");
      }
   }
}
