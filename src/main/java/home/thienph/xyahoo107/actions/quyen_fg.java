package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fg implements Action {
    private final GameManager a;

    public quyen_fg(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        this.a.showContextMenu(GameManager.getMainMenuList(this.a), 0);
    }
}
