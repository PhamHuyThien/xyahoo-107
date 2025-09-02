package home.thienph.xyahoo107.actions;


final class MainLogoutConfirmAction implements Action {
    private final MainLogoutAction mainLogoutAction;

    MainLogoutConfirmAction(MainLogoutAction var1) {
        this.mainLogoutAction = var1;
    }

    public void action() {
        MainLogoutAction var1 = this.mainLogoutAction;
        if (this.mainLogoutAction.a.yahooChat != null) {
            var1 = this.mainLogoutAction;
            this.mainLogoutAction.a.yahooChat.logout();
        }

        var1 = this.mainLogoutAction;
        this.mainLogoutAction.a.disconnect();
    }
}
