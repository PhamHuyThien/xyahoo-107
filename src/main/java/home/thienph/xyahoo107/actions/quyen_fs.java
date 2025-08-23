package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fs implements Action {
   private GameManager a;
   private final Action b;

   public quyen_fs(GameManager var1, Action var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void action() {
      this.a.closeDialog();
      if (this.b != null) {
         this.b.action();
      }
   }
}
