package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.YahooScreen;

public final class quyen_jl implements Action {
    private final YahooScreen a;

    public quyen_jl(YahooScreen var1) {
        this.a = var1;
    }

    public void action() {
        if (!YahooScreen.checkConnectionReady(this.a)) {
            YahooScreen.showStatusDialog(this.a);
        }
    }
}
