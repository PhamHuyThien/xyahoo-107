package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dl implements Action {
    private final GameScreen a;

    public quyen_dl(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameScreen.showChatInput(this.a);
    }
}
