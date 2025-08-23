package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_g implements Action {
    final ContactListComponent a;

    public quyen_g(ContactListComponent var1) {
        this.a = var1;
    }

    public void action() {
        String banMuonXoa = UIUtils.concatStrings("Bạn có muốn xóa ", ContactListComponent.getSelectedItem(this.a).c, "?", null);
        GameManager.getInstance().createSimpleDialog(banMuonXoa, null, new UIFactory("OK", new quyen_h(this)), GameManager.instance.createBackButton(TextConstant.close()));
        System.gc();
    }
}
