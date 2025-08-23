package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;
import home.thienph.xyahoo107.screens.YahooScreen;

final class quyen_jn implements Action {
    private final quyen_jm a;

    quyen_jn(quyen_jm var1) {
        this.a = var1;
    }

    public void action() {
        quyen_jm var1 = this.a;
        String var3 = "Y! " + YahooScreen.getActiveTextInput(this.a.a).getText().trim();
        ChatScreen var2;
        if ((var2 = (ChatScreen) GameManager.instance.setActiveScreen(var3)) != null) {
            var2.startSlideAnimation(1);
            GameManager.instance.switchToScreenByTitle(var3);
        } else {
            var1 = this.a;
            var2 = new ChatScreen(var3, true, null, YahooScreen.getActiveTextInput(this.a.a).getText().trim());
        }

        var2.startSlideAnimation(1);
        GameManager.instance.addScreenToStack(var2);
        GameManager.instance.switchToScreenByTitle(var2.title);
        System.gc();
    }
}
