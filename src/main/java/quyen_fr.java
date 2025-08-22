final class quyen_fr implements Action {
   private GameManager a;

   quyen_fr(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      byte[] var1;
      if ((var1 = quyen_l.a().b()) == null) {
         this.a.closeDialog();
         this.a.d("Lỗi camera");
      } else {
         this.a.a(var1, UIUtils.generateTimestampString(".png"), true, this.a.fileManager);
      }
   }
}
