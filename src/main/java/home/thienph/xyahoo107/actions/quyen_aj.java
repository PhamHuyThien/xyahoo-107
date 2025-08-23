package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class quyen_aj implements Action {
    private final byte[] a;

    public quyen_aj(byte[] var1) {
        this.a = var1;
    }

    public void action() {
        GameProcessor.processMessage(this.a);
    }
}
