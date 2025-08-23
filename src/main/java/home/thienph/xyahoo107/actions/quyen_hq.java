package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.screens.ChatScreen;

public final class quyen_hq implements Action {
    private final ChatScreen a;

    public quyen_hq(ChatScreen var1) {
        this.a = var1;
    }

    public void action() {
        if (!GameManager.emptyString.equals("")) {
            this.a.textInputComponent.insertText(GameManager.emptyString);
        }
    }
}
