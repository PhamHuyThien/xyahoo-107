package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.processors.GameProcessor;

public final class GotoPageComponentAction implements Action {
    private final TextInputComponent textInputComponent;
    private final int page;
    private final byte[] data;

    public GotoPageComponentAction(TextInputComponent var1, int var2, byte[] var3) {
        this.textInputComponent = var1;
        this.page = var2;
        this.data = var3;
    }

    public void action() {
        try {
            int var1;
            if ((var1 = Integer.parseInt(this.textInputComponent.getText())) > 0 && var1 <= this.page) {
                GameProcessor.processMessage(this.data);
            }
        } catch (Exception var2) {
        }
    }
}
