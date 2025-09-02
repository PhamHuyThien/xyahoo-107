package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickPlaySpeedAction implements Action {
    public GameScreenClickPlaySpeedAction(GameScreen var1) {
    }

    public void action() {
        if (GameScreen.totalRooms == 0) {
            PacketSender.g(GameScreen.gameTypeId);
        }
    }
}
