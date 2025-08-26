package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class ChatClickProfileAction implements Action {
    private final String chatTitle;

    public ChatClickProfileAction(ChatScreen var1, String var2) {
        this.chatTitle = var2;
    }

    public void action() {
        PacketSender.i(this.chatTitle);
    }
}
