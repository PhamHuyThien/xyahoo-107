package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

public final class ChatClickBuzzAction implements Action {
    private final ChatScreen chatScreen;
    private final boolean isYahooChat;

    public ChatClickBuzzAction(ChatScreen var1, boolean var2) {
        this.chatScreen = var1;
        this.isYahooChat = var2;
    }

    public void action() {
        if (this.isYahooChat) {
            PacketSender.requestSendDataUIComponent(0L, ChatScreen.getYahooContactId(this.chatScreen), 2);
        } else {
            PacketSender.requestSendDataUIComponent(this.chatScreen.chatId, null, 1);
        }

        this.chatScreen.chatComponent.addPlayerMessage(this.isYahooChat ? YahooScreen.originalUsername : FriendScreen.currentUserName, "BUZZ!", 0);
        GameManager.getInstance().vibrate();
        this.chatScreen.chatComponent.scrollToBottom();
    }
}
