package home.thienph.xyahoo107.actions;


import home.thienph.xyahoo107.components.TextLinkComponent;

public final class quyen_cg implements Action {
    private final TextLinkComponent a;

    public quyen_cg(TextLinkComponent var1) {
        this.a = var1;
    }

    public void action() {
        this.a.linkAction.action();
    }
}
