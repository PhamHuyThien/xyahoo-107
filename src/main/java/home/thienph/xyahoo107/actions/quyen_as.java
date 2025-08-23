package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.messages.MessageProcessor;

public final class quyen_as implements Action {
    private final byte[] a;

    public quyen_as(byte[] var1) {
        this.a = var1;
    }

    public void action() {
        MessageProcessor.processMessage(this.a);
    }
}
