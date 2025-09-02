package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.FriendScreen;
import home.thienph.xyahoo107.utils.TextValidator;

public final class FriendClickOKAction implements Action {
    private final FriendScreen friendScreen;

    public FriendClickOKAction(FriendScreen var1) {
        this.friendScreen = var1;
    }

    public void action() {
        String var1 = TextValidator.filterBadWords(FriendScreen.getStatusMessageInput(this.friendScreen).getText().trim());
        int var2 = FriendScreen.getStatusDropdown(this.friendScreen).getSelectedIndex() == 0 ? 1 : 0;
        if (var1 != null && !var1.equals(FriendScreen.statusMessage)) {
            FriendScreen.updateStatusMessage(var1);
            if (!var1.equals("")) {
                var2 = 1;
            }

            PacketSender.updateViewOnline(var2, 1);
        } else if (var2 != FriendScreen.userStatus) {
            PacketSender.updateViewOnline(var2, 1);
        }

        FriendScreen.userStatus = var2;
        GameManager.getInstance().removeScreen(FriendScreen.getStatusDialog(this.friendScreen));
    }
}
