package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.Screen;

public final class quyen_gc implements Action {
    private final Screen a;

    public quyen_gc(Screen var1) {
        this.a = var1;
    }

    public void action() {
        GameManager.instance.removeScreen(this.a);
    }
}
