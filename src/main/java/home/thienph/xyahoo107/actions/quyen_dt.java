package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

public final class quyen_dt implements Action {
    private final GameScreen a;

    public quyen_dt(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        if (GameScreen.totalRooms == 0) {
            this.a.returnToLobby();
            GameScreen.requestRoomList();
        }
    }
}
