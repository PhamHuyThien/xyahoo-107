package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ContactListComponent;
import home.thienph.xyahoo107.screens.FriendScreen;

public final class quyen_ir implements Action {
    private final ContactListComponent a;

    public quyen_ir(FriendScreen var1, ContactListComponent var2) {
        this.a = var2;
    }

    public void action() {
        this.a.toggleSelectAll();
    }
}
