package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.components.ListComponent;
import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.media.BuddyContact;
import home.thienph.xyahoo107.data.media.BuddyListManager;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

import java.util.Vector;

public final class DownloadScreen extends Screen {
    public ListComponent downloadListComponent;
    public BuddyListManager buddyListManager;
    private final Vector contextMenuItems;
    public ContextMenu contextMenu;

    public DownloadScreen() {
        super.isScrollLocked = true;
        super.title = "Tải Về";
        this.downloadListComponent = new ListComponent(0, 0, screenWidth, screenHeight - GameManager.footerHeight);
        this.addComponent(this.downloadListComponent);
        UIUtils.focusComponent(this, this.downloadListComponent);
        this.buddyListManager = new BuddyListManager();
        this.downloadListComponent.setIconSettings(1, 10, 10);
        this.downloadListComponent.setDataSource(this.buddyListManager, 1, false);
        super.rightSoftkey = GameManager.createCloseButton(this, false, null);
        this.contextMenuItems = new Vector();
        this.contextMenuItems.addElement(new ButtonAction("Xem", new quyen_bf(this)));
        this.contextMenuItems.addElement(new ButtonAction("Xóa", new quyen_bg(this)));
        this.contextMenuItems.addElement(new ButtonAction("Xóa tất cả", new quyen_bh(this)));
        this.contextMenu = new ContextMenu(this.contextMenuItems);
        this.downloadListComponent.itemAction = new quyen_bi(this);
    }

    public void deleteAllDownloads() {
        int var1 = this.downloadListComponent.listItems.size();

        while (--var1 >= 0) {
            quyen_bj var2 = (quyen_bj) this.downloadListComponent.listItems.elementAt(var1);
            this.buddyListManager.removeContact(var2.c, 0L);
        }

        this.downloadListComponent.buildListItems();
    }

    public void deleteDownloadsByType(byte var1) {
        int var2 = 0;
        int var3 = this.downloadListComponent.listItems.size();

        while (--var3 >= 0) {
            BuddyContact var4 = ((quyen_bj) this.downloadListComponent.listItems.elementAt(var3)).i;
            if (var1 == 0) {
                if (var4.downloadType == 0) {
                    if (++var2 > 4) {
                        this.buddyListManager.removeContact(var4.username, 0L);
                    }
                }
            } else if (var4.downloadType == 1) {
                if (++var2 > 3) {
                    this.buddyListManager.removeContact(var4.username, 0L);
                }
            }
        }
    }
}
