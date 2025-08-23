package home.thienph.xyahoo107.screens;

import home.thienph.xyahoo107.actions.quyen_ha;
import home.thienph.xyahoo107.actions.quyen_hb;
import home.thienph.xyahoo107.actions.quyen_hc;
import home.thienph.xyahoo107.actions.quyen_hd;
import home.thienph.xyahoo107.components.ListComponent;
import home.thienph.xyahoo107.components.UIFactory;
import home.thienph.xyahoo107.data.game.ContextMenu;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.utils.UIUtils;

import java.util.Vector;

public final class GameLobbyScreen extends Screen {
    public ListComponent gameListComponent;
    public int selectedGameIndex;
    private final Vector menuItems;
    public ContextMenu contextMenu;
    public static UIFactory buyCoinsButton = new UIFactory("Nạp xu", new quyen_ha());

    public GameLobbyScreen() {
        super.unused1 = 11114;
        super.isScrollLocked = true;
        this.gameListComponent = new ListComponent(0, 0, screenWidth, screenHeight - GameManager.footerHeight);
        this.addComponent(this.gameListComponent);
        UIUtils.focusComponent(this, this.gameListComponent);
        super.rightSoftkey = GameManager.createCloseButton(this, true, null);
        this.menuItems = new Vector();
        this.menuItems.addElement(new UIFactory("Vào nhanh", new quyen_hb(this)));
        this.menuItems.addElement(new UIFactory("Cập nhật", new quyen_hc(this)));
        this.menuItems.addElement(buyCoinsButton);
        this.contextMenu = new ContextMenu(this.menuItems);
        super.leftSoftkey = new UIFactory("Menu", new quyen_hd(this));
    }
}
