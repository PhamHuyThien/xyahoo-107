final class quyen_at implements Action {
    private final byte[] a;

    quyen_at(byte[] var1) {
        this.a = var1;
    }

    public final void action() {
        MessageProcessor.a(this.a);
    }
}
