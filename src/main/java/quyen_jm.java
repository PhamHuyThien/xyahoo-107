final class quyen_jm implements Action {
   final YahooScreen a;

   quyen_jm(YahooScreen var1) {
      this.a = var1;
   }

   public final void action() {
      if (!YahooScreen.checkConnectionReady(this.a)) {
         if (this.a.isSearchMode) {
            this.a.searchInput.setText("");
            this.a.contactList.setSearchFilter("");
            YahooScreen.exitSearchMode(this.a);
         }

         if (YahooScreen.getActiveTextInput(this.a) == null) {
            YahooScreen.setActiveTextInput(this.a, UIFactory.createPopupDialog(this.a, "Xin nhập Yahoo! ID", 0, new quyen_jn(this)));
         }

         this.a.addComponent(YahooScreen.getActiveTextInput(this.a));
         UIUtils.showTextInput(this.a, YahooScreen.getActiveTextInput(this.a));
      }
   }
}
