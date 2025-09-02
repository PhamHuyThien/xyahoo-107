package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;

public final class MainStatusAction implements Action {
    private final GameManager gameManager;

    public MainStatusAction(GameManager var1) {
        this.gameManager = var1;
    }

    public void action() {
        this.gameManager.friendScreen.showStatusDialog();
    }
}
