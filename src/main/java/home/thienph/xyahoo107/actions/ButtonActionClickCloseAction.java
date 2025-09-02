package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class ButtonActionClickCloseAction implements Action {
    private final Screen screen;
    private final TextInputComponent textInputComponent;

    public ButtonActionClickCloseAction(Screen screen, TextInputComponent textInputComponent) {
        this.screen = screen;
        this.textInputComponent = textInputComponent;
    }

    public void action() {
        UIUtils.hideTextInput(this.screen, this.textInputComponent);
    }
}
