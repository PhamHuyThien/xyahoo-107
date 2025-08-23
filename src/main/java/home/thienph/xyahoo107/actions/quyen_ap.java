package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.messages.MessageProcessor;

public final class quyen_ap implements Action {
    private final byte[] a;

    public quyen_ap(byte[] var1) {
        this.a = var1;
    }

    public void action() {
        MessageProcessor.processMessage(this.a);
    }
}
