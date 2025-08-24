package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.*;
import home.thienph.xyahoo107.components.ListComponent;
import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.data.media.BuddyGroupList;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

import java.util.Vector;

public final class DownloadScreen extends Screen {
    public ListComponent downloadListComponent;
    public BuddyGroupList buddyGroupList;
    private final Vector contextMenuItems;
    public ContextMenu contextMenu;

    public DownloadScreen() {
        super.isScrollLocked = true;
        super.title = "Tải Về";
        this.downloadListComponent = new ListComponent(0, 0, screenWidth, screenHeight - GameManager.footerHeight);
        this.addComponent(this.downloadListComponent);
        UIUtils.focusComponent(this, this.downloadListComponent);
        this.buddyGroupList = new BuddyGroupList();
        this.downloadListComponent.setIconSettings(1, 10, 10);
        this.downloadListComponent.setDataSource(this.buddyGroupList, 1, false);
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
            BuddyListItem var2 = (BuddyListItem) this.downloadListComponent.listItems.elementAt(var1);
            this.buddyGroupList.removeContact(var2.groupName, 0L);
        }

        this.downloadListComponent.buildListItems();
    }

    public void deleteDownloadsByType(byte var1) {
        int var2 = 0;
        int var3 = this.downloadListComponent.listItems.size();

        while (--var3 >= 0) {
            BuddyInfo var4 = ((BuddyListItem) this.downloadListComponent.listItems.elementAt(var3)).contactRef;
            if (var1 == 0) {
                if (var4.downloadType == 0) {
                    if (++var2 > 4) {
                        this.buddyGroupList.removeContact(var4.username, 0L);
                    }
                }
            } else if (var4.downloadType == 1) {
                if (++var2 > 3) {
                    this.buddyGroupList.removeContact(var4.username, 0L);
                }
            }
        }
    }
}
