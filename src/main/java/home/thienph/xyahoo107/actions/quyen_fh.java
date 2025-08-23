package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fh implements Action {
   private GameManager a;

   public quyen_fh(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showContextMenu(GameManager.getGameMenuList(this.a), 2);
   }
}
