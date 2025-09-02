package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class GameScreenClickBetOKAction implements Action {
    private final GameScreen gameScreen;

    public GameScreenClickBetOKAction(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void action() {
        if (GameScreen.getBetInputComponent(this.gameScreen).getText().length() > 0) {
            this.gameScreen.removeComponent(GameScreen.getBetInputComponent(this.gameScreen));
            this.gameScreen.isBettingMode = false;
            UIUtils.focusComponent(this.gameScreen, GameScreen.getFocusedComponent(this.gameScreen));

            try {
                long var1 = Long.parseLong(GameScreen.getBetInputComponent(this.gameScreen).getText());
                if (GameScreen.totalRooms == 0) {
                    PacketSender.requestSendDataUIComponent(GameScreen.totalRooms, GameScreen.currentRoomId, this.gameScreen.roomOwner, var1);
                }
            } catch (Exception var3) {
            }

            GameScreen.adjustScroll(this.gameScreen);
            GameScreen.getBetInputComponent(this.gameScreen).setText("");
        }
    }
}
