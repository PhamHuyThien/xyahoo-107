package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextInputComponent;
import home.thienph.xyahoo107.processors.GameProcessor;

public final class quyen_aq implements Action {
    private final TextInputComponent a;
    private final int b;
    private final byte[] c;

    public quyen_aq(TextInputComponent var1, int var2, byte[] var3) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
    }

    public void action() {
        try {
            int var1;
            if ((var1 = Integer.parseInt(this.a.getText())) > 0 && var1 <= this.b) {
                GameProcessor.processMessage(this.c);
            }
        } catch (Exception var2) {
        }
    }
}
