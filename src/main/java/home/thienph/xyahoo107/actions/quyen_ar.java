package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.messages.MessageProcessor;

public final class quyen_ar implements Action {
    private final byte a;
    private final byte[] b;

    public quyen_ar(byte var1, byte[] var2) {
        this.a = var1;
        this.b = var2;
    }

    public void action() {
        MessageProcessor.loadImageData(this.a);
        MessageProcessor.processMessage(this.b);
    }
}
