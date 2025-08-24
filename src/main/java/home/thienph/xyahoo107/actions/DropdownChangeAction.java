package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class DropdownChangeAction implements Action {
    private final byte[] payload;

    public DropdownChangeAction(byte[] payload) {
        this.payload = payload;
    }

    public void action() {
        GameProcessor.processMessage(this.payload);
    }
}
