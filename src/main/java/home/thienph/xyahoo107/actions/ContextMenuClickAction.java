package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class ContextMenuClickAction implements Action {
    private final byte imageId;
    private final byte[] data;

    public ContextMenuClickAction(byte var1, byte[] var2) {
        this.imageId = var1;
        this.data = var2;
    }

    public void action() {
        GameProcessor.loadImageData(this.imageId);
        GameProcessor.processMessage(this.data);
    }
}
