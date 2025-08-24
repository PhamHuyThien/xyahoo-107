package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class ImageClickAction implements Action {
    private final byte[] payload;

    public ImageClickAction(byte[] payload) {
        this.payload = payload;
    }

    public void action() {
        GameProcessor.processMessage(this.payload);
    }
}
