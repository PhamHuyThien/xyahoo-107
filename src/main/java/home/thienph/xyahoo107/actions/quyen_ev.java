package home.thienph.xyahoo107.actions;


final class quyen_ev implements Action {
    private final quyen_gn a;

    quyen_ev(quyen_gn var1) {
        this.a = var1;
    }

    public void action() {
        quyen_gn var1 = this.a;
        this.a.a.showWrappedTextDialog("Vui lòng chờ tin nhắn xác nhận sau vài phút.");
    }
}
