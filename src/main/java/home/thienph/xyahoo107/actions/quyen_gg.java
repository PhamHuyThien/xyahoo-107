package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_gg implements Action {
    private final GameManager a;
    private final String b;
    private final String c;
    private final long d;

    public quyen_gg(GameManager var1, String var2, String var3, long var4) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = var4;
    }

    public void action() {
        ChatRoomScreen var1;
        PacketSender.d((var1 = (ChatRoomScreen) this.a.setActiveScreen(this.a.currentChatRoom)).roomId);
        this.a.removeScreen(var1);
        this.a.joinChatRoom(this.b, this.c, this.d);
    }
}
