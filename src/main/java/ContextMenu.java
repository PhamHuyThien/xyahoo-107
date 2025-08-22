import java.util.Vector;

public final class ContextMenu {
   public Vector menuItems;
   public int x;
   public int y;
   public int width;
   public int height;
   public int selectedIndex;
   public int scrollY;
   public int maxScrollY;
   public int itemHeight;

   public ContextMenu(Vector var1) {
      this.menuItems = var1;
   }
}
