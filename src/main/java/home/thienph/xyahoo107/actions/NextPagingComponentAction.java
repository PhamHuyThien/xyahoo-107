package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class NextPagingComponentAction implements Action {
    private final byte[] data;

    public NextPagingComponentAction(byte[] data) {
        this.data = data;
    }

    public void action() {
        GameProcessor.processMessage(this.data);
    }
}
