package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class GameScreenClickUpdateAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickUpdateAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        if (GameScreen.totalRooms == 0) {
            this.gameScreen.returnToLobby();
            GameScreen.requestRoomList();
        }
    }
}
