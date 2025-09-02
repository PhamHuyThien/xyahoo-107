package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.YahooScreen;
import home.thienph.xyahoo107.utils.TextValidator;

public final class ClickLoginYahooAction implements Action {
    private final YahooScreen yahooScreen;

    public ClickLoginYahooAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        String var1 = TextValidator.filterBadWords(YahooScreen.getStatusMessageInput(this.yahooScreen).getText().trim());
        int var2 = YahooScreen.getStatusDropdown(this.yahooScreen).getSelectedIndex() == 0 ? 0 : 12;
        if (var1 != null && !var1.equals(YahooScreen.statusMessage)) {
            YahooScreen.updateStatusMessage(this.yahooScreen, var1);
            YahooScreen.yahooStatus = 0;
            GameManager.showConnectionStatus = true;
        } else if (var2 != YahooScreen.yahooStatus) {
            if (var2 == 0) {
                if (var1 != null && var1.length() > 0) {
                    YahooScreen.updateStatusMessage(this.yahooScreen, var1);
                } else {
                    PacketSender.updateViewOnline(0, 2);
                }

                YahooScreen.yahooStatus = 0;
                GameManager.showConnectionStatus = true;
            } else {
                PacketSender.updateViewOnline(12, 2);
                YahooScreen.yahooStatus = 12;
                GameManager.showConnectionStatus = true;
            }
        }

        GameManager.getInstance().removeScreen(YahooScreen.getStatusScreen(this.yahooScreen));
    }
}
