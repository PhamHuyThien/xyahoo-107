package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class MultiImageClickAction implements Action {
    private final byte[] actionData;

    public MultiImageClickAction(byte[] actionData) {
        this.actionData = actionData;
    }

    public void action() {
        GameProcessor.processMessage(this.actionData);
    }
}
