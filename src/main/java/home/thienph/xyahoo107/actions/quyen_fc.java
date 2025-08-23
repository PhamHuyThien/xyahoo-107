package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fc implements Action {
   final GameManager a;

   public quyen_fc(GameManager var1) {
      this.a = var1;
   }

   public final void action() {
      this.a.showConfirmDialog("Bạn có muốn thoát?", new quyen_fd(this));
   }
}
