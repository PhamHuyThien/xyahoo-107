final class quyen_js implements Action {
    private final DialogScreen a;

    quyen_js(YahooScreen var1, DialogScreen var2) {
        this.a = var2;
    }

    public final void action() {
        GameManager.instance.removeScreen(this.a);
    }
}
