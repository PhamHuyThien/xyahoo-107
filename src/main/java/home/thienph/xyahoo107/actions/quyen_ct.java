package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;

public final class quyen_ct implements Action {
    private final TextInputComponent a;

    public quyen_ct(TextInputComponent var1) {
        this.a = var1;
    }

    public void action() {
        this.a.deleteCharacterAtCursor();
    }
}
