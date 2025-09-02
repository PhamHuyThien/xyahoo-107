package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;

final class GameScreenConfirmOutRoomAction implements Action {
    private final GameScreenClickConfirmLeaveRoomAction gameScreenClickConfirmLeaveRoomAction;

    GameScreenConfirmOutRoomAction(GameScreenClickConfirmLeaveRoomAction gameScreenClickConfirmLeaveRoomAction) {
        this.gameScreenClickConfirmLeaveRoomAction = gameScreenClickConfirmLeaveRoomAction;
    }

    public void action() {
        GameScreenClickConfirmLeaveRoomAction var1 = this.gameScreenClickConfirmLeaveRoomAction;
        this.gameScreenClickConfirmLeaveRoomAction.gameScreen.exitGame(true);
        var1 = this.gameScreenClickConfirmLeaveRoomAction;
        GameScreen.requestRoomList();
    }
}
