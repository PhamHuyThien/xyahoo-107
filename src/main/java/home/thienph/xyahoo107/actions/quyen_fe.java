package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class quyen_fe implements Action {
    private final GameManager a;

    public quyen_fe(GameManager var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.initAndShowDownloadManager(this.a);
    }
}
