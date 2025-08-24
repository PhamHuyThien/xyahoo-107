package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.processors.GameProcessor;

public final class ListBuddyListClickAction implements Action {
    private final byte[] dataAction;

    public ListBuddyListClickAction(byte[] dataAction) {
        this.dataAction = dataAction;
    }

    public void action() {
        GameProcessor.processMessage(this.dataAction);
    }
}
