package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

import javax.microedition.lcdui.Image;

public final class FriendAddFriendAction implements Action {
    private final ChatScreen chatScreen;
    private final boolean b;
    private final String c;
    private final String d;

    public FriendAddFriendAction(ChatScreen var1, boolean var2, String var3, String var4) {
        this.chatScreen = var1;
        this.b = var2;
        this.c = var3;
        this.d = var4;
    }

    public void action() {
        if (this.b) {
            GameManager.instance.yahooChat.showAddFriendDialog(this.c);
        } else {
            if (!GameManager.instance.friendScreen.isUserOnline(this.chatScreen.chatId) && !GameManager.instance.friendScreen.isUserBlocked(this.chatScreen.chatId) && !GameManager.instance.friendScreen.isRequestPending(this.chatScreen.chatId)) {
                PacketSender.requestAddFriend(this.d);
                GameManager.getInstance().showNotification("Đã gửi yêu cầu kết bạn đến " + this.d, (Image) null, 1);
            } else {
                GameManager.getInstance().showWrappedTextDialog("ID đã tồn tại trong các danh sách: bạn bè, từ chối hoặc chờ kết bạn.");
            }

            ChatScreen.getMenuItems(this.chatScreen).removeElementAt(2);
        }
    }
}
