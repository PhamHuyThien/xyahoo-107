package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_hl implements Action {
   private ChatScreen a;
   private final boolean b;

   public quyen_hl(ChatScreen var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      if (this.b) {
         PacketSender.a(0L, ChatScreen.getYahooContactId(this.a), 2);
      } else {
         PacketSender.a(this.a.chatId, null, 1);
      }

      this.a.chatComponent.addPlayerMessage(this.b ? YahooScreen.originalUsername : FriendScreen.currentUserName, "BUZZ!", 0);
      GameManager.getInstance().vibrate();
      this.a.chatComponent.scrollToBottom();
   }
}
