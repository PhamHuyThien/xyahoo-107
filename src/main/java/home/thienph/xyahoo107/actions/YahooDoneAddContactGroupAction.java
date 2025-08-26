package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.data.media.BuddyInfo;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class YahooDoneAddContactGroupAction implements Action {
    private final GameManager gameManager;
    private final TextInputComponent groupNameInput;
    private final String username;
    private final DialogScreen screen;

    public YahooDoneAddContactGroupAction(GameManager gameManager, TextInputComponent groupNameInput, String username, DialogScreen var4) {
        this.gameManager = gameManager;
        this.groupNameInput = groupNameInput;
        this.username = username;
        this.screen = var4;
    }

    public void action() {
        if (!this.groupNameInput.getText().equals("")) {
            BuddyInfo var1 = new BuddyInfo(this.username, "", 0, "", new int[0], 0, 0, null);
            PacketSender.requestSendDataUIComponent(this.username, this.groupNameInput.getText(), (byte) 1);
            if (this.gameManager.yahooChat.contactList.getContactData().findDownloadFile(this.username, null, 0L) == null) {
                this.gameManager.yahooChat.contactList.getContactData().addContactToGroup(this.groupNameInput.getText(), var1);
                this.gameManager.yahooChat.contactList.refreshDisplayList();
                this.gameManager.yahooChat.contactList.resetAnimation();
            }

            this.gameManager.removeScreen(this.screen);
        }
    }
}
