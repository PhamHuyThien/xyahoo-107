package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickSkipTurnAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickSkipTurnAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        if (this.gameScreen.cardGameComponent.isFirstMove) {
            this.gameScreen.cardGameComponent.isFirstMove = false;
        }

        if (FriendScreen.username.equals(this.gameScreen.currentPlayerTurn)) {
            this.gameScreen.cardGameComponent.gameEnded = true;
            PacketSender.f(GameScreen.currentRoomId, FriendScreen.username);
        }
    }
}
