package home.thienph.xyahoo107.actions;


final class quyen_fd implements Action {
    private final quyen_fc a;

    quyen_fd(quyen_fc var1) {
        this.a = var1;
    }

    public void action() {
        quyen_fc var1 = this.a;
        if (this.a.a.yahooChat != null) {
            var1 = this.a;
            this.a.a.yahooChat.logout();
        }

        var1 = this.a;
        this.a.a.disconnect();
    }
}
