package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.constants.TextConstant;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

public final class ContactListDeleteAction implements Action {
    final ContactListComponent a;

    public ContactListDeleteAction(ContactListComponent var1) {
        this.a = var1;
    }

    public void action() {
        String banMuonXoa = UIUtils.concatStrings("Bạn có muốn xóa ", ContactListComponent.getSelectedItem(this.a).groupName, "?", null);
        GameManager.getInstance().createSimpleDialog(banMuonXoa, null, new ButtonAction("OK", new quyen_h(this)), GameManager.instance.createBackButton(TextConstant.close()));
        System.gc();
    }
}
