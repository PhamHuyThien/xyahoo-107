package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.messages.MessageProcessor;

public final class quyen_ag implements Action {
    private final byte[] a;

    public quyen_ag(byte[] var1) {
        this.a = var1;
    }

    public final void action() {
        MessageProcessor.a(this.a);
    }
}
