import java.util.Vector;

public final class GameLobbyScreen extends Screen {
   public ListComponent gameListComponent;
   public int selectedGameIndex;
   private Vector menuItems;
   public ContextMenu contextMenu;
   public static UIFactory buyCoinsButton = new UIFactory("Nạp xu", new quyen_ha());

   public GameLobbyScreen() {
      super.unused1 = 11114;
      super.isScrollLocked = true;
      this.gameListComponent = new ListComponent(0, 0, Screen.screenWidth, Screen.screenHeight - GameManager.footerHeight);
      this.addComponent(this.gameListComponent);
      UIUtils.focusComponent(this, this.gameListComponent);
      super.rightSoftkey = GameManager.a(this, true, null);
      this.menuItems = new Vector();
      this.menuItems.addElement(new UIFactory("Vào nhanh", new quyen_hb(this)));
      this.menuItems.addElement(new UIFactory("Cập nhật", new quyen_hc(this)));
      this.menuItems.addElement(buyCoinsButton);
      this.contextMenu = new ContextMenu(this.menuItems);
      super.leftSoftkey = new UIFactory("Menu", new quyen_hd(this));
   }
}
