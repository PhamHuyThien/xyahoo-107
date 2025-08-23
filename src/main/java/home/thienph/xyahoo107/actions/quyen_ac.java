package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_ac implements Action {
    private final ChatRoomScreen a;

    public quyen_ac(ChatRoomScreen var1) {
        this.a = var1;
    }

    public void action() {
        PacketSender.b(this.a.roomId, 4811);
    }
}
