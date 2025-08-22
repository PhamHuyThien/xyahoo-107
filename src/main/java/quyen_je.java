final class quyen_je implements Action
{
   private YahooScreen a;
   private final TextInputComponent b;
   private final TextInputComponent c;
   private final DialogScreen d;

   quyen_je(final YahooScreen a, final TextInputComponent b, final TextInputComponent c, final DialogScreen d) {
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
   }

   public final void action() {
      final String lowerCase = this.b.getText().trim().toLowerCase();
      String trim = this.c.getText().trim();
      if (lowerCase.equals("")) {
         UIUtils.focusComponent(this.d, (UIComponent)this.b);
         return;
      }
      if (trim.equals("")) {
         UIUtils.focusComponent(this.d, (UIComponent)this.c);
         return;
      }
      final DownloadDataManager a = GameManager.instance.yahooChat.contactList.getContactData();
      final String s = trim;
      final DownloadDataManager DownloadDataManager = a;
      int i = a.downloadCategories.size() - 1;
      while (true) {
         while (i >= 0) {
             DownloadCategory DownloadCategory = (DownloadCategory) DownloadDataManager.downloadCategories.elementAt(i);
            if (DownloadCategory.getCategoryId().toLowerCase().equals(s.toLowerCase())) {
               final String a2;
               final String s2 = a2 = DownloadCategory.getCategoryId();
               final String s3 = a2;
               if (s2 != null) {
                  trim = s3;
               }
               if (GameManager.instance.yahooChat.contactList.getContactData().findDownload(lowerCase, null, 0L) != null) {
                  GameManager.instance.d("ID đã tồn tại.");
                  return;
               }
               quyen_a.g(lowerCase, trim);
               this.a.contactList.contactData.addDownloadToCategory(trim, new DownloadData(lowerCase, "", 0, "", new int[0], 0, 0, null));
               this.a.contactList.refreshDisplayList();
               this.a.contactList.resetAnimation();
               GameManager.instance.removeScreen(this.d);
               return;
            }
            else {
               --i;
            }
         }
         String a2;
         final String s2 = a2 = null;
         continue;
      }
   }
}
