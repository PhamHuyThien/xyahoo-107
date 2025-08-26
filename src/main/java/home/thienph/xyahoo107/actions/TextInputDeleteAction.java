package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;

public final class TextInputDeleteAction implements Action {
    private final TextInputComponent textInputComponent;

    public TextInputDeleteAction(TextInputComponent var1) {
        this.textInputComponent = var1;
    }

    public void action() {
        this.textInputComponent.deleteCharacterAtCursor();
    }
}
