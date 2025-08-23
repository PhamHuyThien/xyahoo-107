package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatRoomScreen;

public final class quyen_u implements Action {
    final ChatRoomScreen a;

    public quyen_u(ChatRoomScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.getInstance().createSimpleDialog("Bạn có muốn xóa phòng chat?", null, new ButtonAction("OK", new quyen_v(this)), GameManager.instance.createBackButton(TextConstant.close()));
        System.gc();
    }
}
