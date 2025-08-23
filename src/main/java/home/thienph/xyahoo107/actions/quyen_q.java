package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_q implements Action {
    final ChatRoomScreen a;

    public quyen_q(ChatRoomScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().createSimpleDialog("Bạn có muốn thoát phòng chat?", null, new ButtonAction("OK", new quyen_x(this)), GameManager.instance.createBackButton(TextConstant.close()));
        System.gc();
    }
}
