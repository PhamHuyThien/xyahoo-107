package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.ButtonAction;

public final class ButtonActionClickOnCompleteAction implements Action {
    private final TextInputComponent textInputComponent;
    private final ButtonAction buttonAction;

    public ButtonActionClickOnCompleteAction(TextInputComponent textInputComponent, ButtonAction buttonAction) {
        this.textInputComponent = textInputComponent;
        this.buttonAction = buttonAction;
    }

    public void action() {
        this.textInputComponent.rightSoftKey = this.buttonAction;
    }
}
