package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.DialogScreen;

public final class quyen_fn implements Action {
    private GameManager a;
    private final boolean b;
    private final long c;
    private final DialogScreen d;

    public quyen_fn(GameManager var1, boolean var2, long var3, DialogScreen var5) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = var5;
    }

    public final void action() {
        if (!this.b) {
            this.a.friendManager.addToPendingList(this.c);
        }

        this.a.removeScreen(this.d);
    }
}
