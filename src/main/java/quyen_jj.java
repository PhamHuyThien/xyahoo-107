final class quyen_jj implements Action {
   private YahooScreen a;

   quyen_jj(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      String var1 = quyen_hs.b(YahooScreen.getStatusMessageInput(this.a).getText().trim());
      int var2 = YahooScreen.getStatusDropdown(this.a).getSelectedIndex() == 0 ? 0 : 12;
      if (var1 != null && !var1.equals(YahooScreen.statusMessage)) {
         YahooScreen.updateStatusMessage(this.a, var1);
         YahooScreen.yahooStatus = 0;
         GameManager.showConnectionStatus = true;
      } else if (var2 != YahooScreen.yahooStatus) {
         if (var2 == 0) {
            if (var1 != null && var1.length() > 0) {
               YahooScreen.updateStatusMessage(this.a, var1);
            } else {
               quyen_a.a(0, 2);
            }

            YahooScreen.yahooStatus = 0;
            GameManager.showConnectionStatus = true;
         } else {
            quyen_a.a(12, 2);
            YahooScreen.yahooStatus = 12;
            GameManager.showConnectionStatus = true;
         }
      }

      GameManager.getInstance().removeScreen(YahooScreen.getStatusScreen(this.a));
   }
}
