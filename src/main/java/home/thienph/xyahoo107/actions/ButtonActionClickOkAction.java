package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.screens.Screen;
import home.thienph.xyahoo107.utils.UIUtils;

public final class ButtonActionClickOkAction implements Action {
    private final TextInputComponent textInputComponent;
    private final Screen screen;

    public ButtonActionClickOkAction(TextInputComponent textInputComponent, Screen screen) {
        this.textInputComponent = textInputComponent;
        this.screen = screen;
    }

    public void action() {
        if (this.textInputComponent.alternateAction != null) {
            this.textInputComponent.alternateAction.action();
        }

        UIUtils.hideTextInput(this.screen, this.textInputComponent);
    }
}
