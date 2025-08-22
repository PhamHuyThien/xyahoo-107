final class quyen_ft implements quyen_ca {
    private quyen_et a;
    private final quyen_ca b;

    quyen_ft(quyen_et var1, quyen_ca var2) {
        this.a = var1;
        this.b = var2;
    }

    public final void a() {
        this.a.f();
        if (this.b != null) {
            this.b.a();
        }
    }
}
