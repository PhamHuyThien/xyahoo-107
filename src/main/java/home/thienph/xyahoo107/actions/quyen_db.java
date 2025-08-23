package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_db implements Action {
    private final GameScreen a;

    public quyen_db(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.exitGame(true);
    }
}
