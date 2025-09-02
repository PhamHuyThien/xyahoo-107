package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class MainLogoutAction implements Action {
    final GameManager a;

    public MainLogoutAction(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        this.a.showConfirmDialog("Bạn có muốn thoát?", new MainLogoutConfirmAction(this));
    }
}
