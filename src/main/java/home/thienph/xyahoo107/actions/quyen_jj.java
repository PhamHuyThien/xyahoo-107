package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.YahooScreen;
import home.thienph.xyahoo107.utils.TextValidator;

public final class quyen_jj implements Action {
    private final YahooScreen a;

    public quyen_jj(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        String var1 = TextValidator.filterBadWords(YahooScreen.getStatusMessageInput(this.a).getText().trim());
        int var2 = YahooScreen.getStatusDropdown(this.a).getSelectedIndex() == 0 ? 0 : 12;
        if (var1 != null && !var1.equals(YahooScreen.statusMessage)) {
            YahooScreen.updateStatusMessage(this.a, var1);
            YahooScreen.yahooStatus = 0;
            GameManager.showConnectionStatus = true;
        } else if (var2 != YahooScreen.yahooStatus) {
            if (var2 == 0) {
                if (var1 != null && var1.length() > 0) {
                    YahooScreen.updateStatusMessage(this.a, var1);
                } else {
                    PacketSender.a(0, 2);
                }

                YahooScreen.yahooStatus = 0;
                GameManager.showConnectionStatus = true;
            } else {
                PacketSender.a(12, 2);
                YahooScreen.yahooStatus = 12;
                GameManager.showConnectionStatus = true;
            }
        }

        GameManager.getInstance().removeScreen(YahooScreen.getStatusScreen(this.a));
    }
}
