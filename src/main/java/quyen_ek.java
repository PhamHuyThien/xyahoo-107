final class quyen_ek implements Action {
   private quyen_ec a;

   quyen_ek(quyen_ec var1) {
      this.a = var1;
   }

   public final void action() {
      System.gc();
      this.a.a.setText(this.a.a.getText().toLowerCase());
      FriendScreen.currentUserId = this.a.a.getText();
      FriendScreen.userStatus = this.a.d.isChecked ? 0 : 1;
      if ((GameManager.loginType = (byte)this.a.D.getSelectedIndex()) == 1) {
         String var1;
         if ((var1 = this.a.a.getText()).indexOf("@") == -1) {
            StringBuffer var2;
            (var2 = new StringBuffer(FriendScreen.currentUserId)).append("@yahoo.com");
            FriendScreen.currentUserId = var2.toString();
         }

         String var5 = var1;
         byte var3 = 0;
         if (var1.indexOf("@ymail") >= 0) {
            var3 = 1;
            var5 = var1.substring(0, var1.indexOf("@ymail"));
         } else if (var1.indexOf("@rocketmail") >= 0) {
            var3 = 2;
            var5 = var1.substring(0, var1.indexOf("@rocketmail"));
         } else if (var1.indexOf("@yahoo") >= 0) {
            var5 = var1.substring(0, var1.indexOf("@yahoo"));
         }

         Xuka.saveYahooID(var5);
         Xuka.saveYahooPassword(this.a.b.getText());
         Xuka.saveBooleanSetting("statusYahoo", this.a.d.isChecked);
         Xuka.saveYahooDomain(var3);
         if (GameManager.instance.yahooChat != null) {
            GameManager.instance.yahooChat.usernameInput.setText(var5);
            GameManager.instance.yahooChat.passwordInput.setText(this.a.b.getText());
            GameManager.instance.yahooChat.invisibleCheckbox.isChecked = this.a.d.isChecked;
            GameManager.instance.yahooChat.domainDropdown.setSelectedIndex(var3);
         }
      }

      Xuka.saveUserID(this.a.a.getText());
      Xuka.savePassword(this.a.b.getText());
      Xuka.saveIDType(this.a.D.getSelectedIndex());
      Xuka.saveBooleanSetting("status", this.a.d.isChecked);
      FriendScreen.currentUserName = FriendScreen.currentUserId;
      GameManager.getInstance().B();
      int var4;
      if ((var4 = GameManager.a(false)) != -1) {
         DownloadDataManager var6;
         if ((var6 = GameManager.loadBuddyList(false, FriendScreen.currentUserId)) != null) {
            GameManager.instance.friendManager.mainContactList.setContactData(var6, -1);
            GameManager.instance.friendManager.mainContactList.isLoading = false;
            GameManager.instance.friendManager.addAllFriendsToOnline();
            FriendScreen.currentUserTimestamp = GameManager.g(FriendScreen.currentUserId);
         } else {
            var4 = -1;
         }
      }

      String var7;
      FriendScreen.statusMessage = (var7 = Xuka.loadStringData(FriendScreen.currentUserId, false)) == null ? "" : var7;
      if (var7 != null && var7.length() > 0) {
         FriendScreen.updateStatusMessage(FriendScreen.statusMessage);
      }

      System.gc();
      GameGraphics.instance.initializeConnection();
      PacketSender.a(FriendScreen.currentUserId, this.a.b.getText(), FriendScreen.userStatus, 1, var4, GameManager.loginType, FriendScreen.statusMessage);
   }
}
