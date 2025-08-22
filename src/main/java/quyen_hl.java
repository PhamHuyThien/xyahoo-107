final class quyen_hl implements Action {
   private ChatScreen a;
   private final boolean b;

   quyen_hl(ChatScreen var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      if (this.b) {
         quyen_a.a(0L, ChatScreen.getYahooContactId(this.a), 2);
      } else {
         quyen_a.a(this.a.chatId, null, 1);
      }

      this.a.chatComponent.addPlayerMessage(this.b ? YahooScreen.originalUsername : FriendScreen.currentUserName, "BUZZ!", 0);
      GameManager.getInstance().vibrate();
      this.a.chatComponent.scrollToBottom();
   }
}
