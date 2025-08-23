package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.connections.PacketSender;

final class quyen_v implements Action {
    private final quyen_u a;

    quyen_v(quyen_u var1) {
        this.a = var1;
    }

    public void action() {
        quyen_u var1 = this.a;
        PacketSender.b(this.a.a.roomId, 4812);
    }
}
