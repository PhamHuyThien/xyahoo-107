package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class YahooRejectAddContactGroupAction implements Action {
    private final GameManager gameManager;
    private final String username;
    private final TextInputComponent groupNameInput;
    private final DialogScreen screen;

    public YahooRejectAddContactGroupAction(GameManager gameManager, String username, TextInputComponent groupNameInput, DialogScreen screen) {
        this.gameManager = gameManager;
        this.username = username;
        this.groupNameInput = groupNameInput;
        this.screen = screen;
    }

    public void action() {
        PacketSender.requestSendDataUIComponent(this.username, this.groupNameInput.getText(), (byte) 0);
        this.gameManager.removeScreen(this.screen);
    }
}
