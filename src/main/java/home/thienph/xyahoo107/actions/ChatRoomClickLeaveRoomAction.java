package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class ChatRoomClickLeaveRoomAction implements Action {
    final ChatRoomScreen chatRoomScreen;

    public ChatRoomClickLeaveRoomAction(ChatRoomScreen var1) {
        this.chatRoomScreen = var1;
    }

    public void action() {
        GameManager.getInstance().createSimpleDialog("Bạn có muốn thoát phòng chat?", null, new ButtonAction("OK", new ChatRoomAcceptLeaveRoomAction(this)), GameManager.instance.createBackButton(TextConstant.close()));
        System.gc();
    }
}
