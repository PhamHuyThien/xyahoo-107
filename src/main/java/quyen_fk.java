final class quyen_fk implements Action {
   private GameManager a;
   private final TextInputComponent b;
   private final String c;
   private final DialogScreen d;

   quyen_fk(GameManager var1, TextInputComponent var2, String var3, DialogScreen var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void action() {
      if (!this.b.getText().equals("")) {
         DownloadData var1 = new DownloadData(this.c, "", 0, "", new int[0], 0, 0, null);
         quyen_a.a(this.c, this.b.getText(), (byte)1);
         if (this.a.yahooChat.contactList.getContactData().findDownload(this.c, null, 0L) == null) {
            this.a.yahooChat.contactList.getContactData().addDownloadToCategory(this.b.getText(), var1);
            this.a.yahooChat.contactList.refreshDisplayList();
            this.a.yahooChat.contactList.resetAnimation();
         }

         this.a.removeScreen(this.d);
      }
   }
}
