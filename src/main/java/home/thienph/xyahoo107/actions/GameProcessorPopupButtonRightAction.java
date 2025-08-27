package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class GameProcessorPopupButtonRightAction implements Action {
    private final byte[] data;

    public GameProcessorPopupButtonRightAction(byte[] data) {
        this.data = data;
    }

    public void action() {
        GameProcessor.processMessage(this.data);
    }
}
