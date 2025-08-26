package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ListComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;

import java.util.Vector;

public final class quyen_ii implements Action {
    private final FriendScreen a;
    private final ListComponent b;

    public quyen_ii(FriendScreen var1, ListComponent var2) {
        this.a = var1;
        this.b = var2;
    }

    public void action() {
        String var1 = this.b.getSelectedItem().groupName;
        long var2 = this.b.getSelectedItem().contactId;
        Vector var4 = (Vector) this.a.offlineMessages.get(var1);
        this.a.offlineMessages.remove(var1);
        GameManager.instance.showChatWithMessages(var1, var4, var2);
        this.b.dataSource.removeContact(var1, 0L);
        this.b.buildListItems();
        this.a.updateOfflineMessageButton();
    }
}
