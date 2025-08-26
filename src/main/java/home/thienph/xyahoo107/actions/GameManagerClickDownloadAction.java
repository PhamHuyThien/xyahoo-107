package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class GameManagerClickDownloadAction implements Action {
    private final GameManager gameManager;

    public GameManagerClickDownloadAction(GameManager var1) {
        this.gameManager = var1;
    }

    public void action() {
        GameManager.initAndShowDownloadManager(this.gameManager);
    }
}
