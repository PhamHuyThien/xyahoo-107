package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.ButtonAction;
import home.thienph.xyahoo107.screens.YahooScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_jm implements Action {
    final YahooScreen a;

    public quyen_jm(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        if (!YahooScreen.checkConnectionReady(this.a)) {
            if (this.a.isSearchMode) {
                this.a.searchInput.setText("");
                this.a.contactList.setSearchFilter("");
                YahooScreen.exitSearchMode(this.a);
            }

            if (YahooScreen.getActiveTextInput(this.a) == null) {
                YahooScreen.setActiveTextInput(this.a, ButtonAction.createTextInputPopup(this.a, "Xin nhập Yahoo! ID", 0, new quyen_jn(this)));
            }

            this.a.addComponent(YahooScreen.getActiveTextInput(this.a));
            UIUtils.showTextInputPopup(this.a, YahooScreen.getActiveTextInput(this.a));
        }
    }
}
