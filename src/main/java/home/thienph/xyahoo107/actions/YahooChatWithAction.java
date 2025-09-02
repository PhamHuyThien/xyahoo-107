package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.screens.YahooScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class YahooChatWithAction implements Action {
    final YahooScreen yahooScreen;

    public YahooChatWithAction(YahooScreen yahooScreen) {
        this.yahooScreen = yahooScreen;
    }

    public void action() {
        if (!YahooScreen.checkConnectionReady(this.yahooScreen)) {
            if (this.yahooScreen.isSearchMode) {
                this.yahooScreen.searchInput.setText("");
                this.yahooScreen.contactList.setSearchFilter("");
                YahooScreen.exitSearchMode(this.yahooScreen);
            }

            if (YahooScreen.getActiveTextInput(this.yahooScreen) == null) {
                YahooScreen.setActiveTextInput(this.yahooScreen, ButtonAction.createTextInputPopup(this.yahooScreen, "Xin nhập Yahoo! ID", 0, new quyen_jn(this)));
            }

            this.yahooScreen.addComponent(YahooScreen.getActiveTextInput(this.yahooScreen));
            UIUtils.showTextInputPopup(this.yahooScreen, YahooScreen.getActiveTextInput(this.yahooScreen));
        }
    }
}
