package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.GridComponent;
import home.thienph.xyahoo107.managers.GameManager;
import home.thienph.xyahoo107.processors.GameProcessor;

public final class quyen_am implements Action {
    private final boolean a;
    private final GridComponent b;
    private final boolean[] c;
    private final byte[] d;

    public quyen_am(boolean var1, GridComponent var2, boolean[] var3, byte[] var4) {
        this.a = var1;
        this.b = var2;
        this.c = var3;
        this.d = var4;
    }

    public void action() {
        if (this.a) {
            GameManager var10000 = GameManager.instance;
            int var10001 = this.b.getSelectedItemId();
            GridComponent var1 = this.b;
            var10000.joinGame(var10001, this.c[this.b.selectedRowIndex * var1.columnsPerRow + var1.selectedColumnIndex]);
        } else {
            GameProcessor.processMessage(this.d);
        }
    }
}
