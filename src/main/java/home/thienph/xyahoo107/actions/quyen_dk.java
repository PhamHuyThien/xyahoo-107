package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.screens.GameScreen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class quyen_dk implements Action {
    private final GameScreen a;

    public quyen_dk(GameScreen var1) {
        this.a = var1;
    }

    public void action() {
        this.a.removeComponent(this.a.chatInputComponent);
        this.a.isChatMode = false;
        UIUtils.focusComponent(this.a, GameScreen.getFocusedComponent(this.a));
        GameScreen.adjustScroll(this.a);
        this.a.chatInputComponent.setText("");
    }
}
