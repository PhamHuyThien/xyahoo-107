package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class quyen_as implements Action {
    private final byte[] a;

    public quyen_as(byte[] var1) {
        this.a = var1;
    }

    public void action() {
        GameProcessor.processMessage(this.a);
    }
}
