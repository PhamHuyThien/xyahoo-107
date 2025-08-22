final class quyen_ag implements Action {
    private final byte[] a;

    quyen_ag(byte[] var1) {
        this.a = var1;
    }

    public final void action() {
        MessageProcessor.a(this.a);
    }
}
