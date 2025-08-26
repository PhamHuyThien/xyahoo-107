package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class CreateButtonAction implements Action {
    private final byte[] data;

    public CreateButtonAction(byte[] data) {
        this.data = data;
    }

    public void action() {
        GameProcessor.processMessage(this.data);
    }
}
