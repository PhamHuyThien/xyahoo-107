package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickPlayerNameAction implements Action {
    private final GameScreen gameScreen;
    private final int b;

    public GameScreenClickPlayerNameAction(GameScreen var1, int var2) {
        this.gameScreen = var1;
        this.b = var2;
    }

    public void action() {
        PacketSender.i(this.gameScreen.playerComponents[this.b].playerName);
    }
}
