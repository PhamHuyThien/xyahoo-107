package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dp implements Action {
    private final GameScreen a;

    public quyen_dp(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        GameScreen.getBetInputComponent(this.a).rightSoftKey = GameScreen.getBetSendButton(this.a);
    }
}
