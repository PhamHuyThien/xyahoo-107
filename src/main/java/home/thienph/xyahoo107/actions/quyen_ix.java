package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;
import home.thienph.xyahoo107.screens.FriendScreen;

final class quyen_ix implements Action {
    private final FriendClickChatWithAction a;

    quyen_ix(FriendClickChatWithAction var1) {
        this.a = var1;
    }

    public void action() {
        String var5 = FriendScreen.getActiveTextInput(this.a.friendScreen).getText().trim();
        ChatScreen var2;
        if ((var2 = (ChatScreen) GameManager.instance.setActiveScreen(var5)) != null) {
            var2.startSlideAnimation(1);
            GameManager.instance.switchToScreenByTitle(var5);
        } else {
            long var3;
            if ((var3 = FriendScreen.instance.getUserTimestampById(var5)) == 0L) {
                PacketSender.c(var5);
                GameManager.instance.isLoading = true;
            } else {
                (var2 = new ChatScreen(var5, false, null, null)).chatTitle = var5;
                var2.setChatId(var3);
                var2.startSlideAnimation(1);
                GameManager.instance.addScreenToStack(var2);
                GameManager.instance.switchToScreenByTitle(var2.title);
            }
        }

        System.gc();
    }
}
