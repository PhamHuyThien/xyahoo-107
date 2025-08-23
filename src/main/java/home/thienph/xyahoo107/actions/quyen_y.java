package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_y implements Action {
    private final ChatRoomScreen a;

    public quyen_y(ChatRoomScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.textInputComponent.rightSoftKey = ChatRoomScreen.getBackSoftkey(this.a);
    }
}
