package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.components.ButtonAction;

public final class quyen_cm implements Action {
    private final TextInputComponent a;
    private final ButtonAction b;

    public quyen_cm(TextInputComponent var1, ButtonAction var2) {
        this.a = var1;
        this.b = var2;
    }

    public void action() {
        this.a.rightSoftKey = this.b;
    }
}
